package com.buildingInvestor.buildingInvestor.repository;

import com.buildingInvestor.buildingInvestor.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}