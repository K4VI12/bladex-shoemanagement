package com.shoes.bladex.utill;

public enum Role {
    ADMIN,USER;
    public static Role fromString(String text) {
        if (text != null) {
            for (Role role : Role.values()) {
                if (text.equalsIgnoreCase(role.name())) {
                    return role;
                }
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in Role enum");
    }
}
