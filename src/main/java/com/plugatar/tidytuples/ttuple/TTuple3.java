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

import com.plugatar.tidytuples.Tuple3;

import java.io.Serializable;

/**
 * Simple immutable implementation of the {@link Tuple3}.
 *
 * @param <T0> the type of the 0th item
 * @param <T1> the type of the 1st item
 * @param <T2> the type of the 2nd item
 */
public final class TTuple3<T0, T1, T2> extends TTuple implements Tuple3<T0, T1, T2>, Serializable {
    private static final long serialVersionUID = 1L;
    private final T0 i0;
    private final T1 i1;
    private final T2 i2;

    /**
     * Ctor.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     */
    public TTuple3(final T0 i0, final T1 i1, final T2 i2) {
        this.i0 = i0;
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public Object[] asArray() {
        return new Object[]{i0, i1, i2};
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
    public void supplyTo(final Consumer<? super T0, ? super T1, ? super T2> consumer) {
        consumer.accept(i0, i1, i2);
    }

    @Override
    public <R> R applyTo(final Function<? super T0, ? super T1, ? super T2, ? extends R> function) {
        return function.apply(i0, i1, i2);
    }
}
