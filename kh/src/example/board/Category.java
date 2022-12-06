package example.board;


import java.io.Serializable;

import lombok.Data;

@Data
public class Category implements Serializable{
	private static final long serialVersionUID = 1570107296387591040L;
	private static int count = 0; 
	private int num;
	private String categoryName;
	
	public Category(String categoryName, boolean res) {
		if(res)
		count++;
		num = count;
		this.categoryName = categoryName;
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
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}

	public void update(String newCategory) {
		this.categoryName = newCategory;
	}
	
	
	
	
}
