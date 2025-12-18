package com.symbiosis.kvmode.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks") // Обратите внимание на "s" в конце!
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String email;
    private int rating;
    private String comments;

    @Column(name = "admin_response")
    private String adminResponse;

    @Column(name = "has_response")
    private boolean hasResponse = false;

    @Column(name = "is_read")
    private boolean read = false; // Поле в Java называется 'read', но в БД оно 'is_read'

    // Constructors
    public Feedback() {}

    public Feedback(String name, String email, int rating, String comments) {
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.comments = comments;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public String getAdminResponse() { return adminResponse; }
    public void setAdminResponse(String adminResponse) {
        this.adminResponse = adminResponse;
        this.hasResponse = (adminResponse != null && !adminResponse.isEmpty());
    }

    public boolean isHasResponse() { return hasResponse; }
    public void setHasResponse(boolean hasResponse) { this.hasResponse = hasResponse; }

    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }
}