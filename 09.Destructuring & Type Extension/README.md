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

- (_,b,_) = getData()
