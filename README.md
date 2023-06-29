# Web_Project
늘봄 실버타운 & 요양원

# 프로젝트 소개
- 입주자들의 건강, 삶의 질, 사회 참여 등을 증진하기 위한 실버타운과 요양원을 운영
하고, 다양한 서비스와 활동을 제공하기 위해 필요한 기능을 구상한다.
- 이를 위해 효율적인 운영과 관리를 위한 관리자용 그룹웨어와 실버타운 통합 웹 페이지를 구현한다.

# 개발기간
- 2023-05-25 ~ 2023-06-12

# 기술 스택
### Environment
<img src="https://img.shields.io/badge/Eclipse IDE-2c2255?style=for-the-badge&logo=EclipseIDE&logoColor=white"/> <img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white"/> <img src="https://img.shields.io/badge/Git-f05032?style=for-the-badge&logo=Git&logoColor=white"/>

### Language
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"/>  <img src="https://img.shields.io/badge/JavaScript-f7df1e?style=for-the-badge&logo=JavaScript&logoColor=white"/> <img src="https://img.shields.io/badge/HTML5-e34f26?style=for-the-badge&logo=HTML5&logoColor=white"/> <img src="https://img.shields.io/badge/CSS-1572b6?style=for-the-badge&logo=CSS3&logoColor=white"/> 

### Database
<img src="https://img.shields.io/badge/Oracle Database-f80000?style=for-the-badge&logo=Oracle&logoColor=white"/> 

### Server
<img src="https://img.shields.io/badge/Apache Tomcat-f8dc75?style=for-the-badge&logo=&logoColor=white"/> 
### H/W
<img src="https://img.shields.io/badge/Arduino-00979d?style=for-the-badge&logo=Arduino&logoColor=white"/> <img src="https://img.shields.io/badge/Raspberry Pi 4-a22846?style=for-the-badge&logo=RaspberryPi&logoColor=white"/> 

<hr>

# 기능 구현
### :star: 싱글플레이 구현

- 싱글플레이를 위한 AI는 유니티엔진에서 제공하는 Python 기반의 Machine Learning 라이브러리를 사용
- 체크포인트는 시작 지점에서부터 골인 지점까지 번호를 부여하였고, AI가 번호 순서대로 지날 때마다 reward 함수를 통해서 보상을 얻게 된다. (머신러닝)
<p align="center">
  <img src="https://github.com/daktae/RaspberryPI_Project/assets/66005780/7731601e-5781-4263-b8d5-f10e922bf50e" width="400">
</p>

### :star: 멀티플레이 구현
- 멀티플레이를 위한 서버는 클라우드 형식의 서버 포톤PUN 서버 사용
- 포톤PUN 서버: 각 플레이어의 데이터를 PUN으로 전달 -> PUN이 플레이어의 데이터를 중계 -> 각 플레이어는 데이터를 전달받아 동기화 (릴레이방식)
<p align="center">
  <img src="https://github.com/daktae/RaspberryPI_Project/assets/66005780/e47928ad-2d06-4e75-a796-ff556226dc4e" width="400">
</p>

### :star: 조작 구현
- 아두이노의 자이로센서(MPU-6050)를 통해 플레이어의 움직임에 필요한 센서값 갖고오기
- 갖고 온 센서값을 블루투스 모듈(HC-06)을 통해서 라즈베리파이에 전달
- 아두이노의 BTSerial 함수를 통해 버퍼 형태로 센서값 전달
- 전달된 센서값은  Unity Android Bluetooth API를 통해 게임에 전달
- 전달받은 센서값을 통해서 움직임 구현
<p align="center">
  <img src="https://github.com/daktae/RaspberryPI_Project/assets/66005780/99606fb0-9ec9-4591-8b07-3e954f2aac9f" width="400">
</p>

## :video_game: 게임 플레이
- [싱글플레이] https://youtu.be/L9irJsP7_VI
- [멀티플레이] https://youtu.be/qvbSIpQC-Ts

## 문제해결을 위한 노력
- 유니티 게임 엔진으로 만든 게임이 확장자 명이 exe로 나오게 된다. 하지만 OS가 리눅스인 라즈베리파이에서는 exe가 실행되지 않아, 일단 게임을 apk형태로 만든 다음 라즈베리파이에 리니지OS라는 안드로이드 기반의 오픈소스 OS를 설치하여 실행하였다.

## :memo: 아쉬운 점
- 기획에 있어서 게임 실행에 있어서, 터치스크린을 통한 터치로 게임 진행을 목표로 하였다, 화면 크기로 인해 라즈베리파이 정품 터치스크린이 아닌 일반 디스플레이로 대체하여 터치가 되지 않았다. 이런 부족한 면도 있지만, 모든 활용한 소스가 오픈소스라는 점에서 만든 프로그램을 Github를 통해서 자유롭게 수정, 배포, 활용이 가능하다는 점이 장점이라고 생각한다. 

