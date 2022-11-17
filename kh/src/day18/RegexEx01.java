package day18;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx01 {
	
	public static void main(String[] args) {
		String regex = "^...$";
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean res = Pattern.matches(regex, str);
		System.out.println(res);
		
	}

}
