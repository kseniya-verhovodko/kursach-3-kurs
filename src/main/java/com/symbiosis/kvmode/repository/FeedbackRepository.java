package com.symbiosis.kvmode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.symbiosis.kvmode.model.Feedback;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByEmail(String email);

    // Используем правильное название метода для поля isRead
    // Spring Data JPA преобразует isRead в is_read в запросе
    long countByEmailAndHasResponseTrueAndReadFalse(String email);

    // Или можно использовать явный @Query:
    // @Query("SELECT COUNT(f) FROM Feedback f WHERE f.email = :email AND f.hasResponse = true AND f.read = false")
    // long countUnreadWithResponse(@Param("email") String email);
}