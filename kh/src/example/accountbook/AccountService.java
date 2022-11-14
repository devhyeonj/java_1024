package example.accountbook;

import java.util.ArrayList;
import java.util.Scanner;

public interface AccountService { // 기능
	void isnertItem(ArrayList<Item> list, Item item); //가계부에 있는 내역 리스트,추가할 아이템
	void printItem(ArrayList<Item> list); // 가계부에 있는 내역 리스트
	boolean updateItem(ArrayList<Item> list, int index,Item item); // 가계부에 있는 내역 리스트, 몇번지 ,  수정할 아이템
	boolean deleteItem(ArrayList<Item> list, int index); // 가계부에 있는 리스트, 몇번지에 있는거를 지울건지
	void printMenu();
	void runMenu(ArrayList<Item> list, Scanner sc, int menu);

}
// 개발들어가기전에 인터페이스로 이러이러한 기능이  필요할거다 먼저 얘기해보고 시작하기