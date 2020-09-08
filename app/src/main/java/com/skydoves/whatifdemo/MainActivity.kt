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

package com.skydoves.whatifdemo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.showAlignTop
import com.skydoves.whatif.whatIf
import com.skydoves.whatif.whatIfLet
import com.skydoves.whatif.whatIfNotNull
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val nullableBoolean: Boolean? = true
    var nullableString: String? = null

    // example0 : nullable Boolean true-false check.
    whatIf(nullableBoolean) {
      log("not-null and true : $nullableBoolean")
    }

    // example1 : nullable Boolean true-false check extension.
    nullableBoolean.whatIf {
      log("not-null and true : $nullableBoolean")
    }

    // example2 : nullable Boolean true-false check extension with whatIfNot
    nullableBoolean.whatIf(
      whatIf = { log("not-null and true : $nullableBoolean") },
      whatIfNot = { log("null or false : $nullableBoolean") }
    )

    // example3 : nullable String true-false check extension with default value.
    nullableString = nullableBoolean?.whatIfLet(nullableBoolean, "null") {
      "notNull"
    }
    if (nullableString != null) {
      log(nullableString)
    }

    // example4 : nullable any type null check extension.
    nullableString.whatIfNotNull {
      log("$it is not null.")
    }

    // example5 : nullable any type null check extension.
    val newString = nullableString?.whatIfLet(
      given = nullableString.length > 3,
      whatIf = {
        log("$it is long.")
        "long"
      },
      whatIfNot = {
        log("$it is short.")
        "short"
      }
    )

    // example6 : what-if check in the builder pattern.
    val balloon = Balloon.Builder(this)
      .setArrowSize(10)
      .setArrowVisible(true)
      .whatIf(nullableBoolean) { setTextColor(Color.YELLOW) }
      .whatIf(nullableBoolean, { setText("Hello, whatIf") }, { setText("Good-Bye whatIf") })
      .setWidthRatio(1.0f)
      .setMargin(12)
      .setPadding(12)
      .setTextSize(15f)
      .setArrowPosition(0.5f)
      .setCornerRadius(4f)
      .setAlpha(0.9f)
      .setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorPrimary))
      .setBalloonAnimation(BalloonAnimation.FADE)
      .setLifecycleOwner(this@MainActivity)
      .build()

    button.showAlignTop(balloon)
  }

  private fun log(log: String) {
    Log.d(this::class::java.name, log)
  }
}
