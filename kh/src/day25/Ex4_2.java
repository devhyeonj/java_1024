package day25;

import java.util.Scanner;
// 열거형 숫자보다 직관적이다.
public class Ex4_2 {
	/*
	 * 컴퓨터와 가위, 바위, 보 를 하는 프로그램을 작성하세요
	 * - 사용자가 연속 3번 이길때까지 반복
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 * 컴퓨터가 이겼습니다. 더 하겠습니까?
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				System.out.println("사용자: ");
				RPS user = RPS.valueOf( sc.next()); // 입력받은 문자열을 열거형 문자열 객체로 바꿔줌
				RPS com = randomRPS(); //객체로 넘겨줌
				System.out.println("컴퓨터:" + com);
				State state;
				state = resultState(user,com);
				printState(state);
			}catch (IllegalArgumentException e) {
				System.out.println("입력을 잘 못했습니다.");
			}
			System.out.println("더 하시겠습니까?(y/n) :");
		}while(!sc.next().equals("n"));
		
		
	
		
		
	}

	private static void printState(State state) {
		switch (state) {
		case WIN:
			System.out.println("사용자가 이겼습니다.");
			break;
		case LOSE:
			System.out.println("컴퓨터가 이겼습니다.");
			break;
		default:
			System.out.println("비겼습니다.");
			break;
		}
	}

	private static State resultState(RPS user, RPS com) {
		if(user == com) {
			return State.DRAW; // 0 1 -1 보이는거보다 이해가 되게 보여서
		}
		switch (user) {
		case 가위:
			return com == RPS.보 ? State.WIN : State.LOSE;
		case 바위:
			return com == RPS.가위 ? State.WIN : State.LOSE;
		default:
			return com == RPS.바위 ? State.WIN : State.LOSE;
		}
	}

	private static RPS randomRPS() {
		RPS[] rpss = RPS.values(); // 가위바위보 얘내들을 객체로 만들어서 순서대로 배열번지에 넣음
		int r = (int) (Math.random()*3);
		return rpss[r];
	}

}
enum RPS {
	가위,바위,보
}

enum State { //사용자 기준으로 상태
	WIN,LOSE,DRAW // 이긴거 진거 비긴거
}