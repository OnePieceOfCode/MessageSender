package com.messanger.dp.model;

public enum MessageRecipientType {

    FACEBOOK( "fb"),
    TWITTER("tw"),
    FAX( "f"),
    INSTAGRAM( "i");

    private final String addressee;

    MessageRecipientType( String addressee) {
        this.addressee = addressee;
    }

    public static MessageRecipientType getByAddressee(String s) {
        MessageRecipientType[] messageRecipientTypes = values();
        for (MessageRecipientType type : messageRecipientTypes) {
            if(type.addressee.equals(s)){
                return type;
            }
        }
        throw new IllegalStateException("Addressee "+ s + " doesn't exist!");
    }
}
