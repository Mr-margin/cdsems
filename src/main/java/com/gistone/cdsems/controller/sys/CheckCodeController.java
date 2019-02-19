package com.gistone.cdsems.controller.sys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 验证码
 * ClassName: CheckCodeController 
 * @Description: TODO
 * @author luowenbin
 * @date 2018年4月20日
 */
@Controller
@RequestMapping("/checkCode")
public class CheckCodeController extends MultiActionController {
	
	@RequestMapping("/getCheckCode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		// 获取随机生成的4位`字符串类型的验证码
		String code = createCodeString();
		// 将字符串类型的验证码加入session域，用于登录的Servlet中进行和客户端输入的验证码进行比较
		request.getSession().setAttribute("checkCode", code);
		// 获取图片类型的验证码,调用生成图片验证码的方法
		BufferedImage image = createImageCode(code);
		//获取字节输出流对象
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// 将图片写入out流中
		ImageIO.write(image, "JPEG", out);
		
		//将流转换成字节数组
		byte[] buf = out.toByteArray();
		//设置内容的长度；告诉浏览器该图片的长度
		response.setContentLength(buf.length);
		//获取响应输出流对象
		ServletOutputStream output = response.getOutputStream();
		// 将图片内容写出到页面
		output.write(buf);
		out.close();
		output.close();
	}
	
	/**
	 *  验证码的宽，高
	 */
	private static final int WIDTH = 80;
	private static final int HEIGHT = 40;
	private static final String SRC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	// 用于产生一个随机下标，该下标用于从SRC中获取字符
	private static final Random random = new Random(); 
		
	/**
	 *  随机生成验证码的4个文字信息
	 */
	public static char[] createCode(){
		// 创建用于存储验证码的数组
		char[] code = new char[4];
		for (int i = 0; i < code.length; i++) {
			// 循环生成验证码
			code[i] = SRC.charAt(random.nextInt(36));
		}
		return code;
	}
	/**
	 * 把随机生成验证码的4个文字信息转化成String类型的S
	 * @return
	 */
	public static String createCodeString(){
		String s = new String(createCode());
		return s;
	}
	
	/**
	 *  生成图片验证码的方法
	 */  
	public static BufferedImage createImageCode(String code){
		//创建图片对象
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//获取绘制图片的对象
		Graphics g = image.getGraphics();
		//画背景和干扰线
		drawBackground(g);
		//画验证码
		drawCode(g,code);
		//释放资源
		g.dispose();
		//返回图片对象
		return image;
	}
	
	/**
	 *  画背景和干扰线的方法
	 */
	private static void drawBackground(Graphics g){
		// 设置画笔的颜色
		g.setColor(new Color(0xDDDDDD));
		// 填充矩形
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		drawOv(g); 
		drawLi(g);
	}
	
	/**
	 *  画点的方法
	 */
	private static void drawOv(Graphics g) {
		for (int i = 0; i < 20; i++) {
			// 随机产生顶点
			int x = random.nextInt(WIDTH);
			int y = random.nextInt(HEIGHT);
			// 随机产生颜色
			int red = random.nextInt(255);
			int green = random.nextInt(255);
			int blue = random.nextInt(255);
			// 设置画笔的颜色
			g.setColor(new Color(red, green, blue));
			// 画点
			g.drawOval(x, y, 1, 1);
		}
	}
	
	/**
	 *  画干扰线
	 */
	private static void drawLi(Graphics g){
		for (int i = 0; i < 20; i++) {
			// 随机产生顶点
			int beginX = random.nextInt(WIDTH);
			int beginY = random.nextInt(HEIGHT);
			int endX = random.nextInt(WIDTH);
			int endY = random.nextInt(HEIGHT);
			// 随机产生颜色
			int red = random.nextInt(255);
			int green = random.nextInt(255);
			int blue = random.nextInt(255);
			// 设置画笔的颜色
			g.setColor(new Color(red, green, blue));
			// 画点
			g.drawLine(beginX,beginY,endX,endY);
		} 
	}
	
	/**
	 *  画验证码
	 */
	private static void drawCode(Graphics g,String code){
		// 设置画笔颜色
		g.setColor(Color.BLUE);
		// 设置字体
		g.setFont(new Font(null, Font.BOLD, 20));
		// 将字符串类型的验证码画到图片上
		g.drawString(code, 15, 25);
	}

}
