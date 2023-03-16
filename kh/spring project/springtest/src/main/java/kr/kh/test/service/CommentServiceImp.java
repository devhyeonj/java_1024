package kr.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.CommentDAO;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	CommentDAO commentDao;
	

}
