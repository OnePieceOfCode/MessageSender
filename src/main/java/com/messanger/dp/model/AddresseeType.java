package com.messanger.dp.model;

import java.util.Arrays;

public enum AddresseeType {

    FACEBOOK("fb" , "facebook"),
    TWITTER("tw", "twitter"),
    FAX("f", "fax"),
    INSTAGRAM("i", "instagram");

    private String id;
    private String addressee;

    AddresseeType(String id, String addressee) {
        this.id = id;
        this.addressee = addressee;
    }

    public String getId() {
        return id;
    }

    public String getAddressee() {
        return addressee;
    }

    public static String getById(String id) {
        return Arrays.stream(values())
                .filter(addresseeType -> addresseeType.getId().equals(id))
                .findFirst()
                .get()
                .getAddressee();
    }
}
