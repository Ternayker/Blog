package com.spring.safetyblogbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.safetyblogbr.model.Post;

public interface SafetyblogbrRepository extends JpaRepository<Post, Long>{

}
