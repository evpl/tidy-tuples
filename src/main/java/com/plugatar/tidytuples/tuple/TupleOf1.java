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

import com.plugatar.tidytuples.Tuple1;

/**
 * Simple immutable implementation of the {@link Tuple1}.
 *
 * @param <T0> the type of the 0th item
 */
public final class TupleOf1<T0> extends AbstractTuple<Object> implements Tuple1<T0> {
    private final T0 i0;

    /**
     * Ctor.
     *
     * @param i0 the 0th item
     */
    public TupleOf1(final T0 i0) {
        super(new Object[]{i0});
        this.i0 = i0;
    }

    @Override
    public T0 i0() {
        return i0;
    }

    @Override
    public void supplyTo(final Consumer<? super T0> consumer) {
        consumer.accept(i0);
    }

    @Override
    public <R> R applyTo(final Function<? super T0, ? extends R> function) {
        return function.apply(i0);
    }
}
