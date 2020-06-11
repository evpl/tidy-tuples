/*
 * Copyright (c) 2020 Evgenii Plugatar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.plugatar.tidytuples.tuple;

import com.plugatar.tidytuples.Tuple;

import java.lang.reflect.Array;

public final class TupleOf<T> extends AbstractTuple<T> implements Tuple<T> {
    private final T[] items;

    @SafeVarargs
    public TupleOf(final T... items) {
        super(items);
        this.items = items;
    }

    @Override
    public T i(final int idx) {
        if (items.length == 0 || idx < 0 || idx >= items.length) {
            throw new IndexOutOfBoundsException(String.format(
                    "idx = %s, length = %s",
                    idx, items.length
            ));
        }
        return items[idx];
    }

    public TupleOf<T> inner(final int leftBoundIdx, final int rightBoundIdx) {
        checkBounds(items.length, leftBoundIdx, rightBoundIdx);
        if (leftBoundIdx == rightBoundIdx) {
            T[] newArray = newArray(1);
            newArray[0] = items[leftBoundIdx];
            return new TupleOf<>(newArray);
        }
        if (leftBoundIdx == 0 && rightBoundIdx == items.length - 1) {
            return this;
        }
        final int newArrayLength = rightBoundIdx - leftBoundIdx + 1;
        final T[] newArray = newArray(newArrayLength);
        System.arraycopy(this.items, leftBoundIdx, newArray, 0, newArrayLength);
        return new TupleOf<>(newArray);
    }

    public TupleOf<T> outer(final int leftBoundIdx, final int rightBoundIdx) {
        checkBounds(items.length, leftBoundIdx, rightBoundIdx);
        if (leftBoundIdx == rightBoundIdx || rightBoundIdx - leftBoundIdx == 1) {
            return this;
        }
        final T[] newItems = newArray(items.length - rightBoundIdx + leftBoundIdx + 1);
        System.arraycopy(items, 0, newItems, 0, leftBoundIdx + 1);
        System.arraycopy(items, rightBoundIdx, newItems, leftBoundIdx + 1, items.length - rightBoundIdx);
        return new TupleOf<>(newItems);
    }

    @Override
    @SafeVarargs
    public final TupleOf<T> with(final int idx, final T... anotherItems) {
        if (idx < 0 || idx > items.length) {
            throw new IndexOutOfBoundsException(String.format(
                    "idx = %s, length = %s",
                    idx, items.length
            ));
        }
        if (anotherItems.length == 0) {
            return this;
        }
        final T[] newItems = newArray(this.items.length + anotherItems.length);
        if (idx != 0) {
            System.arraycopy(this.items, 0, newItems, 0, idx);
        }
        System.arraycopy(anotherItems, 0, newItems, idx, anotherItems.length);
        System.arraycopy(this.items, idx, newItems, idx + anotherItems.length, this.items.length - idx);
        return new TupleOf<>(newItems);
    }

    @Override
    @SafeVarargs
    public final TupleOf<T> withLast(final T... lastItems) {
        return with(items.length, lastItems);
    }

    @Override
    public void supplyTo(final Consumer<? super T> consumer) {
        consumer.accept(this.asArray());
    }

    @Override
    public <R> R applyTo(final Function<? super T, ? extends R> function) {
        return function.apply(this.asArray());
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(final int length) {
        final Class<?> arrayType = this.items.getClass();
        return arrayType == Object[].class
                ? (T[]) new Object[length]
                : (T[]) Array.newInstance(arrayType.getComponentType(), length);
    }

    private static void checkBounds(final int length, final int leftBoundIdx, final int rightBoundIdx) {
        if (length == 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "leftBoundIdx = %s, rightBoundIdx = %s, length = %s",
                    leftBoundIdx, rightBoundIdx, length)
            );
        }
        final int maxIdx = length - 1;
        if (leftBoundIdx < 0 || leftBoundIdx > maxIdx) {
            throw new IndexOutOfBoundsException(String.format(
                    "leftBoundIdx = %s, length = %s",
                    leftBoundIdx, length
            ));
        }
        if (rightBoundIdx < 0 || rightBoundIdx > maxIdx) {
            throw new IndexOutOfBoundsException(String.format(
                    "rightBoundIdx = %s, length = %s",
                    rightBoundIdx, length
            ));
        }
        if (leftBoundIdx > rightBoundIdx) {
            throw new IllegalArgumentException(String.format(
                    "leftBoundIndex = %s, rightBoundIdx = %s",
                    leftBoundIdx, rightBoundIdx
            ));
        }
    }
}
