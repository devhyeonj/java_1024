package day31;

import lombok.Data;
//얕은복사 한쪽이 바뀌면 다같이 바뀌는게 얕은복사임 (공유)
//참조변수는 = 는 공유임 한쪽이변하면 같이 변함 그래서 new 해줘야됨// 아니면 clone사용 // 스트링은 가능함
public class CopyEx01 {
	public static void main(String[] args) {
		Test t1 = new Test(10,20,"홍길동");
		Test t2 = t1;
		System.out.println("t1 : " + t1);
		System.out.println("t2 : " + t2);
		
		System.out.println("-------------");
		
		t1.setNum1(30);
		t1.getSub().setName("임꺽정");
		System.out.println("t1 : " + t1);
		System.out.println("t2 : " + t2);
		
		//깊은 복사
		// 필드를 복사해서 가져오기때문에 밖에서 바꿔도 영향이 없음
		Test t3 = new Test(10,20,"홍길동");
		Test t4 = new Test(t3); //t3값을 가져와서 복사
		System.out.println("---------------");
		System.out.println("t1 : " + t3);
		System.out.println("t2 : " + t4);
		System.out.println("-----------");
		t3.setNum1(30);
		t3.getSub().setName("임꺽정");
		System.out.println("t3:" + t3);
		System.out.println("t4:" + t4);
	}
}
@Data
class Test{
	int num1,num2;
	Sub sub; //지금 만든 클래스의 객체가 오는 경우
	public Test(int num1, int num2, String name) {
		this.num1 = num1;
		this.num2 = num2;
		this.sub = new Sub(name);
	}
	
	public Test(Test t) {
		this.num1 = t.num1;
		this.num2 = t.num2;
		//깊은복사를 하려면 필드가 참조변수인 경우,
		//필드가 참조변수인 경우,생성자를 이용하여 복새해야함
		this.sub = new Sub(t.sub.getName());
		//this.sub = new Sub(t.sub);//t.sub;
	}
}
@Data
class Sub {
	String name;
	public Sub(String name) {
		this.name = name;
	}
	
	public Sub(Sub sub) {
		this.name = sub.name;
	}
}
