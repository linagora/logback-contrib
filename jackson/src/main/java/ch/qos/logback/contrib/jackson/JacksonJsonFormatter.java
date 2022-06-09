/**
 * Copyright (C) 2016, The logback-contrib developers. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.contrib.jackson;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import ch.qos.logback.contrib.json.JsonFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson-specific implementation of the {@link JsonFormatter}.
 *
 * @author Les Hazlewood
 * @since 0.1
 */
public class JacksonJsonFormatter implements JsonFormatter {
    private ObjectMapper objectMapper;
    private boolean prettyPrint;

    public JacksonJsonFormatter() {
        this.objectMapper = new ObjectMapper();
        this.prettyPrint = false;
    }

    @Override
    public String toJsonString(Map m) throws IOException {
        if (isPrettyPrint()) {
            return this.objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(m);
        }
        return this.objectMapper.writeValueAsString(m);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
    }
}

