package com.project.shop.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project.shop.vo.BbsVO;

public interface ServiceBbs {

	ArrayList<BbsVO> selectlist();
	
	void bbsWrite(BbsVO bbsVO);
	
	Integer nextval();
	
	BbsVO selectById(String bbsId);

	 BbsVO bbsView(BbsVO bbsVo);
	 
	  void bbsDelete(BbsVO bbsVO);
	 
	  void bbsUpdate(BbsVO bbsVO);
	 
	  void hitupdate(String bbsId);

}