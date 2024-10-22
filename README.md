![whatif](https://user-images.githubusercontent.com/24237865/127761307-b19f130f-dce6-4b14-a590-42361a8567e5.png)<br>


<p align="center">
☔ Fluent Kotlin expressions for handling single if-else statements, nullable, collections, and boolean. This library supports Kotlin Multiplatform.
</p>
<br>

<p align="center">
  <a href="https://devlibrary.withgoogle.com/products/android/repos/skydoves-whatif"><img alt="Google" src="https://skydoves.github.io/badges/google-devlib.svg"/></a><br>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=15"><img alt="API" src="https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/skydoves/WhatIf/actions"><img alt="Build Status" src="https://github.com/skydoves/WhatIf/workflows/Android%20CI/badge.svg"/></a>
  <a href="https://androidweekly.net/issues/issue-406"><img alt="Android Weekly" src="https://skydoves.github.io/badges/android-weekly.svg"/></a>
  <a href="https://github.com/skydoves"><img alt="Profile" src="https://skydoves.github.io/badges/skydoves.svg"/></a>
  <a href="https://skydoves.github.io/libraries/whatif/html/index.html"><img alt="Javadoc" src="https://skydoves.github.io/badges/dokka-whatif.svg"/></a>
</p>

## Download
[![Maven Central](https://img.shields.io/maven-central/v/com.github.skydoves/whatif.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.skydoves%22%20AND%20a:%22whatif%22)

☔ WhatIf has been downloaded in more than __300k__ Kotlin and Android projects all over the world! <br><br>
![downloads](https://user-images.githubusercontent.com/24237865/101273131-2187a980-37d6-11eb-9000-e1cd10f87b0d.png)

### Gradle
Add the dependency below to your module's `build.gradle` file:

```gradle
dependencies {
    implementation("com.github.skydoves:whatif:1.2.1")
}
```

For Kotlin Multiplatform, add the dependency below to your module's `build.gradle.kts` file:

```kotlin
sourceSets {
    val commonMain by getting {
        dependencies {
            implementation("com.github.skydoves:whatif:1.2.1")
        }
    }
}
```

## Usage

WhatIf fully supports Kotlin Multiplatform, making it versatile for use in pure Kotlin modules as well as other platforms. You can leverage it in various use cases, including Jetpack Compose, where it helps streamline conditional logic. For instance, you can integrate `WhatIf` in Jetpack Compose to handle conditional rendering, as shown in the example below. This flexibility allows developers to maintain clean, readable code across different Kotlin Multiplatform projects.

```kotlin
Box(
  modifier = Modifier
      .align(Alignment.Center)
      .clickable { isBlueColor = !isBlueColor }
      .whatIfMap(isBlueColor, { it.background(Color.Blue) }, { it.background(Color.Cyan) })
      .whatIfMap(isBlueColor, { it.size(120.dp) }, { it.size(240.dp) }),
)
```

![preview](https://github.com/user-attachments/assets/99d73a48-2e8e-4e99-b553-2c7e57382bfd)

### WhatIf

`WhatIf` is a Kotlin expression that triggers a lambda expression (`whatIf` block) when the provided boolean condition is true and the object is non-null. It's a concise way to handle conditional logic without needing verbose if-else statements, enabling cleaner, more readable code for specific actions when conditions are met.

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

The `whatIf` expression consists of three main parts: `given`, `whatIf`, and `whatIfNot`. If the condition is true and the target is non-null, the `whatIf` lambda is executed. However, if the condition is false or the target is null, the `whatIfNot` lambda will be invoked instead. The `whatIfNot` block is optional, so if there's no need to handle the false/null case, it can simply be omitted, allowing for more concise code when necessary.

```kotlin
whatIf(
  given = nullableBoolean,
  whatIf = { log("not-null and true : $nullableBoolean") },
  whatIfNot = { log("null or false : $nullableBoolean") }
)
```

Here's an extension function designed specifically for nullable booleans.

```kotlin
nullableBoolean.whatIf(
  whatIf = { log("not-null and true : $nullableBoolean") },
  whatIfNot = { log("not-null or false : $nullableBoolean") }
)
```

### WhatIf in the builder pattern

Sometimes, you need to configure a builder differently depending on the available options. This is where `WhatIf` proves useful, especially when using a chaining function like in builder patterns. It can be seamlessly applied to various builder patterns, such as `AlertDialog.Builder` or any other similar construct, allowing conditional logic to be injected cleanly and fluently based on the provided conditions, without breaking the flow of method chaining.

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

`WhatIfNotNull` is a Kotlin expression that triggers the `whatIf` lambda when the target object is not null. This function simplifies handling nullable objects, allowing you to perform actions only when the object is valid, making your code cleaner by avoiding manual null checks. It's particularly useful for eliminating boilerplate when working with nullable types in Kotlin.

```kotlin
val nullableObject: Person? = Person()
nullableObject.whatIfNotNull {
  log("$it is not null")
}
```

You can also handle cases where the target object is null. In such scenarios, instead of executing the `whatIf` lambda, the `whatIfNot` lambda will be triggered. This ensures that null cases are properly managed, providing an alternative action when the object is null, making your code more robust and adaptable to nullable conditions.

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

You can also handle the exception case (target is null or can't cast by the desired type) using `whatIfNot`.

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

An expression for invoking the `whatIf` lambda when the target, such as a **string**, **collection**, or **array**, is neither null nor empty. If the target is null or empty, the `whatIfNot` lambda will be executed instead. This approach ensures that you can easily handle non-empty, valid collections or arrays, while providing an alternative behavior for null or empty cases, streamlining conditional logic when dealing with these data types.

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

You can also handle the null or empty case.

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

You can use some expressions for List, Map, and Set.

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

You can use a default value instead of the `whatIfNot` and it can be omitted.

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

You can use the whatIf extensions related to the Android project.<br>

[![Maven Central](https://img.shields.io/maven-central/v/com.github.skydoves/whatif-android-ext.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.skydoves%22%20AND%20a:%22whatif-android%22)

### Gradle

Add the dependency below to your **module**'s `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.skydoves:whatif-android-ext:version"
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
You can also handle the null case.<br>
```kotlin
this@MainActivity.whatIfHasExtras(
   whatIf = { foo = "${it.getString("foo")}" },
   whatIfNot = { log("intent extras is null or empty.") }
)
```
You can null-check and typecast simultaneously when you getting intent extra data.
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

#### whatIfFindParentInterface
 An expression for invoking `whatIf` lambe when the `Fragment` has an `T` interface as a parent. Let's assume we have a `MainActivity` that implements `OnClickCallback` interface,

 ```kotlin
class MainActivity : AppCompatActivity(), OnClickCallback {
  ...
}
```

You can get the parent Activity's `OnClickCallback` interface on Fragment as following with the `whatIfFindParentInterface`:
```kotlin
class MainFragment: Fragment() {

 override fun onCreateView(
  inflater: LayoutInflater,
  container: ViewGroup?,
  savedInstanceState: Bundle?
 ): View? {
  return super.onCreateView(inflater, container, savedInstanceState)
  
  whatIfFindParentInterface<OnClickCallback> { 
   it.onClickedButtonFromFragment()
  }
 }
}
```

## Find this library useful? :heart:
Support it by joining **__[stargazers](https://github.com/skydoves/whatif/stargazers)__** for this repository. :star: <br>
Also, **__[follow](https://github.com/skydoves)__** me for my next creations! 🤩

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
