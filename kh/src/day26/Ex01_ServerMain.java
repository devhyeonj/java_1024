package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Scanner sc = new Scanner(System.in);
		final String encode = "UTF-8";

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			while(true) {
				System.out.println("[연결 대기 중...]");
				Socket socket = serverSocket.accept(); // 허용
				InetSocketAddress isa 
					= (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락 함] " + isa.getAddress());
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				byte[] bytes = new byte[1024]; // 읽어온데이터를저장함
				int readCount = is.read(bytes);
				//if(readCount == -1) break;
				String str = new String(bytes,0,readCount,encode);
				System.out.println(str);
				//콘솔에서 문자열을 입력받아 클라이언트로 전송하는 코드 작성
				str = sc.nextLine(); // 입력받음
				bytes = str.getBytes(encode); //바이트변환
				os.write(bytes);
				os.flush();
				System.out.println("[전송 완료]");
				is.close();// 묶어서 닫아야함
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
