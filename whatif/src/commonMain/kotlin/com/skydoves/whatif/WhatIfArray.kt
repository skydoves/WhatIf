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
 * An expression for invoking [whatIf] when the [Array] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [Array] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> Array<out T>?.whatIfNotNullOrEmpty(
  whatIf: (Array<out T>) -> Unit,
): Array<out T>? {
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
 * An expression for invoking [whatIf] when the [Array] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [Array] it not null or empty.
 * @param whatIfNot An executable lambda function if the [Array] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> Array<out T>?.whatIfNotNullOrEmpty(
  whatIf: (Array<out T>) -> Unit,
  whatIfNot: () -> Unit,
): Array<out T>? {
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

/**
 * An expression for invoking [whatIf] when the [ByteArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [ByteArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun ByteArray?.whatIfNotNullOrEmpty(
  whatIf: (ByteArray) -> Unit,
): ByteArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  return this.whatIfNotNullOrEmpty(
    whatIf = whatIf,
    whatIfNot = { },
  )
}

/**
 * An expression for invoking [whatIf] when the [ByteArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [ByteArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [ByteArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun ByteArray?.whatIfNotNullOrEmpty(
  whatIf: (ByteArray) -> Unit,
  whatIfNot: () -> Unit,
): ByteArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}

/**
 * An expression for invoking [whatIf] when the [ShortArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [ShortArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun ShortArray?.whatIfNotNullOrEmpty(
  whatIf: (ShortArray) -> Unit,
): ShortArray? {
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
 * An expression for invoking [whatIf] when the [ShortArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [ShortArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [ShortArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun ShortArray?.whatIfNotNullOrEmpty(
  whatIf: (ShortArray) -> Unit,
  whatIfNot: () -> Unit,
): ShortArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}

/**
 * An expression for invoking [whatIf] when the [IntArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [IntArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun IntArray?.whatIfNotNullOrEmpty(
  whatIf: (IntArray) -> Unit,
): IntArray? {
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
 * An expression for invoking [whatIf] when the [IntArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [IntArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [IntArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun IntArray?.whatIfNotNullOrEmpty(
  whatIf: (IntArray) -> Unit,
  whatIfNot: () -> Unit,
): IntArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}

/**
 * An expression for invoking [whatIf] when the [LongArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [LongArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun LongArray?.whatIfNotNullOrEmpty(
  whatIf: (LongArray) -> Unit,
): LongArray? {
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
 * An expression for invoking [whatIf] when the [LongArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [LongArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [LongArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun LongArray?.whatIfNotNullOrEmpty(
  whatIf: (LongArray) -> Unit,
  whatIfNot: () -> Unit,
): LongArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}

/**
 * An expression for invoking [whatIf] when the [FloatArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [FloatArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun FloatArray?.whatIfNotNullOrEmpty(
  whatIf: (FloatArray) -> Unit,
): FloatArray? {
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
 * An expression for invoking [whatIf] when the [FloatArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [FloatArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [FloatArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun FloatArray?.whatIfNotNullOrEmpty(
  whatIf: (FloatArray) -> Unit,
  whatIfNot: () -> Unit,
): FloatArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}

/**
 * An expression for invoking [whatIf] when the [DoubleArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [DoubleArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun DoubleArray?.whatIfNotNullOrEmpty(
  whatIf: (DoubleArray) -> Unit,
): DoubleArray? {
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
 * An expression for invoking [whatIf] when the [DoubleArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [DoubleArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [DoubleArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun DoubleArray?.whatIfNotNullOrEmpty(
  whatIf: (DoubleArray) -> Unit,
  whatIfNot: () -> Unit,
): DoubleArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}

/**
 * An expression for invoking [whatIf] when the [BooleanArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [BooleanArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun BooleanArray?.whatIfNotNullOrEmpty(
  whatIf: (BooleanArray) -> Unit,
): BooleanArray? {
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
 * An expression for invoking [whatIf] when the [BooleanArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [BooleanArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [BooleanArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun BooleanArray?.whatIfNotNullOrEmpty(
  whatIf: (BooleanArray) -> Unit,
  whatIfNot: () -> Unit,
): BooleanArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}

/**
 * An expression for invoking [whatIf] when the [CharArray] is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [CharArray] it not null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun CharArray?.whatIfNotNullOrEmpty(
  whatIf: (CharArray) -> Unit,
): CharArray? {
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
 * An expression for invoking [whatIf] when the [CharArray] is not null and not empty.
 * If the array is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [CharArray] it not null or empty.
 * @param whatIfNot An executable lambda function if the [CharArray] it null or empty.
 *
 * @return Returns the original target object.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun CharArray?.whatIfNotNullOrEmpty(
  whatIf: (CharArray) -> Unit,
  whatIfNot: () -> Unit,
): CharArray? {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (this != null && this.isNotEmpty()) {
    whatIf(this)
  } else {
    whatIfNot()
  }
  return this
}
