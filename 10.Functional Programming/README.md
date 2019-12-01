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
  - { param: type, param: type, ... -> code block}
