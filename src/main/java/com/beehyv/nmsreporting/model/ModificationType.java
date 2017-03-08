package com.beehyv.nmsreporting.model;

/**
 * Created by beehyv on 28/2/17.
 */
public enum ModificationType {
    CREATE("CREATION"),
    UPDATE("UPDATION"),
    DELETE("DELETION");

    private String modificationType;

    private ModificationType(String modificationType) {
        this.modificationType = modificationType;
    }

    public String getModificationType() {
        return modificationType;
    }
}
