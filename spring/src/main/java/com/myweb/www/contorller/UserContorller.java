package com.myweb.www.contorller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.UserVO;
import com.myweb.www.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/member/*")
@Controller
public class UserContorller {
	
	private static final Logger log = LoggerFactory.getLogger(UserContorller.class);
	@Inject
	private UserService usv;
	
	@GetMapping("/signup")
	public String index(Model m) {
		log.info(" >>>>> HOME >>>>>");
		m.addAttribute("msg_home", 1);
		return "/user/signup";
	}
	
	@PostMapping("/signup")
	public String signUpPost(Model m, UserVO uvo) {
		log.info(" >>>>> 회원가입 접근완료 >>>>> ");
		log.info(" >>>>> 회원가입 >>>>> : "+ uvo.toString());
		int isOk = usv.signUp(uvo);
		if(isOk > 0) {
			m.addAttribute(" >>>>> msg_signUp", 1);
		}else {
			m.addAttribute(" >>>>> msg_signUp", 0);
		}
		return "home"; // 결과 페이지
	}
	
}
