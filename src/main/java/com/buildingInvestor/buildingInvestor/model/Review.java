package com.buildingInvestor.buildingInvestor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewerName; // 리뷰 작성자 이름

    @Column(columnDefinition = "TEXT")
    private String content; // 리뷰 내용

    private Integer rating; // 평점 (1~5)

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post; // Post와 다대일 관계
}