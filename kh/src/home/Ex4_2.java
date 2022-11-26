package home;

import java.util.Scanner;
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
				System.out.println("사용자");
				RPS user = RPS.valueOf(sc.next());
				RPS com = randomRPS();
				System.out.println("컴퓨터");
				State state;
				state = resultState(user,com);
				printState(state);
			}catch(IllegalArgumentException e) {
				System.out.println("입력을 잘 못했습니다.");
			}
			System.out.println("더 하시겠습니까?(y/n) :");
		} while (!sc.next().equals("n"));
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
			return State.DRAW;
		}
		switch (user) {
		case 가위:
			return com == RPS.보? State.WIN : State.LOSE;
		case 바위:
			return com == RPS.가위?  State.WIN : State.LOSE;
		default:
			return com == RPS.바위 ?  State.WIN : State.LOSE;
		}
	}

	private static RPS randomRPS() {
		RPS[] rpss = RPS.values();
		int r = (int) (Math.random()*3);
		return rpss[r];
	}
}

enum RPS {
	가위,바위,보
}

enum State {
	WIN,LOSE,DRAW
}
