package com.symbiosis.kvmode.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.symbiosis.kvmode.model.Feedback;
import com.symbiosis.kvmode.service.FeedbackService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Get all feedback entries
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedbacks();
    }

    // Get feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    // Get feedback by email
    @GetMapping("/email/{email}")
    public List<Feedback> getFeedbackByEmail(@PathVariable("email") String email) {
        return feedbackService.getFeedbackByEmail(email);
    }

    // Add new feedback
    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }

    // Add admin response
    @PutMapping("/{id}/response")
    public ResponseEntity<Feedback> addAdminResponse(@PathVariable("id") int id,
                                                     @RequestBody String response) {
        Feedback updatedFeedback = feedbackService.addAdminResponse(id, response);
        return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
    }

    // Mark feedback as read
    @PutMapping("/{id}/read")
    public ResponseEntity<Void> markAsRead(@PathVariable("id") int id) {
        feedbackService.markAsRead(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Count unread feedback with responses
    @GetMapping("/unread/count/{email}")
    public ResponseEntity<Long> countUnreadWithResponse(@PathVariable("email") String email) {
        long count = feedbackService.countUnreadWithResponse(email);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // Delete feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable("id") int id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}