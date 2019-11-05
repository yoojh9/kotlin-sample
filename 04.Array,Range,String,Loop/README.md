# Array, Range, String, Loop

## 1. Arrays
#### 1. Array
 - 배열: 연소걱인 데이터의 나열 (컬렉션/리스트의 일종)

#### 2. size
 - 배열의 크기(요소의 개수) 
 - index: 고유순서번호; zero-base; 0 ~ size -1 까지의 각 요소를 접근

#### 3. Array Exception
 - ArrayIndexOutOfBoundsException 배열 범위 밖 인덱스 요소 접근 예외

#### 4. Array init
 - <T> 타입 파라미터(Generic), 함수 인자(람다식), 팩토리 함수를 통한 배열 요소 초기화
 - Array(n,{}), Array<T>(n,{}), arrayOf(), arrayOf<T>(), arrayOfNulls()
##### 5. Array Builder Classes
 - 배열 빌더 클래스
 - ByteArray, ShortArray, IntArray, LongArray, FloatArray, DoubleArray, BooleanArray, CharArray

#### 6. Array Build StdLib functions
 - 표준 라이브러리 함수
 - byteArrayOf(), shortArrayOf()), intArrayOf(), longArrayOf(), floatArrayOf(), doubleArrayOf(), booleanArrayOf(), charArrayOf()



## 2. For Loop & Index
#### 1. Array Builder Classes
 - 일반 Array 클래스와 구성이 같음. 편리성을 위해서 각 타입별로 만들어져 동일하게 동작하는 typed arrays

#### 2. index
 - 순서번호 [], lastIndex(size-1), first(), last()

#### 3. for(x in XYZ) loop
 - iteration on Array
 - 순차적으로 배열 요소 x에 할당하여 루프 실행을 반복<반복문>

#### 4. for(i in XYZ.indices) loop
 - Array.indices, s..e, 정수 범위, zero-based 기반

#### 5. for( (i,x) in XYZ.withIndex() ) loop
 - Array.withIndex()
 - 순서번호와 요소값이 동시에 한 단위로 묶여서 차례로 루프에 전달됨

#### 6. StdLib functions
 - sum(), average(), fill(), filter{}, find{}, joinToString()


## 3. Range
#### 1. Range
 - RangeTo(), start..end, 비교 가능한 값들이 나열된 유한 구간
 - 일반적으로 상하 경계값 포함

#### 2. IntRange, LongRange, CharRange
 - 타입별 범위 빌더 클래스

#### 3. first, last
 - 범위의 처음과 끝

#### 4. rangeTo(), until(), downTo()
 - 범위의 방향과 끝경계 포함문제
 - 100 until 200 => 100..200-1

#### 5. step()
 - 범위 안에서 건너뛰는 오프셋 양

#### 6. in, !in, contains()
 - 범위 내 포함/비포함 관계

#### 7. withIndex(), joinToString(), filter(), sum(), average()


## 4. While / Do ~ While Loop
#### 1. While loop
 - 조건식이 만족하는 동안 문장/블록을 계속 실행하는 반복문
 - while(expr){...}
 - while(true), while(false)

#### 2. do ~ while loop
 - 적어도 1번의 문장/블록 실행은 보장하는 while 반복문
 - do {...} while(expr)

#### 3. Prime Number
 - 소수 판단
 - 1과 자기 자신 이외는 약수가 없음


## 5. String & 2D Arrays
#### 1. String과 CharArray
 - 문자열 클래스, 문자 배열 빌더 클래스
 - toCharArray()를 통한 변환

#### 2. 2-Dimension Array
 - 2차원 배열; 배열의 배열, 즉 배열들을 요소로 가지는 배열
 - m행 n열 2차원 배열
    - Array(m){ oooArray(n) }     // m x n
    - Array(m){ oooArray(n, {init} )}   // 요소값 초기화, ***ArrayOf(...)
 - args, Array<String> : arrayOf<String>, Array<Array<Char>>
 - [][]: StrArray[m][n], 문자열 배열의 m번째 요소(문자열)의 n번째 문자 값


## 6. Loop Control : Break & Continue
#### 1. break
 - 현재 문맥에서 최근접 루프를 즉시 멈추고 빠져나옴
 - return: 함수 내에서 사용, 리턴값이 있으면 해당 타입으로 되돌리며 즉시 함수 종료 처리함

#### 2. continue
 - 현재 반복 루프 차례의 나머지 문장들을 실행하지 않고, 다음 반복 차례의 처음 문장으로 시랭을 옮김(새로운 인덱스, 요소 동반)

#### 3. Leap Year: 윤년 판단 알고리즘 (그레고리력)
 - 1. 서력 기원 연수가 4로 나누어 떨어지는 해는 윤년으로 한다 (1988, 1992, 1996, 2004, 2008, 2012..)
 - 2. 이 중에서 100으로 나누어 떨어지는 해는 평년으로 한다 (1900, 2100, 2200, 2300, 2500..)
 - 3. 그 중에 400으로 나누어 떨어지는 해는 윤년으로 둔다 (1600, 2000, 2400)
 - if (year is not divisible by 4 ) then (it is a common year)
   else if (year is not divisible by 100) then (it is a leap year)
   else if (year is not divisible by 400) then (it is a common year)
   else (it is a leap year)


## 7. Nested Loops & Labels

