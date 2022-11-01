package day07;
// 참조변수 안바뀌는 예제
public class MethodEx06 {
	
	public static void main(String[] args) {
		int [] arr = {1,3,5};
		test(arr);
		for (int tmp : arr) {
			System.out.println(tmp+"");
		}
	}
	
	public static void test(int[] arr) { // main arr[] 를 같이 공유를 함
		//arr = new int [3]; // 연결을 끊고 new(를 통해서) int[3]이 새로운 배열을 만듬
		arr[0] = 10;
	}

}
