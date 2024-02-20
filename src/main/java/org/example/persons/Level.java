package org.example.persons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Level {
    TOP("TOP")
    ,HIGH("HIGH")
    ,MIDDLE("MIDDLE")
    ,LOW("LOW")
    ;
    private final String value;
}
