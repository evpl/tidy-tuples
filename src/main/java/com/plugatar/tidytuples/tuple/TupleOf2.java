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

import com.plugatar.tidytuples.Tuple2;

/**
 * Simple immutable implementation of the {@link Tuple2}.
 *
 * @param <T0> the type of the 0th item
 * @param <T1> the type of the 1st item
 */
public final class TupleOf2<T0, T1> extends AbstractTuple<Object> implements Tuple2<T0, T1> {
    private final T0 i0;
    private final T1 i1;

    /**
     * Ctor.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     */
    public TupleOf2(final T0 i0, final T1 i1) {
        super(new Object[]{i0, i1});
        this.i0 = i0;
        this.i1 = i1;
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
    public void supplyTo(final Consumer<? super T0, ? super T1> consumer) {
        consumer.accept(i0, i1);
    }

    @Override
    public <R> R applyTo(final Function<? super T0, ? super T1, ? extends R> function) {
        return function.apply(i0, i1);
    }
}
