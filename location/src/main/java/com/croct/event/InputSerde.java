package com.croct.event;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class InputSerde implements Serde<InputEvent> {

    private JsonSerializer<InputEvent> serializer;
    private JsonDeserializer<InputEvent> deserializer;

    public InputSerde() {
        this.serializer = new JsonSerializer<>(InputEvent.class);
        this.deserializer = new JsonDeserializer<>(InputEvent.class);
    }

    public Serializer<InputEvent> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<InputEvent> deserializer() {
        return deserializer;
    }

}
