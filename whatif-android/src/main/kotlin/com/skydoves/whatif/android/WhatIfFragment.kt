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

@file:Suppress("unused")
@file:JvmName("WhatIfFragment")
@file:JvmMultifileClass

package com.skydoves.whatif.android

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullAs
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Context] is not null.
 *
 * @param whatIf An executable lambda function if the [Fragment]'s context is not null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Fragment?.whatIfNotNullContext(
  whatIf: (Context) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this?.context.whatIfNotNull {
    whatIf(it)
  }
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Context] is not null.
 * If the activity is null, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [Fragment]'s context is not null.
 * @param whatIfNot An executable lambda function if the [Fragment]'s context is null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Fragment?.whatIfNotNullContext(
  whatIf: (Context) -> Unit,
  whatIfNot: () -> Unit,
) {
  this?.context.whatIfNotNull(
    whatIf = whatIf,
    whatIfNot = whatIfNot,
  )
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Activity] is not null.
 *
 * @param whatIf An executable lambda function if the [Fragment]'s parent Activity is not null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Fragment?.whatIfNotNullActivity(
  whatIf: (FragmentActivity) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this?.activity.whatIfNotNull {
    whatIf(it)
  }
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Activity] is not null.
 * If the activity is null, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [Fragment]'s parent Activity is not null.
 * @param whatIfNot An executable lambda function if the [Fragment]'s parent Activity is null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Fragment?.whatIfNotNullActivity(
  whatIf: (FragmentActivity) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  this?.activity.whatIfNotNull(
    whatIf = whatIf,
    whatIfNot = whatIfNot,
  )
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Fragment.getArguments] is not null.
 *
 * @param whatIf An executable lambda function if the [Fragment] has arguments.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Fragment?.whatIfHasArguments(
  whatIf: (Bundle) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  whatIfHasArguments(whatIf) { }
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Fragment.getArguments] is not null.
 *
 * @param whatIf An executable lambda function if the [Fragment] has arguments.
 * @param whatIfNot An executable lambda function if the [Fragment] has not any arguments.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Fragment?.whatIfHasArguments(
  whatIf: (Bundle) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  this?.arguments.whatIfNotNull(whatIf, whatIfNot)
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Fragment] has an [T] interface as a parent.
 *
 * @param whatIf An executable lambda function if the [Fragment] has an [T] interface as a parent.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T> Fragment?.whatIfFindParentInterface(
  whatIf: (T) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  whatIfFindParentInterface(whatIf) { }
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [Fragment] has an [T] interface as a parent.
 *
 * @param whatIf An executable lambda function if the [Fragment] has an [T] interface as a parent.
 * @param whatIfNot An executable lambda function if the [Fragment] has not an [T] interface as a parent.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T> Fragment?.whatIfFindParentInterface(
  whatIf: (T) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  this?.activity.whatIfNotNullAs(whatIf, whatIfNot)
}
