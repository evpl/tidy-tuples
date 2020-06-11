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

import com.plugatar.tidytuples.Tuple0;

/**
 * Simple immutable implementation of the {@link Tuple0}.
 */
public final class TupleOf0 extends AbstractTuple<Object> implements Tuple0 {
    private static final TupleOf0 INSTANCE = new TupleOf0();

    /**
     * Ctor. Use {@link #instance()}.
     */
    private TupleOf0() {
        super(new Object[0]);
    }

    /**
     * Returns static instance of this. Exists to reduce the number of identical objects.
     *
     * @return the singleton {@code TupleOf0} instance
     */
    public static TupleOf0 instance() {
        return INSTANCE;
    }

    @Override
    public void supplyTo(Consumer consumer) {
        consumer.accept();
    }

    @Override
    public <R> R applyTo(Function<? extends R> function) {
        return function.apply();
    }
}
