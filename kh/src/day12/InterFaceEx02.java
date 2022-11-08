package day12;

public class InterFaceEx02 {
	public static void main(String[] args) {
		
	}

}

interface TestA {
	/*
	 * 기존 인터페이스에 새로운 메소드를 추가해도 이미 구현된 구현 클래스에 영향이
	 * 가지 않게하기 위해 default메소드로 추가하면 된다.
	 */
	void testA();
	//default void testB() {} // default메소드 구현부가 없이 만들어짐 새로 추가 된 메소드가 디폴트 메소드면 꼭 얘를 구현하지않아도 에러가 안생김
}	// 기존의 메소드에 영향 주지않고 새로운 추가 메소드를 추가할수있다.
	class TestAA implements TestA {

	@Override
	public void testA() {
		System.out.println("AA");
	}
	
}
class TestAB implements TestA {

	@Override
	public void testA() {
		System.out.println("AB");
	}
	
}
