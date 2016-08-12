package com.maker.servlet.knowledge;

import java.io.File;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.maker.constant.Keys;
import com.maker.entity.Attachment;
import com.maker.entity.KnowledgeEntity;
import com.maker.entity.UserInfoEntity;
import com.maker.service.KnowledgeService;
import com.maker.utils.FileUploadUtil;


@WebServlet("/addknowledge")
public class AddKnowledgeServlet extends HttpServlet {
	private String temp = "f:/temp";
	private int flushSize = 1024*512;
	private long fileSize = 1024*1024*10;
	String fileName = null;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		File file = new File(temp);
		if(!file.exists()){
			file.mkdir();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(flushSize);
		factory.setRepository(new File(temp));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(fileSize);
//		if(!upload.isMultipartContent(request)){
//			return;
//		}
		String[] values = null;
		try {
			List<FileItem> items = upload.parseRequest(request);
			values = new String[items.size()];
			int i = 0;
			
			for(FileItem item : items ){
				if(item.isFormField()){
					values[i] = item.getString("utf-8");
					i++;
				}else{
					if(item.getName()!=null && item.getSize()>0){
						//文件表单，处理文件上传
						String path = request.getSession().getServletContext().getRealPath("attachment");
						String name = item.getName();
						String ext = name.substring(name.lastIndexOf('.'));
						fileName = FileUploadUtil.generateFileName() + ext;
						item.write(new File(path,fileName));
					}
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int cid = 0;
		String title = null;
		String label = null;
		String content = null;
		if(values!=null && values.length>=4){
			cid = Integer.valueOf(values[0]);
			title = values[1];
			label = values[2];
			content = values[3];
		}
		
		HttpSession session = request.getSession();
		int uid = ((UserInfoEntity) session.getAttribute(Keys.USER)).getId();
		
		KnowledgeEntity keEntity = new KnowledgeEntity();
		keEntity.setTitle(title);
		keEntity.setLabel(label);
		keEntity.setContent(content.replace(" ", "&nbsp;").replace("\r\n", "<br />"));
		keEntity.setUid(uid);
		keEntity.setDing(0);
		keEntity.setCai(0);
		keEntity.setState(0);
		keEntity.setStateDate(null);
		keEntity.setStateUid(0);
		keEntity.setPubDate(new Date());
		keEntity.setReadCount(0);
		keEntity.setCid(cid);
		
		KnowledgeService service = new KnowledgeService();
		try {
			service.add(keEntity);
			//更新附件标的信息
			//获得当前知识的id
			int kid = service.getKnowledgeId();
			
			Attachment attachment = new Attachment();
			attachment.setKid(kid);
			attachment.setAttachPath(fileName);
			service.addAttachment(attachment);
			
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
