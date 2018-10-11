package TCPDemo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
	public static void main(String[] args) {
		
		try {
			//1.创建一个ServerSocket,指定等待端口
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.使用ServerSocket接收用户请求（处于监听状态）
			Socket socket = serverSocket.accept();
			//3.创建输入流和输出流
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			//4.接收用户数据并输出
			User user = (User)ois.readObject();
			System.out.println("我是服务器端，收到信息："+user);
			//5.发送反馈信息
			boolean flag = false;
			if("root".equals(user.getUsername()) 
					&& "123456".equals(user.getPassword())){
				flag = true;
			}
			dos.writeBoolean(flag);
			//6.关闭流和socket
			ois.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
