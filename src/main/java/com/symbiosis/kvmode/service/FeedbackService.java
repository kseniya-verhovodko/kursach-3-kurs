package com.symbiosis.kvmode.service;

import java.util.List;
import com.symbiosis.kvmode.model.Feedback;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(int id);
    void deleteFeedback(int id);
    Feedback addAdminResponse(int id, String response);
    List<Feedback> getFeedbackByEmail(String email);
    void markAsRead(int id);
    long countUnreadWithResponse(String email);
}