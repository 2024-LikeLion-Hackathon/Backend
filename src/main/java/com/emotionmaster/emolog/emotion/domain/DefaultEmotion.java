package com.emotionmaster.emolog.emotion.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DefaultEmotion {

    @Id
    private Long id;

    private String emotion;

    private int red;

    private int green;

    private int blue;

    @Enumerated(EnumType.ORDINAL)
    private EmotionType type;

}
