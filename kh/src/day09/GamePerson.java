package day09;

public class GamePerson {
	
	private String name;
	private int count;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void print() {
		System.out.println("이름:"+name+count+"회");
	}
	public GamePerson(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	@Override
	public String toString() {
		return "이름:"+name+ count+" 회";
	}
	
	
	
	
	

}
