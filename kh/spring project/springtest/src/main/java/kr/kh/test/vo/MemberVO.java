package kr.kh.test.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	private String me_id;
	private String me_pw;
	private String me_email;
	private Date me_birthday;
	private int me_authority;
	private Date me_join_time;
	String me_session_id;
	Date me_session_limit;
	boolean autoLogin;
	
	public void setMe_birthday(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.me_birthday = format.parse(str);
		} catch (ParseException e) {
			this.me_birthday = null;
		}
	}

}
