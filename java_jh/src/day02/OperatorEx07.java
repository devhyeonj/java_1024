package day02;

public class OperatorEx07 {

	public static void main(String[] args) {
		/*
		 * 조건선택연산자
		 * - 조건식 ? 참일때 : 거짓일떄;
		 */
		// 주어진 성적이 60점 이상이면 Pass , 아니면 Fail
		int score = 80;
		String result = score>= 60 ? "Pass" : "Fail";
		System.out.println(result);
	}

}
