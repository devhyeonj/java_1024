package day12;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	//접근제한자 예약어 리턴타입 메소드명(매개변수);
	//추상 클래스를 상속 받은 일반 클래스를 부모의 추상 메소드를 반드시 오버라이딩 해야함
	// 추상 클래스를 상속 받은 추상 클래스는 추상 메소드를 반드시 오버라이딩 해야하는건 아님

}
// 공동작업
interface Calucator {
	// 자동으로 public final붙음
	//static 붙은애들이 기울어져있음
	int max = 30;
	int sum(int num1,int num2);
	int sub(int num1,int num2);
	int mul(int num1,int num2);
	double div(int num1,int num2);
	int mod(int num1,int num2);
	int run();
}
