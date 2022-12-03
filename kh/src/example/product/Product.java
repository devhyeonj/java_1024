package example.product;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Product {
	private String Classification; //분류
	private String productName; //제품명
	private int Quantity; //수량
	private int sellingQuantity; // 판매수량
	private int purchasePrice; //구매가격
	private int sellingPrice; //판매가격
	private Date sellingDate; // 판매 날짜
	
	public Product(String classification, String productName, int quantity, int purchasePrice, int sellingPrice) {
		this.Classification = classification;
		this.productName = productName;
		this.Quantity = quantity;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
	}
	//구매 판매
	public Product(String productName) {
		this.productName = productName;
	}
	
	public void purchaseProduct(int Quantity) {
		if(Quantity == 0)
			return ;
		this.Quantity += Quantity;
	}
	
	
	public String getSellingDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(sellingDate);
	}
	
	public void setSellingDate(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.sellingDate = format.parse(date);
	}
	
	public void sellingProduct(String sellingdate,int sellingQuantity) throws ParseException {
		if(Quantity == 0)
			return ;
		this.sellingQuantity = sellingQuantity;
		this.Quantity -= sellingQuantity;
		setSellingDate(sellingdate);
	}
	
	
	
	
	@Override
	public String toString() {
		return "분류 : " + Classification + " 제품명 : " + productName + " 수량 : " + Quantity
				+ " 구매가격 : " + purchasePrice + " 판매가격 : " + sellingPrice + " 판매날짜 : "
				+ getSellingDate() +" 판매수량 : " +getSellingQuantity();
	}
	
	
	

	
	public void updateProduct(String classification, String productName, int quantity) {
		this.Classification = classification;
		this.productName = productName;
		this.Quantity = quantity;
	}
	
	

	
	public String getMoney1( ) {
		DecimalFormat df = new DecimalFormat("###,###"); 
		return df.format(purchasePrice);
	}
	public String getMoney2( ) {
		DecimalFormat df = new DecimalFormat("###,###"); 
		return df.format(sellingPrice);
	}

	
	
}
