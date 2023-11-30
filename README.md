# first

## 목차
1. [WebService 동작 원리](#web-service-동작원리)
2. [Vue Templete & MVC Patten](#vue-템플릿-과-mvc-패턴)


### Web Service 동작원리
- 클라이언트 : 서비스를 사용하는 프로그램 또는 컴퓨터
- 서버 : 서비스를 제공하는 프로그램 또는 컴퓨터

&rarr;
클라이언트가 서버에 요청을 하게 되면 서버는 해당 요청을 응답으로 전해준다.

### Vue 템플릿과 MVC 패턴
<details>
<summary>자세히 보기</summary>

- Vue 템블릿 : 화면을 담당하는 기술
    - 틀이되는 페이지가 변수의 값에 따라서 수많은 페이지로 바뀔 수 있음
    - Controller : 처리
    - Model : data
    - Mustache : Vue 템블릿 엔진


- MVC 패턴 : 화면, 처리, 데이터 분야를 각 담당자별로 나누는 기법

- 정리
  <br>

  클라이언트 :
  http://localhost:8080/hi   
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&darr;
  ```java
  @Controller
  public class FirstController {

    @GetMapping("/hi") // localhost:8081/hi
    public String niceToMeetYou(Model model){
        model.addAttribute("username","won yong"); // (변수,값)
        return "greetings"; // templates/greetings.mustache -> 브라우저로 전송 (뷰 페이지 이름)
    }
  }
  ```
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&darr;
  <table>
  <tr>
    <td>key</td>
    <td>value</td>
  </tr>
  <tr><td>username</td><td>won yong</td></tr>
  </table>

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &darr;
  ```html
  <html>
  <head>
      <meta charset="UTF-8">
      <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Document</title>
  </head>
  <body>
      <h1>{{username}}님, 반갑습니다!</h1>
  </body>
  </html>
  ```
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&darr;
</details>
  

### model, view , controller 역할
<details>
<summary>자세히 보기</summary>

 ```java
    @Controller
  public class FirstController {
    @GetMapping("/bye")
    public String seeBob(Model model){
    model.addAttribute("nickname","won yong");
    return "goodday"; //templates
    }
  }
 ```

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &darr;
  ```html
    <html>
  <head>
      <meta charset="UTF-8">
      <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Document</title>
  </head>
  <body>
      <h1>{{nickname}}님, 다음에 밥</h1>
  </body>
  </html>
   ```

</details>

### 화면요소 Layout
<details>
<summary>자세히 보기</summary>

header : navigation
<br>
content
<br>
footer : information



</details>

### 폼 데이터 주고받기

<details>
<summary>자세히 보기</summary>

1. Create

  - form 데이터를 받는 객체 -> DTO
<br>
  #### 입력 폼 만들기

<br>




#### JPA
Client -> DTO -> Controller -> Entity -> repository -> save() -> db

```java
 // 1. Dto를 변환! Entity!
    Article article = form.toEntity();
```    
```java
 // 2. Repository에게 Enbtity를 DB안에 저장하게 함!
    Article saved = articleRepository.save(article);
```

### DB접근

 - h2 DB, 웹 콘솔 접근 허용 : spring.h2.console.enabled=true
<br>

 - web 접속 :  http://localhost:8081/h2-console


</details>