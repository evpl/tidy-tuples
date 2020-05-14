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
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for {@link TupleFactory} overloading static factory method.
 */
final class TupleFactoryTest {

    @Test
    void tuple0() {
        final Tuple0 firstTuple = TupleFactory.tuple();
        assertThat(firstTuple)
                .isExactlyInstanceOf(TTuple0.class)
                .isEqualTo(new TTuple0());
        final Tuple0 secondTuple = TupleFactory.tuple();
        assertThat(secondTuple)
                .isSameAs(firstTuple);
    }

    @Test
    void tuple1() {
        final Tuple1<Integer> tuple = TupleFactory.tuple(0);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple1.class)
                .isEqualTo(new TTuple1<>(0));
    }

    @Test
    void tuple2() {
        final Tuple2<Integer, Integer> tuple = TupleFactory.tuple(0, 1);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple2.class)
                .isEqualTo(new TTuple2<>(0, 1));
    }

    @Test
    void tuple3() {
        final Tuple3<Integer, Integer, Integer> tuple = TupleFactory.tuple(0, 1, 2);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple3.class)
                .isEqualTo(new TTuple3<>(0, 1, 2));
    }

    @Test
    void tuple4() {
        final Tuple4<Integer, Integer, Integer, Integer> tuple = TupleFactory.tuple(0, 1, 2, 3);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple4.class)
                .isEqualTo(new TTuple4<>(0, 1, 2, 3));
    }

    @Test
    void tuple5() {
        final Tuple5<Integer, Integer, Integer, Integer, Integer> tuple = TupleFactory.tuple(0, 1, 2, 3, 4);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple5.class)
                .isEqualTo(new TTuple5<>(0, 1, 2, 3, 4));
    }

    @Test
    void tuple6() {
        final Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = TupleFactory.tuple(0, 1, 2, 3, 4, 5);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple6.class)
                .isEqualTo(new TTuple6<>(0, 1, 2, 3, 4, 5));
    }

    @Test
    void tuple7() {
        final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                TupleFactory.tuple(0, 1, 2, 3, 4, 5, 6);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple7.class)
                .isEqualTo(new TTuple7<>(0, 1, 2, 3, 4, 5, 6));
    }

    @Test
    void tuple8() {
        final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                TupleFactory.tuple(0, 1, 2, 3, 4, 5, 6, 7);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple8.class)
                .isEqualTo(new TTuple8<>(0, 1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    void tuple9() {
        final Tuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                TupleFactory.tuple(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple9.class)
                .isEqualTo(new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8));
    }

    @Test
    void tuple10() {
        final Tuple10<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                TupleFactory.tuple(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(tuple)
                .isExactlyInstanceOf(TTuple10.class)
                .isEqualTo(new TTuple10<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    void tupleN() {
        final Tuple rest = new FakeTuple(10, 11);
        final TupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = TupleFactory.tuple(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, rest);
        assertThat(tuple)
                .isExactlyInstanceOf(TTupleN.class)
                .isEqualTo(new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, rest));
    }
}
