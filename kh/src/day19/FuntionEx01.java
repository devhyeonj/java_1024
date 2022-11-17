package day19;

import java.util.ArrayList;
import java.util.function.Function;

public class FuntionEx01 {

	public static void main(String[] args) {
		ArrayList <Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,1,"홍길동",100,90,80));
		list.add(new Student(1,2,1, "임꺽정",90,90,80));
		list.add(new Student(1,1,2,"고길동",10,90,20));
		
		//람다식은 상황에 맞게 필터 처리를 할 수 있다.
		printKor(list, "국어", (s) -> s.getKor());
		printKor(list, "영어", (s) -> s.getEng());
		printKor(list, "수학", (s) -> s.getMath());
		printKor(list, "총합", (s) -> s.getMath()+s.getKor()+s.getEng());
		
 	}
	public static void printKor(ArrayList<Student> list, String subject,Function<Student,Integer> f) {
		for (Student student : list) {
			System.out.println(subject + " : " + f.apply(student));
		}
	}
	

}
