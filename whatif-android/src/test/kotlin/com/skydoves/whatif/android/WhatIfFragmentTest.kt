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

package com.skydoves.whatif.android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import junit.framework.TestCase.assertNotNull
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
internal class WhatIfFragmentTest {

  private lateinit var controller: ActivityController<MainTestActivity>
  private lateinit var mainTestActivity: MainTestActivity

  @Before
  fun createActivity() {
    this.controller = Robolectric.buildActivity(
      MainTestActivity::class.java,
    ).create().start()
    this.mainTestActivity = controller.get()
    this.mainTestActivity.supportFragmentManager.apply {
      beginTransaction()
        .add(MainTestFragment(), MainTestFragment.TAG)
        .commit()
      executePendingTransactions()
    }
  }

  @Test
  fun whatIfNotNullContextTest() {
    val fragment = mainTestActivity.supportFragmentManager.findFragmentByTag(MainTestFragment.TAG)

    var flag = false
    fragment.whatIfNotNullContext {
      assertThat(it, instanceOf(Context::class.java))
      flag = true
    }
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfNotNullElseContextTest() {
    val fragment = MainTestFragment()

    var flag = false
    fragment.whatIfNotNullContext(
      whatIf = {},
      whatIfNot = { flag = true },
    )
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfNotNullActivityTest() {
    val fragment = mainTestActivity.supportFragmentManager.findFragmentByTag(MainTestFragment.TAG)

    var flag = false
    fragment.whatIfNotNullActivity {
      assertThat(it, instanceOf(FragmentActivity::class.java))
      flag = true
    }
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfNotNullElseActivityTest() {
    val fragment = MainTestFragment()

    var flag = false
    fragment.whatIfNotNullActivity(
      whatIf = {},
      whatIfNot = { flag = true },
    )
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfHasArgumentsTest() {
    val fragment = MainTestFragment().apply {
      arguments = Bundle().apply {
        putInt("param", 123)
      }
    }

    var flag = false
    fragment.whatIfHasArguments {
      assertThat(it.getInt("param", 0), `is`(123))
      flag = true
    }
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfHasArgumentsNotNullTest() {
    val fragment = MainTestFragment()

    var flag = false
    fragment.whatIfHasArguments(
      whatIf = {},
      whatIfNot = { flag = true },
    )
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfFindParentInterfaceTest() {
    val fragment = mainTestActivity.supportFragmentManager.findFragmentByTag(MainTestFragment.TAG)

    var flag = false
    fragment.whatIfFindParentInterface<MainTestActivity> {
      assertNotNull(it)
      assertThat(it, instanceOf(MainTestActivity::class.java))
      flag = true
    }
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfFindParentInterfaceAsInterfaceTest() {
    val fragment = mainTestActivity.supportFragmentManager.findFragmentByTag(MainTestFragment.TAG)

    var flag = false
    fragment.whatIfFindParentInterface<MainTestActivityInterface> {
      assertNotNull(it)
      assertThat(it, instanceOf(MainTestActivityInterface::class.java))
      flag = true
    }
    assertThat(flag, Is.`is`(true))
  }

  @Test
  fun whatIfFindParentInterfaceNotNullTest() {
    val fragment = mainTestActivity.supportFragmentManager.findFragmentByTag(MainTestFragment.TAG)

    var flag = false
    fragment.whatIfFindParentInterface<MainTestFragment2>(
      whatIf = {
        assertThat(1, `is`(2))
      },
      whatIfNot = {
        flag = true
      },
    )
    assertThat(flag, Is.`is`(true))
  }
}
