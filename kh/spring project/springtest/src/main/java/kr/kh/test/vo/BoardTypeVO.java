package kr.kh.test.vo;

import lombok.Data;

@Data
public class BoardTypeVO {
	private int bt_num;
	private String bt_type;
	private String bt_name;
	private int bt_r_authority;
	private int bt_w_authority;

}
