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

import com.plugatar.tidytuples.Tuple5;

/**
 * Simple immutable implementation of the {@link Tuple5}.
 *
 * @param <T0> the type of the 0th item
 * @param <T1> the type of the 1st item
 * @param <T2> the type of the 2nd item
 * @param <T3> the type of the 3rd item
 * @param <T4> the type of the 4th item
 */
public final class TupleOf5<T0, T1, T2, T3, T4> extends AbstractTuple<Object> implements Tuple5<T0, T1, T2, T3, T4> {
    private final T0 i0;
    private final T1 i1;
    private final T2 i2;
    private final T3 i3;
    private final T4 i4;

    /**
     * Ctor.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @param i4 the 4th item
     */
    public TupleOf5(final T0 i0, final T1 i1, final T2 i2, final T3 i3, final T4 i4) {
        super(new Object[]{i0, i1, i2, i3, i4});
        this.i0 = i0;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
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
    public void supplyTo(final Consumer<? super T0, ? super T1, ? super T2, ? super T3, ? super T4> consumer) {
        consumer.accept(i0, i1, i2, i3, i4);
    }

    @Override
    public <R> R applyTo(final Function<? super T0, ? super T1, ? super T2, ? super T3, ? super T4,
            ? extends R> function) {
        return function.apply(i0, i1, i2, i3, i4);
    }
}
