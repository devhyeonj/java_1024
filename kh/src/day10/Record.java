package day10;
// 저장하기 위한
public class Record {
	
	private int count;  // 횟수 ( 정해져있음
	private String name; // 이름
	
	public Record(int count, String name) {
		this.count = count;
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void pirnt() {
		System.out.println(name + " : "+count);
	}
	
	
	

}
