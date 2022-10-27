package day04;
//복습하기
public class BreakPrimeNumberEx01 {

	public static void main(String[] args) {
		//소수 판별 처음만나는 약수를 찾아서 1인지 아닌지 판단 
		// break 문을 이용하여 소수를 판별하는 예제
		
		int num=11;
		int i;			//제일 작은수
		for (i = num-1; i >= 1 ; i--) {
			if(num % i == 0) {
				break;
			}
		}
		if(i == 1) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수 아님");
		}
	}

}
