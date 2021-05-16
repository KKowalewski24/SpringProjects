package pl.kkowalewski.showroom.model.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum EngineType {

    /*------------------------ FIELDS REGION ------------------------*/
    INLINE4("Inline 4"),
    INLINE6("Inline 6"),
    V6("V6"),
    V8("V8");

    private final String name;

    /*------------------------ METHODS REGION ------------------------*/
    EngineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EngineType fromString(final String text) {
        return Arrays.asList(EngineType.values())
                .stream()
                .filter((it) -> it.getName().equals(text))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<String> getNamesList() {
        return Arrays.asList(EngineType.values())
                .stream()
                .map((it) -> it.getName())
                .collect(Collectors.toList());
    }
}
