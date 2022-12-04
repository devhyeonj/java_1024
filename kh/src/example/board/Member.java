package example.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Member implements Serializable{
	private static final long serialVersionUID = 1167670053403581622L;
	private String id;
	private String password; 
	private String nickname; 
	private Authority authority;
	private Date signUpDate; 
	
	public Member(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		signUpDate = new Date();
	}
	
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(signUpDate);
	}
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String print() {
		return "아이디: "+ id + " 비밀번호: " + password + " 닉네임: " + nickname
				+ " 회원등급 " + getAuthority() +" 회원가입 날짜:" + getDate(); 
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
		return Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password);
	}

}
enum Authority {
	ADMIN, MEMBER;
}
