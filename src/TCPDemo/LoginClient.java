package TCPDemo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {
	public static void main(String[] args) {
		
		try {
			//1.创建socket用来发送请求
			Socket socket = 
					new Socket(InetAddress.getByName("127.0.0.1"),8888);
			//2.创建输入流和输出流
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			//3.发送数据
			Scanner input = new Scanner(System.in);
			System.out.println("请输入用户名:");
			String username = input.nextLine();
			System.out.println("请输入密码:");
			String password = input.nextLine();
			User user = new User(username,password);
			oos.writeObject(user);
			//4.接收反馈信息并输出
			boolean flag = dis.readBoolean();
			if(flag) {
				System.out.println("登陆成功");
			}else {
				System.out.println("登陆失败");
			}
			//5.关闭流和socket
			dis.close();
			oos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
