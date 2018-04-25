package socket;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * @author 逝兮诚
 * @date 2017年5月22日 下午3:31:40
 * socket实现，只能进行一次数据发送
 */
public class TestSocket {
	
	@Test
	public void testService() throws IOException, InterruptedException {
		ServerSocket socket = new ServerSocket(10888);
		
		Socket socket2 = socket.accept();
		System.out.println("连接成功");
		
		InputStream is = socket2.getInputStream();
		byte[] bytes = new byte[1024];
		int l = 0;
		StringBuffer sb = new StringBuffer();
		while((l = is.read(bytes)) != -1) {
			is.read(bytes, 0, l);
			String str = new String(bytes, "UTF-8");
			sb.append(str);
		}
		System.out.println(sb.toString());
		
		OutputStream outputStream = socket2.getOutputStream();
		String a = "服务器消息";
		outputStream.write(a.getBytes("UTF-8"));
		outputStream.flush();
		socket2.shutdownOutput();
		
		outputStream.close();
		is.close();
		socket2.close();
		
	}
	
	@Test
	public void testClient() throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 10888);
		OutputStream os = socket.getOutputStream();
		String cmsg = "client connect success";
		os.write(cmsg.getBytes("UTF-8"));
		os.flush();					//这是socket强制发送
		socket.shutdownOutput();	
		
		InputStream is = socket.getInputStream();
		byte[] bs = new byte[1024];
		int l = 0;
		StringBuffer sb = new StringBuffer();
		while((l = is.read(bs)) != -1) {
			is.read(bs, 0, l);
			String bsstr = new String(bs, "UTF-8");
			sb.append(bsstr);
		}
		System.out.println(sb);
		socket.shutdownInput();
		
		is.close();
		os.close();
		socket.close();
	}

}
