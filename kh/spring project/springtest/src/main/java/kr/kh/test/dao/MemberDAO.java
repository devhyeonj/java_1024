package kr.kh.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberDAO {

	String selectMemberName(@Param("num") Integer num);
	
	int insertMember(@Param("member") MemberVO member);
	
	MemberVO selectMemberById(@Param("me_id")String me_id);
	
	int insertMemberOK(@Param("mok") MemberOKVO memberOKVO);

	int deleteMemberOK(@Param("mok") MemberOKVO mok);

	int updateMemberAuthority(@Param("me_id")String mo_me_id, @Param("me_authority")int me_authority);
	//dao 가 두개 이상이면 반드시 param을 붙여야함 
}
