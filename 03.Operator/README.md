# 3. OPERATORS
## 1. Operator
#### 1. Operator
 - 연산자, Kotlin 연산자는 함수이며, operator-overloading이 가능함 

#### 2. Operator Precedence
 - 연산자는 정해진 우선순위가 있음
 - https://kotlinlang.org/docs/reference/grammar.html#precedence

#### 3. Unary
 - 단항 연산자 +2, -1, !false

#### 4. Arithmetic
 - 산술/복합/증감 연산자 +-* / %(mod,rem), += -= *= /= ++ ()

#### 5. Logical/Relational
 - 논리/관계(조건식) > >= < <= == != && ||

#### 6. contains
 - 리스트, 범위 등에 포함 관계 in !in

#### 7. Bitwise
 - 비트조작 shl shr ushr and or xor inv


## 2. Conditions & If branches
#### 1. condition
 - 조건식, true/false(Boolean)로 판정되는 논리

#### 2. branch
 - 명령 실행의 분기 흐름

#### 3. if
 - 조건부 분기문 구조, 주어진 조건이 만족하면 실행, 아니면 통과함(bypass)
 - if(true) ...무조건 실행
 - if(false) ...무조건 통과(씰행 안함)
 - if(조건) { A... } else B... 무조건 이분 분기(조건에 따라 A나 B중 하나는 반드시 실행)

#### 4. Expression If
 - 식으로써의 if문 (조건 분기 실행에 대한 결과로 값을 되돌려 줌)


## 3. If/else if multi-branches
#### 1. Multiple Branches
 - 조건식이 2개 이상 존재하는 분기문

#### 2. if else if ... else
 - 조건식을 갖춘 if가 2개 이상 있으며 같이 묶인 다중 분기문
 - 가장 위에 처음 만나는 조건식부터 판별하며, 아래 방향으로 순차적으로 조건식의 결과가 true로 판정되는 분기를 바로 실행함
 - 현재 조건식은 선행 조건식들의 모든 결과가 false로 판정된 조건 범위를 이미 갖춘 상태로 해당 조건식의 판정에 들어감
 - 모든 조건식들이 true로 만족하지 못하면 최종적으로 else 블록 분기가 무조건 실행됨.
 
