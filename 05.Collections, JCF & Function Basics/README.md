## 1. Collections - Set
## 1. Set
```
 interface Set<out E> : Collection<E>(source)
```
 - 일반적으로 Set은 read-only
 - MutableSet은 추가하거나 삭제 가능하다.

#### 1. Data Structure
 - 공통 데이터 구조, Set, List, Hash; kotlin.collections.* (JVM JCF)

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
 
