package com.ProGrad.feedbackappbackend.repositry;

import com.ProGrad.feedbackappbackend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepositry extends JpaRepository<Feedback,Long> {
}
