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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class SerializationPipeline {
    private final Object object;

    /**
     * Ctor.
     */
    SerializationPipeline(Object object) {
        this.object = object;
    }

    /**
     * Serialize and deserialize object and returns result.
     *
     * @return the deserialization result
     * @throws RuntimeException if it fails to serialize or deserialize object
     */
    public Object result() {
        final byte[] bytes;
        try (
                ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
                ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput)
        ) {
            objectOutput.writeObject(object);
            bytes = byteOutput.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        try (
                ByteArrayInputStream byteInput = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInput = new ObjectInputStream(byteInput)
        ) {
            return objectInput.readObject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
