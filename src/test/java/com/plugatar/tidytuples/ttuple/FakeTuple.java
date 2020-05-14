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

import java.io.Serializable;
import java.util.Arrays;

/**
 * Serializable fake {@link Tuple}.
 */
final class FakeTuple implements Tuple, Serializable {
    private final Object[] items;

    /**
     * Ctor.
     */
    FakeTuple(Object... items) {
        this.items = items;
    }

    @Override
    public Object[] asArray() {
        return items;
    }

    @Override
    public <T> T[] asArray(Class<? extends T[]> arrayType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "FakeTuple" + Arrays.toString(items);
    }
}
