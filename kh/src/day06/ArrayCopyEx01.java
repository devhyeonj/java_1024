package day06;

// 1
public class ArrayCopyEx01 {

	public static void main(String[] args) {
		// 배열의 얕은 복사 예제 (공유폴더 수정
		int arr1[] = new int[3];
		int arr2[];
		arr2 = arr1; // arr1을 얕은 복사해서 arr2를 만듬
		// arr1과 arr2값 확인
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i] + ",arr2[" + i + "]=" + arr2[i]);
		}
		
		System.out.println();
		// 같이 10으로 바뀌는걸 확인 할 수 있다.
		arr1[0] = 10;
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i] + ",arr2[" + i + "]=" + arr2[i]);
		}
	}
}
