package com.spring.safetyblogbr.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.safetyblogbr.model.Post;
import com.spring.safetyblogbr.repository.SafetyblogbrRepository;
import com.spring.safetyblogbr.service.SafetyblogbrService;

@Service
public class SafetyblogbrServiceImpl implements SafetyblogbrService{

	@Autowired
	SafetyblogbrRepository safetyblogbrRepository;
	
	@Override
	public List<Post> fidAll() {
		return safetyblogbrRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return safetyblogbrRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return safetyblogbrRepository.save(post);
	}

	@Override
	public void deleteById(long id) {
		safetyblogbrRepository.deleteById(id);
	}

	@Override
	public Post getReferenceById(long id) {
		return safetyblogbrRepository.getReferenceById(id);
	}

}