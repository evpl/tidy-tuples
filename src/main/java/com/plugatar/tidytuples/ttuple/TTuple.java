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
package com.plugatar.tidytuples.ttuple;

import com.plugatar.tidytuples.Tuple;

import java.util.Arrays;

/**
 * Implementation of the {@link Tuple} that based on the future
 * {@link #asArray()} abstract method implementation.
 */
public abstract class TTuple implements Tuple {

    @Override
    public final <T> T[] asArray(final Class<? extends T[]> arrayType) {
        final Object[] items = this.asArray();
        return Arrays.copyOf(items, items.length, arrayType);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.asArray());
    }

    @Override
    public final boolean equals(final Object obj) {
        return obj == this || obj instanceof Tuple && Arrays.equals(((Tuple) obj).asArray(), this.asArray());
    }

    @Override
    public final String toString() {
        final Object[] items = this.asArray();
        final int maxIdx = items.length - 1;
        if (maxIdx == -1) {
            return "()";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (int idx = 0; ; ++idx) {
            sb.append(items[idx]);
            if (idx == maxIdx) {
                return sb.append(')').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
