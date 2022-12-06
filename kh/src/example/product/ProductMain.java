package example.product;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductMain {
	/* 제품을 관리하는 프로그램을 작성하세요.
	 * - 구매가격, 판매가격은 변동이 없음
	 * 기능
	 * - 제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
	 * - 제품 수정
	 * - 제품 삭제
	 * - 제품 구매(관리자가 구매, 입고)
	 * - 제품 판매
	 * - 매출액 확인
	 *   - 년별
	 *     - 제품별
	 *     - 전체
	 *   - 월별
	 *     - 제품별
	 *     - 전체
	 *   - 일별
	 *     - 제품별
	 *     - 전체
	 * 분류 : 식품
	 * 제품명 : 진라면
	 * 수량 : 0
	 * 구매가격 : 400원
	 * 판매가격 : 500원    
	 * 진라면 100개 구매 => 진라면 수량 100개
	 * 진라면 10개 판매(날짜) => 진라면 수량 90개
	 */
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Product> productList = new ArrayList<>();
	private static String filename = "product.txt";
	private static ArrayList<ProductLog> logList = new ArrayList<>();
	private static ArrayList<Integer> indexList = new ArrayList<>();
	
	public static void main(String[] args) {
		int menu = -1;
			load();
			do {
				try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				runMenu(menu);
				}catch (InputMismatchException e) {
					sc.nextLine();
					System.out.println("정수를 입력 해주세요.");
				} catch (ParseException e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}while(menu !=7);
			save();
	}

	private static void load() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			while (true) {
				Product product = (Product) ois.readObject();
				productList.add(product);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("불러오기 실패");
		} catch (EOFException e) {
			System.out.println("불러오기 성공");
		} catch (IOException e) {
			System.out.println("불러오기 실패");
		}
	}

	private static void save() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			for (Product product : productList) {
				oos.writeObject(product);
			}
			System.out.println("저장 완료");
		} catch (IOException e) {
			System.out.println("저장 실패");
		}
	}

	private static void runMenu(int menu) throws ParseException {
		int salesNum = -1;
		switch (menu) {
		case 1://제품 등록
			insertProduct();
			break;
		case 2://제품 수정
			updateProduct();
			break;
		case 3://제품 삭제
			deleteProduct();
			break;
		case 4://제품 구매
			purchaseProduct();
			break;
		case 5://제품 판매
			sellingProduct();
			break;
		case 6://매출액 확인 (서브메뉴)
			salesPrint();
				do {
					try {
					salesNum = sc.nextInt();
					sc.nextLine();
					runSales(salesNum);
					}catch (InputMismatchException e) {
						sc.nextLine();
						System.out.println("정수를 입력 해주세요.");
					}
				}while(salesNum != 4);
			break;
		case 7:
			System.out.println("프로그램을 종료 합니다.");
			break;
		case 0:
			for (Product product : productList) {
				System.out.println(product);
			}
			System.out.println("===============");
			for (ProductLog productLog : logList) {
				System.out.println(productLog);
			}
			break;
		default:
			System.out.println("잘못된 메뉴를 선택 하셨습니다.");
			break;
		}
	}

	private static void sellingProduct() throws ParseException {
		System.out.println("판매하신 제품명을 입력해주세요");
		Product product = scanProductName();
		if(product == null) 
			return ;
		int sellingQuantity;
		do {
			System.out.print("판매하신 수량을 입력해주세요>>");
			sellingQuantity = sc.nextInt();
			if(product.getQuantity() < sellingQuantity) {
			System.out.println("가지고 있는 수량 보다 적게 입력하세요.");
			System.out.println("현재수량:"+product.getQuantity());
			}
		}while(product.getQuantity() < sellingQuantity);
		
		System.out.print("판매하신 날짜를 입력해주세요 (예: 2022-12-03)");
		String sellingdate = sc.next(); 
		ProductLog p = new ProductLog(product, sellingdate, sellingQuantity);
		logList.add(p);
		p.sellingProduct(sellingQuantity, product.getQuantity(),product.getSellingPrice());
		
	}

	private static void search(Predicate<Product> p) {
		for (Product product : productList) {
			if(p.test(product)) {
				System.out.println(product);
			}
		}
	}

	private static void purchaseProduct() {
		System.out.println("구매하신 제품명을 입력해주세요");
		Product product = scanProductName();
		if(product == null) 
			return ;
		System.out.println(product.getProductName());
		System.out.print("구매하신 수량을 입력해주세요>>");
		int Quantity = sc.nextInt();
		System.out.println(Quantity+"개 구매");
		product.purchaseProduct(Quantity);
		
		//확인용
		System.out.println(product.getProductName()+" "+"수량 : " + product.getQuantity());
	}

	private static void deleteProduct() {
		System.out.println("삭제 하실 제품명을 입력해주세요.");
		Product product = scanProductName();
		
		if(product == null) 
			return ;
		System.out.println("====================================================");
		System.out.println(product);
		System.out.println("====================================================");
		
		System.out.println("삭제를 시작 합니다.");
		if(!productList.remove(product)) {
			System.out.println("삭제에 실패 하였습니다.");
			return ;
		}
		System.out.println("삭제에 성공 하였습니다.");
	}

	private static void updateProduct() {
		System.out.println("수정 하실 제품명을 입력해주세요.");
		Product product = scanProductName();
		
		if(product == null) 
			return ;
		System.out.println("====================================================");
		System.out.println(product);
		System.out.println("====================================================");
		
		System.out.println("수정을 시작 합니다.");
		
		System.out.print("분류 : ");String Classification = sc.nextLine();
		System.out.print("제품명 : ");String productName = sc.nextLine();
		
		product.updateProduct(Classification, productName, 0);
		
		System.out.println("수정하였습니다.");
		
		//확인용
		productList.forEach(p ->System.out.println(p));
		
	}

	private static Product scanProductName() {
		System.out.print("제품명>>");
		String productName = sc.nextLine();
		int index = productList.indexOf(new Product(productName));
		
		if(index == -1) {
			System.out.println("해당 제품이 존재하지 않습니다.");
			return null;
		}
		return productList.get(index);
	}

	private static void insertProduct() {
		if(productList == null) 
			System.out.println("제품 관리 리스트가 생성되지 않았습니다.");
		System.out.print("분류 : ");String Classification = sc.nextLine();
		System.out.print("제품명 : ");String productName = sc.nextLine();
		System.out.print("구매가격 : ");int purchasePrice = sc.nextInt();
		System.out.print("판매가격 : ");int sellingPrice = sc.nextInt();
		Product product = new Product(Classification, productName, 0, purchasePrice, sellingPrice);
		if(productList.indexOf(product) != -1) {
			System.out.println("중복된 제품이 있습니다.");
			return ;
		}
		productList.add(product);
		System.out.println("제품 등록에 성공 하였습니다.");
	}
	//매출액 확인
	private static void runSales(int salesNum) {
		int subMenu;
		switch (salesNum) {
		case 1: // 년별
			printSelect();
			subMenu = sc.nextInt();
			sc.nextLine();
			yearSelect(subMenu);
			break;
		case 2: // 월별
			printSelect();
			subMenu = sc.nextInt();
			sc.nextLine();
			monthSelect(subMenu);
			break;
		case 3:// 일별
			printSelect();
			subMenu = sc.nextInt();
			sc.nextLine();
			daySelect(subMenu);
		case 4:
			break;
		}
	}

	private static void yearSelect(int num) {
		ProductLog p = null;
		String year;
		switch (num) {
		case 1://제품별
			System.out.print("연도 입력 : ");
			year = sc.next();
			sc.nextLine();
			System.out.println("매출액 확인하실 제품명을 입력해주세요");
			Product product = scanProductName();
			indexList = searchLog(l -> l.getSellingDate().substring(0, 4).equals(year) && l.getProduct().getProductName().equals(product.getProductName()));
			for (int i = 0; i < indexList.size(); i++) {
				p = logList.get(indexList.get(i));
				System.out.println(p.getProduct().getProductName()+" "+" 매출액 : " + p.getSales());
			}
			break;
		case 2://전체
			System.out.print("연도 입력 : ");
			year = sc.next();
			indexList = searchLog(l -> l.getSellingDate().substring(0, 4).equals(year));
			for (int i = 0; i < indexList.size(); i++) {
				p = logList.get(indexList.get(i));
				System.out.println(p.getProduct().getProductName()+" "+" 매출액 : " + p.getSales());
			}
			break;
		case 3:
			break;
		}
	}
	
	private static void monthSelect(int num) {
		ProductLog p = null;
		String month;
		switch (num) {
		case 1://제품별
			System.out.print("월 입력 : ");
			month = sc.next();
			sc.nextLine();
			System.out.println("매출액 확인하실 제품명을 입력해주세요");
			Product product = scanProductName();
			indexList = searchLog(l -> l.getSellingDate().substring(5, 7).equals(month) && l.getProduct().getProductName().equals(product.getProductName()));
			for (int i = 0; i < indexList.size(); i++) {
				p = logList.get(indexList.get(i));
				System.out.println(p.getProduct().getProductName()+" "+" 매출액 : " + p.getSales());
			}
			break;
		case 2://전체
			System.out.print("월 입력 : ");
			month = sc.next();
			indexList = searchLog(l -> l.getSellingDate().substring(5, 7).equals(month));
			for (int i = 0; i < indexList.size(); i++) {
				p = logList.get(indexList.get(i));
				System.out.println(p.getProduct().getProductName()+" "+" 매출액 : " + p.getSales());
			}
			break;
		case 3:
			break;
		}
	}
	
	private static void daySelect(int num) {
		ProductLog p = null;
		String day;
		switch (num) {
		case 1://제품별
			System.out.print("일 입력 : ");
			day = sc.next();
			sc.nextLine();
			System.out.println("매출액 확인하실 제품명을 입력해주세요");
			Product product = scanProductName();
			indexList = searchLog(l -> l.getSellingDate().substring(8, 10).equals(day)&& l.getProduct().getProductName().equals(product.getProductName()));
			for (int i = 0; i < indexList.size(); i++) {
				p = logList.get(indexList.get(i));
				System.out.println(p.getProduct().getProductName()+" "+" 매출액 : " + p.getSales());
			}
			break;
		case 2://전체
			System.out.print("일 입력 : ");
			day = sc.next();
			indexList = searchLog(l -> l.getSellingDate().substring(8, 10).equals(day));
			for (int i = 0; i < indexList.size(); i++) {
				p = logList.get(indexList.get(i));
				System.out.println(p.getProduct().getProductName()+" "+" 매출액 : " + p.getSales());
			}
			break;
		case 3:
			break;
		}
	}
	


	//판매날짜가 같은 번지를 정수형 리스트에 저장
	private static ArrayList<Integer> searchLog(Predicate<ProductLog> p) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		for (int i = 0; i < logList.size(); i++) {
			if(p.test(logList.get(i))) {
				indexs.add(i);
			}
		}
		return indexs;
	}
	
	


	private static void printSelect() {
		System.out.println("1. 제품별");
		System.out.println("2. 전체");
		System.out.println("3. 뒤로가기");
		System.out.print("메뉴 선택>>");
	}

	private static void salesPrint() {
		System.out.println("1. 년별");
		System.out.println("2. 월별");
		System.out.println("3. 일별");
		System.out.println("4. 뒤로가기");
	}

	private static void printMenu() {
		System.out.println("1. 제품 등록");
		System.out.println("2. 제품 수정");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제품 구매");
		System.out.println("5. 제품 판매");
		System.out.println("6. 매출액 확인"); 
		System.out.println("7. 프로그램 종료");
		System.out.print("메뉴 선택>>");
	}
	

}
