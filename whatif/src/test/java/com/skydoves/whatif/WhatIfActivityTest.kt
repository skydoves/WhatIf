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

import android.content.Intent
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class WhatIfActivityTest {

  private lateinit var controller: ActivityController<MainTestActivity>
  private lateinit var mainTestActivity: MainTestActivity

  @Before
  fun createActivity() {
    val intent = Intent()
    intent.putExtra("foo", "bar")
    this.controller = Robolectric.buildActivity(MainTestActivity::class.java, intent).create().start()
    this.mainTestActivity = controller.get()
  }

  @Test
  fun whatIfHasExtrasTest() {
    var foo: String? = null

    this.mainTestActivity.whatIfHasExtras(
      whatIf = { foo = it.getString("foo") },
      whatIfNot = { foo = null }
    )

    assertThat(foo, `is`("bar"))

    this.mainTestActivity.whatIfHasExtras {
      foo = "${it.getString("foo")} single"
    }

    assertThat(foo, `is`("bar single"))
  }
}
