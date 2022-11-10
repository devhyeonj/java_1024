package day14;

import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
		/*
		 * Calendar 클래스 : 날짜와 관련된 클래스
		 * get() 을 통해서 년도, 월, 일 , 시 , 분, 초등 다양한 정보를 가져옴
		 */
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1); // 1년뒤를 추가함
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // month 0부터 시작함
		int day = cal.get(Calendar.DATE);
		System.out.println(year+"년 "+(month+1)+"월 "+day+"일");
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.print(hour+"시");
		int min = cal.get(Calendar.MINUTE);
		System.out.print(min+"분");
		int sec = cal.get(Calendar.SECOND);
		System.out.print(sec + "초");
		
	}

}
