package com.ovidos.docket.network.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by omral on 11.05.2017.
 */

public class GsonUTCDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private final DateFormat deserializeDateFormat;
    private final DateFormat serializeDateFormat;

    public GsonUTCDateAdapter() {
        deserializeDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS", Locale.getDefault());
        deserializeDateFormat.setTimeZone(TimeZone.getDefault());

        serializeDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS", Locale.getDefault());
        serializeDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-00:00"));

    }

    @Override
    public synchronized Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return deserializeDateFormat.parse(json.getAsString());
        } catch (ParseException pe) {
            return null;
            //throw new JsonParseException(pe);
        }
    }

    @Override
    public synchronized JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(serializeDateFormat.format(src));
    }
}
