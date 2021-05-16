package pl.kkowalewski.showroom.model.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BrandType {

    /*------------------------ FIELDS REGION ------------------------*/
    AUDI("Audi"),
    BMW("BMW"),
    VOLKSWAGEN("Volkswagen"),
    PORSCHE("Porsche");

    private final String name;

    /*------------------------ METHODS REGION ------------------------*/
    BrandType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static BrandType fromString(final String text) {
        return Arrays.asList(BrandType.values())
                .stream()
                .filter((it) -> it.getName().equals(text))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<String> getNamesList() {
        return Arrays.asList(BrandType.values())
                .stream()
                .map((it) -> it.getName())
                .collect(Collectors.toList());
    }
}
