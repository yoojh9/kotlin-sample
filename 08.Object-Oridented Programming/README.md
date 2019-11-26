## 1. LATEINIT & BY LAZY

#### 1. lateinit

- 늦은 초기화
- var(mutable) 변수 초기화를 의도적으로 지연시키는 방법
- nullable에서도 null로 선언과 동시에 초기화 하지 않고,init{}에서 초기화 하지 않아도 됨
- 해당 프로퍼티를 사용하고자 할 때 초기화를 진행하고 바로 사용할 수 있음
- 초기화 안하고 그냥 참조하면, 예외(UninitializedPropertyAccessException)를 발생시킴

```
class MyOldCar {
    var color: Int = 0xFF0000
    var garage: String? = null
    lateinit var name: String // error 없음
}
```

#### 2. by lazy

- 게으른 초기화 (프로퍼티 위임 초기화)
- val(immutable) 상수 property에 지정
- property 초기화를 위한 위임(delegated) 블록을 지정하여 맨 처음 참조 시 단 한번의 초기화를 진행하는 방법
- 맨 처음 참조 시에 값을 얻게 되므로, 깔끔하게 null 처리가 전혀 불필요 함

```
class MyOldCar {
    var color: Int = 0xFF0000
    var garage: String? = null
    lateinit var name: String
    val type by lazy { // 바로 실행되지 않음
        "${color.toString(16) 색 SUV 중고차}
    }
}
```

## 2. Abstract Class & Method

#### 1. abstract method

- 추상 메소드, no body, 구현체 코드가 없음
- 구현되지 않고 원형 선언
- (function prototype)만 존재하는 멤버 함수

#### 2. abstract class

- 하나 이상의 추상 메소드를 가지는 클래스, 상속용으로 설계
- constructor를 정의할 수 있어도 호출하지 못하여 인스턴스(instantiation)화 할 수 없음
- 자신이나 부모, 조상 클래스(들) 혹은 모든 상속한 인터페이스(들)의 추상 메소드를 남김없이 override 구현(implementation)하지 못하면 abstract로 남아 있게됨
- 주로 derived classes를 위한 공통 base class로 사용되며, top-down 설계에 유용함

## 3. INTERFACE

#### 1. interface

- 일종의 공통 규약, 프로토콜, 직계 상속으로는 물려 받을 수 없는 다양한 기능들을 확장할 수 있는 방법
  - 기본적으로 모든 함수가 추상 메소드 (public open); 생성자 없음
  - 인터페이스에서 공통으로 늘 사용되는 코드는 기본 바디를 갖춘 구체화 함수로서 구현될 수 있음
  - 상태를 가질 수는 없지만 getter 프로퍼티는 가질 수 있음
  - 클래스는 단일 상속만, 인터페이스는 다중 상속도 지원함

```
    open class A; open class B{} open class C{}
    interface D interface E interface F:D,E
    class Z: A(), B(), C(), D, E //error
    class Z: A(), D, E
```

## 4. Polymorphism

#### 1. polymorphism

- 다형성
- 흔히 배열/컬렉션과 같이 사용되며, 동일한 구조(루프/함수 호출/인자 및 리턴 타입 등)에서 여러가지 내용을 가진 객체들을 사용할 수 있음 => 내용과 구조가 분리된 방식
- 함수 오버로딩, 상속(추상) 클래스 다형성, 인터페이스 다형성

#### 2. kotlin.Any 클래스 기본 다형성

- 최상위 타입으로 모든 타입의 상속 다형성을 부여함
  ```
  listOf<Flock>(Red("길동"), Red("영희"),
      Blues("안나"), Blues("대산"),
      Chuck("Elle"), Chuck("Mike"))
      .forEach {
          with(it) {
              readyForShoot() // Flock
              adjustAngleLength() // Flock
              flyAfterShoot() // 각 하위 클래스마다 고유하게 재정의된 함수가 호출 override 된게 먼저 우선
              crashWithDamage() // 각 하위 클래스마다 고유하게 재정의된 함수가 호출 override 된게 먼저 우선
              landingForEnd() // Flock
          }
      }
  ```
