package com.project.shop.service;

import java.util.ArrayList;

import com.project.shop.vo.QnAVO;

public interface ServiceQnA {
	
	ArrayList<QnAVO> selectlist();
	
	void write(QnAVO qnaVO);
	
	Integer nextval();
	
	QnAVO selectById(String qnaId);
	
	void update(QnAVO qnaVO);
	
	void answer(QnAVO qnaVO);
}
