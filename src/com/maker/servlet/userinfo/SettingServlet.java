package com.maker.servlet.userinfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.maker.constant.Keys;
import com.maker.entity.UserInfoEntity;
import com.maker.service.UserInfoService;
import com.maker.utils.FileUploadUtil;

@WebServlet("/setting")
public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 文件上传的参数设置
	private String tempPath = "c:/tempPath";
	private int flushSize = 1024 * 512;
	private long fileSize = 10 * 1024 * 1024;

	@Override
	public void init() throws ServletException {
		// 容器初始化时创建临时目录
		File temp = new File(tempPath);
		if (!temp.exists()) {
			temp.mkdir();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 带文件上传的表单处理
		/**
		 * 1.设置上传的文件的存放位置 2.设置上传的jvm缓冲的参数 3.实例化文件上传核心类的对象
		 * 4.获得上传的数据包解析成FileItem的集合 5.获得表单的字段类型，对file类型的元素进行文件上传处理 6.检测文件的安全性
		 * 7.设置文件的名称 8.将文件写到要保存的目录下 9.更新数据库的字段 10.普通字段正常处理
		 */

		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(flushSize);
		factory.setRepository(new File(tempPath));

		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件的文件名的中文乱码问题
		upload.setHeaderEncoding("utf-8");

		// 不是文件上传的表单，不进行处理
		if (!upload.isMultipartContent(request)) {
			return;
		}

		String[] values = null;
		try {
			List<FileItem> items = upload.parseRequest(request);
			values = new String[items.size()];
			int i = 0;
			for (FileItem item : items) {

				if (!item.isFormField()) {
					// 处理文件上传元素
					String path = request.getSession().getServletContext().getRealPath("headerimages");

					// 生成保存文件的名称
					String name = item.getName();
					String ext = name.substring(name.lastIndexOf('.'));
					String fileName = FileUploadUtil.generateFileName() + ext;

					// 拦截用户没有选择上传的文件的问题
					if (fileName == null || fileName.trim().equals("")) {
						return;
					}

					// 获得文件头信息，验证上传文件的安全性
					InputStream is = item.getInputStream();
					int b1 = is.read();
					int b2 = is.read();
					String fileHeader = String.valueOf(b1) + String.valueOf(b2);
					// jsp:6037 png:13780 jpg:255216 gif:7173 jpeg:255216
					if (fileHeader.equals("13780") || fileHeader.equals("7173") || fileHeader.equals("255216")) {
						item.write(new File(path, fileName));

						// 更新数据库记录
						UserInfoEntity entity = ((UserInfoEntity) request.getSession().getAttribute(Keys.USER));
						entity.setHeaderImage(fileName);
						new UserInfoService().update(entity);
					}
				} else {
					// 普通表单元素，获得修改后的个人信息，更新数据

					// String userName =
					// item.getString();/*request.getParameter("username");*/
					// String nickName =
					// item.getString();/*request.getParameter("nickname");*/
					// String introduce =
					// item.getString();/*request.getParameter("introduce");*/

					values[i] = item.getString("utf-8");// 解决获得表单内容时中文乱码的问题
					i++;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		UserInfoEntity entity = null;
		UserInfoService service = new UserInfoService();
		try {
			int id = ((UserInfoEntity) request.getSession().getAttribute(Keys.USER)).getId();
			entity = service.getById(id);

			if (values != null && values.length >= 3) {
				entity.setUserName(values[0]);
				entity.setNickName(values[1]);
				entity.setIntroduce(values[2]);
			}

			service.update(entity);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 更新后跳转到重新登录

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
