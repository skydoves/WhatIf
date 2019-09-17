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

import android.app.Activity
import android.os.Bundle

/**
 * An expression for invoking [whatIf] when the
 * [Activity]'s intent extras is not null and not empty.
 */
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
