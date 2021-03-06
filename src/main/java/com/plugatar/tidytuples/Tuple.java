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
package com.plugatar.tidytuples;

public interface Tuple<T> extends AnyTuple, Iterable<T> {

    @Override
    T[] asArray();

    T i(int idx);

    Tuple<T> inner(int leftBoundIdx, int rightBoundIdx);

    Tuple<T> outer(int leftBoundIdx, int rightBoundIdx);

    Tuple<T> with(int idx, T... anotherItems);

    Tuple<T> withLast(T... lastItems);

    void supplyTo(Consumer<? super T> consumer);

    <R> R applyTo(Function<? super T, ? extends R> function);

    @FunctionalInterface
    interface Consumer<T> {

        void accept(T[] items);
    }

    @FunctionalInterface
    interface Function<T, R> {

        R apply(T[] items);
    }
}
