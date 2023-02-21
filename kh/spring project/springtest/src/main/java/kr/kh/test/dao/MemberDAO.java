package kr.kh.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberDAO {

	String selectMemberName(@Param("num") Integer num);
	
	int insertMember(@Param("member") MemberVO member);
	
	MemberVO selectMemberById(@Param("me_id")String me_id);
	
	int insertMemberOK(@Param("mok") MemberOKVO memberOKVO);

	int updateAuthentication(@Param("me_id")String me_id, @Param("me_authority")int me_authority);

	int deleteMemberOK(@Param("mo_me_id")String mo_me_id, @Param("mo_num")String mo_num);

}
