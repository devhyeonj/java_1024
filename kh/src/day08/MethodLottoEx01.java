package day08;

import java.util.Arrays;
import java.util.Scanner;

//1 로또 만들기 예제 
//메소드를 쓰면 구조적으로 파악하기 좋다.
public class MethodLottoEx01 {

	public static void main(String[] args) {
		int min = 1, max = 45;
		int size = 6;
		int [] lotto = createRandomArray(min, max, size);
		Arrays.sort(lotto);
		System.out.println("로또 번호:");
		printArray(lotto);
		//보너스 번호 생성
		int bonus;
		do {
			bonus = random(min, max);
		}while(contains(lotto, bonus));
		System.out.println("보너스 번호 : " + bonus);
		Scanner sc = new Scanner(System.in);
		int [] user = new int [size];
		System.out.print("입력번호>>");
		for (int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(countLotto(lotto, user)+"개 맞추셨습니다.");
		
		//당첨 등수를 알려주는 코드를 작성하세요. 단, 메소드를 이용할 것
		resultLotto(countLotto(lotto, user), lotto, user,bonus);	
		
		//강사님 코드
		int rank = getRank(lotto, bonus, user);
		printRank(rank);
		
		
	} 
	
	//강사님 코드 ( 코드 간결해짐)
	public static int getRank(int[] lotto,int bonus,int[] user) {
		int count = countLotto(lotto, user);
		switch (count) {
		case 6: return 1;
		case 5: return contains(user, bonus)? 2:3;		// return case를 빠져나가서 break가 필요없다
		case 4: return 4;
		case 3: return 5;
		default: return -1;
		}
	}
	
	public static void printRank(int rank) {
		switch (rank) {
		case 1: System.out.println("1등");break;
		case 2:System.out.println("2등");break;
		case 3:System.out.println("3등");break;
		case 4:System.out.println("4등");break;
		case 5:System.out.println("5등");break;
		case -1:System.out.println("꽝!");break;
		}
	}
	
	
	
	
	
	
	
	/*
	 * 기능: 주어진 일치하는 숫자의 개수를 판단해서 출력하는 메소드
	 * 매개변수 : 일치하는 숫자의 갯수,두 배열 -> int sameCount,int lotto[] int user[]
	 * 리턴타입 : void
	 * 메소드명: resultLotto
	 */
	//내가 한 코드
	public static void resultLotto(int sameCount,int lotto[],int user[],int bonus) {
		switch (sameCount) {
		case 6: {
			System.out.println("1등");
			break;
		}
		case 5: {//2등 //3등
			boolean isDuplicated = false;
				if(contains(user, bonus)) {
					sameCount++;
					isDuplicated = true;
			}
			if(isDuplicated) {
				System.out.println("2등");
			}else {
				System.out.println("3등");
			}
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
	
	/*
	 * 기능 : 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 주어진 두 배열 => int[] lotto, int[] user
	 * 리턴타입 : 일치하는 숫자의 개수 int  => 정수 => int
	 * 메소드명 : countLotto
	 */
	public static int countLotto(int[] lotto, int[] user) {
		if(lotto == null || user == null) {
			return 0;
		}
		int sameCount=0;
		for (int i : user) {
			if(contains(lotto, i)) {
				sameCount++;
			}
		}
		return sameCount;
	
	}
	
	//출력하는 메소드
	public static void printArray(int arr[]) {
		if(arr == null) { // 일반적으로 null로 초기화 함 할당이 안되있음
			return; // 배열이 비어있으면 출력할게 없다
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	//중복 허용 안되게 수정
	// i는 0부터 i가 배열의 크기보다 작을때까지
	public static int[] createRandomArray(int min,int max,int size) {
		if(max - min + 1 <= size) {// min과 max에서 표현할수 있는 갯수
			return null; // 비어있습니다.
		}
		int arr[] = new int[size];
		for (int i = 0; i < arr.length; ) { // 무한루프 
			//랜덤한 수를 r에 저장
			int r = random(min,max); // 배열에 바로 저장하지말고 변수에 저장해서 배열에 값이 있는지 없는지 체크
			if(!contains(arr, r)) {
				// 배열에 r이 없으면 배열 i 번지에 r 저장 한후, i를 1증가	
				arr[i] = r;
				i++;
			}
		}
		return arr;
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max-min+1)+min);
	}
	
	//중복
	public static boolean contains(int[]arr , int num) {
		if(arr == null || arr.length == 0) {//배열이 0개일수도 있다.
			return false;
		}
		for (int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}

}
