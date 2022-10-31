package day06;

import java.util.Scanner;
// 내가 한 코드
public class ArrayScoreEx01 {

	public static void main(String[] args) {
		/* 5명 학생의 국어, 영어, 수학 성적을 저장하기 위한 배열을 만들고,
		 * Scanner를 이용하여 입력받아, 국어평균, 영어 평균, 수학 평균을 구하는 코드를 작성하세요
		 */
		Scanner sc = new Scanner(System.in);
		
		int stdCount = 5;
		int[] kor = new int[5];
		int[] eng = new int[5];
		int[] math = new int[5];
		double sum1 =0 , sum2=0, sum3=0; // 국영수 합계 변수
		
		for (int i = 0; i <=4; i++) {
			System.out.print("학생" + (i + 1) + "의 국어,영어,수학 성적을 입력");
			kor[i] = sc.nextInt();
			eng[i] = sc.nextInt();
			math[i] = sc.nextInt();
			sum1 += kor[i];
			sum2 += eng[i];
			sum3 += math[i];
		}
		//과목별 평균
		System.out.println("5명의 학생의 국어 평균은>>"+  sum1 / kor.length);
		System.out.println("5명의 학생의 영어 평균은>>"+ sum2 / eng.length);
		System.out.println("5명의 학생의 수학 평균은>>"+ sum3 / math.length);
		
		//학생별 평균
		for (int i = 0; i < stdCount; i++) {
			double sum = kor[i] + eng[i] + math[i];
			System.out.println("학생" + (i + 1) + "의 평균 :" + sum / 3);
		}

	}
}
