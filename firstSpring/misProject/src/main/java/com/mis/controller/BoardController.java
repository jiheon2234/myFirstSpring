package com.mis.controller;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.PageMaker;
import com.mis.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET() throws Exception{
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		System.out.println("register method");
		service.register(vo);
		rttr.addFlashAttribute("result","success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		model.addAttribute("list",service.listAll());
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("bno")int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		service.modify(vo);
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
//	@RequestMapping(value="/listCri",method=RequestMethod.GET)
//	public void listCri(Criteria cri, Model model) throws Exception{
//		//페이징 네비계이션이 없음
//		model.addAttribute("list",service.listCriteria(cri));
//	}
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		
		//선택된 페이지의 계시글 정보 가져오기
		model.addAttribute("list",service.listCriteria(cri));
		//페이징 네비계이션 추가
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		//페이징 정보 화면 전달
		model.addAttribute("pageMaker",pageMaker);
		
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.GET)
	public void modifyPage(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPage(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) throws Exception{
		service.modify(vo);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
	
}
