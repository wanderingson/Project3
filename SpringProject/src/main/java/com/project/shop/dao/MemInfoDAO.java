package com.project.shop.dao;

import java.util.ArrayList;

import com.project.shop.vo.MemInfoVO;

public interface MemInfoDAO {
	

	// 회원가입 관련
	//===========================================================================================
	// 회원가입
	void memberInsert(MemInfoVO meminfoVO);
	
	//아이디 중복 체크
	ArrayList<MemInfoVO> getAllInfo();
	//===========================================================================================
	
	// 회원탈퇴 관련
	//===========================================================================================

	int memberDelete(MemInfoVO meminfoVO);

	//===========================================================================================
	
	
	// 로그인 페이지 관련
	//===========================================================================================
	// 로그인 
	ArrayList<MemInfoVO> select_loginCheck();
	
	//아이디찾기	
	String findId(MemInfoVO vo);
	
	// 비밀번호 찾기
	String FindPW(MemInfoVO memvo);
	
	//===========================================================================================
	
	// 마이페이지 관련
	//===========================================================================================

	// 해당 id 의 회원정보 가져오기
	MemInfoVO select_memInfo(String mem_id);
	

	// 회원정보 수정
	void update_memInfo(String mem_id, String pw, String tel, String address1, String address2, String address3);

	//===========================================================================================
	
	// 주문 페이지
	// 회원등급, 적립금 수정해주기
	void update_grade(String mem_id, String grade_name, int mem_point);


	
	
}
