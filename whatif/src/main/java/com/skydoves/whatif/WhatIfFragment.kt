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

@file:Suppress("unused")

package com.skydoves.whatif

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * An expression for invoking [whatIf] when the [Context] is not null.
 */
@WhatIfInlineOnly
inline fun Fragment.whatIfNotNullContext(
  whatIf: (Context) -> Unit
) {

  this.context.whatIfNotNull {
    whatIf(it)
  }
}

/**
 * An expression for invoking [whatIf] when the [Context] is not null.
 *
 * If the activity is null, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun Fragment.whatIfNotNullContext(
  whatIf: (Context) -> Unit,
  whatIfNot: () -> Unit
) {

  this.context.whatIfNotNull(
    whatIf = {
      whatIf(it)
    },
    whatIfNot = { whatIfNot() }
  )
}

/**
 * An expression for invoking [whatIf] when the [Activity] is not null.
 */
@WhatIfInlineOnly
inline fun Fragment.whatIfNotNullActivity(
  whatIf: (FragmentActivity) -> Unit
) {

  this.activity.whatIfNotNull {
    whatIf(it)
  }
}

/**
 * An expression for invoking [whatIf] when the [Activity] is not null.
 *
 * If the activity is null, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun Fragment.whatIfNotNullActivity(
  whatIf: (FragmentActivity) -> Unit,
  whatIfNot: () -> Unit
) {

  this.activity.whatIfNotNull(
    whatIf = {
      whatIf(it)
    },
    whatIfNot = { whatIfNot() }
  )
}

/**
 * An expression for invoking [whatIf] when the [Fragment.getArguments] is not null.
 */
@WhatIfInlineOnly
inline fun Fragment.whatIfNotNullArguments(
  whatIf: (Bundle) -> Unit
) {

  this.arguments.whatIfNotNull {
    whatIf(it)
  }
}
