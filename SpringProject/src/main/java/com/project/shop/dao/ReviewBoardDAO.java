package com.project.shop.dao;

import com.project.shop.vo.ReviewBoardVO;

public interface ReviewBoardDAO {
	// 상품후기 작성
	void insert_review(ReviewBoardVO reviewboardVO);
	// 후기작성되었는지 확인
	int check_review(String rid, String rproduct, int order_details_num);
}
