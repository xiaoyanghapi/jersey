package cn.itcast;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/** 
 * 
 * 发送图片到另一台tomcat
 * @author 作者 yjj: 
 * @version 创建时间：2016年4月21日 下午5:00:33 
 * 
 */
public class JerseyDemo {

	public static void main(String[] args) {
		//实例化一个Jersey
		Client client = new Client();
		//图片路径
		String path = "C:\\Users\\yjj\\Desktop\\babasport图片\\5547882bNc592f1ce.jpg";
		//给请求路径去发送
		String url = "http://localhost:8088/image-web/upload/qqq.jpg";
		//设置请求路径 具备发送图片的能力
		WebResource resource = client.resource(url);
		//读取图片到内存中
		try {
			byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(path));
			
			//put提交
			resource.put(String.class, readFileToByteArray);
			
			System.out.println("发送完成！");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	
	
}
