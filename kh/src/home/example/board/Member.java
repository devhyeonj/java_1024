package home.example.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pw;
	private Authority authority;
	private Date joinDate;
	
	public Member(String id, String pw, Authority authority) {
		this.id = id;
		this.pw = pw;
		this.joinDate = new Date();
		this.authority = authority;
	}
	
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(joinDate);
	}
	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String print() {
		return "아이디: "+ id + " 비밀번호: " + pw + " 회원등급 " + getAuthority() +" 회원가입 날짜:" + getDate(); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pw);
	}
	
	
	
}

enum Authority {
	ADMIN, MEMBER;
}