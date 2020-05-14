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

import com.plugatar.tidytuples.Tuple1;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test cases for {@link TTuple1}.
 */
final class TTuple1Test {

    @Test
    void i0() {
        final TTuple1<Integer> tuple = new TTuple1<>(0);
        assertThat(tuple.i0())
                .isEqualTo(0);
    }

    @Test
    void asArray() {
        final TTuple1<Integer> tuple = new TTuple1<>(0);
        assertThat(tuple.asArray())
                .isExactlyInstanceOf(Object[].class)
                .isEqualTo(new Object[]{0});
    }

    @Test
    void supplyTo() {
        final TTuple1<Integer> tuple = new TTuple1<>(0);
        final AtomicInteger atomicInteger = new AtomicInteger();
        final Tuple1.Consumer<Integer> consumer = i0 -> atomicInteger.set(i0 + 1);
        tuple.supplyTo(consumer);
        assertThat(atomicInteger.get())
                .isEqualTo(1);
    }

    @Test
    void supplyToThrowsNPE() {
        final TTuple1<Integer> tuple = new TTuple1<>(0);
        assertThatThrownBy(() -> tuple.supplyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void applyTo() {
        final TTuple1<Integer> tuple = new TTuple1<>(0);
        final Tuple1.Function<Integer, Integer> function = i0 -> i0 + 1;
        assertThat(tuple.applyTo(function))
                .isEqualTo(1);
    }

    @Test
    void applyToThrowsNPE() {
        final TTuple1<Integer> tuple = new TTuple1<>(0);
        assertThatThrownBy(() -> tuple.applyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void serialization() {
        final Object result = new SerializationPipeline(new TTuple1<>(0)).result();
        assertThat(result)
                .isExactlyInstanceOf(TTuple1.class)
                .isEqualTo(new TTuple1<>(0));
    }
}
