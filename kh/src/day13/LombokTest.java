package day13;

import lombok.Data;

public class LombokTest {

	public static void main(String[] args) {
		TestA t1 = new TestA();
		t1.setNum(10);
		System.out.println(t1.getNum());
		System.out.println(t1); //toString() 확인
		TestA t2 = new TestA();
		t2.setNum(10);
		System.out.println(t1.equals(t2));
	}

}

@Data // @Getter @Setter @ToStrng @EqualsAndHashCode @RequiredArgsConstructor
													// 기본생성자
class TestA {
	private int num;
	
}