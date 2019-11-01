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