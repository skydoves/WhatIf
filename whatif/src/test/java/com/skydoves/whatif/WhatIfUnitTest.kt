/*
 * Designed and developed by 2019 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.whatif

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class WhatIfUnitTest {

  @Test
  fun whatIfSingleLambdaTest() {
    var nullableBoolean: Boolean? = true

    whatIf(nullableBoolean) {
      nullableBoolean = false
    }

    assertThat(nullableBoolean, `is`(false))
  }

  @Test
  fun whatIfNotSingleLambdaTest() {
    var nullableString: String? = null

    whatIf(
      given = nullableString.isNullOrEmpty(),
      whatIf = { nullableString = "whatIf" },
      whatIfNot = { nullableString = "whatIfNot" }
    )

    assertThat(nullableString, `is`("whatIf"))

    whatIf(
      given = nullableString.isNullOrEmpty(),
      whatIf = { nullableString = "whatIf" },
      whatIfNot = { nullableString = "whatIfNot" }
    )

    assertThat(nullableString, `is`("whatIfNot"))
  }

  @Test
  fun whatIfDoSingleLambdaTest() {
    var nullableString: String? = null

    whatIf(
      given = { nullableString.isNullOrEmpty() },
      whatIfDo = { nullableString = "isNullOrEmpty" }
    )

    assertThat(nullableString, `is`("isNullOrEmpty"))
  }

  @Test
  fun whatIfDoNotSingleLambdaTest() {
    var nullableString: String? = null

    whatIf(
      given = { nullableString.isNullOrEmpty() },
      whatIfDo = { nullableString = "isNullOrEmpty" }
    )

    assertThat(nullableString, `is`("isNullOrEmpty"))

    whatIf(
      given = { nullableString.isNullOrEmpty() },
      whatIfDo = { nullableString = "isNullOrEmpty" },
      whatIfNot = { nullableString = "isNotNullOrEmpty" }
    )

    assertThat(nullableString, `is`("isNotNullOrEmpty"))
  }

  @Test
  fun whatIfLetTest() {
    var nullableString: String? = null

    nullableString = nullableString.whatIfLet(
      given = !nullableString.isNullOrEmpty(),
      default = "default",
      whatIf = { "whatIf" }
    )

    assertThat(nullableString, `is`("default"))

    nullableString = nullableString.whatIfLet(
      given = !nullableString.isNullOrEmpty(),
      default = "default",
      whatIf = { "whatIf" }
    )

    assertThat(nullableString, `is`("whatIf"))
  }

  @Test
  fun whatIfNotNullTest() {
    var nullableString: String? = "notNull"

    nullableString.whatIfNotNull {
      nullableString = "whatIf $it"
    }

    assertThat(nullableString, `is`("whatIf notNull"))
  }

  @Test
  fun whatIfNotNullWhatIfNotTest() {
    var nullableString: String? = null

    nullableString.whatIfNotNull(
      whatIf = { nullableString = "whatIf" },
      whatIfNot = { nullableString = "whatIfNot" }
    )

    assertThat(nullableString, `is`("whatIfNot"))

    nullableString.whatIfNotNull(
      whatIf = { nullableString = it.length.toString() },
      whatIfNot = { nullableString = "whatIfNot" }
    )

    assertThat(nullableString, `is`("9"))
  }

  @Test
  fun whatIfNotNullWithDifferentTypeReturnTest() {
    val nullableString: String? = "notNull"
    val length: Int

    length = nullableString.whatIfNotNullWith(
      whatIf = { it.length },
      whatIfNot = { 0 }
    )

    assertThat(length, `is`(7))
  }

  @Test
  fun nullableBooleanWhatIfTest() {
    var nullableBoolean: Boolean? = null
    var testInteger = 0

    nullableBoolean.whatIf { testInteger = 1 }
    assertThat(testInteger, `is`(0))

    nullableBoolean = true

    nullableBoolean.whatIf { testInteger = 1 }
    assertThat(testInteger, `is`(1))
  }

  @Test
  fun nullableBooleanWhatIfNotTest() {
    var nullableBoolean: Boolean? = null
    var testInteger = 0

    nullableBoolean.whatIf(
      whatIf = { testInteger = 0 },
      whatIfNot = { testInteger = 1 }
    )
    assertThat(testInteger, `is`(1))

    nullableBoolean = true

    nullableBoolean.whatIf(
      whatIf = { testInteger = 0 },
      whatIfNot = { testInteger = 1 }
    )
    assertThat(testInteger, `is`(0))
  }

  @Test
  fun nullableBooleanWhatIfElseTest() {
    var nullableBoolean: Boolean? = null
    var testInteger = 0

    nullableBoolean.whatIf { testInteger = 1 }
    assertThat(testInteger, `is`(0))

    nullableBoolean = false

    nullableBoolean.whatIfElse { testInteger = 1 }
    assertThat(testInteger, `is`(1))
  }

  @Test
  fun whatIfNotNullTypeCastingTest() {
    var nullableInt: MutableList<Int>? = null

    nullableInt.whatIfNotNullAs<List<String>>(
      whatIf = { nullableInt = arrayListOf(it.size) },
      whatIfNot = { nullableInt = arrayListOf(123) }
    )

    assertThat(nullableInt?.get(0), `is`(123))

    nullableInt.whatIfNotNullAs<List<String>> {
      nullableInt = arrayListOf(it.size)
    }

    assertThat(nullableInt?.get(0), `is`(1))
  }
}
