package com.croct.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@Value
@Builder
@Jacksonized
public class OutputEvent {
    Long clienteId;
    Long timeStamp;
    String ip;
    Double latitude;
    Double longitude;
    String country;
    String region;
    String city;

}
