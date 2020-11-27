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

@file:JvmName("WhatIfCollections")
@file:JvmMultifileClass

package com.skydoves.whatif

/**
 * An expression for invoking [whatIf] when the [List] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [List] it not null or empty.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> List<T>?.whatIfNotNullOrEmpty(
  whatIf: (List<T>) -> Unit
): List<T>? = apply {

  this.whatIfNotNullOrEmpty(
    whatIf = whatIf,
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [List] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf]
 *
 * @param whatIf An executable lambda function if the [List] it not null or empty.
 * @param whatIfNot An executable lambda function if the [List] it null or empty.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> List<T>?.whatIfNotNullOrEmpty(
  whatIf: (List<T>) -> Unit,
  whatIfNot: () -> Unit
): List<T>? = apply {

  if (!this.isNullOrEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/**
 * An expression for invoking [whatIf] when the [Set] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [Set] it not null or empty.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> Set<T>?.whatIfNotNullOrEmpty(
  whatIf: (Set<T>) -> Unit
): Set<T>? = apply {

  this.whatIfNotNullOrEmpty(
    whatIf = whatIf,
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [Set] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [Set] it not null or empty.
 * @param whatIfNot An executable lambda function if the [Set] it null or empty.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> Set<T>?.whatIfNotNullOrEmpty(
  whatIf: (Set<T>) -> Unit,
  whatIfNot: () -> Unit
): Set<T>? = apply {

  if (!this.isNullOrEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/**
 * An expression for invoking [whatIf] when the [Map] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [Map] it not null or empty.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> Map<T, R>?.whatIfNotNullOrEmpty(
  whatIf: (Map<T, R>) -> Unit
): Map<T, R>? = apply {

  this.whatIfNotNullOrEmpty(
    whatIf = whatIf,
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [Map] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [Map] it not null or empty.
 * @param whatIfNot An executable lambda function if the [Map] it null or empty.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> Map<T, R>?.whatIfNotNullOrEmpty(
  whatIf: (Map<T, R>) -> Unit,
  whatIfNot: () -> Unit
): Map<T, R>? = apply {

  if (!this.isNullOrEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/**
 * An expression for adding an [element] and invoking [whatIf] when the [element] is not null.
 *
 * @param element An element should be added into the target.
 * @param whatIf An executable lambda function if the [element] it not null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : MutableCollection<E>, reified E> T.addWhatIfNotNull(
  element: E?,
  whatIf: (T) -> Unit
): T = apply {

  this.addWhatIfNotNull(
    element = element,
    whatIf = whatIf,
    whatIfNot = { }
  )
}

/**
 * An expression for adding an [element] and invoking [whatIf] when the [element] is not null.
 *
 * @param element An element should be added into the target.
 * @param whatIf An executable lambda function if the [element] it not null.
 * @param whatIfNot An executable lambda function if the [element] it null or empty.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : MutableCollection<E>, reified E> T.addWhatIfNotNull(
  element: E?,
  whatIf: (T) -> Unit,
  whatIfNot: (T) -> Unit
): T = apply {

  element?.whatIfNotNullAs<E>(
    whatIf = {
      add(it)
      whatIf(this)
    },
    whatIfNot = {
      whatIfNot(this)
    }
  )
}
