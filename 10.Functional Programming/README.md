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
