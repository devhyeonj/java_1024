package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		// 학생 5명의 국어 성적을 입력받고 출력하는 코드를 작성하세요

		Scanner sc = new Scanner(System.in);

		int[] stu = new int[5];
		int kor = 0;

		for (int i = 0; i < stu.length; i++) {
			System.out.print((stu[i] + i + 1) + "학생의 국어 성적을 입력 하세요>>");
			kor = sc.nextInt();
			stu[i] = kor;
		}

		for (int tmp : stu) {
			System.out.println(tmp);
		}
		/*
		 * 학생 성적의 평균을 구하는 코드를 작성하세요.
		 */
		int sum=0;
		
		//기본for문
		for (int i = 0; i < stu.length; i++) {
			 sum += stu[i];  
		}
		
		double avg = (double)sum/stu.length; // 형변환
		
		System.out.println(stu.length+"명의 성적 평균은:"+avg+"입니다.");
		sum = 0;
		
		// 향상된 for문
		for (int tmp : stu) {
			sum+= tmp;
		}
		avg = (double)sum/stu.length; // 형변환
		
		System.out.println(stu.length+"명의 성적 평균은:"+avg+"입니다.");

		sc.close();

	}

}
