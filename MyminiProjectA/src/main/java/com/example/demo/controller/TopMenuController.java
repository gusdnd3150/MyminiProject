package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TopMenuService;
import com.example.demo.vo.UserVo;

@Controller
public class TopMenuController {
	
	// 인재 ,기업 , 서울시 등 상단 해더 컨트롤러 (main,회원가입,로그인 제외)
	
	@Autowired
	private TopMenuService service;
	
	//인재 리스트
	@RequestMapping("/people.do")
	public String peopleList(HttpServletRequest request,Model model) {
		UserVo user = (UserVo) request.getSession().getAttribute("USER");
		model.addAttribute("userDetail", user);
		
		List<UserVo> peopleList =service.selectUserList();
		
		model.addAttribute("peopleList", peopleList);
		return "topMenu/peopleList";
	} 

}
