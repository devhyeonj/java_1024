package example.Shopping;

import java.util.List;
import java.util.Scanner;

public class ProductServiceImp implements ProductService {

	@Override
	public boolean insertProduct(List<Product> productList, Product product) {
		// 매개변수 예외 체크
		if(productList == null || product == null) 
			return false;
		// 이미 등록된 제품인지 확인
		if(productList.contains(product)) {
			return false;
		}
		// 제품 등록
		productList.add(product);
		return true;
	}


	@Override
	public boolean deleteProduct(List<Product> productList, Product product) {
		//매개변수 예외 체크
		if(productList == null || productList.size() == 0
				|| product == null) 
		return false;
		return productList.remove(product);
	}
	@Override
	public boolean updateProduct(List<Product> productList, int index, Product product) {
		if(productList == null || productList.size() ==0
				|| index <0 || product==null)
			return false;
		//수정
		productList.set(index, product);
		return true;
	}

	

	@Override
	public Product getProduct(List<Product> productList, int index) {
		//매개변수 예외 처리
		if(productList == null || index < 0
				|| productList.size() <= index)
		return null;
		
		return productList.get(index);
	}

	@Override
	public boolean productStock(Product product, int amount) {
		if(amount < 0 && product.getAmount() < -amount) {
			System.out.println("재고량이 부족합니다.");
			return false;
		}
		product.addAmount(amount); // 양수로 들어가서 의미가 구매 판매는 -
		return true;
	}

	@Override
	public Product inputProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.print("분류 : ");
		String type = sc.nextLine();
		System.out.print("제품명 : ");
		String title = sc.nextLine();
		System.out.print("구매가 : ");
		int buyPrice = sc.nextInt();
		System.out.print("판매가 : ");
		int sellPrice = sc.nextInt();
		if(buyPrice > sellPrice)
			return null;
		return new Product(type, title, buyPrice, sellPrice);
	}


	@Override
	public Product getProduct(List<Product> productList, Product product) {
		int index = productList.indexOf(product);
		if(index < 0)
			return null;
		return productList.get(index);
	}


	

	

}
