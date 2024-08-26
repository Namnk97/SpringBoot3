package com.example.booking_online.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrackingContextEnum {

    LANG("LANG", "LANG");
    private final String headerKey;
    private final String threadKey;
}
