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

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test cases for {@link TTuple} final methods.
 */
final class TTupleTest {

    /**
     * Create anonymous implementation of {@link TTuple}.
     */
    private static TTuple ttuple(Object... items) {
        return new TTuple() {

            @Override
            public Object[] asArray() {
                return items;
            }
        };
    }

    private static Stream<Arguments> asGenericArrayArgs() {
        return Stream.of(
                Arguments.of(
                        new Object[]{},
                        Object[].class
                ),
                Arguments.of(
                        new Object[]{1, "bb", 3},
                        Object[].class
                ),
                Arguments.of(
                        new Object[]{},
                        String[].class
                ),
                Arguments.of(
                        new Object[]{"a", "bb", "ccc"},
                        String[].class
                ),
                Arguments.of(
                        new Integer[]{1, 2, 3},
                        Integer[].class
                ),
                Arguments.of(
                        new Object[]{1.1, 2L, 3},
                        Number[].class
                ),
                Arguments.of(
                        new Object[]{},
                        int[][].class
                ),
                Arguments.of(
                        new Object[]{new int[]{0, 1, 2}, new int[]{3}, new int[]{4, 5}},
                        int[][].class
                )
        );
    }

    @ParameterizedTest(name = "TTuple of {0} converted to {1} array")
    @MethodSource("asGenericArrayArgs")
    <T> void asGenericArray(final Object[] items, final Class<? extends T[]> arrayType) {
        final TTuple tuple = ttuple(items);
        assertThat(tuple.asArray(arrayType))
                .isExactlyInstanceOf(arrayType)
                .isEqualTo(items);
    }

    private static Stream<Arguments> asGenericArrayThrowsExceptionArgs() {
        return Stream.of(
                Arguments.of(
                        new Object[]{1, 2, 3},
                        null,
                        NullPointerException.class
                ),
                Arguments.of(
                        new Object[]{"a", 2, 3},
                        String[].class,
                        ArrayStoreException.class
                )
        );
    }

    @ParameterizedTest(name = "TTuple of {0} converted to {1} array throws {2}")
    @MethodSource("asGenericArrayThrowsExceptionArgs")
    <T> void asGenericArrayThrowsException(final Object[] items, final Class<? extends T[]> arrayType,
                                           final Class<? extends Exception> exceptionType) {
        final TTuple tuple = ttuple(items);
        assertThatThrownBy(() -> tuple.asArray(arrayType))
                .isExactlyInstanceOf(exceptionType);
    }

    private static Stream<Arguments> sameHashCodeArgs() {
        return Stream.of(
                Arguments.of(
                        ttuple(),
                        ttuple()
                ),
                Arguments.of(
                        ttuple(1, "bb", 3),
                        ttuple(1, "bb", 3)
                )
        );
    }

    @ParameterizedTest(name = "TTuple {0} has same hashCode as {1}")
    @MethodSource("sameHashCodeArgs")
    void sameHashCode(final TTuple tuple1, final TTuple tuple2) {
        assertThat(tuple1.hashCode())
                .isEqualTo(tuple2.hashCode());
    }

    private static Stream<Arguments> differentHashCodeArgs() {
        return Stream.of(
                Arguments.of(
                        ttuple(),
                        ttuple(1)
                ),
                Arguments.of(
                        ttuple(1),
                        ttuple(2)
                ),
                Arguments.of(
                        ttuple(1, 2, 3),
                        ttuple(1, 2, "ccc")
                )
        );
    }

    @ParameterizedTest(name = "TTuple {0} has different hashCode than {1}")
    @MethodSource("differentHashCodeArgs")
    void differentHashCode(final TTuple tuple1, final TTuple tuple2) {
        assertThat(tuple1.hashCode())
                .isNotEqualTo(tuple2.hashCode());
    }

    private static Stream<Arguments> isEqualsArgs() {
        return Stream.of(
                Arguments.of(
                        ttuple(),
                        ttuple()
                ),
                Arguments.of(
                        ttuple(),
                        new FakeTuple()
                ),
                Arguments.of(
                        ttuple(1, "bb", 3),
                        ttuple(1, "bb", 3)
                ),
                Arguments.of(
                        ttuple(1, "bb", 3),
                        new FakeTuple(1, "bb", 3)
                )
        );
    }

    @ParameterizedTest(name = "TTuple {0} equals to {1}")
    @MethodSource("isEqualsArgs")
    void isEquals(final TTuple tuple, final Object other) {
        assertThat(tuple)
                .isEqualTo(other);
    }

    private static Stream<Arguments> notEqualsArgs() {
        return Stream.of(
                Arguments.of(
                        ttuple(),
                        ttuple(1)
                ),
                Arguments.of(
                        ttuple(1),
                        ttuple(2)
                ),
                Arguments.of(
                        ttuple(1, 2, 3),
                        ttuple(1, 2, "ccc")
                )
        );
    }

    @ParameterizedTest(name = "TTuple {0} not equals to {1}")
    @MethodSource("notEqualsArgs")
    void notEquals(final TTuple tuple, final Object other) {
        assertThat(tuple)
                .isNotEqualTo(other);
    }

    private static Stream<TTuple> toStringArgs() {
        return Stream.of(
                ttuple(),
                ttuple((Object) null),
                ttuple(1, "a", 2, null, "b")
        );
    }

    @ParameterizedTest(name = "TTuple {0} converted to string")
    @MethodSource("toStringArgs")
    void toString(final TTuple tuple) {
        assertThat(tuple.toString())
                .isNotNull();
    }
}
