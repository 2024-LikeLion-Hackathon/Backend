package com.emotionmaster.emolog.emotion;

import com.emotionmaster.emolog.color.dto.response.ColorResponse;
import com.emotionmaster.emolog.emotion.domain.DefaultEmotion;
import com.emotionmaster.emolog.emotion.repository.DefaultRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmotionService {

    private final DefaultRepository defaultRepository;

    public ColorResponse getColorByEmotion(String emotion) {
        DefaultEmotion entity = defaultRepository.findByEmotion(emotion)
                .orElseThrow(() -> new EntityNotFoundException("Emotion not found: " + emotion));

        ColorResponse response = new ColorResponse();
        response.setRed(entity.getRed());
        response.setBlue(entity.getBlue());
        response.setGreen(entity.getGreen());
        response.setType(entity.getType());  // enum 인덱스로 변환

        return response;
    }
}
