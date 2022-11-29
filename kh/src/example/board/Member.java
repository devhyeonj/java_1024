package example.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Member implements Serializable{
	private static final long serialVersionUID = 1167670053403581622L;
	private String id; // 아이디
	private String password; // 비밀번호
	private String nickname; // 닉네임
	private Membership membership; // 멤버등급
	private Date signUpDate; // 회원가입 날짜
	
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
	//로그인
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public void setMemberShip(Membership membership) {
		this.membership = membership; 
	}
	
	
	public String print() {
		return "아이디: "+ id + " 비밀번호: " + password + " 닉네임: " + nickname
				+ " 회원등급 " + membership +" 회원가입 날짜:" + getDate(); 
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	



	
	
	
	

}
