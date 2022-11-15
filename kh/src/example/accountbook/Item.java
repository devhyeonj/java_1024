package example.accountbook;

import lombok.Data;

//내역
@Data
class Date {
	int year;
	int month;
	int day;
}

@Data
public class Item {
	String division;
	String classification;
	String Contents;
	int price;
	Date date;

	
	
	
	
	@Override
	public String toString() {
		return "Item [division=" + division + ", classification=" + classification + ", Contents=" + Contents
				+ ", price=" + price + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}



	
	
	
	
	

}
