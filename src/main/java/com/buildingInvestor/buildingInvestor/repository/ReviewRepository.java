package com.buildingInvestor.buildingInvestor.repository;

import com.buildingInvestor.buildingInvestor.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByPostId(Long postId);
}