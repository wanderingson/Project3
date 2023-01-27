package com.project.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.shop.vo.BbsVO;

public interface BbsDAO {

	ArrayList<BbsVO> selectlist();
	
	void  bbsWrite(BbsVO bbsVO);
	
	Integer nextval();
	
	BbsVO selectById(String bbsId);
	
	BbsVO bbsView(BbsVO bbsVo);

void bbsDelete(BbsVO bbsVO);

	void bbsUpdate(BbsVO bbsVO);
	
	void hitupdate(String bbsId);
}