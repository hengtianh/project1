package com.maker.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random random = new Random();
	private int width = 100;
	private int height = 30;

	public CodeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应输出的方式
		response.setContentType("image/jpeg");

		// 设置客户端不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 生成内存图片
		String str = getCode();

		// 记住生成的验证码
		request.getSession().setAttribute("code", str);

		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, width, height);
		//g.setColor(Color.WHITE);
		g.setFont(new Font("宋体", Font.PLAIN, 20));
		g.drawString(str, 30, 20);
		g.setColor(Color.GRAY);
		for (int i = 0; i < 20; i++) {
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
		}
		g.dispose();// 关闭画布，防止出现被占用的情况

		// 向客户端输出内存图片
		ImageIO.write(image, "jpeg", response.getOutputStream());

	}
	
	private String getCode() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			builder.append((char) (random.nextInt(26)+97));
		}
		return builder.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
