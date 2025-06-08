# Emolog 🎨🐶 <br> - AI 친구 Modi와 대화하며 감정을 분석하는 600가지 감정 일기 서비스

<table border="0" cellpadding="0" cellspacing="0">
  <tr>
   <td>
     <img width="300" alt="로고 1@2x" src="https://github.com/user-attachments/assets/0226f750-5fb4-4999-bd43-e6f968ba064c" />
   </td>
    <td>
      <h3>
        “Modi가 당신의 이야기를 들어줄테니, </br><p></p>
        편안하게 자신의 감정을 돌이켜보고 오늘의 색을 만들어봐요”
      </h3>
      <p>
       참여 인원 : 5명 / 
       개발 주기 : 1달 / 
       2024 멋쟁이사자처럼 중앙 해커톤 출품
      </p>
      <p></p>
    </td>
  </tr>
</table>

## 문제점 발견 ‼️

<table border="0" cellpadding="0" cellspacing="0">
  <tr>
   <td>
      <img src="https://github.com/user-attachments/assets/1a065b49-fb33-48f3-9e15-adb91a77fd9b" alt="문제점" width="500"/>
   </td>
    <td>
       <img src="https://github.com/user-attachments/assets/f54e8d0f-6662-46c4-a395-a8f5e12e5255" alt="문제점" width="500"/>
    </td>
  </tr>
</table>

정신 건강 문제인 **화병 해소의 핵심은 ‘자기감정’을 정확히 표현하는 것**이지만, 스스로 감정을 되돌아보는 것은 쉽지 않으며 **타인이 공감하며 되물어줄 때 더욱 효과적인 해소가 가능하다.**

### "왜 감정 일기인데 감정이 한정되어 있을까?"

기존 감정 일기 서비스는 감정이 20개 내외로 한정되어 있는 것에 의아함을 느꼈고.. 선택지를 굉장히 폭넓히자는 의지로 최종 **600가지의 감정을 사용했다!**

### Emotion + Log = Emolog 🎨

1. 오늘의 일기에 관하여 AI 친구 MoDi와 함께 대화를 나누며 자신의 감정에 솔직해지도록 도와주는 서비스
2. 약 600가지의 감정들 중 일기 내용에 맞는 감정들을 뽑아 보여주며 더 다양한 '자기 감정'에 집중할 수 있다.
3. 선택한 감정들을 토대로 RGB 값을 뽑아 오늘의 색 생성
4. 일기 내용에 연관된 그림일기를 AI가 제작하여 더 풍부해진 일기 제공


## Tech 🔧

<img src="https://upload.wikimedia.org/wikipedia/commons/7/79/Spring_Boot.svg" width=50 height=50> <img src="https://upload.wikimedia.org/wikipedia/commons/a/a7/React-icon.svg" width=50 height=50> <img src="https://upload.wikimedia.org/wikipedia/commons/9/99/Unofficial_JavaScript_logo_2.svg" width=50 height=50> 

<table border="0" cellpadding="5" cellspacing="0">
  <tr>
    <th>카테고리</th>
    <th>기술 스택</th>
    <th>상세 내용</th>
  </tr>
  <tr>
    <td><strong>백엔드</strong></td>
    <td>Spring Boot 3.3.1 / Spring Security, Java 17</td>
    <td>
      라이브러리: Spring Data JPA, JWT, OAuth2.0, Thymeleaf, JUnit<br/>
      인프라: Nginx, AWS RDS, GitHub Actions
    </td>
  </tr>
  <tr>
    <td><strong>프론트엔드</strong></td>
    <td>Next.js, React</td>
    <td>
      주요 라이브러리: Axios, React-Hook-Form
    </td>
  </tr>
  <tr>
    <td><strong>협업</strong></td>
    <td>Notion, Postmanr</td>
    <td>협업 툴로 프로젝트 관리 및 API 문서화</td>
  </tr>
</table>

## 전체적인 Flow Chart 🫧

<img src="https://github.com/user-attachments/assets/5c2fc06e-eb51-4521-b70e-91498700832a" width="700">

## 구현 기능 👨‍💻

### 0. 실제 사용 화면

![image](https://github.com/user-attachments/assets/6726cb5d-d649-4ed0-aa00-52d0cda471cc)

### 1. 로그인 / 회원가입

![image](https://github.com/user-attachments/assets/2d2c44f7-1083-4e16-bd92-df8f82d74825)

### 2. 주간 캘린더 / 월간 캘린더

![image](https://github.com/user-attachments/assets/eee0da33-f418-4732-9ef3-9ba59e9de799)

### 3. 일기 작성 -> 일기를 기반으로 AI와 대화 진행

![image](https://github.com/user-attachments/assets/bbacc711-d68e-41ee-8731-61350b82eda1)

### 4. 감정 선택 -> 오늘의 색 반환 
* 일기와 대화를 분석하여 감정 수치 반환, 600가지의 감정 중 감정 수치에 해당하는 감정들 나열 -> 결과 페이지에서 오늘의 색과 그림일기 확인

![image](https://github.com/user-attachments/assets/b6a51d86-db36-4358-98c6-1570e170ac7f)

### 5. 마이페이지

![image](https://github.com/user-attachments/assets/e1a1b2e5-9eaa-4573-8978-ef7ccbf30791)

## 감정에 관하여 💟
### 600개의 감정을 어떻게 RGB 값으로 구현했을까?

![image](https://github.com/user-attachments/assets/af747ead-413b-42d6-a97c-ee11c9694ced)

* Russell의 정서 차원 이론 및 「한국어 감정단어의 목록 작성과 차원 탐색」 논문 참고
* ‘쾌/불쾌’(Valence)와 ‘활성화’(Arousal)를 기준으로 4사분면으로 분류하여 감정의 위치에 따라 각 RGB 색상 값을 할당
* 결론적으로 ‘쾌/불쾌’와 ‘활성화’ 색상들을 가중 평균(80% + 20%)하여 최종 RGB 산출

## 최적화 ♒

### JPA에서 JDBC 전환으로 쿼리 속도 약 9배 개선
> * ORM 계층을 생략하고 JdbcTemplate으로 간단한 SELECT 쿼리를 통해 DTO로 매핑하여 조회
> * JPA: 184ms, JPQL: 131ms, JDBC: 21ms 으로 약 9배 가량 단축

이에 관하여..  <br>

<a href="https://velog.io/@khhkmg0205/JdbcTemplate-JPQL-JPA%EC%9D%98-%EC%82%AC%EC%9A%A9%EA%B3%BC-%EB%B9%84%EA%B5%90">
  <img src="https://github.com/user-attachments/assets/80861861-3a3d-49d8-a29b-3f14c51f5f9a" alt="벨로그" width="300"/>
</a>

---
# 팀 소개 (4팀 감정마스터)
<div align=center>
  
|PM & BE|BE|FE|FE|AI|DESIGN|
|:--:|:--:|:--:|:--:|:--:|:--:|
|열정이|잡념이|낙관이|명랑이|따분이|평온이|
|<a href="https://github.com/X1n9fU"> <img src="https://github.com/user-attachments/assets/e5cb0b03-78fa-405c-9b99-a5c0bdff355d" width=100 height=100> </a> |<a href="https://github.com/gisu1102"> <img src="https://github.com/user-attachments/assets/136a59b4-6fd8-4ba3-a7a0-f95600dd89a1" width=100 height=100> </a>|<a href="https://github.com/yereong"> <img src="https://github.com/user-attachments/assets/6e6f4929-1027-4e5b-9474-f4e8ab54026d" width=100 height=100> </a>|<a href="https://github.com/yy0un9"> <img src="https://github.com/user-attachments/assets/a86af69d-c982-41fd-a82b-d9a05b9f6be9" width=100 height=100> </a>|<a href="https://github.com/Hwan9915"> <img src="https://github.com/user-attachments/assets/5a66bacd-96c1-4f2b-b171-28264c53a470" width=100 height=100> </a>|<a href="https://github.com/yunzena"> <img src="https://github.com/user-attachments/assets/a3978022-0b23-4c52-81b0-3ac996cdd6c6" width=100 height=100> </a>

</div>
