package kr.kh.spring;

public class infoVO {
	private String name;
	private int num;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "infoVO [name=" + name + ", num=" + num + "]";
	}
	
	public infoVO(String name,int num) {
		this.name = name;
		this.num = num;
	}
}
