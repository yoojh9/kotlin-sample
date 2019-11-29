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

## 5. Nested & Inner Classes

#### 1. nested class

- 외부 클래스 안쪽에 중첩된 클래스, 거의 패키지 수준

#### 2. inner class

- 중첩되었으나 하나의 내부 멤버로써 정의된 클래스
- 외부 클래스의 보이는 모든 자원(상속 계보 포함)들을 접근할 수 있음

  ```
  class OuterA {
      class NestedB {

      }
      inner class innerC {
          // OuterA 외부 클래스의 보이는 모든 자원(상속 계보 포함)들을 접근할 수 있음
      }
  }
  ```

#### 3. super@

- inner 내부 클래스에서는 super@OuterA.xyz 외부 클래스의 이름을 레이블로 하여 outer 클래스의 super의 프로퍼티와 메소드를 접근할 수 있음

## 6. Object Declaration & Companion Object

#### 1. Object declaration

- only one instance available; single object as itself
- singleton 패턴 구현
- 오브젝트를 정의하여 선언하면, 추후 처음 사용될 때 초기화(lazily)되며, 단독 인스턴스 객체처럼 동작함 => Singleton 패턴 구현(일종의 Director 객체임)

#### 2. Companion Object

- object declaration inside a class
- Java static 함수 정의에 대응(똑같지 않음)
- Factory 패턴 구현
  ```
   class Product(val id: Int){
       companion object Factory { // Factory 이름 생략 가능(companion으로만)
        fun makeOne(id: Int): Product = Product(id)
       }
   }
   val pr1 = Product.makeOne(1)
  ```

## 7. Sealed class & Type alias

#### 1. Sealed class

- extended enum, 열겨형의 확장된 형태
- 제한된 계층 하위 클래스만 가질 수 있도록 봉인해준다.
- 실드된 범위, 즉 제한된 클래스 계층 타입들(constrained type hierachy)의 객체로만 표현할 수 있도록 해줌
- when() 분기문에서 실드 클래스형 인자에 대해 모든 가능한 하위 타입들에 대한 분기 체크를 진행함(모든 하위 클래스 체크시, else 분기 불필요)
- sealed된 하위 클래스는 중첩된 내부 클래스 형태나 같은 파일의 패키지 수준에서만 정의될 수 있음(아니면 컴파일 에러가 발생됨)
- 상태를 가지는 object도 실드 타입의 하위 멤버가 될 수 있음

#### 2. typealias

- 타입 ABC를 타입 X라고 흔히 단축형의 다른 이름(별명 alias)을 지정하여 사용하는 것
- typealias Cal = abc.my.Calculator
