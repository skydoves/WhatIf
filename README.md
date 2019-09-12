# WhatIf

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=15"><img alt="API" src="https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://travis-ci.org/skydoves/WhatIf"><img alt="BuildStatus" src="https://travis-ci.org/skydoves/WhatIf.svg?branch=master"/></a>
  <a href="https://skydoves.github.io/libraries/whatif/javadoc/whatif/com.skydoves.whatif/index.html"><img alt="Javadoc" src="https://img.shields.io/badge/Javadoc-WhatIf-yellow"/></a>
</p>

<p align="center">
☔ WhatIf is kotlin extensions for expressing a single if-else statement, nullable and boolean.
</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/24237865/64483102-1727da00-d238-11e9-9f69-7037223947d1.png" width="844" height="341"/>
</p>

## Download
[![Download](https://api.bintray.com/packages/devmagician/maven/whatif/images/download.svg) ](https://bintray.com/devmagician/maven/whatif/_latestVersion)
[![Jitpack](https://jitpack.io/v/skydoves/whatif.svg)](https://jitpack.io/#skydoves/whatif)
### Gradle
Add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
    implementation "com.github.skydoves:whatif:1.0.3"
}
```

## Usage
### WhatIf
`WhatIf` is an expression for invoking `whatIf` lambda when the given boolean is true and not-null.
```kotlin
val nullableBoolean: Boolean? = true
whatIf(nullableBoolean) {
  log("not-null and true : $nullableBoolean")
}
```
Here is an extension for nullable booleans.
```kotlin
nullableBoolean.whatIf {
  log("not-null and true : $nullableBoolean")
}
```
### WhatIfNot
The `whatIf` expression is basically composed with `given`, `whatIf`, `whatIfNot`.<br>
If the target is null or false, `whatIfNot` will be invoked instead of the `whatIf`.<br>
If we do not need to handle `whatIfNot` case, it can be omitted.
```kotlin
whatIf(
  given = nullableBoolean,
  whatIf = { log("not-null and true : $nullableBoolean") },
  whatIfNot = { log("null or false : $nullableBoolean") }
)
```
Or here is an extension for nullable boolean.
```kotlin
nullableBoolean.whatIf(
  whatIf = { log("not-null and true : $nullableBoolean") },
  whatIfNot = { log("not-null or false : $nullableBoolean") }
)
```

### WhatIf in the builder pattern
Sometimes we should set builder differently to depend on options.<br>
`WhatIf` is useful when using a chaining function like a builder pattern.<br>
It can be applied to any builder patterns like `AlertDialog.Builder` or anything.
```kotlin
val balloon = Balloon.Builder(baseContext)
  .setArrowSize(10)
  .setArrowVisible(true)
  .whatIf(nullableBoolean) { setTextColor(Color.YELLOW) }
  .whatIf(nullableBoolean, { setText("Hello, whatIf") }, { setText("Good-Bye whatIf") })
  .setWidthRatio(1.0f)
  .build()
```

### WhatIfNotNull
`WhatIfNotNull` is an expression for invoking `whatIf` lambda when the target object is not null.
```kotlin
val nullableObject: Person? = Person()
nullableObject.whatIfNotNull {
  log("$it is not null")
}
```
And we can handle the null case.<br>
If the target is null, `whatIfNot` will be invoked instead of the `whatIf`.
```kotlin
nullableObject.whatIfNotNull(
  whatIf = { log("$it is not null.") },
  whatIfNot = { log("$it is null.") }
)
```

### WhatIfNotNullOrEmpty
An expression for invoking `whatIf` lambda when the __string__, __collections__ and __array type__ is not null and not empty.<br>
If the collections or array type target is null or empty, `whatIfNot` will be invoked instead of the `whatIf`.

```kotlin
val nullableString: String? = "NotNullOrEmpty"
nullableString.whatIfNotNullOrEmpty { 
  log("$it is not null or empty")
}
```
Here is an example for collections.
```kotlin
nullableList.whatIfNotNullOrEmpty {
  log("list $it is not null and not empty")
}
```
And we can handle the null or empty case.
```kotlin
nullableList.whatIfNotNullOrEmpty(
  whatIf = { log("list $it is not null and not empty") },
  whatIfNot = { log("list is null or empty") }
)
```
Here is the same example for the array.
```kotlin
nullableArray.whatIfNotNullOrEmpty {
  log("$it is not null and not empty")
}
```
#### Array
Array, ByteArray, ShortArray, IntArray, LongArray, FloatArray, DoubleArray, BooleanArray, CharArray

#### Collections 
List, Map, Set

### WhatIfLet
The basic concept is the same as `whatIf` but it is useful when the receiver and the result should be different.<br>
```kotlin
val length = nullableString?.whatIfLet(
  given = nullableString.length < 5,
  whatIf = { it.length },
  whatIfNot = {
    log("$it, length can not over than 5.")
    5
  }
)
```
We can use default value instead of the `whatIfNot` and can be omitted the `whatIfNot`.
```kotlin
val length = nullableString?.whatIfLet(
  nullableString.length < 5,
  default = nullableString.length) { 
  log("$it, length can not over than 5.")
  5
}
```

## Find this library useful? :heart:
Support it by joining __[stargazers](https://github.com/skydoves/whatif/stargazers)__ for this repository. :star: <br>
And __[follow](https://github.com/skydoves)__ me for my next creations! 🤩

# License
```xml
Copyright 2019 skydoves (Jaewoong Eum)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
