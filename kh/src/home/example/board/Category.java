package home.example.board;

import java.util.Objects;

import lombok.Data;

@Data
public class Category {
	private static int count = 0;
	private int num;
	private String categoryName;
	
	public Category(int num, String categoryName, boolean res) {
		this.categoryName = categoryName;
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
		Category other = (Category) obj;
		return Objects.equals(categoryName, other.categoryName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryName);
	}
	
	
	
	

}
