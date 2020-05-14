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

import com.plugatar.tidytuples.Tuple9;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test cases for {@link TTuple9}.
 */
final class TTuple9Test {

    @Test
    void i0() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i0())
                .isEqualTo(0);
    }

    @Test
    void i1() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i1())
                .isEqualTo(1);
    }

    @Test
    void i2() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i2())
                .isEqualTo(2);
    }

    @Test
    void i3() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i3())
                .isEqualTo(3);
    }

    @Test
    void i4() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i4())
                .isEqualTo(4);
    }

    @Test
    void i5() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i5())
                .isEqualTo(5);
    }

    @Test
    void i6() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i6())
                .isEqualTo(6);
    }

    @Test
    void i7() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i7())
                .isEqualTo(7);
    }

    @Test
    void i8() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.i8())
                .isEqualTo(8);
    }

    @Test
    void asArray() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.asArray())
                .isExactlyInstanceOf(Object[].class)
                .isEqualTo(new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    void supplyTo() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        final AtomicInteger atomicInteger = new AtomicInteger();
        final Tuple9.Consumer<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>
                consumer = (i0, i1, i2, i3, i4, i5, i6, i7, i8)
                -> atomicInteger.set(i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8);
        tuple.supplyTo(consumer);
        assertThat(atomicInteger.get())
                .isEqualTo(36);
    }

    @Test
    void supplyToThrowsNPE() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThatThrownBy(() -> tuple.supplyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void applyTo() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        final Tuple9.Function<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>
                function = (i0, i1, i2, i3, i4, i5, i6, i7, i8) -> i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
        assertThat(tuple.applyTo(function))
                .isEqualTo(36);
    }

    @Test
    void applyToThrowsNPE() {
        final TTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple =
                new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThatThrownBy(() -> tuple.applyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void serialization() {
        final Object result = new SerializationPipeline(new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8)).result();
        assertThat(result)
                .isExactlyInstanceOf(TTuple9.class)
                .isEqualTo(new TTuple9<>(0, 1, 2, 3, 4, 5, 6, 7, 8));
    }
}