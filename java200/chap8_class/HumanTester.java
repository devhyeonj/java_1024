package chap8_class;

class Human {
	//필드
	private String name;
	private int height;
	private int weight;
	
	//생성자
	public Human(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	String getName() {return name;}
	int getHeight() {return height;}
	int getWeight() {return weight;}
	
	//메소드
	
	//살이 찐다.
	void gainWeight(int w) {
		weight += w;
	}
	
	//살이 빠진다.
	void reduceWeight(int w) {
		weight -= w;
	}
	
	
}

public class HumanTester {
	public static void main(String[] args) {
		Human gildong = new Human("길동",170,60);
		Human chulsu = new Human("철수", 166, 72);
		
		gildong.gainWeight(3); // 길동이 3kg 쪘다.
		chulsu.reduceWeight(5); // 철수가 5kg 빠졌다.
		
		System.out.println("이름:" + gildong.getName());
		System.out.println("신장:" + gildong.getHeight() + "cm");
		System.out.println("체중:" + gildong.getWeight() + "kg");
		System.out.println();
		
		System.out.println("이름:" + chulsu.getName());
		System.out.println("신장:" + chulsu.getHeight()+ "cm");
		System.out.println("체중:" + chulsu.getWeight()+ "kg");
		
	}

}
