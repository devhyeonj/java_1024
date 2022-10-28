package day05;

public class ForEx01 {

	public static void main(String[] args) {
		int i;
		for (i = 1; i <=5; i++); 
		{// ;세미콜론때문에 반복문이랑 별개임
			System.out.println(i);
		}
		i = 5;
		if(i % 2 ==0 ); // ;에 의해 if문 실행문이 짝수 출력이 아니라 없음
		// i값과 상관없이 짝수가 출력
		{
			System.out.println("짝수");
		}
		//else {
			System.out.println("홀수");
//		}
			//조건문, 반복문은 실행문이 1줄이면 {}생략이 가능
			for (i = 1; i <=5; i++) 
				System.out.println(i);
			
	}

}
