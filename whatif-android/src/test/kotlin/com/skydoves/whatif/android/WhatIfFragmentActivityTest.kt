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

import junit.framework.TestCase.assertNotNull
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
internal class WhatIfFragmentActivityTest {

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
  fun whatIfFindFragmentTest() {
    assertNotNull(mainTestActivity.supportFragmentManager.findFragmentByTag(MainTestFragment.TAG))

    mainTestActivity.whatIfFindFragment<MainTestFragment>(MainTestFragment.TAG) {
      assertNotNull(it)
      assertNotNull(it.activity)
      assertThat(it, instanceOf(MainTestFragment::class.java))
      assertThat(it.activity, instanceOf(MainTestActivity::class.java))
    }
  }

  @Test
  fun whatIfNotNullFindFragmentTest() {
    assertNotNull(mainTestActivity.supportFragmentManager.findFragmentByTag(MainTestFragment.TAG))

    var flag = false
    mainTestActivity.whatIfFindFragment<MainTestFragment2>(
      tag = MainTestFragment.TAG,
      whatIf = {
        assertNotNull(it)
        assertNotNull(it.activity)
        assertThat(it, instanceOf(MainTestFragment::class.java))
        assertThat(it.activity, instanceOf(MainTestActivity::class.java))
      },
      whatIfNot = {
        flag = true
      },
    )
    assertThat(flag, `is`(true))
  }
}
