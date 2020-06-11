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
package com.plugatar.tidytuples.tuple;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test cases for {@link TupleOf0}.
 */
final class TupleOf0Test {

    @Test
    void instance() {
        final TupleOf0 tuple1 = TupleOf0.instance();
        final TupleOf0 tuple2 = TupleOf0.instance();
        assertThat(tuple2)
                .isSameAs(tuple1);
    }

    @Test
    void applyToReturnsResult() {
        final TupleOf0 tuple = TupleOf0.instance();
        final TupleOf0.Function<Integer> function = () -> 0;
        assertThat(tuple.applyTo(function))
                .isEqualTo(0);
    }

    @Test
    void applyToThrowsNPE() {
        final TupleOf0 tuple = TupleOf0.instance();
        assertThatThrownBy(() -> tuple.applyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void supplyToHaveSideEffect() {
        final TupleOf0 tuple = TupleOf0.instance();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final TupleOf0.Consumer consumer = () -> atomicInteger.set(1);
        tuple.supplyTo(consumer);
        assertThat(atomicInteger.get())
                .isEqualTo(1);
    }

    @Test
    void supplyToThrowsNPE() {
        final TupleOf0 tuple = TupleOf0.instance();
        assertThatThrownBy(() -> tuple.supplyTo(null))
                .isExactlyInstanceOf(NullPointerException.class);
    }
}
