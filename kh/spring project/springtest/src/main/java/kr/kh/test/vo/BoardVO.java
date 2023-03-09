package kr.kh.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	private int bo_num;
	private String bo_title;
	private String bo_content;
	private Date bo_register_date;
	private Date bo_update_date;
	private int bo_views;
	private int bo_up;
	private int bo_down;
	private int bo_ori_num;
	private String bo_me_id;
	private int bo_bt_num;
	private String bt_name;
	
	public String getBo_register_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		if(bo_register_date == null)
			return "";
		return format.format(bo_register_date);
	}
	
	public String getBo_update_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		if(bo_update_date == null)
			return "";
		return format.format(bo_update_date);
	}
}
