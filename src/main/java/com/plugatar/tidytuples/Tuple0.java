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
 * Empty tuple.
 */
public interface Tuple0 extends AnyTuple, Iterable<Object> {

    /**
     * Applies {@code consumer} to nothing.
     *
     * @param consumer the consumer that accepts nothing
     * @throws NullPointerException if {@code consumer} is null
     */
    void supplyTo(Consumer consumer);

    /**
     * Applies {@code function} to nothing and returns the {@code function} result.
     *
     * @param function the function that accepts nothing
     * @param <R>      the type of the {@code function} result
     * @return the {@code function} result
     * @throws NullPointerException if {@code function} is null
     */
    <R> R applyTo(Function<? extends R> function);

    /**
     * Represents operation that accepts nothing and returns no result.
     */
    @FunctionalInterface
    interface Consumer {

        /**
         * Performs this operation on nothing.
         */
        void accept();
    }

    /**
     * Represents function that accepts nothing and produces a result.
     *
     * @param <R> the type of the function result
     */
    @FunctionalInterface
    interface Function<R> {

        /**
         * Applies this function to nothing.
         *
         * @return the function result
         */
        R apply();
    }
}
