/*
 * Designed and developed by 2019-2023 skydoves (Jaewoong Eum)
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

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class WhatIfStringUnitTest {

  @Test
  fun whatIfNotNullOrEmptyStringNullTest() {
    var nullableString: String? = null

    nullableString.whatIfNotNullOrEmpty(
      whatIf = { nullableString = it },
      whatIfNot = { nullableString = "NullOrEmpty" },
    )

    assertThat(nullableString, `is`("NullOrEmpty"))

    nullableString.whatIfNotNullOrEmpty {
      nullableString = "NotNullOrEmpty"
    }

    assertThat(nullableString, `is`("NotNullOrEmpty"))
  }

  @Test
  fun whatIfNotNullOrEmptyStringEmptyTest() {
    var nullableString: String? = ""

    nullableString.whatIfNotNullOrEmpty(
      whatIf = { nullableString = it },
      whatIfNot = { nullableString = "NullOrEmpty" },
    )

    assertThat(nullableString, `is`("NullOrEmpty"))

    nullableString.whatIfNotNullOrEmpty {
      nullableString = "Not$it"
    }

    assertThat(nullableString, `is`("NotNullOrEmpty"))
  }
}
