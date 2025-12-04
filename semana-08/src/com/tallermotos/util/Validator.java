package com.tallermotos.util;
import java.util.Set;

public class Validator {

    public static boolean validatePlate(String plate) {
        return plate != null && plate.length() >= 5;
    }

    public static boolean validateId(String idClient) {
        return idClient != null && !idClient.isBlank();
    }

    public static boolean validateTypeService(Set<String> types, String type) {
        return types.contains(type);
    }

}
