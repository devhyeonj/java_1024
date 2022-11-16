package example.accountbook;

import java.text.SimpleDateFormat;
import java.util.Objects;

import lombok.Data;

//내역
@Data
class Date {
	int year;
	int month;
	int day;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getDate(){
		return ""+ year + "/" + month + "/" + day ;
	}

	
	
	
	
}

@Data
public class Item {
	String division;
	String classification;
	String Contents;
	int price;
	Date date;
	
	public Item(String division, String classification, String contents, int price, Date date) {
		this.division = division;
		this.classification = classification;
		this.Contents = contents;
		this.price = price;
		this.date = date;
	}
	
	public Item(Date date) {
		this.date = date;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if(!(obj instanceof String)) {
				return false;
			}
			return date.equals(obj);
		}
		Item other = (Item) obj;
		return Objects.equals(date, other.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	public void update(String division, Date date, String classification, String contents, int price) {
		this.division = division;
		this.date = date;
		this.classification = classification;
		this.Contents = contents;
		this.price = price;
	}

}