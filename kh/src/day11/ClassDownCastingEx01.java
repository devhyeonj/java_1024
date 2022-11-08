package day11;

public class ClassDownCastingEx01 {

	public static void main(String[] args) {
		/* 클래스 다운 캐스팅은 조건부로 가능
		 * 안되는 경우 : 부모 클래스의 객체를 바로 자식 클래스의 객체에 저장하는 경우
		 */
		//KiaCar kcar = (KiaCar) (new Car(4, "k5", 0x00ff00, "123허1234","기아"));
		//kcar.print();
		
		
		/*
		 * 되는 경우 : 자식 클래스의 객체를 부모 클래스의 객체에 저장 한 후,
		 * 부모 클래스의 객체를 다시 자식 클래스의 객체로 저장하는 경우
		 */
		KiaCar kcar1 = new KiaCar (4, "k5", 0x00ff00, "123허1234");
		Car car = (Car) kcar1;
		Car car1 = new KiaCar (4, "k5", 0x00ff00, "123허1234");
		
		//
		Car[] carList = new Car[5]; // 하나의 타입으로 여러타입의 객체를 관리할수있기때문
		carList[0] = new KiaCar(4, "k5", 0x00ff00, "123허1234");
		carList[1] = new HyundaiCar(4, "쏘나타", 0xff0000, "456가1234");
		for(Car tmp : carList) {
			// 차 종류에 맞게 기아면 수동으로 현대면 자동으로 트렁크가 열리기 위해
			// 다운캐스팅을 함
			if(tmp instanceof KiaCar) {
				((KiaCar) tmp).hand();
			}else  if(tmp instanceof HyundaiCar) {
				(( HyundaiCar) tmp).auto();
			}
		}
		
	}
}
