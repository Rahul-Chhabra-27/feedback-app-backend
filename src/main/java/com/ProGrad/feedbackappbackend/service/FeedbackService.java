package com.ProGrad.feedbackappbackend.service;

import com.ProGrad.feedbackappbackend.model.Feedback;
import com.ProGrad.feedbackappbackend.repositry.FeedbackRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepositry feedbackORM;
    public ResponseEntity<List<Feedback>> getFeedbacks() {
        try {
            List<Feedback> feedbacks = feedbackORM.findAll();
            if(feedbacks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(feedbacks,HttpStatus.ACCEPTED);
            }
        }
        catch(Exception expception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Feedback> addFeedback(Feedback feedback) {
        feedbackORM.save(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

}
