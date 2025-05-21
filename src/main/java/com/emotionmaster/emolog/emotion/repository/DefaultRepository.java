package com.emotionmaster.emolog.emotion.repository;

import com.emotionmaster.emolog.color.dto.response.ColorResponse;
import com.emotionmaster.emolog.emotion.domain.DefaultEmotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DefaultRepository extends JpaRepository<DefaultEmotion, Long> {
    @Query("SELECT new com.emotionmaster.emolog.color.dto.response.ColorResponse(d.red, d.blue, d.green, d.type) " +
            "FROM DefaultEmotion d WHERE d.emotion = :emotion")
    ColorResponse findColorByEmotion(@Param("emotion") String emotion);

    Optional<DefaultEmotion> findByEmotion(String emotion);
}
