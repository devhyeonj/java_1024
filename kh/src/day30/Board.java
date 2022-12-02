package day30;

import lombok.Data;

@Data
public class Board {
	private int num;
	private String title, contents, writer;

	@Override
	public String toString() {
		return num + " | " + title + " | " + writer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	public void print() {
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("작성자: " + writer);
		System.out.println("내용 : " + contents);
	}

	public Board(int num, String title, String contents, String writer) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}

	public Board(int num) {
		this.num = num;
	}

}