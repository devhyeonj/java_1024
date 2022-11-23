package day23;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamEx02 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("test.txt");
			fw = new FileWriter("test.text");
			
			char ch = '\u0000';
			for (int i = 0; i<200; i++) {
				fw.write(ch++);
			}
			int num;
			for (int i = 0; i < 200; i++) {
				num = fr.read();
				System.out.println((char)num);
			}
			fr.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
