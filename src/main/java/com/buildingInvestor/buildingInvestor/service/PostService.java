package com.buildingInvestor.buildingInvestor.service;


import com.buildingInvestor.buildingInvestor.model.Post;
import com.buildingInvestor.buildingInvestor.model.PostImage;
import com.buildingInvestor.buildingInvestor.model.Review;
import com.buildingInvestor.buildingInvestor.repository.PostImageRepository;
import com.buildingInvestor.buildingInvestor.repository.PostRepository;
import com.buildingInvestor.buildingInvestor.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;
    private final ReviewRepository reviewRepository;

    public PostService(PostRepository postRepository, PostImageRepository postImageRepository, ReviewRepository reviewRepository) {
        this.postRepository = postRepository;
        this.postImageRepository = postImageRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public List<PostImage> findImagesByPostId(Long postId) {
        return postImageRepository.findAllByPostId(postId);
    }

    public List<Review> findReviewsByPostId(Long postId) {
        return reviewRepository.findAllByPostId(postId);
    }
}