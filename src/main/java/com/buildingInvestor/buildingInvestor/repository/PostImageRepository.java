package com.buildingInvestor.buildingInvestor.repository;

import com.buildingInvestor.buildingInvestor.model.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
    List<PostImage> findAllByPostId(Long postId);
}