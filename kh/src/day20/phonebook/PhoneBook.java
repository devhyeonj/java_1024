package day20.phonebook;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PhoneBook {
	
	private String lastName;
	private String firstName;
	private String work;
	private ArrayList<Phone> phoneList= new ArrayList<>();;
	
	public PhoneBook(String lastName, String firstName, String work) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.work = work;
	}
	
	public void addPhone(String name,String number) {
		phoneList.add(new Phone(name, number));
	}

	public void updatePerson(String lastName, String firstName, String work) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.work = work;
	}
	

}
