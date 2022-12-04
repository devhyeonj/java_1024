package example.product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;


@Data
public class ProductLog {
	
	private Product product;
	private Date sellingDate;
	private int sellingQuantity; // 판매수량
	private int Sales; //매출액
	
	public ProductLog(String productName) {
		product = new Product(productName);
	}
	
	public ProductLog(Product product, String sellingDate,int sellingQuantity) throws ParseException {
		this.product = product;
		setSellingDate(sellingDate);
		this.sellingQuantity = sellingQuantity;
	} 
	
	public String getSellingDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(sellingDate);
	}
	
	public void setSellingDate(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.sellingDate = format.parse(date);
	}
	
	public void sellingProduct(int sellingQuantity,int Quantity, int SellingPrice) {
		System.out.println("==="+Quantity);
		if(sellingQuantity == 0)
			return ;
		Quantity-=sellingQuantity;
		product.setQuantity(Quantity);
		if(sellingQuantity != 0) 
			this.sellingQuantity += sellingQuantity;
		this.sellingQuantity = sellingQuantity;
		this.Sales = sellingQuantity*SellingPrice;
	}
	
	

	@Override
	public String toString() {
		return product.getProductName()+sellingQuantity+" 개 판매("+getSellingDate()+")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductLog other = (ProductLog) obj;
		return Objects.equals(sellingDate, other.sellingDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sellingDate);
	}
	
	
}
