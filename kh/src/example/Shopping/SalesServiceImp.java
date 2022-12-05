package example.Shopping;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class SalesServiceImp implements SalesService {

	@Override
	public Sales inputSales(String saleType) {
		Scanner sc = new Scanner(System.in);
		System.out.print("일시 : ");
		String date = sc.nextLine();
		System.out.print("분류 : ");
		String type = sc.nextLine();
		System.out.print("제품명 : ");
		String title = sc.nextLine();
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		if(amount <= 0)
			return null;
		Product product = new Product(type, title, 0, 0);
		Sales sales = 
				new Sales(product, amount, 0, date, SalesType.valueOf(saleType));
		return sales;
	}

	@Override
	public void printByYear(List<Sales> salesList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 : ");
		String year = sc.nextLine();
		String date = year;
		printSales(salesList,s -> {
			String salesDate = s.getDateStr().substring(0,date.length());
			return salesDate.equals(date);
		});
	}
	
	@Override
	public void printByMonth(List<Sales> salesList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 : ");
		String year = sc.nextLine();
		System.out.print("월 :");
		String month = sc.nextLine();
		//2022-01 // 길이만큼 가져와서 비교 서브스트링으로 
		String date = year + "-" + (month.length()<2?"0" + month:month);
		printSales(salesList,s -> {
			String salesDate = s.getDateStr().substring(0,date.length());
			return salesDate.equals(date);
		});
	}

	@Override
	public void printByDay(List<Sales> salesList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 : ");
		String year = sc.nextLine();
		System.out.print("월 :");
		String month = sc.nextLine();
		System.out.print("일 :");
		String day = sc.nextLine();
		//2022-01 // 길이만큼 가져와서 비교 서브스트링으로 
		String date = 
		year + "-" 
		+ (month.length()<2?"0" + month:month) + "-"
		+ (day.length() <2? "0" +day:day);
		printSales(salesList,s -> {
			String salesDate = s.getDateStr().substring(0,date.length());
			return salesDate.equals(date);
		});
	}
	
	
	
	@Override
	public void printSales(List<Sales> salesList,Predicate<Sales> p) {
		if(salesList == null || salesList.size() == 0) {
			System.out.println("결과 없습니다.");
			return;
		}
		int count = 0;
		int buyPrice = 0;
		int sellPrice = 0;
		for(Sales sales : salesList) {
			if(p.test(sales)) {
				System.out.println(sales);
				count++;
				if(sales.getType() == SalesType.구매) 
					buyPrice += sales.getPrice();
				else 
					sellPrice += sales.getPrice();
			}
		}
		if(count == 0) {
			System.out.println("결과 없습니다.");
		}else {
			System.out.println("구매 금액:" + buyPrice);
			System.out.println("판매 금액:" + sellPrice);
			System.out.println("매출 정산:" + (sellPrice - buyPrice));
		}
	}


}
