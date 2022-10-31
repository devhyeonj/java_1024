package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		// 학생 5명의 국어 성적을 입력받고 출력하는 코드를 작성하세요
		Scanner sc= new Scanner(System.in);
		
		int[] score = new int[5];
		
		for (int i = 0; i < score.length; i++) {
			System.out.print(i+1+"번 학생의 국어 성적을 입력하세요:");
			score[i] = sc.nextInt();
			System.out.println(i+1+"번 학생의 국어 성적:"+ score[i]);
		}
		
		/* 학생 성적의 평균을 구하는 코드를 작성하세요.*/
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum+= score[i];
		}
		double avg = (double)sum/score.length;
		System.out.println("학생들의 평균:"+avg);
		
		//향상된 for문이용
		for (int i : score) {
			sum+= i;
		}
		avg = (double)sum / score.length;
		System.out.println("학생들의 평균 : " + avg);
		sc.close();
	}
}
