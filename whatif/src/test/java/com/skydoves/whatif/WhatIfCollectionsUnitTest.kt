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
class WhatIfCollectionsUnitTest {

  @Test
  fun whatIfNotNullOrEmptyListTest() {
    var list: List<String>? = null

    list.whatIfNotNullOrEmpty(
      whatIf = { },
      whatIfNot = { list = arrayListOf("NotNullOrEmpty") }
    )

    assertThat(list?.get(0), `is`("NotNullOrEmpty"))

    list.whatIfNotNullOrEmpty {
      list = arrayListOf("NotNullOrEmpty2")
    }

    assertThat(list?.get(0), `is`("NotNullOrEmpty2"))
  }

  @Test
  fun whatIfNotNullOrEmptyMapTest() {
    var map: Map<Int, String>? = null

    map.whatIfNotNullOrEmpty(
      whatIf = { },
      whatIfNot = { map = mapOf(1 to "NotNullOrEmpty") }
    )

    assertThat(map?.get(1), `is`("NotNullOrEmpty"))

    map.whatIfNotNullOrEmpty {
      map = mapOf(1 to "NotNullOrEmpty2")
    }

    assertThat(map?.get(1), `is`("NotNullOrEmpty2"))
  }

  @Test
  fun whatIfNotNullOrEmptySetTest() {
    var set: Set<String>? = null

    set.whatIfNotNullOrEmpty(
      whatIf = { },
      whatIfNot = { set = setOf("NotNullOrEmpty") }
    )

    assertThat(set?.contains("NotNullOrEmpty"), `is`(true))

    set.whatIfNotNullOrEmpty {
      set = setOf("NotNullOrEmpty2")
    }

    assertThat(set?.contains("NotNullOrEmpty2"), `is`(true))
  }
}
