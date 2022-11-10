package day14;

import lombok.Data;

@Data
class Parent {

	private int num;
	
	public void print() {
		System.out.println(num);
	}
	
}

class Child extends Parent{}

public class RuntimeExceptionEx01 {

	public static void main(String[] args) {
		//RuntimeException은 코드 상 에러 표시가 안나고, 실행 시 예외가 발생할 수 있음
		// 예외처리가 필수가 아님
		int num1 = 1 , num2 =0;
		//System.out.println(1/0);
		//System.out.println(1%0);
		Parent p = null;
		//p.print();
		//exceptionTest(p);
		// 예외 발생. 배열의 크기가 음수
		int size = -1;
		//int []arr = new int[size];
	    int []arr2 = new int[5];
	    //ArrayIndexOutOfBoundsException 발생. 접근할 수 없는 번지에 접근시도
	    //arr2[5] = 5;
	    
	    Parent p1 = new Parent();
	    //ClassCastException 발생. 강제 클래스 변환이 불가능해서
	    Child C = (Child)p1;
	}
	
	
	public static void exceptionTest(Parent a) {
		//a가 null인 경우 NullPointerException 이 발생
		a.print();
	}
	
}

