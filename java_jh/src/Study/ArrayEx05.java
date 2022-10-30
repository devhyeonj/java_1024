package Study;

//집가서 다시 해보기
public class ArrayEx05 {

	public static void main(String[] args) {

		/*
		 * 5개짜리 배열을 생성하여 2부터 5개의 소수를 배열에 저장하고 출력하세요
		 */
		int num = 0;
		int i;
		int count = 0;
		
		int[] arr = new int[5];
		int index = 0;
		
		for (num = 2  ; ; num++) {
			// num가 소수인지 판별하는 코드
			for (i = 1, count = 0; i <= num; i++) {
				if (num % i == 0) {
					count++;
				}
			}
			if (count == 2) {
				arr[index] = num;
				index++;
			}
			if(index == arr.length) {
				break;
		}
		
		}

	}
}
