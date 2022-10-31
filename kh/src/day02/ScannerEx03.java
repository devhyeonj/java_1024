package day02;

import java.util.Scanner;

public class ScannerEx03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 콘솔에서 한 단어이상을 입력하면,next() ,nextLine() 순으로 동작을 하면
		// nextLine에는 콘솔에서 따로 입력하지 않아도 앞에서 입력한 값이 들어간다.
		System.out.println("한 단어를 입력하세요 :");
		String str2 = sc.next();
		System.out.println(str2);
		
		// 입력버퍼 현상 없이 정상없이 출력하려면..?
		sc.nextLine(); // 입력버퍼에 남아 있는 문자열과 공백을 제거해줌
		
		System.out.println("한 문장을 입력하세요 :");
		String str1 = sc.nextLine();
		System.out.println(str1);
		
		sc.close();
		
		/* 입력버퍼 현상
		 * 나머지는 스캐너 라인이 가져감 ex) 홍길동 엔터 -> 홍길동 한 문장을 입력하세요 : 엔터
		 */
		

	}

}
