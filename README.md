# Jclip-proto

Jclip서비스 개인용 프로토타입

![Build Status](http://203.254.143.135:1880/job/Jclip_Prototype/badge/icon?style=flat-square)

# TODO
---

### 서버 개발

(back 기능 구현)
- [x] Article - Keyword - User 관계 작성(sep.19 2019)  
- [ ] 알림된 공지사항 중 클립 기능 구현
- [ ] 로그서비스 
- [ ] spring admin
- [ ] spring restdocs & [rest authorize](https://supawer0728.github.io/2018/03/20/spring-data-rest/)

(front 기능 구현)
- [ ] User별로 Clip한 Article 제공, 신규 Article 제공
- [ ] 클립 로그 구현 통해 Popular Notice 제공
- [ ] 알림되지 않은 공지사항에 대해서도 클립기능 구현
- [ ] Custom Clip
- [ ] 전체 공지사항 보여주기


### 프론트 및 배포

- [x] 프론트 - react 나 vue 둘 중하나 정하기 React.js, React Native 훑어보기. --> React 라이브러리 선택, [spring 연동 테스트](https://spring.io/guides/tutorials/react-and-spring-data-rest/)
- [x] jcloud / AWS 배포수단 고민, Jcloud 포워딩 및 배포테스트  : jcloud-AWS 이중화 방식 채택
- [ ] jclip.jbnu.ac.kr 도메인 신청하기


## 테스트

- [ ] Strength Test - [ngrinder](https://github.com/naver/ngrinder)
- [x] Static Test & CI/CD - Jenkins (oct 06 2019 jenkins 
- [ ] Security Test - OWASP zap
