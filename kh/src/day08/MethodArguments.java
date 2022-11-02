package day08;

public class MethodArguments {

	public static void main(String[] args) {
		/*
		 * 매개변수의 개수를 다양하게 하고 싶을 때 가변 인자를 사용
		  매개 변수에 자료형...배열명 => 메소드에서 배열처럼 사용
		 */
		//가변인자가 항상 마지막에 와야된다. 같은자료형이야 한다( 첨부파일
		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
	}
	public static int sum(int ...nums) { // , 여러개 입력이지만 메소드안에는 배열처럼 사용함
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}
	
	public static int sum(int num) {
		return 0;
	}
	public static void score(int grade, int classNum, int num,String name,int...score) {
		
	}

}
