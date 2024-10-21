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

package com.skydoves.whatifdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.whatif.whatIf
import com.skydoves.whatif.whatIfMap
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatifdemo.theme.WhatIfTheme
import com.skydoves.whatifdemo.theme.background

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    whatIfExamples()

    setContent {
      WhatIfTheme {
        var isBlueColor by remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxSize()) {
          Box(
            modifier = Modifier
              .align(Alignment.Center)
              .clickable { isBlueColor = !isBlueColor }
              .whatIfMap(
                isBlueColor,
                { it.background(Color.Blue) },
                { it.background(Color.Cyan) },
              )
              .whatIfMap(isBlueColor, { it.size(120.dp) }, { it.size(240.dp) }),
          )

          Box(modifier = Modifier.align(Alignment.Center)) {
            whatIf(
              given = isBlueColor,
              whatIf = {
                Text(
                  text = "isBlueColor=$isBlueColor",
                  color = Color.White,
                )
              },
              whatIfNot = {
                Text(
                  text = "isBlueColor=$isBlueColor",
                  color = Color.Red,
                )
              },
            )
          }
        }
      }
    }
  }

  private fun whatIfExamples() {
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
      whatIfNot = { log("null or false : $nullableBoolean") },
    )

    // example3 : nullable String true-false check extension with default value.
    nullableString = nullableBoolean.whatIfMap(nullableBoolean, "null") {
      "notNull"
    }

    log(nullableString)

    // example4 : nullable any type null check extension.
    nullableString.whatIfNotNull {
      log("$it is not null.")
    }

    // example5 : nullable any type null check extension.
    val newString = nullableString.whatIfMap(
      given = nullableString.length > 3,
      whatIf = {
        log("$it is long.")
        "long"
      },
      whatIfNot = {
        log("$it is short.")
        "short"
      },
    )
  }

  private fun log(log: String) {
    Log.d("MainActivity", log)
  }
}
