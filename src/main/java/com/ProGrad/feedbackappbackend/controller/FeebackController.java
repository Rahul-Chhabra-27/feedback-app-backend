package com.ProGrad.feedbackappbackend.controller;

import com.ProGrad.feedbackappbackend.model.Feedback;
import com.ProGrad.feedbackappbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeebackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/")
    public ResponseEntity<List<Feedback>> getFeedbacks() {
        return feedbackService.getFeedbacks();
    }

    @PostMapping("/add-feedback")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }
}
