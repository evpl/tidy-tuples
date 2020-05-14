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
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for {@link TTupleN}.
 */
final class TTupleNTest {

    /**
     * Create implementation of {@link FakeTuple} with two items: 10, 11.
     */
    private static Tuple fakeTuple() {
        return new FakeTuple(10, 11);
    }

    @Test
    void i0() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i0())
                .isEqualTo(0);
    }

    @Test
    void i1() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i1())
                .isEqualTo(1);
    }

    @Test
    void i2() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i2())
                .isEqualTo(2);
    }

    @Test
    void i3() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i3())
                .isEqualTo(3);
    }

    @Test
    void i4() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i4())
                .isEqualTo(4);
    }

    @Test
    void i5() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i5())
                .isEqualTo(5);
    }

    @Test
    void i6() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i6())
                .isEqualTo(6);
    }

    @Test
    void i7() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i7())
                .isEqualTo(7);
    }

    @Test
    void i8() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i8())
                .isEqualTo(8);
    }

    @Test
    void i9() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.i9())
                .isEqualTo(9);
    }

    @Test
    void rest() {
        final Tuple rest = fakeTuple();
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, rest);
        assertThat(tuple.rest())
                .isEqualTo(rest);
    }

    @Test
    void asArray() {
        final TTupleN<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Tuple>
                tuple = new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple());
        assertThat(tuple.asArray())
                .isExactlyInstanceOf(Object[].class)
                .isEqualTo(new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
    }

    @Test
    void serialization() {
        final Object result = new SerializationPipeline(
                new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple())
        ).result();
        assertThat(result)
                .isExactlyInstanceOf(TTupleN.class)
                .isEqualTo(
                        new TTupleN<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, fakeTuple())
                );
    }
}
