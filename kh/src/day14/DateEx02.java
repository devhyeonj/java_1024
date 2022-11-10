package day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx02 {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		//Date를 원하는 패턴의 시간형태로 문자열로 변환
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateStr = format.format(date);
		System.out.println(dateStr);
		
		// 문자열로 Date로 변환
		String str = "2022-11-12 00:01:02";
		Date date2 = null;
		try {
			date2 = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(date2);
		}
	}

}
