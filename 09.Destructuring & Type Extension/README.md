## 1. Destructuring

#### 1. Destucturing Declaration

- splite an object into a number of variables
  ```
  val (a,b) = C()
  val a = C().component1();
  val b = C().component2()
  componentN() methods..
  ```

#### 2. tuples and data class

- Data classes like Pair, Triple etc. hava componentN()

#### 3. indexedValue data class

- for with iterator
- for( (i,c) in collection)

#### 4. key/value pair

- map with iterator
- for( (k,v) in map)
- collection.map{(k,v)->z}

#### 5. mixed returning

- return DataClassType(result, extra1, extra2, ...)

#### 6. underscore '\_' as unused destructured variable

- (\_,b,\_) = getData()

## 2. Extenstion Functions

#### 1. Extenstion

- adding functions or properties to class without any inheritance, with dot notation callable
- 클래스로 대변되는 타입에 상속 관계 없이 함수나 프로퍼티를 추가함.

#### 2. Extension Function

    ```
    // 확장함수
    fun ReceiverType.FunctionName(params...){
        this // receiver object
    }

    // 이 함수를 마치 이 함수의 멤버 함수인 것처럼 .으로 호출할 수 있음
    ReceiverType().FunctionName(abc) // extension function call
    ```

- extension functions are dispatched statically, not virtual by receiber type(no inheritance relationship)
  ```
  fun Byte.toUnsignedInt() = toInt() and 0xFF
  fun charRange.toS(): String = this.toList().joinToString("")
  ```

## 3. Extension Properties

#### 1. Extension Properties

- not actually define any member property into class (클래스에 멤버 프로퍼티를 추가하는 건 아님)
- initializer (with status) are not allowed (no backing field)
  ```
  val<T> List<T>.lastIndex:Int get() = size - 1
  // Length
  val Double.mm get() = 1000 * this
  val Double.cm get() = 1000 * this
  val Double.m get() = 1 * this
  val Double.km get() = 0.001 * this
  val Double.inch get() = 39.370079 * this
  ```
