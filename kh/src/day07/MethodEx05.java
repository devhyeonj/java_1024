package day07;

public class MethodEx05 {

	public static void main(String[] args) {
		// 1부터 10까지 합을 구하는 코드를 작성하세요. 단 , 메소드를 이용할 것

		System.out.println(sum(10, 1));

	}
	//출력하는 코드는 main에 입력하는게 났다
	/*
	 * 기능 : 시작숫자부터 끝숫자 사이의 모든 정수를 더하고, 더한 결과를 알려주는 메소드
	 * 매개변수 : 시작숫자, 끝숫자 => int start, int end
	 * 리턴타입 : 더한 결과 => 정수 => int
	 * 메소드명 : sum
	 */
	// 서로 숫자 바꾸는 코드
	public static int sum(int start, int end) {
		int sum = 0,tmp=0; // 메소드이름이랑 상관없음
		if(start > end) {
			tmp = start;
			start = end;
			end = tmp;
		}
		System.out.println(start+""+end);
		for (int i = start; i <= end; i++) {
			sum += i;
			}
		
		return sum;
	}

}
