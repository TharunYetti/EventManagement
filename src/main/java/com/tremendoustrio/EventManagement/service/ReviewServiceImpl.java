package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.ReviewCard;
import com.tremendoustrio.EventManagement.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public String addReview(ReviewCard reviewCard) {
        reviewRepository.save(reviewCard);
        return "";
    }

    @Override
    public List<ReviewCard> getAll() {
        return reviewRepository.findAll();
    }
}
