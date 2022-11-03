package day09;

public class staticEx01 {

	public static void main(String[] args) {
		KiaCar k1 = new KiaCar("모닝");
		KiaCar k2 = new KiaCar("레이");
		KiaCar k3 = new KiaCar("k3");
		k1.print();
		k2.print();
		k3.print();
		k1.name = "K5";
		//k1.logo = "Kia";
		KiaCar.logo = "Kia"; //일반적
		System.out.println("------------");
		k1.print();
		k2.print();
		k3.print();
	}

}

class KiaCar {
	public static String logo = "KIA"; // static은 공유하는 것 안붙은거는 객체 각각에 생성이되지만 static은 클래스 하나에 생성이된다.
	public String name;

	public KiaCar(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.print(logo);
		System.out.println(" : " + name);
	}
	
	public static void printLogo() { // static은 객체가 만들어지기전에 생성되기때문에 안되는거임
		System.out.print(logo);
		//System.out.println(" : " + name); // 필드 못써서 에러발생
	}
}
