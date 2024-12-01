package com.buildingInvestor.buildingInvestor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagePath; // 이미지 경로

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post; // Post와 다대일 관계
}