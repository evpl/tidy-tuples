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

/**
 * Tuple of 5 items.
 *
 * @param <T0> the type of the 0th item
 * @param <T1> the type of the 1st item
 * @param <T2> the type of the 2nd item
 * @param <T3> the type of the 3rd item
 * @param <T4> the type of the 4th item
 */
public interface Tuple5<T0, T1, T2, T3, T4> extends Tuple {

    /**
     * Returns the 0th item.
     *
     * @return the 0th item
     */
    T0 i0();

    /**
     * Returns the 1st item.
     *
     * @return the 1st item
     */
    T1 i1();

    /**
     * Returns the 2nd item.
     *
     * @return the 2nd item
     */
    T2 i2();

    /**
     * Returns the 3rd item.
     *
     * @return the 3rd item
     */
    T3 i3();

    /**
     * Returns the 4th item.
     *
     * @return the 4th item
     */
    T4 i4();

    /**
     * Applies {@code consumer} to this tuple items.
     *
     * @param consumer the consumer that accepts this tuple items
     * @throws NullPointerException if {@code consumer} is null
     */
    void supplyTo(Consumer<? super T0, ? super T1, ? super T2, ? super T3, ? super T4> consumer);

    /**
     * Applies {@code function} to this tuple items and returns the {@code function} result.
     *
     * @param function the function that accepts this tuple items
     * @param <R>      the type of the {@code function} result
     * @return the {@code function} result
     * @throws NullPointerException if {@code function} is null
     */
    <R> R applyTo(Function<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function);

    /**
     * Represents operation that accepts 5 items and returns no result.
     *
     * @param <T0> the type of the 0th item
     * @param <T1> the type of the 1st item
     * @param <T2> the type of the 2nd item
     * @param <T3> the type of the 3rd item
     * @param <T4> the type of the 4th item
     */
    @FunctionalInterface
    interface Consumer<T0, T1, T2, T3, T4> {

        /**
         * Performs this operation on the given items.
         *
         * @param i0 the 0th item
         * @param i1 the 1st item
         * @param i2 the 2nd item
         * @param i3 the 3rd item
         * @param i4 the 4th item
         */
        void accept(T0 i0, T1 i1, T2 i2, T3 i3, T4 i4);
    }

    /**
     * Represents function that accepts 5 items and produces a result.
     *
     * @param <T0> the type of the 0th item
     * @param <T1> the type of the 1st item
     * @param <T2> the type of the 2nd item
     * @param <T3> the type of the 3rd item
     * @param <T4> the type of the 4th item
     * @param <R>  the type of the function result
     */
    @FunctionalInterface
    interface Function<T0, T1, T2, T3, T4, R> {

        /**
         * Applies this function to the given items.
         *
         * @param i0 the 0th item
         * @param i1 the 1st item
         * @param i2 the 2nd item
         * @param i3 the 3rd item
         * @param i4 the 4th item
         * @return the function result
         */
        R apply(T0 i0, T1 i1, T2 i2, T3 i3, T4 i4);
    }
}
