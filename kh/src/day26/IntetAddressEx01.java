package day26;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IntetAddressEx01 {

	public static void main(String[] args) {
		InetAddress ia =  null;
		
		try {
			ia = InetAddress.getByName("localhost");
			System.out.println(ia);
			ia = InetAddress.getByName("www.naver.com");
			System.out.println(ia);
			//현재 내 pc ip
			ia = InetAddress.getLocalHost();
			System.out.println(ia);
			InetAddress[] ias = InetAddress.getAllByName("www.naver.com");
			for (InetAddress inetAddress : ias) {
				System.out.println(inetAddress);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
