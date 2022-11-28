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
	
	
}
