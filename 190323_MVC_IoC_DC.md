#  객체지향 기술과 분산프로그래밍 1(기초)
## 하석재 강사님 / 2HCUBE, CEO
### 2019.03.20.

---

### 프로그래밍 기술의 흐름
- 언어
    - 절차적언어('80-'90) -> 객체지향언어('00-'10) -> 함수형언어(람다)('10-)
    - C -> C++ -> Java/C# -> Modern Java / Javascript(ES) + Typescript / Python
- 함수형 언어
    - 코드를 짧게 만들어주는것
    - 왜 이렇게 되는거야? 하는게 문제
    - 특징
        - 간단한 정의 vs. 모호성
    - 원조
        - IPL/Lisp
    - 현세대
        - Scala, Haskell, Erlang
        - Modern Java(8.0 이상)
- Lambda Expression
    - 익명함수를 뜻하지만 실무적으로는 코드의 간결함, 지연 연산을 통한 퍼포먼스 향상, 그리고 기존 이터레이션
    - 정규식 같이 알고나면 효율적이나 알기가 힘든게 단점
- 객체지향기술을 기반으로 다른 기술을 융합하면서 발전
- OOP(+IoC/DI +MVC) + (분산)컴포넌트 + 람다(함수형언어)
- Front-end vs. Back-end
    - 서버/클라이언트 기술 이후
    - 현재 웹기준으로는 백엔드는 **자바(+스프링 프레임워크)**로 구성하고 프론트엔드는 **자바스크립트**를 사용해서 구성하는 것이 대세
    - 데이터사이언스+AI용으로는 **파이썬**의 절대적 강세
    - 현재는 서버단의 처리가 많이 줄고 프론트엔드로 넘어가는 경우가 많음 그래서 **자바스크립트**가 뜨기 시작함

### 객체지향기술의 흐름
- 객체지향은 20년 전부터 뜨기 시작
- 현재는 객체지향을 모르면 개발이 불가능한 상황
- 요즘의 모든 언어들은 객체지향으로 함
    - ex) Java 스크립트도 TypeScript가 등장하면서 객체지향화 되고 있음
- 1급 함수
    1. 변수나 데이터에 할당할 수 있어야함
    2. 객체의 인자로 넘길 수 있어야함
    3. 객체의 리턴값으로 반환할 수 있어야함
- 객체지향?
    - 객체(Object) : 
        - 사물, 물건/물체
        - 추상 개념
    - 오리엔트(Oriented) : 
        - 해가 뜨는 곳(영어 뜻) 
        - "Based", "Centric"
    - 먼저 오브젝트를 생성하고 오브젝트의 기능을 호출하면서 원하는 동작을 하도록 만드는 프로그래밍 방식
- 객체지향기술
    - OO = OOP + 
- 객체지향프로그래밍(OOP) 4단계
    - 클래스 정의
    - 오브젝트 선언
    - 인스턴스 생성
    - 메소드 호출
- 네이밍
    - 개발자가 가장 힘들어하는 분야
    - 헝가리안 표기법(Hungarian Notation)
        - MS의 찰스시모니가 제안
        - **i**Simple = **f**Temp;
        - 앞에 타입을 나타내는 알파벳을 넣음
        - MFC(CObject, m_temp), Typescript(_temp)
    - 낙타 표기법(Camel Casing) / 파스칼 표기법(Pascal Casing)
        - 가장 많이 사용(Java, C#, ...)
        - helloWorld(method/field) / HelloWord(Class)
    - 뱀 표기법(Snake Case)
        - hello_word
    - CoC(Convension over Configuration) 표기법
        - 스프링/MyBatis에서 많이 사용
        - Model Class(Sample) Controller Class(SamplesController)
        - Table Name(smaples), PK(id, auto_increment, int), FK(simple_id)
        - 외우면 쉬워짐
    - 케밥 표기법(Kebab Casing)
        - Angular(Google)에서 사용
        - hello-world
- 객체지향 기술은 왜 인싸?
    - 소프트웨어 위기 현상 : 개발하는 시간보다 유지보수, 디버깅 하는 시간이 더 오래걸림
    - 소프트웨어 위기 원인
        - 전역 변수의 사용
        - 중간에 전역변수 값이 깨지면 문제 발생
    - 대응방안
        - 캡슐화 - 객체지향 프로그래밍(OOP)
- 객체지향의 핵심 아이디어
    - 캡슐화(Encapsulation)
        - private으로 만들기
        - getter/setter를 만들어 이 메소드를 통해 필드를 접근
    - 상속(Inheritance)
        - 코드 재활용
    - 상속을 쓰기 좋게 만듬
- 상속 방법
    - 서브클래싱(부모 -> 자식)
    - 독립구현(상속 없이 구현)
    - 슈퍼클래싱(자식 -> 부모)

### 상속 예제
- 상속을 사용하는 것은 좋으나 상속 받고 부모의 모든 코드를 쓰는 것은 아님
    - 상속 받고 재활용 안되는 코드가 얼마나 되는가?
    - 코드 재활용을 위해 상속을 했으나, 절반도 재활용이 안된다면?
    - 상속을 받지 않는 것이 오히려 베스트
- 독립구현 예제
```java
// 정수 클래스
class INT {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void add(int value){
        this.value += value;
    }

    public void subtract(int value){
        this.value -= value;
    }

    public void multiply(int value){
        this.value *= value;
    }
}
```
- 여기에서 정수 클래스를 상속받는 자연수 클래스를 만든다면 모든 계산 함수를 Override 해야함
    - 이 경우 그냥 상속을 받지 않고 새로운 클래스로 만드는 것이 더 나음
```java
class NAT extends INT{
	private boolean isNegative(int value){
		return (value>0)? true:false;
	}

	private boolean negativeDo(){
		System.out.println("negative!!");
		System.exit(-1);
	}

	@Override
	public void setValue(int value){
		if (!isNegative(value)){ super.setValue(value); }
		else{ negativeDo(); }
	}

	@Override
	public void add(int Value){
		if (value > 0){ super.add(value); }
		else{ negativeDo(); }
	}

	@Override
	public void multiply(int value){
		if (value > 0){ super.multiply(value); }
		else{ negativeDo(); }
	}

	@Override
	public void subtract(int value){
        if(super.getValue() >= value){ super.subtract(value); }
        else{ negativeDo(); }
	}

	public static void main(String[] args){
		NAT a = new NAT();
		a.setValue();
		a.add();
		a.subtract();
		a.multiply();

		System.out.println(a.getValue());
	}
}
```
- 슈퍼클래싱 예제
    - 정수와 자연수 모두 가지고 있는 것을 부모로 만든다면?
    - 공통 부모를 만들고 내부 함수의 내용이 달라져야하니 추상 클래스로 생성하게 됨
```java
// class INT extends NUM {}
// class NAT extends NUM {}

abstract class NUM{
    private int value;
    public int getValue(){ return value; }
    public void setValue(int value){ this.value = value; }
    abstract add(int value);
    abstract subtract(int value); 
    abstract multiply(int value);
}
```
- 상속 방법 : 서브클래싱 -> 상속없이 구현 -> 슈퍼클래싱
    - 경험적으로 하다보면 어떻게 구현해야하는지 알게됨

### 오버헤드
- 객체지향의 문제점
    - 클래스의 일부만 선택해서 상속받을 수 없음
    - All or Nothing
    - 상속받았지만 재활용되지 않는 코드는?
- 상속에 대한 입장(단일상속 vs. 다중상속)
    - 부모클래스를 하나만 허용 vs. 여러 개를 허용
    - 단일상속의 경우 선택의 문제가 발생(재활용할 코드가 있어도 이미 상속받았을 경우는 구현해야 함)
    - 객체지향기술의 주류는 단일상속이 됨 -> 오버헤드의 관점에서 설명가능
- 단일상속기술의 보완책(인터페이스)
    - 타입 = 클래스 + 인터페이스
    - 클래스/오브젝트 = 코드(메소드) + 데이터(필드)
    - 인터페이스 = 코드를 가질 수 없는 클래스(메소드 선언만 허용)
    - 다중상속 허용
    - 인터페이스는 코드가 없어 코드 재활용이 안됨!
    - 용도 : 상속한 클래스에게 메소드를 만들도록 가이드하는 역할
        - 소스코드를 재활용하는 것이 목표가 아님
- 마샬링/직렬화
    - 오브젝트 <-> 파일/네트워크/데이터베이스(ORM)
    - 관련기술 : ProtocolBuffer(Google)/Thrift(Facebook)
    - 자바의 ObjectStream

### 객체지향 심화
- SOLID(객체지향설계 5원칙)
    - **단일책임의 원칙**
        - 하나의 클래스는 하나의 기능만
    - **개방-폐쇄의 원칙**
        - 확장에는 열려있고 수정에는 닫혀있어야함
    - 리스코프 치환 원칙
    - 인터페이스 분리 원칙
    - 의존성 역전의 원칙
- 리펙토링은 프로그램 최적화 문제에서는 더 안좋을 수 있음
    - 유지보수, 확장에 편함
    - 속도나 확장에는 다른 방법을 사용해야함
    - 속도가 최고의 미덕이 아님
- POJO(Plain Old Java Object)
    - 객체지향의 특징 및 정신을 요약
    - 특정 기술/규약이나 특정 클래스에 의존하는 것은 안 됨
    - 단적으로 특정 기능을 구현하기 위해서 특정 클래스를 상속받는 것은 안 됨
        - ex) 자바에서 Thread를 생성하는 방법 : Thead 상속 vs. Runnable
        - 선택권 보장 - 단일상속의 문제점을 보완하는 방향으로 발전
    - 이를 위해서 **DI + AOP + PSA**가 필요
        - DI(의존 관계 주입) : 의존성이 심하면 안됨
        - AOP(관점 중심 프로그래밍) : 이름을 잘 지어라(이름에 함수를 기능을 제공하고 코드는 로직만 제공)
        - PSA(이식 가능한 서비스 추상화)
    - 클래스/인터페이스로 구현할 수 있는 방법을 모두 제공
        - 클래스 아닌 인터페이스를 사용을 선호
        - 클래스는 상속 받는 순간 패널티가 큼
- 제어의 역전(IoC, Inversion of Control)
    - 프레임워크/WAS/미들웨어등이 주로 사용
    - 제어의 권한을 넘기고 필요한 기능(메소드/함수)만 구현하는 형태
    - 프레임워크는 정해진 (콜백)메소드를 호출하면 사용자의 코드가 호출되는 구조
- UML 기본
    - generalization(extends) : -|>
    - realization(implements) : --|>
    - association : ->
    - depedency : -->
- 의존성(Dependency)
    - 어떤 프로그램이나 서비스가 수행되기 위해 필요한 것
        - 보통 리소스(자원)에 의존
    - **의존성에는 방향이 있음**
        - 전체는 부분에게 의존함
        - 프로그램에서 DBMS로 오라클을 사용한다 -> 프로그램은 오라클에 의존한다
- 의존성 주입(DI, Dependency Injection)
    - 인터페이스를 사용하는 전략패턴(DI)이 주류
    - 다르지만 거의 같이 사용
    - 탬플릿 메소드 패넡(추상클래스) vs. 전략패턴(인터페이스)
        - 자바의 단일상속을 고려하면 인터페이스를 사용하는 것을 선호
    - 필요한 의존성 오브젝트를 정해진 시점에 공급
    - 의존성이 없는(최소화한) 프로그래밍을 작성하라
        - **프로그램 실행단계(마지막)에서 결정**
        - 의존성 없는 코드를 먼저 짜고, 의존성 있는 코드를 분리시키고, 의존성을 주입
    - 주로 생성자를 사용해서 주입
        - setter를 통한 주입
        - 메소드를 통한 주입
    - 인터페이스 패턴!
        - 코드의 기능추가가 매우 쉬운 구조

