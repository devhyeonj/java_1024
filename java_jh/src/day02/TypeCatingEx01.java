package day02;

public class TypeCatingEx01 {

	public static void main(String[] args) {
		// 접미사 f(F)가 없는 실수 리터럴은 double형
		// 8바이트 double 이고 , 4바이트인 float이기 때문에 자동 형변환이 불가능하다 => 접미사를 붙이거나 강제형변환
		float num1 = (float)1.23;
		// 정수 리터럴은 자료형에 맞는 타입으로 설정 
		byte num2 = 3;
		long num3 = 3;
		int num4 = (int) 12345678901L; // 큰 숫자는 int형 범위를 넘어가면 에러가 발생함, 적절한 타입 L을 붙여주고 int로 강제 형변환해줌

	}

}
