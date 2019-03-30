#  객체지향 기술과 분산프로그래밍 2(기초)
## 하석재 강사님 / 2HCUBE, CEO
### 2019.03.30.

---

### 의존성 주입(DI, Dependency Injection)
- 디자인패턴의 전략패턴
- 필요한 의존성 오브젝트를 정해진 시점에 공급
- 의존성이 없는 코를 짜고, 의존성이 있는 부분은 메인을 짜면서 짜자

### 의존성 주입(IoC/DI)
- 의존성 오브젝트를 생성자를 통해서 넣자
- 인터페이스에만 의존
    - MySQL, MariaDB 등 DB에 대한 인터페이스만 있고, 안에 동작하는 것은 무엇이 되건 상관 없음
    - 확장에는 열려있고, 수정에는 닫혀있음

### MVC(Model-View-Controller)
- 하나의 클래스를 여러개로 나눔
    - 모델(데이터), 뷰, 컨트롤러로 클래스를 분할
- **데이터를 화면에 뿌릴 때, 중간에 컨트롤러가 제어하자**
- monoless 구조는 좋지 않음
- SRP in SOLID(단일책임의 원칙)
- MVC와 COC 네이밍이 붙어있음
    - Ruby on Rails에서 MVC를 제일 먼저 주장함
    - Ruby on Rails에서 COC를 사용
- E.L.(표현언어) 템플릿
- 결국 데이터를 읽어 화면에 뿌리는 동작
    - 비지니스로직은 아무데도 속하지 않음
    - 도메인을 따로 만들어 넣자
- 스프링MVC(프론트 컨트롤러 패턴)
- JSP에서 직접 DBMS를 접속해서 데이터를 가져오는 것(model1 아키텍처)
- 뷰는 JSP로, 컨트롤러는 Servlet으로 생성(model2 아키텍처)
    - MVC를 JSP 기반으로 만들기 위함

### 3-tier / N-tier Architecture
- 1-tier : client / server
- 2-tier : web client - web server/DBMS client - DBMS server
- 3-tier : web client - web server/WAS client(Middleware) - WAS server/DBMS client - DBMS server
- 서버 관리 등 복잡한 내용은 WAS 서버에 맡겨두고 개발자는 기존 방식대로 구현만 하고, SQL만 날려 데이터를 가져오자

#### 개발자?
- Programmer = Architect + Coder + Tester
    - cf. TDD(Test Driven Development)
- 코드를 설계할 때, 미래에 더 확장할 수 있음을 고려해서 만들어야함
- 반복을 통해서 빠른 시간 안에 코드를 생성할 수 있도록 만들어야함

### MVC 실습
- 개발자의 주력 언어
    - Java
    - Javascript
    - Python
- Python에서 DI를 사용하지 않음. 왜?
    - Python은 다중상속 언어이기에 인터페이스가 존재하지 않음
    - DI를 할 수 없음
- Abstract vs. Interface
    - pure abstract fuction : 코드가 없는 abstract fuction
- ORM(Object Relational Mapping)
    - cf. Hibernate(Java) - MyBatis(SQLMapper)
    - cf. JPA(Java Persitence Architecture)
    - 동작을 호출하면 내부적으로 데이터와 연동
    - 모델과 DB 사이의 연동
    - View-Controller-Model-Table(DBMS)
- rs->MemberDao(model)->view
    1. setter를 사용한 직접 대입
    2. ORM
    3. SQLMapper

### 컴포넌트
- 컴포넌트
    - 컴파일된(바이너리) 레벨의 재활용 기술 등장
    - 프로퍼티(Property)를 통한 호출 및 제어가능
        - Reflection - Java
- CORBA
- MS COM - ActiveX/DCOM
- Java - Java Beans/Enterprise Java Beans(EJB)/Spring Bean

- Thread-safe
    - Thread를 돌렸을 때와 안돌렸을 때, 결과가 같게 나와야함
    - Synchronization(Lock in DBMS)
- 비동기는 초기에 네트워크에서 프로세스가 죽는 것을 방지하기 위해 만들어졌음
    - 현재는 속도를 위해 다른 분야에서도 사용되기 시작함

### RPC/RMI
- 네트워크 프로그램을 함수 호출하는 방식으로 만들어줌
- Remote Procedure Call / Remote Method Invocation
    - RPC나 RMI는 같은 말
    - RPC는 C 버전, RMI는 Java 버전
- Sun이 처음으로 제안
- XML Base vs. JSON Base
    - 여러 시스템간의 연동을 위함
- Java RMI는 Sun RPC 기반, MS DCOM은 DCE RPC 기반
- Stub(클라이언트) / Skeleton(서버)
    - 현재는 모두 Stub이라는 말로 통일됨
- 인자와 리턴값을 시스템에 맞게 조정해주어야 함
- gRPC
    - 구글이 만든 RPC/RMI
    - 압축기술을 이용하여 보안과 성능을 증가시킴

### RMI 실습
- 인터페이스 구현
```java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RSInterface extends Remote { // 반드시 Remote 를 상속
    public void println(String msg) throws RemoteException;
}
```
- 서버 구현
    - 서버의 위치를 알아야하기에 Registry에 서버 Stub을 등록
- 클라이언트 구현
    - registry를 확인하여 stub을 가져옴

- 디렉토리 서비스
    - 해당 기능을 찾기 위함
    - 

### SOA/MSA
- 분산컴포넌트 기술의 발전
- SOA : 모든 것을 서비스로 만들어라
    - 너무 무거움
- MSA : SOA를 가볍게 만든 구조
    - 기존의 모노리틱(서비스가 한 덩어리 구조) 구조를 개선
    - 다른 사이트를 모아서 하나의 사이트로 만들자
    - 가변적으로 필요한 서비스들을 늘리고, 불필요한 서비스는 줄임
    - 필요한 부분만 배포 가능
    - 부하가 많은 서비스만 확장 가능
    - 마샬링 오버헤드가 걸림
    - 메모리가 많이 필요함
    - 네트워크 상의 부하가 생김
- 오케스트레이션과 좋은 궁합
- Netflix가 MSA를 제일 잘함
    - Amazon Kong -> Netflix OSS(zuul)


---
## 참고문헌
- 강의자료 : <https://docs.google.com/presentation/d/1RRD1lXSudYm5PdX78hHjdfditfvpo5AFEK_hwGw021o/present?slide=id.p>
- <https://0yumin.tistory.com/17?category=606010>