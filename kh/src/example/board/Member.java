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
	private Category category; // 게시글 종류
	private Membership membership; // 멤버등급
	private Date signUpDate; // 회원가입 날짜
	// ArrayList<Board> boardList; 멤버는 게시판 정보들을 가지고있다 ?
	
	public Member(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.membership = Membership.MEMBER; //가입하면 기본으로 멤버등급은 멤버
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
	
	
	public String print() {
		return "아이디: "+ id + " 비밀번호: " + password + " 닉네임: " + nickname
				+ " 회원등급 " + membership +" 회원가입 날짜:" + getDate(); 
	}




	
	
	
	

}
