package day07;

public class MethodArrayEx02 {

	public static void main(String[] args) {
		/*
		 * 1~9 사이의 랜덤한 수를 배열에 3개 저장하는 코드를 작성하세요 메소드를 이용 할 것
		 */
		int[] arr = new int[3];
		int min = 1,max=9;
		createRandomArray1(arr,min,max);
		printArray(arr);
		saveArray(arr,min,max); // 내가한 코드 
		int [] arr2 = createRandomArray2(min, max, 3);
		printArray(arr2);
	
	}
	
	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	/*
	 * 기능 : 최소값과 최대값 사이의 랜덤한 수를 주어진 배열에 저장하는 메소드
	 * 매개변수 : 최소값, 최대값, 배열 => int arr[], int min, int max
	 * 리턴타입 : 없음 => void
	 * 메소드명 : createRandomArray1
	 */
	public static void createRandomArray1(int arr[], int min, int max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random(min,max);
		}
	}
	// 배열을 안에서 넘겨주는건지 밖에서 넘겨주는건지의 차이
	
	/*
	 * 기능 : 최소값과 최대값과 사이의 랜덤한 수를 n개 만들어 배열에 저장한 후, 
	 * 		 저장된 배열을 반환하는 메소드
	 * 매개변수 : 최소값, 최대값, 만들 개수 => int min, int max, int size;
	 * 리턴타입 : 랜덤한 수가 저장된 배열 => int[]
	 * 메소드명 : createRandomArray2
	 */
	
	public static int[] createRandomArray2(int min,int max,int size) {
		int arr[] = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random(min,max);
		}
		return arr;
	}
	/*
	 * 기능 : 최소값과 최대값 사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 매개변수 : 최소값, 최대값 => int min, int max
	 * 리턴타입 : 랜덤한 수 => 정수 => int
	 * 메소드명 : random
	 */
	public static int random(int min, int max) {
		return random(min,max);
	}
	
	
	
	
	
	
	//내가한코드
	public static void saveArray(int arr[],int min,int max) {
		for (int i = 0; i < arr.length; i++) {
			int r = random(min,max);
			arr[i] = r;
			System.out.println(arr[i]);
		}
	}
	
	}
