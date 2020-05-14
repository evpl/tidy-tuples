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
 * Tuple of 10+ items.
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
public interface TupleN<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R extends Tuple> extends Tuple {

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
     * Returns the 5th item.
     *
     * @return the 5th item
     */
    T5 i5();

    /**
     * Returns the 6th item.
     *
     * @return the 6th item
     */
    T6 i6();

    /**
     * Returns the 7th item.
     *
     * @return the 7th item
     */
    T7 i7();

    /**
     * Returns the 8th item.
     *
     * @return the 8th item
     */
    T8 i8();

    /**
     * Returns the 9th item.
     *
     * @return the 9th item
     */
    T9 i9();

    /**
     * Returns the rest items tuple.
     *
     * @return the rest items tuple
     */
    R rest();
}
