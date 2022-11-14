package example.accountbook;

import java.util.Scanner;
/*
 추가 - 가계부를 년,월,일로 정렬
가계부가 필요
가계부는 내역들로 구성
가계부 클래스
내역(항목) 클래스
가계부는 내역들을 가지고 있다.(포함관계) => 가계부 클래스에 내역 객체가 필드
메인은 가계부 실행만 하고 가계부에서 모든걸 해야한다.
내역 추가, 확인 , 수정 ,삭제 인터페이스로 묶을 수 있다.
 */
public class AccountBookMain {
	// 메인은 그냥 프로그램 실행만 하는게 좋음 그런게 객체지향
	public static void main(String[] args) {
		//스캐너를 주면서 가계부를 만듬
		AccountBook ab = new AccountBook(new Scanner(System.in));
		// 가계부 실행
		ab.run();
	}

}
