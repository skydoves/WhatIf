![whatif](https://user-images.githubusercontent.com/24237865/127761307-b19f130f-dce6-4b14-a590-42361a8567e5.png)<br>


<p align="center">
☔ Fluent expressions of Kotlin for handling single if-else statements, nullable, collections, and boolean.
</p>
<br>

<p align="center">
  <a href="https://devlibrary.withgoogle.com/products/android/repos/skydoves-whatif"><img alt="Google" src="https://skydoves.github.io/badges/google-devlib.svg"/></a><br>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=15"><img alt="API" src="https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/skydoves/WhatIf/actions"><img alt="Build Status" src="https://github.com/skydoves/WhatIf/workflows/Android%20CI/badge.svg"/></a>
  <a href="https://androidweekly.net/issues/issue-406"><img alt="Android Weekly" src="https://skydoves.github.io/badges/android-weekly.svg"/></a>
  <a href="https://github.com/skydoves"><img alt="Profile" src="https://skydoves.github.io/badges/skydoves.svg"/></a>
  <a href="https://skydoves.github.io/libraries/whatif/javadoc/whatif/com.skydoves.whatif/index.html"><img alt="Javadoc" src="https://skydoves.github.io/badges/javadoc-whatif.svg"/></a>
</p>

## Download
[![Maven Central](https://img.shields.io/maven-central/v/com.github.skydoves/whatif.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.skydoves%22%20AND%20a:%22whatif%22)
[![Jitpack](https://jitpack.io/v/skydoves/whatif.svg)](https://jitpack.io/#skydoves/whatif)

☔ WhatIf has been downloaded in more than __70k__ Kotlin and Android projects all over the world! <br><br>
![downloads](https://user-images.githubusercontent.com/24237865/101273131-2187a980-37d6-11eb-9000-e1cd10f87b0d.png)

### Gradle
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
    repositories {
        mavenCentral()
    }
}
```
And add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
    implementation "com.github.skydoves:whatif:1.1.1"
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

### WhatIfNotNullAs
`WhatIfNotNullAs` is an expression for invoking `whatIf` lambda when the target object is not null and the target can be cast by the desired type, the receiver will get a casted type.

```diff
- (serializable as? Poster?)?.let { poster ->
- 
- }

+ parcelable.whatIfNotNullAs<Poster> { poster ->
+  log(poster.name)
+ }
```
And we can also handle the exception case (target is null or can't cast by the desired type) using `whatIfNot`.

```diff
- (serializable as? Poster?)?.let { poster ->
-  log(poster.name)
- } ?: let {
-  // do something
- }

+ serializable.whatIfNotNullAs<Poster>(
+  whatIf = { poster -> log(poster.name) },
+  whatIfNot = { 
+    // do something
+  })
```

### WhatIfNotNullOrEmpty
An expression for invoking `whatIf` lambda when the __string__, __collections__ and __array type__ is not null and not empty.<br>
If the collections or array type target is null or empty, `whatIfNot` will be invoked instead of the `whatIf`.

```kotlin
val nullableString: String? = "NotNullOrEmpty"
nullableString.whatIfNotNullOrEmpty { 
  log("$it is not null and not empty")
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
We can use some expressions for List, Map, and Set.
- whatIfNotNullOrEmpty: An expression for invoking `whatIf` when the `List` is not null and not empty.
- addWhatIfNotNull: An expression for adding an element and invoking `whatIf` when the element is not null.
- addAllWhatIfNotNull: An expression for adding an element and invoking `whatIf` when the element is not null.
- removeWhatIfNotNull: An expression for removing an element and invoking `whatIf` when the element is not null.
- removeAllWhatIfNotNull: An expression for removing a collection of element and invoking `whatIf` when the element is not null.


### WhatIfMap
The basic concept is the same as `whatIf`. An expression for invoking `whatIf` when the target object is not null. It is useful when the type of the receiver and the result should be different.<br>
```kotlin
val length: Int = nullableString.whatIfMap(
  whatIf = { it.length },
  whatIfNot = {
    log("$it, nullableString is null.")
    -1
  }
)
```
We can use a default value instead of the `whatIfNot` and it can be omitted.
```kotlin
val length = nullableString.whatIfMap(
    default = -1
  ) { 
  log("$it, length can not over than 5.")
  5
}
```

### whatIfElse
An expression for invoking `whatIf` lambda when the target boolean is not null and false.
```kotlin
nullableBoolean.whatIfElse {
  log("nullableBoolean is not null and false")
}
```

### WhatIfAnd, WhatIfOr
An expression for invoking `whatIf` lambda when the target boolean is true and/or a predicate receiver is true.<br>
```kotlin
nullableBoolean.whatIfAnd(predicate) {
  log("nullableBoolean is true and the predicate is also true")
}

nullableBoolean.whatIfOr(predicate) {
  log("nullableBoolean is true or the predicate is true")
}
```

## WhatIf for Android Extension
We can use the whatIf extensions related to the Android project.<br>

[![Maven Central](https://img.shields.io/maven-central/v/com.github.skydoves/whatif-android.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.skydoves%22%20AND%20a:%22whatif-android%22)
### Gradle
Add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
    implementation "com.github.skydoves:whatif-android:version"
}
```

### WhatIf for Android Activity
### WhatIfHasExtras
An expression for invoking `whatIf` lambda when the Activity's intent extras is not null and not empty.
```kotlin
var foo: String? = null
this@MainActivity.whatIfHasExtras {
  foo = "${it.getString("foo")}"
}
```
And we can handle the null case.<br>
```kotlin
this@MainActivity.whatIfHasExtras(
   whatIf = { foo = "${it.getString("foo")}" },
   whatIfNot = { log("intent extras is null or empty.") }
)
```
We can null-check and typecast simultaneously when we getting intent extra data.
```kotlin
whatIfHasSerializableExtra<Poster>("poster") { poster ->
 ...
}
whatIfHasParcelableExtra<Poster>("poster") { poster ->
 ...
}
```

### WhatIf for Android fragment
#### whatIfNotNullContext
An expression for invoking `whatIf` lambda  when the Context is not null.
```kotlin
class WhatIfFragment : Fragment() {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    whatIfNotNullContext {
      Toast.makeText(it, "context is not null!", Toast.LENGTH_SHORT).show()
    }
  }
}
```

#### whatIfNotNullArguments
An expression for invoking `whatIf` when the `Fragment.getArguments` is not null.
```kotlin
whatIfNotNullArguments {
  it.getString("name").whatIfNotNull {
    log("my name is $it")
  }
}
```

#### whatIfNotNullActivity
An expression for invoking `whatIf` lambda when the Activity is not null.
```kotlin
whatIfNotNullActivity { activity ->
  activity.supportFragmentManager.addOnBackStackChangedListener {
    // .. //
  }
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
