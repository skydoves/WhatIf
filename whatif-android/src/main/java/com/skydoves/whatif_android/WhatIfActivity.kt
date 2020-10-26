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

package com.skydoves.whatif_android

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import com.skydoves.whatif.WhatIfInlineOnly
import com.skydoves.whatif.whatIfNotNull
import java.io.Serializable

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is not null and not empty.
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasExtras(
  whatIf: (Bundle) -> Unit
) {

  this.whatIfHasExtras(
    whatIf = whatIf,
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is not null and not empty.
 *
 * If the intent extras is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasExtras(
  whatIf: (Bundle) -> Unit,
  whatIfNot: () -> Unit
) {

  this.intent.extras.whatIfNotNull(
    whatIf = {
      if (!it.isEmpty) {
        whatIf(it)
      }
    },
    whatIfNot = { whatIfNot() }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is not null and not empty.
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasExtras(
  name: String,
  whatIf: () -> Unit
) {
  this.whatIfHasExtras(
    name = name,
    whatIf = { whatIf() },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is not null and not empty.
 *
 * If the intent extras is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasExtras(
  name: String,
  whatIf: () -> Unit,
  whatIfNot: () -> Unit
) {

  if (intent.hasExtra(name)) {
    whatIf()
  } else {
    whatIfNot()
  }
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has a string extra by name.
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasStringExtra(
  name: String,
  whatIf: (String) -> Unit
) {
  this.intent.getStringExtra(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has a string extra by name.
 *
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasStringExtra(
  name: String,
  whatIf: (String) -> Unit,
  whatIfNot: () -> Unit
) {
  this.intent.getStringExtra(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { whatIfNot() }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has a CharSequence extra by name.
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasCharSequenceExtra(
  name: String,
  whatIf: (CharSequence) -> Unit
) {
  this.intent.getCharSequenceExtra(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has a CharSequence extra by name.
 *
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasCharSequenceExtra(
  name: String,
  whatIf: (CharSequence) -> Unit,
  whatIfNot: () -> Unit
) {
  this.intent.getCharSequenceExtra(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { whatIfNot() }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has a Serializable extra by name.
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasSerializableExtra(
  name: String,
  whatIf: (Serializable) -> Unit
) {
  this.intent.getSerializableExtra(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has a Serializable extra by name.
 *
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun Activity.whatIfHasSerializableExtra(
  name: String,
  whatIf: (Serializable) -> Unit,
  whatIfNot: () -> Unit
) {
  this.intent.getSerializableExtra(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { whatIfNot() }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has an object extra by name.
 */
@WhatIfInlineOnly
inline fun <reified T : Parcelable> Activity.whatIfHasParcelableExtra(
  name: String,
  whatIf: (T) -> Unit
) {
  this.intent.getParcelableExtra<T>(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has an object extra by name.
 *
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun <reified T : Parcelable> Activity.whatIfHasParcelableExtra(
  name: String,
  whatIf: (T) -> Unit,
  whatIfNot: () -> Unit
) {
  this.intent.getParcelableExtra<T>(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { whatIfNot() }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has an ArrayList of object extra by name.
 */
@WhatIfInlineOnly
inline fun <reified T : Parcelable> Activity.whatIfHasParcelableArrayListExtra(
  name: String,
  whatIf: (ArrayList<T>) -> Unit
) {
  this.intent.getParcelableArrayListExtra<T>(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is has an ArrayList of object extra by name.
 *
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun <reified T : Parcelable> Activity.whatIfHasParcelableArrayListExtra(
  name: String,
  whatIf: (ArrayList<T>) -> Unit,
  whatIfNot: () -> Unit
) {
  this.intent.getParcelableArrayListExtra<T>(name).whatIfNotNull(
    whatIf = { whatIf(it) },
    whatIfNot = { whatIfNot() }
  )
}
