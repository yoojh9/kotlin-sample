## 1. VO / DTO Objects & toString(), copy()

#### 1. structed data object

- 구조적으로 데이터를 담는 최소 단위 객체
- 주로 스키마와 연동됨
- 데이터의 전송이나 비교 및 각종 스키마 단위 연산 등을 위해 사용됨
  - contructor, getters/setters, toString(), equals(), hashCode(), copy()

#### 2. ERD

- Entity Relationship Diagram
- 개체 관계 모델링으로 그린 다이어그램

#### 3. VO

- value object

#### 4. DTO

- Data Transfer Object
- 데이터 전송 오브젝트

#### 5. toString()

- 객체의 내용을 문자열로 표현함

#### 6. copy()

- 객체를 복제(clone)함
- 일부 필드를 변경하여 복제도 가능

## 2. Data class & Tuples

#### 1. tuples

- Pair(1, "sea"), Triple("ABC",3.14,'Z'),...

#### 2. data class

- pure DTO

```
 data class Human(val name: String, var age: Int = 20)
```

- at least one val or var property in primary constructor
- cannt be abstract, open, sealed or inner
- equals() & hashCode()
- toString() => "Human(name=Gildong, age=33)"
- componentN() functions => destructuring & tuple
- copy()

## 3. Equality & Identity

#### 1. Equality

- equals()에 (재)정의된 대로 동등성 판단, 보통 내용이 같으면 true
- structural equality
- a == b, a != b
- a?.equals(b) ?: (b===null)

#### 2. Identity

- 동일, 주소까지도 같음
- Referential equality
- a === b, a !== b

#### 3. data class DTO, not the VO

- 코틀린의 data 클래스 객체들은 DTO라서 내용만 같다고 꼭 같은 객체로 보지는 않음
- data class는 Equality 뿐만 아니라 Identity도 만족해야함
