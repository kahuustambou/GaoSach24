package com.example.gaosach24h.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Category {
    private Long idCategory;
    private String name;

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
