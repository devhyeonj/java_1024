package day20.phonebook;

import lombok.Data;

@Data
public class Phone {
	
	private String name;
	private String number;
	
	public Phone(String name, String number) {
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return name + number;
	}
	
	
	
	

}
