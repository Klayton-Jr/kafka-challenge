package com.croct.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

@AllArgsConstructor
@Value
@Builder
@Jacksonized
public class InputEvent {
    Long clienteId;
    String ip;
    Long timeStamp;
}
