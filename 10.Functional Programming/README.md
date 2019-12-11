## 1. Function Type, Anonymous Funtion & Lambda

#### 1. 대략적인 주류 프로그래밍 패러다임 변천사

- 절차형 => 객체지향 => 객체지향 + 관점지향 => 객체지향 + 함수형 => 객체지향 + 함수 / 반응형

#### 2. First class citizen

- 1급 시민, number, object, function
- Kotlin은 JVM 기반으로 간결하면서도 강력한 OOP + FP(Funtional Programming) 를 지원함
- 1급 함수 => 함수를 하나의 타입(Type)/자료형으로써 표현이 가능하다는 것
  - 변수(variable)에 저장할 수 있음
  - 인자(parameter)로 전달할 수 있음
  - 반환값(return value)으로 전달될 수 있음
  - 런타임(runtime)시점에 생성이 가능함
  - 익명으로/임의로(anonymous)생성이 가능함

#### 3. Function Type

- 함수 타입 (types of parameters) -> return type
  - () -> Unit
  - (Int) -> Double
  - (String, List<Int>) -> String
  - val test: (String) -> Unit = ...

#### 4. HOF: Higher Order Functions(고차함수)

- 함수타입으로 인자를 받거나 함수타입으로 리턴값을 되돌려주는 함수
- 즉 함수를 데이터처럼 소비하거나 함수를 생산할 수 있음
- fun testHOF(input: (List<Char>) -> String) : (String, Int) -> Unit = ...

#### 5. Anonumous Function

- 익명/임의 함수, 함수의 이름이 없음
  - 식(expression)처럼 변수에 담을 수 있음(defining a function as an object)
  - fun(param: type, ...){...}
- Lambda Expression (Block): 람다 식(블록)
  )

  - { argument(s) -> code block as the function body}
  - { param: type, param: type, ... -> code}

## 2. Function Reference, Import as & Single Lambda Argument, It

#### 1. Single Lambda Argument, it:

- only one parameter for lambda expression(문맥에서 유추/추론)
- 람다 파라미터 정의를 생략하고 그냥 it 키워드로 인자를 사용
- 함수형으로 유명한 LINQ style로 표현, readability 향상
  ```
     listOf("aaa","bbbb","ccccc","dddddd")
         .filter{it.length >= 5} // str: String -> str..
         .map{it.toUpperCase()}  // s -> s...
  ```

#### 2. Function Reference

- 일종의 reflection, 함수 자체의 이름으로 함수 바디를 객체로써 참조함
  ```
  fun myFunName(p: Type): Boolean = ...
  myList.filter{myFunName(it)}
  myList.filter(::myFunName) // 함수 body 자체를 파라미터로 참조
  ```

#### 3. Method Reference

- 클래스 수준의 멤버 함수일 경우에는
- ClassName::FunctionName; String::isNotEmpty

#### 4. import as

- for name collision, locally rename that as another one
  ```
  import my.Name // Name is accessible
  import your.Name as yName // yName is accessible for other Name type
  ```

## 3. SAM, 익명객체식(@FunctionalInterface, anonymous obj)

#### 1. Java SAM Functional Interface & Anonymous Object Expression

- object expression of anonyous class
- Java Single Abstract Method Function Interface

#### 2. anonymous object expression: 오브젝트 식 <=> 오브젝트 선언(declaration)

- 클래스, 인터페이스 등을 상속받거나 받지 않더라도 익명의 (내부) 클래스의 객체를 생성함

  ```
  val o1 = obejct {
      val a: Int = 0
      var b = "string"
  }

  val o2: C = object: Class(1).interface {
      override val propClass = "xyz"
      override fun getInterface() = ...
  }
  ```

#### 3. Java SAM FI(Functional Interface)

- 인터페이스를 통해 함수형 람다식을 처리할 수 있음
- @FunctionalInterface 어노테이션을 적용함
- 오직 하나의 추상 메소드(SAM: Single Abtract Method)만 가진 인터페이스

      ```
      @FunctionalInterface
      public interface Comparator<T>
      ```

- 코틀린에서는 Java SAM FI는 익명 객체(object exp.)
  나 람다식(lambda)으로 축약 표현이 가능함

      ```
      val obj1 = object: JavaSAMFI{...}
      val obj2 = JavaSAMFI { it?.xxx }
      ```

- java.lang 패키지: interface Runnable {void run(); }
- java.util 패키지 : interface Comparator<T> { boolean compare(T x, T y); } - 객체 비교 comparison

#### 4. java.util.function 패키지

- T get() - 함수 생산 Supply, Produce
- void accept(T t) - 함수 소비 Consume
- R apply(T t) - 함수 적용 T => R 변환(Function<T,R>) Apply
- boolean test(T t) - 조건식 함수 콜백, Predicate

## 4. Currying & Partial Appication

#### 1. Currying

- 커링, 여러개의 인자를 가진 함수를 호출 할 경우, 한 개의 인자를 받는 연속적인 호출들을 통해서 누락된 모든 파라미터들을 처리하는 함수형 방식
  - f:(X,Y,Z) -> N curried into curry(f):X -> ( Y -> ( Z -> N ))
    - f(1,2) === g(1)(2)

#### 2. Partial Application

- 커링과 비슷하지만 인자를 바인딩하여 재사용 하고자 하는 용도의 함수형 방식
  - 인자의 일부분이 curry된 함수를 통해 독립적인 '부분기능'들을 만들어 놓고 조립 하듯이 사용할 수 있음
  - f:(X,Y,Z) -> N partially applied to (with X binding)

## 5. Closure & Scope Functions

#### 1. Closure, Functors & FP Stdlib Functions

- closure; let()
- functor; map()
- stdlib functions: run(), with(), apply(), also()

- Closures: 클로져; variables(or context) d`eclared in the outer scope, when the lambda expression or anonymous function defined
  - Unlike Java, variable captured in the closure can be modified; not final
- Functor: 펑터; something can be mapped over, mappable object; iteration over with map(); Array, List
  - Identity: z.map(x => x) is equivalent to z
  - Composition: z.map(x => f(g(x))) is equivalent to z.map(g).map(f)

| 함수명      | 설명      | 타입                                                                            | T 전달방식  | 리턴             |
| ----------- | --------- | ------------------------------------------------------------------------------- | ----------- | ---------------- |
| **let()**   | extension | T 타입 객체 자신을 it으로 블록에 던져줌                                         | it          | last block value |
| **map()**   | extension | functor를 위한 iteration 맵핑 T => R 적용                                       | mappable it | mapped List<R>   |
| **with()**  | normal    | this 문맥 하에 T 객체의 멤버 사용(설정)                                         | this        | last block value |
| **apply()** | extension | this 문맥 하에 T 객체의 멤버 사용(설정) 후 T를 되돌려 줌 <br> builder 패턴 적용 | this        | T                |
| **run()**   | extension | let() + with()의 조합과 흡사함                                                  | this        | last block value |
| **also()**  | extension | T 타입 객체 자신을 it으로 블록에 던져주고 다시 T를 되돌려줌                     | it          | T                |
