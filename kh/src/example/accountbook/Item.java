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




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
	
	
	
	
	

}
