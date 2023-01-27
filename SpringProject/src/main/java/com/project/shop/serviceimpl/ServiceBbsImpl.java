package com.project.shop.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shop.dao.BbsDAO;
import com.project.shop.service.ServiceBbs;
import com.project.shop.vo.BbsVO;

@Service("servicebbs")
public class ServiceBbsImpl implements ServiceBbs {
	
	@Autowired
	BbsDAO bbskaja;
	
	@Override
	public ArrayList<BbsVO> selectlist() {
		// TODO Auto-generated method stub
		return bbskaja.selectlist();
	}
	
	@Override
	public void bbsWrite(BbsVO bbsVO) {
		bbskaja.bbsWrite(bbsVO);
	}
	
	@Override
	public Integer nextval() {
		return bbskaja.nextval();
	}
	
	@Override
	public BbsVO selectById(String bbsId) {
		return bbskaja.selectById(bbsId);
	}
	
	  @Override public BbsVO bbsView(BbsVO bbsVO) { 
	  return bbskaja.bbsView(bbsVO);
	 }
	 
	
@Override
	public void bbsDelete(BbsVO bbsVO) {
		bbskaja.bbsDelete(bbsVO);
	}
	
	@Override
	public void bbsUpdate(BbsVO bbsVO) {
		bbskaja.bbsUpdate(bbsVO);
	}

	@Override
	public void hitupdate(String bbsId) {
		// TODO Auto-generated method stub
		bbskaja.hitupdate(bbsId);
	} 
}