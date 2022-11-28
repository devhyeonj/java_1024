package day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_ClientMain {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			socket	= new Socket();
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[연결 완료]");
			//Output 스트림 연결
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			//보내려는 문자열을 byte 배열로 변환
			String str = sc.nextLine();
			byte[] bytes = str.getBytes("UTF-8");
			//전송
			os.write(bytes);
			os.flush(); // 밀어줌
			bytes = new byte[1024];

			int readCount = is.read(bytes);
			str = new String(bytes, 0, readCount, "UTF-8"); //문자열로 바꿔주기위해서 생성자를 이용
			System.out.println(str); // 출력
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
