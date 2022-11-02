package day08;
// 클래스에 가장 기본적인 코드
public class ClassEx01 {
	
	public static void main(String[] args) {
		//기본 생성자 호출
		Point pt = new Point();
		pt.print();
		pt.move(2,2);
		pt.print();
		//생성자 오버로딩 호출
		Point pt1 = new Point(3, 1);
		pt1.print();
		//복사 생성자 호출(생성자 오버로딩)
		Point pt2 = new Point(pt1);
		pt2.print();
	}

}
/*
 * 2차원 좌표평면의 점을 나타내는 클래스
 * - 필드
 * x좌표, y좌표
 * - 메소드(기능)
 * 좌표 출력 기능
 * 좌표 이동 기능
 */
class Point{
	private int x,y; // 멤버변수는 기본값으로 초기화가 된다.
	public void print() {
		System.out.println("좌표 : " + x + "," + y);
	}
	
	public void move(int x1,int y1) {
		x = x1;
		y = y1;
	}
	
	public Point() {
		x = 3;
		y = 3;
	}

	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}
	
	public Point(Point pt) {
		x = pt.x;
		y = pt.y;
	}
	
	
}
