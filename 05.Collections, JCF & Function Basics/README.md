## 1. Collections - Set

## 1. Set

```
 interface Set<out E> : Collection<E>(source)
```

- 일반적으로 Set은 read-only
- MutableSet은 추가하거나 삭제 가능하다.

#### 1. Data Structure

- 공통 데이터 구조, Set, List, Hash; kotlin.collections.\* (JVM JCF)

#### 2. Set

- 데이터 구조; 중복되지 않는 데이터들을 단순히 묶은 집합
  - unordered: 일반적으로 순서가 없고 (요소 추가 시 순서가 보존 안됨)
  - no duplicated: 포함되는 요소(element)의 중복을 허용하지 않음

#### 3. interface Set

- Set<out E>, setOf(), isEmpty(), size, in, contains()

#### 4. Mutability

- MutableSet<E>, mutableSetOf(), add(), addAll(), remove(), clear()..

#### 5. Iteration

- 요소들을 루프로 탐색할 수 있음
- iterator(), hasNext(), next() => "xyz".toSet()

#### 6. operations

- containsAll(), intersect, union, subtract

## 2. List

#### 1. List

- 리스트, 데이터 구조, Enumeration in countable, JVM Collection Framework
  - ordered: 일반적으로 요소의 순서가 있으며(요소 추가 시 순서가 보존) => index, 정렬의 묹
  - duplicated: 요소들간의 중복을 허용함 => distinct().sorted()
  - 응용구조: Stack, Queue, LinkedList

#### 2. Array & List

- 배열도 일종의 리스트에 속함

#### 3. List<out E> vs MutableList<E>

- listOf(), mutableListOf()
  - get(), [], size, indexOf(), lastIndexOf(), subList(), toMutableList()
  - add(), add(i,E), set(), remove(), clear(), withIndex()

#### 4. sorting

- sorted(), sortedBy{}, sortedByDescending{},...

## 3. Map

#### 1. Map, Dictionary, Hash

- 데이터 구별을 위한 키와 그에 대응되는 값으로 표현되는 공통 데이터 구조
  - key(이름)/value(값)의 쌍(Pair) 구조로 되어있는 일종의 집합
  - 키는 중복을 허용하지 않고, 주로 문자열이 사용되곤 함. 값은 중복과 관계 없음
  - ex) 전화번호부, 주소록, 지도, 사전, 설정파일(x=y), 암호화, 데이터베이스 등

#### 2. Entry

- key와 value를 한 쌍으로 묶은 데이터 구조, 맵의 데이터 단위, 키 기준의 iteration 등에 적용함
- Pair(K,V), K to V => JVM:java.util.Map.Entry<K,V>

#### 3. Map

- mapOf(...), size, isEmpty(), containsKey(), ...keys(Set), values(C)
  - get()[] => null, getValue() => NoSuchElementException

#### 4. MutableMap

- mutableMapOf(...), put(), remove(), clear(),...

## 4. JVM Collections & CRUD

#### 1. Java Collection Framework 구현체 클래스들

- JVM 구현체를 그대로 사용, 성능, 편의, CRUD가 적용
- ex) publc typealias ArrayList<E> = java.util.ArrayList<E>

#### 2. kotlin.collections.HashSet

- HashSet<E> = hashSetOf()

#### 3. kotlin.collections.ArrayList

- ArrayList<E> = arrayListOf()

#### 4. kotlin.collections.HashMap

- HashMap<K,V> = hashMapOf()

#### 5. CRUD operations

- Creation, Read(Retrieval), Update, Delete(Destroy)
- 데이터를 조작할 수 있는 최소 연산, 자료구조, DB SQL DML, Web HTTP methods

## 4. Function: Overloading, Default, Named, Single Expression Body

#### 1. Function Basics

- 공통, 반복적으로 사용되는 명령/문장들을 묶어서 하나의 기능으로 동작
  - input(데이터) => 블랙박스(함수) => output(결과)
  - Function Definition(함수 정의) & Function Call(함수 호출)

#### 2. Single expression body Function

- 단일 식을 결과로 리턴하는 함수 =로 축약 표현 가능

#### 3. Default Argument

- 기본인자
- 함수의 파라미터의 기본값을 =로 각각 지정함

#### 4. Named Parameter

- 함수 호출 시 원하는 파라미터들만의 이름을 명시하여 인자값을 넘겨줌

#### 5. Function Overloading

- 다형성의 한 예
- 코틀린에서는 기본인자, named param과 같이 쓰임
  - 일반적으로 함수 호출 시 호출 인자의 타입, 개수 등에 따라 같은 이름으로 미리 정의된 여러 바디의 함수들을 동적으로 선택하여 호출하는 방식을 의미함

```
fun 함수이름(param이름: type, ...): Unit or 생략 or 타입x
{
    문장블록, 함수바디
    return X
}
```
