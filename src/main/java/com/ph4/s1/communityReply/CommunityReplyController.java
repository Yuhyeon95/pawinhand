package com.ph4.s1.communityReply;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ph4.s1.member.MemberDTO;

@Controller
@RequestMapping("/boardReply/**")
public class CommunityReplyController {
	
	@Autowired
	private CommunityReplyService communityReplyService;
	
	@GetMapping("boardReplyList")
	public ModelAndView getList(CommunityReplyPager communityReplyPager) {
		ModelAndView mv = new ModelAndView();
		System.out.println(communityReplyPager.getCurPage());
		List<CommunityReplyDTO> ar = communityReplyService.getList(communityReplyPager);
		mv.addObject("lists", ar);
		mv.addObject("pager", communityReplyPager);
		mv.setViewName("board/boardReply/boardReplyList");
		System.out.println("boardReplyList");
		return mv;
	}
	
	@GetMapping("boardReplyDelete")
	public ModelAndView setDelete(CommunityReplyDTO communityReplyDTO, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		System.out.println("member : " + memberDTO.getId());
		System.out.println("writer : " + communityReplyDTO.getCmn_num() );
		if(memberDTO.getId().equals(communityReplyDTO.getWriter())) {
		int result = communityReplyService.setDelete(communityReplyDTO);
		}else {
			System.out.println("dddd");
		}
		long num = communityReplyDTO.getCmn_num();
		mv.setViewName("redirect:../community/communitySelect?num="+num);
		return mv;
	}
	
	@PostMapping("boardReplyInsert")
	public ModelAndView setInsert(CommunityReplyDTO communityReplyDTO) {
		ModelAndView mv = new ModelAndView();
		int result = communityReplyService.setInsert(communityReplyDTO);
		long num = communityReplyDTO.getCmn_num();
		mv.setViewName("redirect:../community/communitySelect?num="+num);
		return mv;
	}
	
	@GetMapping("reply")
	public ModelAndView setReply(CommunityReplyDTO communityReplyDTO, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		String contents = communityReplyDTO.getContents();
		String writer = memberDTO.getId();
		System.out.println("writer : " + writer );
		CommunityReplyDTO dto = communityReplyService.getOne(communityReplyDTO);
		dto.setContents(contents);
		dto.setWriter(writer);
		int result = communityReplyService.setReply(dto);
		long num = dto.getCmn_num();
		mv.setViewName("redirect:../community/communitySelect?num="+num);
		return mv;
	}
	
	
}
