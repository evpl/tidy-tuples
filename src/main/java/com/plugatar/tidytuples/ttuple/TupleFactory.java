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
import com.plugatar.tidytuples.Tuple0;
import com.plugatar.tidytuples.Tuple1;
import com.plugatar.tidytuples.Tuple10;
import com.plugatar.tidytuples.Tuple2;
import com.plugatar.tidytuples.Tuple3;
import com.plugatar.tidytuples.Tuple4;
import com.plugatar.tidytuples.Tuple5;
import com.plugatar.tidytuples.Tuple6;
import com.plugatar.tidytuples.Tuple7;
import com.plugatar.tidytuples.Tuple8;
import com.plugatar.tidytuples.Tuple9;
import com.plugatar.tidytuples.TupleN;

/**
 * Utility class that contains overloading single static factory method for tuple instantiation.
 */
public final class TupleFactory {

    /**
     * Ctor. Utility class cannot be instantiated.
     */
    private TupleFactory() {
    }

    /**
     * Returns the empty tuple.
     *
     * @return the empty tuple
     * @see TTuple0
     */
    public static Tuple0 tuple() {
        return TTuple0.INSTANCE;
    }

    /**
     * Returns a tuple of the given item.
     *
     * @param i0 the 0th item
     * @return a tuple of 1 item
     * @see TTuple1
     */
    public static <T0> Tuple1<T0> tuple(T0 i0) {
        return new TTuple1<>(i0);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @return a tuple of 2 items
     * @see TTuple2
     */
    public static <T0, T1> Tuple2<T0, T1> tuple(T0 i0, T1 i1) {
        return new TTuple2<>(i0, i1);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @return a tuple of 3 items
     * @see TTuple3
     */
    public static <T0, T1, T2> Tuple3<T0, T1, T2> tuple(T0 i0, T1 i1, T2 i2) {
        return new TTuple3<>(i0, i1, i2);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @return a tuple of 4 items
     * @see TTuple4
     */
    public static <T0, T1, T2, T3> Tuple4<T0, T1, T2, T3> tuple(T0 i0, T1 i1, T2 i2, T3 i3) {
        return new TTuple4<>(i0, i1, i2, i3);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @param i4 the 4th item
     * @return a tuple of 5 items
     * @see TTuple5
     */
    public static <T0, T1, T2, T3, T4> Tuple5<T0, T1, T2, T3, T4> tuple(T0 i0, T1 i1, T2 i2, T3 i3, T4 i4) {
        return new TTuple5<>(i0, i1, i2, i3, i4);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @param i4 the 4th item
     * @param i5 the 5th item
     * @return a tuple of 6 items
     * @see TTuple6
     */
    public static <T0, T1, T2, T3, T4, T5> Tuple6<T0, T1, T2, T3, T4, T5> tuple(T0 i0, T1 i1, T2 i2, T3 i3, T4 i4,
                                                                                T5 i5) {
        return new TTuple6<>(i0, i1, i2, i3, i4, i5);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @param i4 the 4th item
     * @param i5 the 5th item
     * @param i6 the 6th item
     * @return a tuple of 7 items
     * @see TTuple7
     */
    public static <T0, T1, T2, T3, T4, T5, T6> Tuple7<T0, T1, T2, T3, T4, T5, T6> tuple(T0 i0, T1 i1, T2 i2, T3 i3,
                                                                                        T4 i4, T5 i5, T6 i6) {
        return new TTuple7<>(i0, i1, i2, i3, i4, i5, i6);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @param i4 the 4th item
     * @param i5 the 5th item
     * @param i6 the 6th item
     * @param i7 the 7th item
     * @return a tuple of 8 items
     * @see TTuple8
     */
    public static <T0, T1, T2, T3, T4, T5, T6, T7> Tuple8<T0, T1, T2, T3, T4, T5, T6, T7> tuple(
            T0 i0, T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7) {
        return new TTuple8<>(i0, i1, i2, i3, i4, i5, i6, i7);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @param i4 the 4th item
     * @param i5 the 5th item
     * @param i6 the 6th item
     * @param i7 the 7th item
     * @param i8 the 8th item
     * @return a tuple of 9 items
     * @see TTuple9
     */
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8> tuple(
            T0 i0, T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7, T8 i8) {
        return new TTuple9<>(i0, i1, i2, i3, i4, i5, i6, i7, i8);
    }

    /**
     * Returns a tuple of the given items.
     *
     * @param i0 the 0th item
     * @param i1 the 1st item
     * @param i2 the 2nd item
     * @param i3 the 3rd item
     * @param i4 the 4th item
     * @param i5 the 5th item
     * @param i6 the 6th item
     * @param i7 the 7th item
     * @param i8 the 8th item
     * @param i9 the 9th item
     * @return a tuple of 10 items
     * @see TTuple10
     */
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> tuple(
            T0 i0, T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7, T8 i8, T9 i9) {
        return new TTuple10<>(i0, i1, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    /**
     * Returns a tuple of the given items.
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
     * @return a tuple of 10+ items
     * @see TTupleN
     */
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R extends Tuple> TupleN<T0, T1, T2, T3, T4, T5, T6, T7, T8,
            T9, R> tuple(T0 i0, T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7, T8 i8, T9 i9, R rest) {
        return new TTupleN<>(i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, rest);
    }
}
