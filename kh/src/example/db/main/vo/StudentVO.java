package example.db.main.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
	private int st_num;
	private String st_name;
	private int st_semester;
	private String st_state;
	private int st_pr_num;
}
