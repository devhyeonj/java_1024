package day04;

public class BreakEx01 {
	
	public static void main(String[] args) {
		// break를 만나면 증감식으로 가지 않고, 반복문을 빠져 나감
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello World!");
			if(i == 3)
			break; // 감싸고 있는 가까운 for문을 빠져나옴
		}
	}

}
