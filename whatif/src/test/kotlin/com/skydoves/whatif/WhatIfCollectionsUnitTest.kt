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

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class WhatIfCollectionsUnitTest {

  @Test
  fun whatIfNotNullOrEmptyListTest() {
    var list: List<String>? = null

    list.whatIfNotNullOrEmpty(
      whatIf = { arrayListOf("NotNullOrEmpty") },
      whatIfNot = { list = arrayListOf("NullOrEmpty") },
    )

    assertThat(list?.get(0), `is`("NullOrEmpty"))

    list.whatIfNotNullOrEmpty {
      list = arrayListOf("Not${it[0]}")
    }

    assertThat(list?.get(0), `is`("NotNullOrEmpty"))
  }

  @Test
  fun whatIfNotNullOrEmptySetTest() {
    var set: Set<String>? = null

    set.whatIfNotNullOrEmpty(
      whatIf = { set = setOf("NotNullOrEmpty") },
      whatIfNot = { set = setOf("NullOrEmpty") },
    )

    assertThat(set?.contains("NullOrEmpty"), `is`(true))

    set.whatIfNotNullOrEmpty {
      set = setOf("NotNullOrEmpty")
    }

    assertThat(set?.contains("NotNullOrEmpty"), `is`(true))
  }

  @Test
  fun whatIfNotNullOrEmptyMapTest() {
    var map: Map<Int, String>? = null

    map.whatIfNotNullOrEmpty(
      whatIf = { map = mapOf(1 to "NotNullOrEmpty") },
      whatIfNot = { map = mapOf(1 to "NullOrEmpty") },
    )

    assertThat(map?.get(1), `is`("NullOrEmpty"))

    map.whatIfNotNullOrEmpty {
      map = mapOf(1 to "Not${it[1]}")
    }

    assertThat(map?.get(1), `is`("NotNullOrEmpty"))
  }

  @Test
  fun addWhatIfNotNullTest() {
    var poster: Poster? = Poster.create()
    val posters: MutableList<Poster> = mutableListOf(Poster.create())

    posters.addWhatIfNotNull(poster) {
      poster = Poster.create()
    }

    assertThat(posters.size, `is`(2))
    assertThat(poster, `is`(Poster.create()))

    poster = null
    posters.addWhatIfNotNull(poster) {
      poster = Poster.create()
    }

    assertThat(posters.size, `is`(2))
    assertNull(poster)
  }

  @Test
  fun addAllWhatIfNotNullTest() {
    val posters: MutableList<Poster> = mutableListOf(Poster.create())
    var poster: List<Poster>? = listOf(Poster.create(), Poster.create())

    posters.addAllWhatIfNotNull(poster) {
      poster = listOf(Poster.create())
    }

    assertThat(posters.size, `is`(3))
    assertThat(poster, `is`(listOf(Poster.create())))

    posters.addAllWhatIfNotNull(poster) {
      poster = null
    }

    assertThat(posters.size, `is`(4))
    assertNull(poster)
  }

  @Test
  fun removeWhatIfNotNullTest() {
    val posters: MutableList<Poster> = mutableListOf(Poster.create(), Poster.create())
    var poster: Poster? = Poster.create()

    posters.removeWhatIfNotNull(poster) {
      poster = null
    }

    assertThat(posters.size, `is`(1))

    posters.removeWhatIfNotNull(poster) {
      poster = null
    }

    assertThat(posters.size, `is`(1))
    assertNull(poster)
  }

  @Test
  fun removeAllWhatIfNotNullTest() {
    val posters: MutableList<Poster> =
      mutableListOf(Poster.create(), Poster.create(), Poster.create())
    var poster: List<Poster>? = null

    posters.removeAllWhatIfNotNull(poster) {
      poster = listOf(Poster.create())
    }

    poster = listOf(Poster.create())

    assertThat(posters.size, `is`(3))
    assertThat(poster, `is`(listOf(Poster.create())))

    posters.removeAllWhatIfNotNull(poster) {
      poster = null
    }

    assertThat(posters.size, `is`(0))
    assertNull(poster)
  }

  @Test
  fun whatIfAndTest() {
    var predicates = listOf(true, true, true, false)
    var result = 0

    predicates.whatIfAnd(
      whatIf = {
        result = 1
      },
      whatIfNot = {
        result = -1
      },
    )

    assertThat(result, `is`(-1))

    predicates = listOf(true, true, true, true)

    predicates.whatIfAnd {
      result = 1
    }

    assertThat(result, `is`(1))
  }

  @Test
  fun whatIfOrTest() {
    var predicates = listOf(false, false, false, false)
    var result = 0

    predicates.whatIfOr(
      whatIf = {
        result = 1
      },
      whatIfNot = {
        result = -1
      },
    )

    assertThat(result, `is`(-1))

    predicates = listOf(false, false, false, true)

    predicates.whatIfOr {
      result = 1
    }

    assertThat(result, `is`(1))
  }
}
