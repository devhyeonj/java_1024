package day10;

import java.util.Arrays;

public class BaseballGame {
	private int[] com; // com 은 맞출때까지 고정된값
	private int[] user;
	private int strike;
	private int ball;
	
	public int getStrike() {
		return strike;
	}

	public BaseballGame(int[] com) {//랜덤한 수 만들어진애가 오면
		this.com = Arrays.copyOf(com, com.length); // 매개변수에 있는 com를 복사해서 새로운 객체를 만듬
		//복사하고자하는 오리지널 배열 넣고, 복사하고자하는 총범위를 뒤에 넣어줌
	}	//깊은 복사 값들을 하나하나 가져와서 복사하는거
	
	public void setUser(int[] user) { // setter는 리턴타입이 void
		this.user = Arrays.copyOf(user, user.length);
		calculateResult(); // 계산하도록 시킴 
	}
	// 스트라이크 볼 내부적으로 계산 ( 유저가 입력될때마다
	private void calculateResult() {
		calculateStrike();
		calculateBall();
	}
	
	private void calculateStrike() {
		int count = 0;
		int size = com.length < user.length ? com.length : user.length; // 예외방지
		for (int i = 0; i < size; i++) {
			if(com[i] == user[i]) {
				count++;
			}
		}
		strike = count;
	}
	
	private void calculateBall() {
		int count = 0;
		for (int i = 0; i < com.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if(com[i] == user[j] && i!=j) {// 번지가 다른애들끼리 같은애들이있으면 count++;
					count++;
				}
			}
			ball = count;
		}
	}
	
	public void printResult() {
			if(strike != 0) {
				System.out.print(strike+"S ");
			}
			if(ball != 0) {
				System.out.print(ball + "B");
			}
			if(strike == 0 && ball == 0) {
				System.out.print("OUT");
			}
			System.out.println();
		}
	}


	
	
	
