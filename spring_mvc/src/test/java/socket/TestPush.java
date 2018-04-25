package socket;

import com.socket.util.StreamUtil;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author 逝兮诚
 * @date 2017年5月22日 下午3:32:00
 * socket实现push
 */
public class TestPush {
	
	@SuppressWarnings("resource")
	@Test
	public void pushService() throws IOException {
		ServerSocket serviceSocket = new ServerSocket(10888);
		while(true) {
			Socket socket = serviceSocket.accept();
			InputStream clientMsgIs = socket.getInputStream();
			String clientMsg = StreamUtil.inputStreamToString(clientMsgIs, "UTF-8");
			System.out.println(clientMsg);
			socket.shutdownInput();
			
			System.out.println("请输入推送信息：");
			Scanner sc = new Scanner(System.in);
			String pushMsg = sc.nextLine();
			
			OutputStream serviceOs = socket.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(serviceOs));
			while(!"end".equals(pushMsg)) {
				writer.write(pushMsg);
				writer.newLine();
				writer.flush();
				System.out.println("请输入推送信息：");
				sc = new Scanner(System.in);
				pushMsg = sc.nextLine();
			}
			socket.shutdownOutput();
			serviceOs.close();
			socket.close();
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void pushClient() throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 10888);
		
		OutputStream os = socket.getOutputStream();
		String cmsg = "client connect success";
		os.write(cmsg.getBytes("UTF-8"));
		os.flush();					//这是socket强制发送
		socket.shutdownOutput();
		
		InputStream serviceMsgIs = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(serviceMsgIs));
		String content = null;
		while(true) {
			if((content = reader.readLine()) != null) {
				 System.out.println(content);  
			}
		}
	}
}
