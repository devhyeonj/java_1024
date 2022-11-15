package example.accountbook;

import java.util.ArrayList;
import java.util.Scanner;

//가계부
public class AccountBook {
	ArrayList<Item> list = new ArrayList<>();
	AccountService accountService = new AccountServiceImp();
	
	Scanner sc;
	public void run() {
		System.out.println("가계부 프로그램 실행합니다.");
		int menu = -1;
		//반복문
		do {
			accountService.printMenu();
			menu = sc.nextInt();
			accountService.runMenu(list,sc,menu);
		}while(menu!=5);
		System.out.println("가계부 프로그램 종료 합니다.");
	}
	// 가계부내에서는 어디서든 스캐너를 쓸수있게 함
	public AccountBook(Scanner sc) {
		if(sc == null) {
			this.sc  = new Scanner(System.in);
		}else {
			this.sc = sc;
		}
	}
	

}
