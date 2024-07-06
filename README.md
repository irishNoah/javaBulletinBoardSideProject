# Java Board(Simple)
※ Java 기반으로 구현한 아주 간단한 게시판입니다. MySQL을 연동한 CRUD가 가능하며, Pagination도 가능합니다.

## Directory
```
Project Name
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │ │ └── example
│ │ │ │ │ ├── servlet
│ │ │ │ │ │ ├── Post.java
│ │ │ │ │ │ ├── PostAddServlet.java
│ │ │ │ │ │ ├── PostDetailServlet.java
│ │ │ │ │ │ └── PostServlet.java
│ │ │ │ │ └── util
│ │ │ │ │ │ ├── DBUtil.java
│ │ └── webapp
│ │ │ ├── META-INF
│ │ │ │ ├── MANIFEST.MF
│ │ │ └── WEB-INF
│ │ │ │ ├── lib
│ │ │ │ └── web.xml
│ │ │ └── WEB-JSP
│ │ │ │ ├── postadd.jsp
│ │ │ │ ├── postdetail.jsp
│ │ │ │ ├── postlist.jsp
│ │ │ └── index.jsp
├── target
└── pom.xml
```

##  핵심 디렉토리 구조 & 파일 설명
### Directory
| 폴더명 | 설명  |
| :---------- | :------- |
| src/main/java/com/example/servlet     | 게시판 관련 getter 및 setter & CRUD 관련 Servlet 관련 디렉토리 |
| src/main/java/com/example/util        | MySQL 접속 관련 디렉토리  |
| src/main/webapp/WEB-INF         	| Servlet name / class / url-patter 등록 관련 디렉토리  |
| src/main/webapp/WEB-JSP         	| jsp(화면) 관련 디렉토리  |


### File
| 파일명 | 설명  |
| :---------- | :------- |
| Post.java     | 게시판 테이블 컬럼 getter & setter |
| PostAddServlet.java       | 게시판 Create 작업 수행  |
| PostDetailServlet.java         	| 게시판 Update 및 Delete 작업 수행  |
| PostServlet.java         	| 게시판 목록 Read 작업 수행  |
| DBUtil.java         	| MySQL DB 접속 작업 수행  |
| web.xml         	| 라우터 경로 설정  |
| postadd.jsp         	| 등록 화면  |
| postdetail.jsp         	| 상세 화면(수정 / 삭제)  |
| postlist.jsp         	| 게시판 목록 화면  |
| index.jsp          	| http://localhost:8080 으로 들어올 경우, 바로 postlist.jsp로 이동  |

## DBUtil.java



## 환경 설정
- Dynamic Web으로 구현


## 화면



## 어려웠던 점



## Velog
