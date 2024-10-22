# Java Board(Simple)
※ Java 기반으로 구현한 아주 간단한 게시판입니다. MySQL을 연동한 CRUD가 가능하며, Pagination도 가능합니다.

## Directory
```
Project Name
├── DATABASE
│ ├── ddl_mysql.sql
│ ├── dml_mysql.sql
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
| DATABASE     | 게시판 관련 MySQL 쿼리문 관련 디렉토리 |
| src/main/java/com/example/servlet     | 게시판 관련 getter 및 setter & CRUD 관련 Servlet 관련 디렉토리 |
| src/main/java/com/example/util        | MySQL 접속 관련 디렉토리  |
| src/main/webapp/WEB-INF         	| Servlet name / class / url-patter 등록 관련 디렉토리  |
| src/main/webapp/WEB-JSP         	| jsp(화면) 관련 디렉토리  |


### File
| 파일명 | 설명  |
| :---------- | :------- |
| ddl_mysql.sql     | 게시판 관련 테이블 생성 쿼리문 |
| dml_mysql.sql     | 게시판 관련 테이블 데이터 삽입 쿼리문 |
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

## 환경 설정
| 프로그램 명 | 버전 명  |
| :---------- | :------- |
| JDK         | v17.0.1  |
| Tomcat     | v9.0 Server |
| mysql-connector-java     | v8.0.33 |


## DBUtil.java
※ DBUtil.java는 .gitignore 대상으로, 해당 파일의 소스 코드는 아래와 같습니다. <br>
※ DBUtil.java의 경로는 src/main/java/com/example/util 아래에 넣으셔야 합니다.

```java
package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/DB명(예시:bulletin_board)?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "Your DB ID";
    private static final String PASSWORD = "Your DB Password";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
    	System.out.println("hello?");
    	return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

## 화면 (+ URL Example)
### 메인 화면 (Read Page / http://localhost:8080)
![image](https://github.com/user-attachments/assets/ff7f113d-e447-49d0-a5d7-a9a240e69ca6)



### 등록 화면 (http://localhost:8080/postadd?)
![image align="left"](https://github.com/irishNoah/javaBulletinBoardSideProject/assets/80700537/dc77b79d-a189-4065-87b3-0c7f2890e7b2)

### 상세 화면 (http://localhost:8080/postdetail?no=15)
![image align="left"](https://github.com/irishNoah/javaBulletinBoardSideProject/assets/80700537/62f1b7d2-8aaf-4e1a-a92e-329ec0e1722e)


## 어려웠던 점
- 경로 설정
- [한글 깨짐 방지](https://velog.io/@irish/JavaBoardProject-DeletePosting-and-PreventCrackKorean)

## Velog
- [Java 게시판 프로젝트 관련 블로그](https://velog.io/@irish/series/JavaBoardProject-Create_Dynamic_Web_Project)

## 추후 예정 사항
- Spring + React
