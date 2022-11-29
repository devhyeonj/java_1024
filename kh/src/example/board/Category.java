package example.board;


import lombok.Data;

@Data
public class Category {
	private static int categoryNum = 0; // 카테고리 번호
	private int num;
	private String categoryName;
	
	public Category(String categoryName) {
		categoryNum++;
		num = categoryNum;
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
	
	
	
	
}
