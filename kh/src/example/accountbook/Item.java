package example.accountbook;

import lombok.Data;

//내역

@Data
public class Item {
	String division;
	String classification;
	String Contents;
	int price;
	
	int year;
	int month;
	int day;
	@Override
	public String toString() {
		return "Item [division=" + division + ", classification=" + classification + ", Contents=" + Contents
				+ ", price=" + price + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	
	
	

}
