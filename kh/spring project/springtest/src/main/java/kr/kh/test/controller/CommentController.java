package kr.kh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.test.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;

}
