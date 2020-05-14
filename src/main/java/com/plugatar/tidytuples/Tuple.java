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
package com.plugatar.tidytuples;

/**
 * Representation of the tuple concept.
 */
public interface Tuple {

    /**
     * Collect this tuple items to the ordered by index {@code Object[]} type array.
     *
     * @return the ordered array of this tuple items
     */
    Object[] asArray();

    /**
     * Collect this tuple items to the ordered by index specific type array.
     *
     * @param arrayType the {@code Class} object representing the type of the array
     * @param <T>       the component type of the array
     * @return the ordered array of this tuple items
     * @throws ArrayStoreException  if one of this tuple items has incompatible to {@code arrayType} type
     * @throws NullPointerException if {@code arrayType} is null
     */
    <T> T[] asArray(Class<? extends T[]> arrayType);
}
