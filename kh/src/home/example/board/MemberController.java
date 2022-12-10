package home.example.board;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
	private List<Member> memberList;
	private MemberService ms = new MemberServiceImp();
	
	public MemberController() {
		this.memberList = new ArrayList<>();
	}
	
	//회원가입
	public void join() {
		Member member = ms.inputIdPw();
		
		if(ms.join(memberList,member)) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		for (Member m : memberList) {
			System.out.println(m);
		}
	}
	
	//로그인
	public void login() {
		Member member = ms.inputIdPw();
		if(ms.login(memberList,member)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
	
}
