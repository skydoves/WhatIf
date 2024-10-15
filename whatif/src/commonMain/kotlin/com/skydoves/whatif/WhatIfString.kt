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

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.jvm.JvmSynthetic

/**
 * An expression for invoking [whatIf] when the [String] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [String] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun String?.whatIfNotNullOrEmpty(
  whatIf: (String) -> Unit,
): String? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this.whatIfNotNullOrEmpty(
    whatIf = whatIf,
    whatIfNot = { },
  )
  return this
}

/**
 * An expression for invoking [whatIf] when the [String] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [String] it not null or empty.
 * @param whatIfNot An executable lambda function if the [String] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun String?.whatIfNotNullOrEmpty(
  whatIf: (String) -> Unit,
  whatIfNot: () -> Unit,
): String? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (!this.isNullOrEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}
