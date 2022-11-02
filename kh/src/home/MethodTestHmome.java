package home;

import java.util.Arrays;
import java.util.Scanner;

import day06.ArrayLottoEx01;

public class MethodTestHmome {

	public static void main(String[] args) {
		/*
		 * 로또 번호를 랜덤으로 생성하고, 당첨번호를 입력하여 몇등 당첨됐는지 출력하는 코드를 작성하세요. 단 메소드를 이용할 것 
		 * 숫자범위 : 1~45 
		 * 1등 : 6개 
		 * 2등: 5개 + 보너스 번호 
		 * 3등 : 5개 
		 * 4등 : 4개 
		 * 5등 : 3개 
		 * 로또 번호 : 번호 6개와 + 보너스 번호
		 */
		int size = 6,sameCount=0;
		int[] randomLottoNumber = saveArrayRandom(size);
		System.out.print("랜덤 로또번호>>");printALL(randomLottoNumber);
		int[] userLottoNumber = scannerUserLottoNum(size);
		System.out.print("유저가 입력한 로또번호>>");printALL(userLottoNumber);
		sameCount = sameLotto(userLottoNumber, userLottoNumber, sameCount);
		System.out.println("맞춘 횟수:"+sameCount);
		resultLotto(sameCount);
		
	}
	
	/*
	 ** 1~45 사이의 번호를 랜덤으로 생성하는 메소드
	 */
	public static int random() {
		int r = (int) ((Math.random()*45)+1);
		return r;
	}
	// size별로 array 생성하는 메소드
	public static int[] saveArray(int size) {
		int[] array = new int[size];
		return array;
	}
	
	
	/*
	 * 랜덤으로 생성한 로또번호 배열에 저장하는 메소드
	 */
	public static int[] saveArrayRandom(int size) {
		int[] lotto = saveArray(size);
		for (int i = 0; i < size; i++) {
			lotto[i] = random();
		}
		boolean b = deleteDuplicated(lotto);
		if(b) {
			
		}
		return lotto;
	}
	
	/*
	 * 중복 제거 메소드 
	 */
	public static boolean deleteDuplicated(int[] num) {
		boolean isDuplicated = false;
		for (int i = 0; i < num.length ; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i] == num[j]) {
					num[i] = random();
				}
				if(num[i] == num[j]) {
					System.out.println(num[i]+"는 중복!!!!!!!!!!!");
					num[i] = random();
				}
			}
			
		}
		return isDuplicated;
		}
	
	/*
	 * 출력하는 메소드
	 */
	public static void printALL(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	/*
	 * 유저한테 입력 받는 메소드
	 */
	public static int[] scannerUserLottoNum(int size) {
		int user[] = saveArray(size);
		Scanner sc = new Scanner(System.in);
		System.out.print("로또 번호를 입력하세요(번호 6개 + 보너스번호)>>");
		for (int i = 0,num=0; i < size; i++) {
			num = sc.nextInt();
			user[i] = num;
		}
		return user;
		
	}
	
	/*
	 * 입력 받은 메소드랑 로또 번호가 일치하는지 확인하는 메소드(보너스 번호 제외) 안됨
	 */
	public static int sameLotto(int[] user,int[] lotto,int sameCount) {
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if(lotto[i] == user[j]) {
					sameCount++;
				}
			}
	}
		return sameCount;
	
	}
	
	/*
	 * 등수 판별하는 메소드 (안됨
	 */
	public static void resultLotto(int sameCount) {
	switch (sameCount) {
	case 6: {
		System.out.println("1등");
		break;
	}
	case 4: {
		System.out.println("4등");
		break;
	}
	case 3: {
		System.out.println("5등");
		break;
	}
	default:
		System.out.println("꽝!");
	}
}
	
}
