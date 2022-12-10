package home.example.board;

import java.util.ArrayList;
import java.util.List;

public interface MemberService {
	
	//회원가입( 처음 가입한 회원이 관리자, 그외 회원은 일반 회원)
	boolean join(List<Member> memberList, Member member); 
	//로그인
	boolean login(List<Member> memberList, Member member);
	//관리자 확인
	boolean isAdmin();
	// 로그인 체크
	boolean checkLogin(boolean res);
	Member inputIdPw();
	
}
