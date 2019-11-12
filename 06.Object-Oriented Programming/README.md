## 1. OOP & Class, Object

#### 1. OOP

- OOP: Object Oriented Programming - 캡슐화, 재사용성

#### 2. class & object

- 클래스(설계도면, 청사진, 프레임, 틀)와 객체(혹은 instance: 설계도 대로 만들어지며, 고유의 데이터와 연관 행위를 갖춘 독립적인 단위)

#### 3. class definition

- 클래스 정의를 통해 하나의 새로운 형(Type 자료형)으로 만드는 것
- 데이터(field, attribute, property, 멤버 변수/상수) + 행위(method, 멤버 함수)

```
class 클래스 이름 {
    body 정의부
}
```

#### 4. Instantiation

- 인스턴스화(클래스 타입의 객체를 생성 및 초기화 하는 것)
- 클래스형의 변수가 바로 인스턴스, 다른 타입의 객체들과 상호작용 할 수 있음

#### 5. constuctor

- 객체 생성을 위해 반드시 생성자(constuctor)가 한 번 호출 되어야 함
- 코틀린에서는 new, alloc, init 등을 별도로 지정해서 호출하지 않음

- 자바와 달리 코틀린 클래스는 이름이 파일명과 일치할 필요가 없음
- 코틀린 클래스는 탑레벨 선언이 가능하며, 특정 패키지에 mport 될 수 있음

## 2. Primary Constuctor & val/var Properties

#### 1. primary constructor

- 주요 생성자
- 클래스에 단 1개만 가질 수 있음

```
// public 접근 가능한 빈 주요 생성자가 생략되어 있음
class Student public constuctor()
```

- Student() 호출: 생성자 함수를 호출하여 클래스의 객체를 인스턴스로 생성함

#### 2. val/var properties

- 읽기 전용, 혹은 읽기/쓰기용 접근이 가능한 프로퍼티(필드) 정의
- getter, setter 함수 역할
- 주요 생성자의 인자로 var, val 프로퍼티를 바로 정의하여 사용할 수도 있음

```
class Student(name: String, val age: Int = 20)
```

#### 3. value-parameter

- val, var가 없어서 프로퍼티나 필드가 아니고 단지 init{} 블록이나 필드/프로퍼티의 초기화에서만 바로 사용되는 값을 담은 인자

## 3. init block, secondary constructors

#### 1. init block

- 주요 생성자의 value-parameter나 프로퍼티 파라미터를 사용하여 초기화

```
init {
    초기화 코드
}
```

#### 2. secondary constructors

- 2차 생성자를 한 개 이상 더 정의할 수 있음
- 주요 생성자 / 다른 2차 생성자를 호출하여 초기화를 위임할 수 있음

```
class Professor(var name: String){
    constructor(_name: String, _age: Int): this(_name){
        age = _age
    }

    constructor(_name: String, _age: Int, _major: String, fav: Double) : this(_name, _age) {
        major = _major
        this.fav = fav
    }
}

```

## 4. Getters, Setters & Backing Field

#### 1. getters & setters

- 기본적으로 프로퍼티에 대한 val 읽기
- var 읽기/쓰기 메소드들을 제공
- custom getter/setter 메소드들로 각각 갱신 정의 가능

```
var <propertyName>[:<propertyType>] [=<property_initializer>]
    [<getter>]
    [<setter>] // 인자 이름으로 value를 주로 사용
```

#### 2. field

- 커스텀 getter/setter 메소드 내에서 필드 그 자체를 나타내는 백킹 필드 키워드

## 5. Visibility Modifier
