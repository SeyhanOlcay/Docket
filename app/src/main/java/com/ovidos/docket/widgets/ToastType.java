package com.ovidos.docket.widgets;

/**
 * Created by omral on 11.05.2017.
 */

public enum ToastType {
    generalError(0), infoForFavorites(1), generalSuccess(2), generalWarning(3);

    private int value;

    ToastType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
