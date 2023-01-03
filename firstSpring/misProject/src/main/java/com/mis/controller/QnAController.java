package com.mis.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.PageMaker;
import com.mis.domain.QnAVO;
import com.mis.domain.SearchCriteria;
import com.mis.service.QnAService;

@Controller
@RequestMapping("/qna/*")
public class QnAController {
	
	@Inject
	private QnAService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(QnAVO vo, RedirectAttributes rttr) throws Exception {

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/qna/list";

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		// 선택된 페이지의 게시글 정보 가져오기 10개
		model.addAttribute("list", service.listSearch(cri));

		// 페이징 네비게이션이 추가
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		// 페이징 정보 화면 전달
		model.addAttribute("pageMaker", pageMaker);

	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("qnaNo") int qnaNo, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		
		model.addAttribute(service.read(qnaNo));
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("qnaNo") int qnaNo, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		//1)공지사항 글
		model.addAttribute(service.read(qnaNo));
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(QnAVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		//1)공지사항 수정 + 첨부파일도 재업로드
		service.modify(vo);
		
		//2)페이징 정보 전달
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/qna/list";
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePOST(@RequestParam("qnaNo") int qnaNo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		//1)공지사항 삭제
		service.remove(qnaNo);
		
		//2)페이징 정보 전달
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/qna/list";
		
	}
	
	

}
