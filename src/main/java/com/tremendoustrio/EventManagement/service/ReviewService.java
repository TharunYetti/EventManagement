package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.ReviewCard;

import java.util.List;

public interface ReviewService {
    String addReview(ReviewCard reviewCard);
    List<ReviewCard> getAll();
}
