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

	// �ļ��ϴ��Ĳ�������
	private String tempPath = "c:/tempPath";
	private int flushSize = 1024 * 512;
	private long fileSize = 10 * 1024 * 1024;

	@Override
	public void init() throws ServletException {
		// ������ʼ��ʱ������ʱĿ¼
		File temp = new File(tempPath);
		if (!temp.exists()) {
			temp.mkdir();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���ļ��ϴ��ı�����
		/**
		 * 1.�����ϴ����ļ��Ĵ��λ�� 2.�����ϴ���jvm����Ĳ��� 3.ʵ�����ļ��ϴ�������Ķ���
		 * 4.����ϴ������ݰ�������FileItem�ļ��� 5.��ñ����ֶ����ͣ���file���͵�Ԫ�ؽ����ļ��ϴ����� 6.����ļ��İ�ȫ��
		 * 7.�����ļ������� 8.���ļ�д��Ҫ�����Ŀ¼�� 9.�������ݿ���ֶ� 10.��ͨ�ֶ���������
		 */

		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(flushSize);
		factory.setRepository(new File(tempPath));

		ServletFileUpload upload = new ServletFileUpload(factory);
		// ����ϴ��ļ����ļ�����������������
		upload.setHeaderEncoding("utf-8");

		// �����ļ��ϴ��ı��������д���
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
					// �����ļ��ϴ�Ԫ��
					String path = request.getSession().getServletContext().getRealPath("headerimages");

					// ���ɱ����ļ�������
					String name = item.getName();
					String ext = name.substring(name.lastIndexOf('.'));
					String fileName = FileUploadUtil.generateFileName() + ext;

					// �����û�û��ѡ���ϴ����ļ�������
					if (fileName == null || fileName.trim().equals("")) {
						return;
					}

					// ����ļ�ͷ��Ϣ����֤�ϴ��ļ��İ�ȫ��
					InputStream is = item.getInputStream();
					int b1 = is.read();
					int b2 = is.read();
					String fileHeader = String.valueOf(b1) + String.valueOf(b2);
					// jsp:6037 png:13780 jpg:255216 gif:7173 jpeg:255216
					if (fileHeader.equals("13780") || fileHeader.equals("7173") || fileHeader.equals("255216")) {
						item.write(new File(path, fileName));

						// �������ݿ��¼
						UserInfoEntity entity = ((UserInfoEntity) request.getSession().getAttribute(Keys.USER));
						entity.setHeaderImage(fileName);
						new UserInfoService().update(entity);
					}
				} else {
					// ��ͨ��Ԫ�أ�����޸ĺ�ĸ�����Ϣ����������

					// String userName =
					// item.getString();/*request.getParameter("username");*/
					// String nickName =
					// item.getString();/*request.getParameter("nickname");*/
					// String introduce =
					// item.getString();/*request.getParameter("introduce");*/

					values[i] = item.getString("utf-8");// �����ñ�����ʱ�������������
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
		// ���º���ת�����µ�¼

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
