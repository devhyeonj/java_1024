package example.product;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

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
	
	public static void main(String[] args) {
		int menu = -1;
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
		product.sellingProduct(sellingdate, sellingQuantity);
		
		//확인용
		System.out.println(product);
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
		System.out.print("수량:");int Quantity = sc.nextInt();
		
		product.updateProduct(Classification, productName, Quantity);
		
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
		System.out.print("수량 : ");int Quantity = sc.nextInt();
		System.out.print("구매가격 : ");int purchasePrice = sc.nextInt();
		System.out.print("판매가격 : ");int sellingPrice = sc.nextInt();
		Product product = new Product(Classification, productName, Quantity, purchasePrice, sellingPrice);
		if(productList.indexOf(product) != -1) {
			System.out.println("중복된 제품이 있습니다.");
			return ;
		}
		productList.add(product);
		System.out.println("제품 등록에 성공 하였습니다.");
	}
	private static void runSales(int salesNum) {
		//int num = sc.nextInt();
		String year,month,day;
		switch (salesNum) {
		case 1: // 년별
			year = inputYear();
			printProductDate(year);
//			printSelect();
//			num = sc.nextInt();
//			runSelect(num);
			break;
		case 2: // 월별
			year = inputYear();
			month = inputMonth();
			printProductDate(year,month);
//			printSelect();
//			num = sc.nextInt();
//			runSelect(num);
			break;
		case 3:// 일별
			year = inputYear();
			month = inputMonth();
			day = inputDay();
			printProductDate(year,month,day);
//			printSelect();
//			num = sc.nextInt();
//			runSelect(num);
			break;
		case 4:
			break;
		}
	}

	private static String inputYear() {
		System.out.print("연도 입력 : ");
		String year = sc.next();
		return year;
	}

	private static String inputMonth() {
		System.out.print("월 입력 : ");
		String month = sc.next();
		return month;
	}

	private static String inputDay() {
		System.out.print("일 입력 : ");
		String day = sc.next();
		return day;
	}

	private static void runSelect(int num) {
		switch (num) {
		case 1://제품별
			System.out.println("매출액 확인하실 제품명을 입력해주세요");
			Product product = scanProductName();
			printProduct(productList,product.getProductName(),"매출액", (p) -> p.getSellingQuantity()*p.getSellingPrice());
			break;
		case 2://전체
			break;
		case 3:
			break;
		}
	}
	
	private static void printProductDate(String... dates) {
		int size = dates.length;
		
		for (Product product : productList) {
			if(product.getSellingDate().substring(0, size).equals(dates)) {
				System.out.println(product);
			}
		}
		
	}

	//판매날짜가 같은 번지를 정수형 리스트에 저장
	private static ArrayList<Integer> searchProduct(ArrayList<Product> list, Predicate<Product> p) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if(p.test(list.get(i))) {
				indexs.add(i);
			}
		}
		return indexs;
	}
	
	public static void printProduct(ArrayList<Product> list,String product,String selling, Function<Product,Integer> f) {
		for (Product p : list) {
			System.out.println(product+" "+selling + f.apply(p));
		}
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
