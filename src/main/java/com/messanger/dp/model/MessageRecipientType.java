package com.messanger.dp.model;

import java.util.Arrays;

public enum MessageRecipientType {

    FACEBOOK(0, "fb"),
    TWITTER(1, "tw"),
    FAX(2, "f"),
    INSTAGRAM(3, "i");

    private final Integer id;
    private final String addressee;

    MessageRecipientType(Integer id, String addressee) {
        this.id = id;
        this.addressee = addressee;
    }

    public Integer getId() {
        return id;
    }

    public String getAddressee() {
        return addressee;
    }

    public static String getAddresseeById(int id) {
        return Arrays.stream(values())
                .filter(addresseeType -> addresseeType.getId().equals(id))
                .findFirst()
                .get()
                .getAddressee();
    }
}
