## 1. LATEINIT & BY LAZY

#### 1. lateinit

- 늦은 초기화
- var(mutable) 변수 초기화를 의도적으로 지연시키는 방법
- nullable에서도 null로 선언과 동시에 초기화 하지 않고,init{}에서 초기화 하지 않아도 됨
- 해당 프로퍼티를 사용하고자 할 때 초기화를 진행하고 바로 사용할 수 있음
- 초기화 안하고 그냥 참조하면, 예외(UninitializedPropertyAccessException)를 발생시킴

```
class MyOldCar {
    var color: Int = 0xFF0000
    var garage: String? = null
    lateinit var name: String // error 없음
}
```

#### 2. by lazy

- 게으른 초기화 (프로퍼티 위임 초기화)
- val(immutable) 상수 property에 지정
- property 초기화를 위한 위임(delegated) 블록을 지정하여 맨 처음 참조 시 단 한번의 초기화를 진행하는 방법
- 맨 처음 참조 시에 값을 얻게 되므로, 깔끔하게 null 처리가 전혀 불필요 함

```
class MyOldCar {
    var color: Int = 0xFF0000
    var garage: String? = null
    lateinit var name: String
    val type by lazy { // 바로 실행되지 않음
        "${color.toString(16) 색 SUV 중고차}
    }
}
```
