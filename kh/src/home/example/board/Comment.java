package home.example.board;

import java.util.Objects;

import lombok.Data;

@Data
public class Comment {
	private static int count = 0;
	private int num;
	private int boardNum;
	private String contents,writer;
	
	
	public Comment(int num, String writer,String contents,boolean res) {
		this.writer = writer;
		this.contents = contents;
		if(res)
		num = count++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	@Override
	public String toString() {
		return num + " | " + writer + " | " + contents; 
	}

	
}
