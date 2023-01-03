package com.mis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.ProductVO;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	/**
	 * void 타입 => doA.jsp로 응답
	 */
	
	@RequestMapping("doA")
	public void  doA() {
		
		//요청=> 응답 (화면으로, .jsp)=> 나의 requestMapping주소와 동일한 jsp 실행  ==(doA.jsp실행)
		logger.info("doA called.......");
	}
	
	/**
	 * 2) String타입 => 문자열.jsp로 응답  => home.jsp
	 * @return
	 */
	
	@RequestMapping("doB")
	public String doB() {
		logger.info("doB called");
		return "home";
	}
	
	/**
	 * 
	 * result.jsp + 매개변수 msg(get param 값)
	 * @return
	 */
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called");
		return "result";
	}
	
	/**
	 * 4) VO를 jsp로 전달 ** 가장 많이 사용
	 */
	
	@RequestMapping("doD")
	public String doD(Model model) {
		//model은 화면(jsp)로 정보를 전달 할 때 사용하는 객체
		//1) 데이터베이스에서 VO전달을 받음 (여기서는 가상의 데이터)
		ProductVO product = new ProductVO("제품이름",10000);
		//2) model속성에 VO 담기
		model.addAttribute("pVO",product);
		
		return "productDetail";
	}
	
	/**
	 *  5) Redirect 해야 하는 경우 (등록, 수정, 삭제 후 이동)->주소창 정보 변경
	 */
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		
		rttr.addAttribute("msg","redirected by doE");
		
		return "redirect:/doC";
	}
	
}
