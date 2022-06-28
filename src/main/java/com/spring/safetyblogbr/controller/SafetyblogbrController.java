package com.spring.safetyblogbr.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.safetyblogbr.model.Post;
import com.spring.safetyblogbr.service.SafetyblogbrService;

@Controller
public class SafetyblogbrController {

	@Autowired
	SafetyblogbrService safetyblogbrService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPost() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = safetyblogbrService.fidAll();
		mv.addObject("posts",posts);
		return mv;
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDataile(@PathVariable("id") long id) {
			ModelAndView mv = new ModelAndView("postDetails");
			Post post = safetyblogbrService.findById(id);
			mv.addObject("post",post);
			return mv;
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostFormat() {
		return "postFormat";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem","verifique se os campos obrigatorios foram preenchidos");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		safetyblogbrService.save(post);
		return "redirect:/posts";
	}
	
	
	@RequestMapping(value = "/deletpost/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("id") long id) {
		safetyblogbrService.deleteById(id);
		return "redirect:/posts";
	}
	

}

