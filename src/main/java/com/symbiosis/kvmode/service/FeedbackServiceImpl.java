package com.symbiosis.kvmode.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.symbiosis.kvmode.exception.ResourceNotFoundException;
import com.symbiosis.kvmode.model.Feedback;
import com.symbiosis.kvmode.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepo;

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepo.findAll();
    }

    @Override
    public Feedback getFeedbackById(int id) {
        return feedbackRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id " + id));
    }

    @Override
    public void deleteFeedback(int id) {
        feedbackRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id " + id));
        feedbackRepo.deleteById(id);
    }

    @Override
    public Feedback addAdminResponse(int id, String response) {
        Feedback feedback = getFeedbackById(id);
        feedback.setAdminResponse(response);
        feedback.setHasResponse(true);
        feedback.setRead(false);
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbackByEmail(String email) {
        return feedbackRepo.findByEmail(email);
    }

    @Override
    public void markAsRead(int id) {
        Feedback feedback = getFeedbackById(id);
        feedback.setRead(true);
        feedbackRepo.save(feedback);
    }

    @Override
    public long countUnreadWithResponse(String email) {
        // Используем сгенерированный метод
        return feedbackRepo.countByEmailAndHasResponseTrueAndReadFalse(email);
    }
}