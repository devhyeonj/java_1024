package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.MemberOKVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	String selectMemberName(@Param("num")String num);

	int insertMember(@Param("m") MemberVO member); 	
	// param으로 m으로 했기때문에 mapper.xml에서 m.으로 접근한거임

	void insertMember(@Param("mok") MemberOKVO mok);
	
}
