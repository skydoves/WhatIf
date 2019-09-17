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

/** An expression for invoking [whatIf] when the [Array] is not null and not empty. */
@WhatIfInlineOnly
inline fun <T> Array<out T>?.whatIfNotNullOrEmpty(
  whatIf: (Array<out T>) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [Array] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun <T> Array<out T>?.whatIfNotNullOrEmpty(
  whatIf: (Array<out T>) -> Unit,
  whatIfNot: () -> Unit
) {

  if (!this.isNullOrEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [ByteArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun ByteArray?.whatIfNotNullOrEmpty(
  whatIf: (ByteArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [ByteArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun ByteArray?.whatIfNotNullOrEmpty(
  whatIf: (ByteArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [ShortArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun ShortArray?.whatIfNotNullOrEmpty(
  whatIf: (ShortArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [ShortArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun ShortArray?.whatIfNotNullOrEmpty(
  whatIf: (ShortArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [IntArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun IntArray?.whatIfNotNullOrEmpty(
  whatIf: (IntArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [IntArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun IntArray?.whatIfNotNullOrEmpty(
  whatIf: (IntArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [LongArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun LongArray?.whatIfNotNullOrEmpty(
  whatIf: (LongArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [LongArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun LongArray?.whatIfNotNullOrEmpty(
  whatIf: (LongArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [FloatArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun FloatArray?.whatIfNotNullOrEmpty(
  whatIf: (FloatArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [FloatArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun FloatArray?.whatIfNotNullOrEmpty(
  whatIf: (FloatArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [DoubleArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun DoubleArray?.whatIfNotNullOrEmpty(
  whatIf: (DoubleArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [DoubleArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun DoubleArray?.whatIfNotNullOrEmpty(
  whatIf: (DoubleArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [BooleanArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun BooleanArray?.whatIfNotNullOrEmpty(
  whatIf: (BooleanArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [BooleanArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun BooleanArray?.whatIfNotNullOrEmpty(
  whatIf: (BooleanArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}

/** An expression for invoking [whatIf] when the [CharArray] is not null and not empty. */
@WhatIfInlineOnly
inline fun CharArray?.whatIfNotNullOrEmpty(
  whatIf: (CharArray) -> Unit
) {

  this.whatIfNotNullOrEmpty(
    whatIf = { whatIf(it) },
    whatIfNot = { }
  )
}

/**
 * An expression for invoking [whatIf] when the [CharArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 */
@WhatIfInlineOnly
inline fun CharArray?.whatIfNotNullOrEmpty(
  whatIf: (CharArray) -> Unit,
  whatIfNot: () -> Unit
) {

  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
}
