package day27;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import day27.Ex01_Server.Client;


public class Ex01_Client {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 시도중]");
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[연결 성공]");
			send(socket, "정현");
			recieve(socket);
		}catch(Exception e) {
			System.out.println("[연결 실패]");
		}

	}
	
	public static void recieve(Socket socket) {
		Thread t = new Thread(() -> {
			InputStream is = null;
			try {
				byte [] bytes = new byte[1024]; //최대길이
				is = socket.getInputStream();
				while(true) {
				int readCount = is.read(bytes);
				//byte[]에 있는 byte들을 문자열로 변환 , 0번지부터
				//readCount 개수만큼 변환하는데 인코딩은 UTF-8
				if(readCount == -1)
					break; // 읽어온 글자가 없으면 break;
				String str = new String(bytes, 0 ,readCount, "UTF-8");
				int index = str.indexOf(",");
				if(index == -1) 
					continue;
				String name = str.substring(0,index);
				String message = str.substring(index+1);
				System.out.println(name+">"+message);
				}
				is.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//읽기 위해서 대기하다 예외가 발생하면 socket을 닫아줌
				// => 클라이언트에서 접속을 종료함
					try {
						if(socket != null && !socket.isClosed())
						socket.close();
						System.out.println("[클라이언트 종료]");
					} catch (Exception e1) {
						System.out.println("클라이언드 소켓 닫기 실패");
					}
			}
		});
		t.start();
		
	}
											// id
	public static void send(Socket socket,String name) {
		Thread t = new Thread(() -> {
			Scanner sc = new Scanner(System.in);
			try {
				OutputStream os = socket.getOutputStream();
				while(true) {
					String str = sc.nextLine();
					if(str.equals("exit")) {
						break;
					}
					str = name + ","+str;
					byte[] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
				os.close();
			}catch(Exception e) {
				
			}finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				}catch(Exception e) {
					
				}
			}
			
		});
		t.start();
	}

}
