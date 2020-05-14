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

import com.plugatar.tidytuples.Tuple6;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test cases for {@link TTuple6}.
 */
final class TTuple6Test {

    @Test
    void i0() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThat(tuple.i0())
                .isEqualTo(0);
    }

    @Test
    void i1() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThat(tuple.i1())
                .isEqualTo(1);
    }

    @Test
    void i2() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThat(tuple.i2())
                .isEqualTo(2);
    }

    @Test
    void i3() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThat(tuple.i3())
                .isEqualTo(3);
    }

    @Test
    void i4() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThat(tuple.i4())
                .isEqualTo(4);
    }

    @Test
    void i5() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThat(tuple.i5())
                .isEqualTo(5);
    }

    @Test
    void asArray() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThat(tuple.asArray())
                .isExactlyInstanceOf(Object[].class)
                .isEqualTo(new Object[]{0, 1, 2, 3, 4, 5});
    }

    @Test
    void supplyTo() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        final AtomicInteger atomicInteger = new AtomicInteger();
        final Tuple6.Consumer<Integer, Integer, Integer, Integer, Integer, Integer> consumer =
                (i0, i1, i2, i3, i4, i5) -> atomicInteger.set(i0 + i1 + i2 + i3 + i4 + i5);
        tuple.supplyTo(consumer);
        assertThat(atomicInteger.get())
                .isEqualTo(15);
    }

    @Test
    void supplyToThrowsNPE() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> tuple.supplyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void applyTo() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        final Tuple6.Function<Integer, Integer, Integer, Integer, Integer, Integer, Integer> function =
                (i0, i1, i2, i3, i4, i5) -> i0 + i1 + i2 + i3 + i4 + i5;
        assertThat(tuple.applyTo(function))
                .isEqualTo(15);
    }

    @Test
    void applyToThrowsNPE() {
        final TTuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple = new TTuple6<>(0, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> tuple.applyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void serialization() {
        final Object result = new SerializationPipeline(new TTuple6<>(0, 1, 2, 3, 4, 5)).result();
        assertThat(result)
                .isExactlyInstanceOf(TTuple6.class)
                .isEqualTo(new TTuple6<>(0, 1, 2, 3, 4, 5));
    }
}
