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

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for {@link TTuple0}.
 */
final class TTuple0Test {

    @Test
    void asArray() {
        final TTuple0 tuple = new TTuple0();
        assertThat(tuple.asArray())
                .isExactlyInstanceOf(Object[].class)
                .isEmpty();
    }

    @Test
    void serialization() {
        final Object firstResult = new SerializationPipeline(new TTuple0()).result();
        assertThat(firstResult)
                .isExactlyInstanceOf(TTuple0.class)
                .isEqualTo(new TTuple0());
        final Object secondResult = new SerializationPipeline(new TTuple0()).result();
        assertThat(secondResult)
                .isSameAs(firstResult);
    }
}
