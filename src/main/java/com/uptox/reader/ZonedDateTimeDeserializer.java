package com.uptox.reader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

class ZonedDateTimeDeserializer implements JsonDeserializer<ZonedDateTime> {
    private static int nanosInSeconds = 1000000000;

    @Override
    public ZonedDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Long seconds = Long.valueOf(jsonElement.getAsString()) / nanosInSeconds;
        Long nanos = Long.valueOf(jsonElement.getAsString()) % nanosInSeconds;
        Instant i = Instant.ofEpochSecond(seconds, nanos);
        return ZonedDateTime.ofInstant(i, ZoneOffset.UTC);
    }
}
