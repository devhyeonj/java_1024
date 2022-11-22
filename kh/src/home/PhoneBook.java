package home;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PhoneBook {
	private String name,company;
	private ArrayList<PhoneNumber> pnList;
	
	
	public PhoneBook(String name, String company, ArrayList<PhoneNumber> pnList) {
		this.name = name;
		this.company = company;
		this.pnList = pnList;
	}


	public void print() {
		System.out.println("==================");
		System.out.println("이름 :" + name);
		System.out.println("직장 :" + company);
		for (PhoneNumber phoneNumber : pnList) {
			System.out.println(phoneNumber);
		}
	}


	public void update(String name, String company) {
		this.name = name;
		this.company = company;
	}


	public void printPhoneNum() {
		for (int i = 0; i < pnList.size(); i++) {
			System.out.println(i+1+". "+pnList.toString());
		}
	}
}
