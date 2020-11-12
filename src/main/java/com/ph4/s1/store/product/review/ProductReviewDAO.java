package com.ph4.s1.store.product.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductReviewDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String NAMESPACE = "com.ph4.s1.store.product.review.ProductReviewDAO.";
	
	public List<ProductReviewDTO> getList(){
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
}
