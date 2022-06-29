package com.spring.safetyblogbr.service;

import java.util.List;

import com.spring.safetyblogbr.model.Post;

public interface SafetyblogbrService {

	List<Post> fidAll();
	Post findById(long id);
	Post save(Post post);
	void deleteById(long  id);
	Post getReferenceById(long id);
}
