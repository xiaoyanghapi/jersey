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
 * ����ͼƬ����һ̨tomcat
 * @author ���� yjj: 
 * @version ����ʱ�䣺2016��4��21�� ����5:00:33 
 * 
 */
public class JerseyDemo {

	public static void main(String[] args) {
		//ʵ����һ��Jersey
		Client client = new Client();
		//ͼƬ·��
		String path = "C:\\Users\\yjj\\Desktop\\babasportͼƬ\\5547882bNc592f1ce.jpg";
		//������·��ȥ����
		String url = "http://localhost:8088/image-web/upload/qqq.jpg";
		//��������·�� �߱�����ͼƬ������
		WebResource resource = client.resource(url);
		//��ȡͼƬ���ڴ���
		try {
			byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(path));
			
			//put�ύ
			resource.put(String.class, readFileToByteArray);
			
			System.out.println("������ɣ�");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	
	
}
