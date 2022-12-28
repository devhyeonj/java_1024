package example.db.main.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO2 {
	private int num;
	private String name;
	private int semester;
	private String state;
	private int professorNum;
}
