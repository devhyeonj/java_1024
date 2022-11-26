package day25;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex4_t {
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
		
		do {
			System.out.println("사용자: ");
			String user = sc.next();
			String com = randomRPS();
			System.out.println("컴퓨터: "+ com);
			int res = compare(user,com);
			printResult(res);
			System.out.println("더 하시겠습니까?(y/n)");
		}while(!sc.next().equals("n"));
	
		
	
		
		
	}

	private static void printResult(int res) {
		switch(res) {
		case 1:
			System.out.println("사용자가 이겼습니다.");
			break;
		case -1:
			System.out.println("컴퓨터가 이겼습니다.");
			break;
		default:
			System.out.println("비겼습니다.");
		}
	}

	private static int compare(String a, String b) {
		//비김을 처리
		if(a.equals(b))
			return 0;
		switch(a) {
		//a가 이기거나 지거나(1) 지거나 (-1)
		case "가위":
			return b.equals("보") ? 1 : -1;
		case "바위":
			return b.equals("가위") ? 1 : -1;
		default:
			return b.equals("바위") ? 1 : -1;
		}
	}

	private static String randomRPS() {
		List<String> list = Arrays.asList("가위","바위","보"); //리스트 초기화방법
		int r = (int) (Math.random()*3);
		return list.get(r);
	}
}
