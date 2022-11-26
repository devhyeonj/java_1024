package chap7_method;
// 양의 정숫값을 읽어서 뒤에서부터 읽어서 표시
import java.util.Scanner;

class readPlusInt {
	
	static Scanner sc = new Scanner(System.in); //메서드 밖에서 선언된 필드는 해당 클래스 전체에서 사용 가능

	// 양의 정숫값을 읽어서 반환
	static int readPlusInt() {
		int x;
		do {
			System.out.println("양의 정숫값:");
			x = sc.nextInt();
		}while(x<=0);
		return x;
	}
	public static void main(String[] args) {
		int x;
		do {
			int n = readPlusInt();
			
			System.out.print("반대로 읽으면 ");
			while(n > 0) {
				System.out.print(n%10);
				n/=10;
			}
			System.out.println("입니다.");
			
			do {
				System.out.print("다시 한번?<Yes...1/No...0>:");
				x = sc.nextInt();
			}while(x!=0 && x!=1);
		} while(x == 1);
	}
}
