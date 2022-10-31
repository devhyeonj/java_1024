package day06;

import java.util.Scanner;
// 다시 해보기
public class ArrayRandomEx01 {

	public static void main(String[] args) {
		// 랜덤으로 1~9 사이의 숫자를 3개 생성하여 배열 저장하는 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);

		int size = 3;
		int[] num = new int[size];

		for (int i = 0; i < size; i++) {
			num[i] = (int) (Math.random() * 9) + 1;
		}

		int numN = 0;
		for (int tmp : num) {
			System.out.println("랜덤 값" + tmp);
		}

		// 정수를 입력받아 랜덤한 수에 있는지 없는지 확인해서 알려주는 코드를 작성하세요.
		
		System.out.print("정수입력>>");
		numN = sc.nextInt();

		boolean isDuplicated = false;//중복이 안됨으로 초기화
		
		for (int i = 0; i < num.length; i++) {
			//i번지에 있는 값과 num가 같으면 
			if(num[i] == numN ) {
				//중복됐다고 저장함
				isDuplicated = true;
				break;
			}
		}
		//중복 됐으면 있다고 출력하고 아니면 없다고 출력
		if(isDuplicated) {
			System.out.println(numN+"가 있습니다.");
		}else {
			System.out.println(numN+"가 없습니다.");
		}
		sc.close();
	}
}
