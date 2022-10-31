package day02;

import java.util.Scanner;

public class OperatorEx05 {

	public static void main(String[] args) {
		/*
		 * 홍길동 학생의 국어,영어,수학 점수를 콘솔에 입력받고,
		 * 홍길동 학생 평균 성적을 콘솔에 출력하는 코드를 작성하세요.
		 */
		// 과목 점수 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 영어 수학 점수를 입력하세요>>>>");
		int ko,en,su,sum;
		ko = sc.nextInt();
		en = sc.nextInt();
		su =  sc.nextInt();
		sc.close();
		// 총점을 계산
		sum = ko + en + su; // 총점
		
		// 평균을 계산
		double avg = sum/3.0; // 평균
		
		//평균을 출력
		//통과입니까? true/false
		//평균이 60점 이상이면 true , false
		System.out.println("홍길동 학생의 평균 성적>>>>" + (avg)+"점 입니다." + "\n통과 입니까???????"+(avg >= 60));
		
		//통과를 알려주는 변수, 실패를 알려주는 변수 (수업
		boolean isPass = avg >= 60;
		boolean isFail = avg < 60;
		System.out.println("통과입니까?" + isPass);
		System.out.println("통과입니까?" + !isFail);

		

	}

}
