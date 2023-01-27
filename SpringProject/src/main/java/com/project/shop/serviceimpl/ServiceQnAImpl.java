package com.project.shop.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shop.dao.QnADAO;
import com.project.shop.service.ServiceQnA;
import com.project.shop.vo.QnAVO;

@Service("serviceqna")
public class ServiceQnAImpl implements ServiceQnA {

	@Autowired
	QnADAO qnadao;
	
	@Override
	public ArrayList<QnAVO> selectlist() {
		// TODO Auto-generated method stub
		return qnadao.selectlist();
	}
	
	public void write(QnAVO qnaVO) {
		qnadao.write(qnaVO);
	}
	
	
	public Integer nextval() {
		return qnadao.nextval();
	}
	
	public QnAVO selectById(String qnaId) {
		return qnadao.selectById(qnaId);
	}
	
	public void update(QnAVO qnaVO) {
		qnadao.update(qnaVO);
	}
	
	public void answer(QnAVO qnaVO) {
		qnadao.answer(qnaVO);
	}

}
