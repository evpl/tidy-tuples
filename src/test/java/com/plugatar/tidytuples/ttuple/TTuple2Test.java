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

import com.plugatar.tidytuples.Tuple2;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test cases for {@link TTuple2}.
 */
final class TTuple2Test {

    @Test
    void i0() {
        final TTuple2<Integer, Integer> tuple = new TTuple2<>(0, 1);
        assertThat(tuple.i0())
                .isEqualTo(0);
    }

    @Test
    void i1() {
        final TTuple2<Integer, Integer> tuple = new TTuple2<>(0, 1);
        assertThat(tuple.i1())
                .isEqualTo(1);
    }

    @Test
    void asArray() {
        final TTuple2<Integer, Integer> tuple = new TTuple2<>(0, 1);
        assertThat(tuple.asArray())
                .isExactlyInstanceOf(Object[].class)
                .isEqualTo(new Object[]{0, 1});
    }

    @Test
    void supplyTo() {
        final TTuple2<Integer, Integer> tuple = new TTuple2<>(0, 1);
        final AtomicInteger atomicInteger = new AtomicInteger();
        final Tuple2.Consumer<Integer, Integer> consumer = (i0, i1) -> atomicInteger.set(i0 + i1);
        tuple.supplyTo(consumer);
        assertThat(atomicInteger.get())
                .isEqualTo(1);
    }

    @Test
    void supplyToThrowsNPE() {
        final TTuple2<Integer, Integer> tuple = new TTuple2<>(0, 1);
        assertThatThrownBy(() -> tuple.supplyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void applyTo() {
        final TTuple2<Integer, Integer> tuple = new TTuple2<>(0, 1);
        final Tuple2.Function<Integer, Integer, Integer> function = (i0, i1) -> i0 + i1;
        assertThat(tuple.applyTo(function))
                .isEqualTo(1);
    }

    @Test
    void applyToThrowsNPE() {
        final TTuple2<Integer, Integer> tuple = new TTuple2<>(0, 1);
        assertThatThrownBy(() -> tuple.applyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void serialization() {
        final Object result = new SerializationPipeline(new TTuple2<>(0, 1)).result();
        assertThat(result)
                .isExactlyInstanceOf(TTuple2.class)
                .isEqualTo(new TTuple2<>(0, 1));
    }
}
