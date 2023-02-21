package kr.kh.test.service;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberService {

	String selectMemberName(Integer num);
	
	boolean signup(MemberVO memberVO);
	
	MemberVO login(MemberVO member);

	boolean authentication(String mo_me_id, String mo_me_id2);


}
