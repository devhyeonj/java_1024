package day05;

public class WhileSumEx01 {
	public static void main(String[] args) {

		// 1부터 10사이의 홀수의 합을 구하는 코드를 while문으로 작성하세요
		int sum = 0,i= 1;

		while (i <= 10) {
			if(i % 2 !=0) {
				System.out.println("홀수확인"+i);
				sum+= i;
			}
			i++;
		}
		System.out.printf("1부터 10사이의 홀수의 합은 %d 입니다.",sum);
		
		System.out.println("===============================");
		
		while (++i <= 10) {
			if(i % 2 !=0) {
				System.out.println("홀수확인"+i);
				sum+= i;
			}
		}
		System.out.printf("1부터 10사이의 홀수의 합은 %d 입니다.",sum);

	}
}
