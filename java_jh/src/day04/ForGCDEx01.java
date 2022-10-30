package day04;

public class ForGCDEx01 {

	public static void main(String[] args) {
		/*
		 * 두 정수의 최대 공약수를 구하는 코드를 작성하세요
		 * 약수 : 나누었을때 나머지가 0 이 되는수
		 * 공약수 : 두 정수의 약수들 중에서 공통으로 있는 약수
		 * 최대공약수 : 두 정수의 약수들 중에서 가장 큰 공약수
		 * 12: 1 2 3 4 6 12
		 * 18: 1 2 3 6 9 18
		 * 12와 18의 공약수 : 1 2 3 6
		 * 12와 18의 최대 공약수 : 6
		 */
		int num1 = 12,num2=18,gcd=0;
		for (int i = 1; i <= num1; i++) {
			if(num1 % i ==0 && num2 % i == 0) {
				gcd = i;
			}
		}
		System.out.printf("%d와 %d의 최대 공약수 :%d",num1,num2,gcd);
		

	}

}
