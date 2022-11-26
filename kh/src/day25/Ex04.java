package day25;

import java.util.Scanner;

public class Ex04 {
	/*
	 * 컴퓨터와 가위, 바위, 보 를 하는 프로그램을 작성하세요
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자가 이겼습니다. 더 하겠습니까?(y/n) : y
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 * 컴퓨터가 이겼습니다. 더 하겠습니까?
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char ch;
		//1 가위 2바위 3보 
		
		do {
			int random = (int)(Math.random()*3)+1;
			System.out.println("사용자:");
			String str = sc.next();
			game(random,str);
			System.out.println("더 하겠습니까?(y/n)");
			ch = sc.next().charAt(0);
		}while(ch != 'n');
		
		
	}

	public static void game(int random,String str) {
		int computer;
		switch (str) {
		case "가위"://가위
			System.out.println("사용자:"+str);
			computer = computer(random);
			if(computer == 1) {
				System.out.println("비겼습니다.");
			}else if(computer == 2) {
				System.out.println("컴퓨터가 이겼습니다.");
			}else if(computer == 3) {
				System.out.println("사용자가 이겼습니다.");
			}
			break;
		case "바위":
			System.out.println("사용자:"+str);
			computer = computer(random);
			if(computer == 1) {
				System.out.println("사용자가 이겼습니다.");
			}else if(computer == 2) {
				System.out.println("비겼습니다.");
			}else if(computer == 3) {
				System.out.println("컴퓨터가 이겼습니다.");
			}
			break;
		case "보":
			System.out.println("사용자:"+str);
			computer = computer(random);
			if(computer == 1) {
				System.out.println("컴퓨터가 이겼습니다.");
			}else if(computer == 2) {
				System.out.println("사용자가 이겼습니다.");
			}else if(computer == 3) {
				System.out.println("비겼습니다.");
			}
			break;
		
		}
	}

	private static int computer(int random) {
		switch (random) {
		case 1:
			System.out.println("컴퓨터 : 가위");
			break;
		case 2:
			System.out.println("컴퓨터 : 바위");
			break;
		case 3:
			System.out.println("컴퓨터 : 보");
			break;
		}
		return random; 
	}

}
