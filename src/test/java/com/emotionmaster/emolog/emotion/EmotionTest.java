package com.emotionmaster.emolog.emotion;

import com.emotionmaster.emolog.color.dto.response.ColorResponse;
import com.emotionmaster.emolog.emotion.domain.EmotionType;
import com.emotionmaster.emolog.emotion.repository.DefaultEmotionRepository;
import com.emotionmaster.emolog.emotion.repository.DefaultRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 DB 사용
public class EmotionTest {

    @Autowired
    private DefaultEmotionRepository emotionRepository;

    @Autowired
    private DefaultRepository defaultRepository;

    @Autowired
    private EmotionService emotionService;

    String emotion = "머쓱하다";

    @Test
    @DisplayName("콜드 스타트 시 쿼리 속도 값")
    public void testQueryTime(){
        long start, end;
        //jdbcTemplate 사용
        start = System.currentTimeMillis();
        ColorResponse jdbcResponse = emotionRepository.getColorByEmotion(emotion);
        end = System.currentTimeMillis();
        check(emotion, jdbcResponse);
        System.out.println("JdbcTemplate: " + (end - start) + "ms");

        //JPQL
        start = System.currentTimeMillis();
        ColorResponse jpqlResponse = defaultRepository.findColorByEmotion(emotion);
        end = System.currentTimeMillis();
        check(emotion, jpqlResponse);
        System.out.println("JPQL: " + (end - start) + "ms");

        //JPA + Service
        start = System.currentTimeMillis();
        ColorResponse jpaResponse = emotionService.getColorByEmotion(emotion);
        end = System.currentTimeMillis();
        check(emotion, jpaResponse);
        System.out.println("JPA + Service: " + (end - start) + "ms");
    }

    //정확한 값이 반환되었는지 확인
    private static void check(String emotion, ColorResponse jdbcResponse) {
        if (emotion.equals("머쓱하다")){
            //머쓱하다
            assertThat(jdbcResponse.getRed()).isEqualTo(170);
            assertThat(jdbcResponse.getGreen()).isEqualTo(163);
            assertThat(jdbcResponse.getBlue()).isEqualTo(32);
            assertThat(jdbcResponse.getType()).isEqualTo(EmotionType.NEG_UNACT);
        }
        else {
            //사랑스럽다
            assertThat(jdbcResponse.getRed()).isEqualTo(180);
            assertThat(jdbcResponse.getGreen()).isEqualTo(180);
            assertThat(jdbcResponse.getBlue()).isEqualTo(21);
            assertThat(jdbcResponse.getType()).isEqualTo(EmotionType.POS_ACT);
        }
    }

    //버퍼 풀 적재 후에는 nanoTime으로 확인
    private long measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return TimeUnit.NANOSECONDS.toMillis(end - start);
    }

    @Test
    @DisplayName("3회 조회 후 평균 쿼리 속도 값")
    public void testAverageQueryTime() {
        int trials = 3;
        long jdbcTotal = 0, jpqlTotal = 0, jpaTotal = 0;

        for (int i = 0; i < trials; i++) {
            jdbcTotal += measureTime(() ->
                    emotionRepository.getColorByEmotion(emotion)
            );
            jpqlTotal += measureTime(() ->
                    defaultRepository.findColorByEmotion(emotion)
            );
            jpaTotal += measureTime(() ->
                    emotionService.getColorByEmotion(emotion)
            );
        }

        System.out.println("Average JdbcTemplate: " + (jdbcTotal / trials) + " ms");
        System.out.println("Average JPQL: " + (jpqlTotal / trials) + " ms");
        System.out.println("Average JPA + Service: " + (jpaTotal / trials) + " ms");
    }

    @Test
    @DisplayName("5회 동안 조회 때마다 쿼리 속도 값")
    public void testEveryQueryTime() {
        int trials = 5;
        long jdbcTotal = 0, jpqlTotal = 0, jpaTotal = 0;

        for (int i = 0; i < trials; i++) {
            jdbcTotal = measureTime(() ->
                    emotionRepository.getColorByEmotion(emotion)
            );
            jpqlTotal = measureTime(() ->
                    defaultRepository.findColorByEmotion(emotion)
            );
            jpaTotal = measureTime(() ->
                    emotionService.getColorByEmotion(emotion)
            );
            System.out.println((i+1) + " JdbcTemplate: " + jdbcTotal + " ms");
            System.out.println((i+1) + " JPQL: " + jpqlTotal + " ms");
            System.out.println((i+1) + " JPA + Service: " + jpaTotal + " ms");
        }
    }
}
