# 2. DataType, Variable, Null

## 1. Any, Type Check & Cast

#### 1. Any
 - kotlin.Any 모든 코틀린 클래스의 최상의 타입 클래스 -> java Object
 
#### 2. type check
 - 런타임에서 type을 검사, is, !is 연산자(java instanceOf)

#### 3. type casting
 - 형을 변환 하는 것
 - as 캐스트 연산자는 타입 변환 예외 exception을 발생시킬 가능성이 있다,
 - 타입을 체크해서 그 값이 확실하게 바뀔 수 있을 때만 as를 쓰고 보통 to를 사용하여 다른 자료형으로 명시적으로 변환하는 것을 권장한다.

#### 4. smart type cast
 - 문맥적으로 타입을 추론하여 자동 변환
 - 연산 결과 자동 형변환, is 타입 체크 판단 문맥

#### 5. explicit conversions
 - 명시적 형변환 (더 넓은 범위로 형변환)
 - toByte(), toInt(), toShort(), toLong(), toFloat(), toDouble()
 - (형 변환은 아닌) toChar(), toString()


## 2. Smart & Safe Cast

#### 1. is type check & smart cast
 - is 타입 체크 이후 판단에 따른 context에서의 타입 자동 변환 사용

#### 2. unsafe cast
 - as 연산자를 통한 캐스트

#### 3. exception
 - ClassCastException 예외 발생

#### 4. safe cast
 - as? 타입 캐스팅 할 수 없어도 예외를 발생시키지 않고, null을 돌려주는 안전한 nullable type cast 연산자


