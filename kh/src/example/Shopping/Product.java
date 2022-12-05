package example.Shopping;

import lombok.Data;

@Data
public class Product {
	private String type;
	private String title;
	private int amount;
	private final int buyPrice;
	private final int sellprice;
	
	public Product(String type, String title,int buyPrice, int sellprice) {
		this.type = type;
		this.title = title;
		this.buyPrice = buyPrice;
		this.sellprice = sellprice;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}

	@Override
	public String toString() {
		return "["+type+" |"+ type + " |" + title + " |수량:" + amount + "|판매가:" + buyPrice
				+ "| 구매가:" + sellprice + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	//깊은복사를 위한 생성자
	public Product(Product p) {
		this.type = p.type; //생성자를 통해서 덮어쓰기 그래야 나중에 가격이 바뀌어도 매출이랑 상관없음
		this.title = p.title;
		this.amount = p.amount;
		this.buyPrice = p.buyPrice;
		this.sellprice = p.sellprice;
	}
	
	
	
	

}
