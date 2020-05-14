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
import com.plugatar.tidytuples.TupleN;

import java.io.Serializable;

/**
 * Simple immutable implementation of the {@link TupleN}.
 *
 * @param <T0> the type of the 0th item
 * @param <T1> the type of the 1st item
 * @param <T2> the type of the 2nd item
 * @param <T3> the type of the 3rd item
 * @param <T4> the type of the 4th item
 * @param <T5> the type of the 5th item
 * @param <T6> the type of the 6th item
 * @param <T7> the type of the 7th item
 * @param <T8> the type of the 8th item
 * @param <T9> the type of the 9th item
 * @param <R>  the type of the rest items tuple
 */
public final class TTupleN<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R extends Tuple> extends TTuple
        implements TupleN<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>, Serializable {
    private static final long serialVersionUID = 1L;
    private final T0 i0;
    private final T1 i1;
    private final T2 i2;
    private final T3 i3;
    private final T4 i4;
    private final T5 i5;
    private final T6 i6;
    private final T7 i7;
    private final T8 i8;
    private final T9 i9;
    private final R rest;

    /**
     * Ctor.
     *
     * @param i0   the 0th item
     * @param i1   the 1st item
     * @param i2   the 2nd item
     * @param i3   the 3rd item
     * @param i4   the 4th item
     * @param i5   the 5th item
     * @param i6   the 6th item
     * @param i7   the 7th item
     * @param i8   the 8th item
     * @param i9   the 9th item
     * @param rest the rest items tuple
     */
    public TTupleN(final T0 i0, final T1 i1, final T2 i2, final T3 i3, final T4 i4, final T5 i5,
                   final T6 i6, final T7 i7, final T8 i8, T9 i9, final R rest) {
        this.i0 = i0;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.i5 = i5;
        this.i6 = i6;
        this.i7 = i7;
        this.i8 = i8;
        this.i9 = i9;
        this.rest = rest;
    }

    @Override
    public Object[] asArray() {
        final Object[] thisItems = new Object[]{i0, i1, i2, i3, i4, i5, i6, i7, i8, i9};
        final Object[] restItems = rest.asArray();
        final Object[] items = new Object[thisItems.length + restItems.length];
        System.arraycopy(thisItems, 0, items, 0, thisItems.length);
        System.arraycopy(restItems, 0, items, thisItems.length, restItems.length);
        return items;
    }

    @Override
    public T0 i0() {
        return i0;
    }

    @Override
    public T1 i1() {
        return i1;
    }

    @Override
    public T2 i2() {
        return i2;
    }

    @Override
    public T3 i3() {
        return i3;
    }

    @Override
    public T4 i4() {
        return i4;
    }

    @Override
    public T5 i5() {
        return i5;
    }

    @Override
    public T6 i6() {
        return i6;
    }

    @Override
    public T7 i7() {
        return i7;
    }

    @Override
    public T8 i8() {
        return i8;
    }

    @Override
    public T9 i9() {
        return i9;
    }

    @Override
    public R rest() {
        return rest;
    }
}
