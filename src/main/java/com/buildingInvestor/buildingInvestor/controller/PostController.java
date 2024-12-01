package com.buildingInvestor.buildingInvestor.controller;

import com.buildingInvestor.buildingInvestor.model.Post;
import com.buildingInvestor.buildingInvestor.model.PostImage;
import com.buildingInvestor.buildingInvestor.model.Review;
import com.buildingInvestor.buildingInvestor.service.PostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String listPosts(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        List<PostImage> images = postService.findImagesByPostId(id);
        List<Review> reviews = postService.findReviewsByPostId(id);
        model.addAttribute("post", post);
        model.addAttribute("images", images);
        model.addAttribute("reviews", reviews);
        return "post/view";
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/form";
    }

    @PostMapping
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}