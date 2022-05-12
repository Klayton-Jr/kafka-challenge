package com.croct.event;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class OutputSerde implements Serde<OutputEvent> {

    private JsonSerializer<OutputEvent> serializer;
    private JsonDeserializer<OutputEvent> deserializer;

    public OutputSerde() {
        this.serializer = new JsonSerializer<>(OutputEvent.class);
        this.deserializer = new JsonDeserializer<>(OutputEvent.class);
    }

    public Serializer<OutputEvent> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<OutputEvent> deserializer() {
        return deserializer;
    }

}
