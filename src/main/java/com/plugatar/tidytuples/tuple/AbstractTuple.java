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

import com.plugatar.tidytuples.AnyTuple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractTuple<T> implements AnyTuple, Iterable<T> {
    protected final T[] items;

    public AbstractTuple(T[] items) {
        this.items = items;
    }

    @Override
    public final int length() {
        return items.length;
    }

    @Override
    public final T[] asArray() {
        return Arrays.copyOf(items, items.length);
    }

    @Override
    public final Iterator<T> iterator() {
        return new ArrayIterator<>(items);
    }

    @Override
    public final int hashCode() {
        return Arrays.deepHashCode(this.items);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractTuple) {
            final AbstractTuple that = (AbstractTuple) obj;
            return that.length() == this.length()
                    && Arrays.deepEquals(that.items, this.items);
        }
        if (obj instanceof AnyTuple) {
            final AnyTuple that = (AnyTuple) obj;
            return that.length() == this.length()
                    && Arrays.deepEquals(that.asArray(), this.items);
        }
        return false;
    }

    @Override
    public final String toString() {
        if (this.length() == 0) {
            return "()";
        }
        final StringBuilder sb = new StringBuilder(Arrays.deepToString(this.items));
        sb.setCharAt(0, '(');
        sb.setCharAt(sb.length() - 1, ')');
        return sb.toString();
    }

    private static final class ArrayIterator<T> implements Iterator<T> {
        private final T[] array;
        private int cursor;

        private ArrayIterator(final T[] array) {
            this.array = array;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return array[cursor++];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasNext() {
            return cursor != array.length;
        }
    }
}
