package day18;

import java.util.Scanner;

public class EnumEx02 {

	public static void main(String[] args) {
		/*
		 * 오늘의 요일을 영어로 입력받아 한글로 출력하는 코드를 작성하세요
		 * 요일 : WEDNESDAY
		 * 수요일
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		String day = sc.next();
		try {
		Week week = Week.valueOf(day);
		switch(week) {
		case MONDAY:
			System.out.println("월요일");
			break;
		case THUESDAY:
			System.out.println("화요일");
			break;
		case WEDNESDAY:
			System.out.println("수요일");
			break;
		case THURSDAY:
			System.out.println("목요일");
			break;
		case FRIEDAY:
			System.out.println("금요일");
			break;
		case SATURDAY:
			System.out.println("토요일");
			break;
		}
		}catch(Exception e) {
			System.out.println("잘못 입력했습니다.");
		}
	}
}

enum Week {
	MONDAY,THUESDAY,
	WEDNESDAY ,
	THURSDAY, FRIEDAY, SATURDAY
	
}