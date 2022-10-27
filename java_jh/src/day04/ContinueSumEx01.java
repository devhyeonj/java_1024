package day04;

public class ContinueSumEx01 {
	
	public static void main(String[] args) {
		int i , sum=0;
		for (i = 0; i <= 10; i++) {
			if(i % 2 != 0) {
				continue;
			}
			sum += i;
		}
		System.out.println("1부터 10까지의 짝수의 합 :" + sum);
	}

}
