package home.example.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class MemberServiceImp implements MemberService {
	
	private static Scanner sc = new Scanner(System.in);
	private static Member user;
	
	@Override
	public boolean login(List<Member> memberList,Member member) {
		int index = memberList.indexOf(member);
		if(index == -1) {
			return false;
		}
		user = memberList.get(index);
		return true;
	}

	@Override
	public boolean isAdmin() {
		if(user.getAuthority() != Authority.ADMIN) {
			System.out.println("관리자가 아닙니다. 해당 기능을 이용할 수 없습니다.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLogin(boolean res) {
		if(user != null && res) {
			System.out.println("로그인한 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		if(user == null && !res) {
			System.out.println("로그인 하지 않은 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		return false;
	}

	@Override
	public Member inputIdPw() {
		System.out.print("아이디 : "); String id = sc.next();
		System.out.print("비밀번호:"); String pw = sc.next();
		return new Member(id, pw);
	}

	@Override
	public boolean join(List<Member> memberList, Member member) {
		Authority authority = memberList.size() ==0? Authority.ADMIN : Authority.MEMBER;
		member = new Member(member.getId(), member.getPw(), authority);
		memberList.add(member);
		return true;
	}
}
