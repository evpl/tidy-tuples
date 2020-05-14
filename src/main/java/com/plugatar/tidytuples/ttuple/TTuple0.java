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

import com.plugatar.tidytuples.Tuple0;

import java.io.Serializable;

/**
 * Simple immutable implementation of the {@link Tuple0}.
 */
public final class TTuple0 extends TTuple implements Tuple0, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Object[] EMPTY_ARRAY = new Object[0];
    /**
     * Exists to reduce the number of identical objects.
     *
     * @see #readResolve()
     * @see TupleFactory#tuple()
     */
    static final TTuple0 INSTANCE = new TTuple0();

    /**
     * Ctor.
     */
    public TTuple0() {
    }

    @Override
    public Object[] asArray() {
        return EMPTY_ARRAY;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
