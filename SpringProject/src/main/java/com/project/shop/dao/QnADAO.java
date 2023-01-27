package com.project.shop.dao;

import java.util.ArrayList;

import com.project.shop.vo.QnAVO;

public interface QnADAO {

	ArrayList<QnAVO> selectlist();
	
	void write(QnAVO qnaVO);
	
	Integer nextval();
	
	QnAVO selectById(String qnaId);
	
	void update(QnAVO qnaVO);
	
	void answer(QnAVO qnaVO);

}
