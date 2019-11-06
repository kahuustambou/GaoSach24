package com.example.gaosach24h;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
     Long idCategory;
     String name;

    public Product() {
    }

    protected Product(Parcel in) {
        if (in.readByte() == 0) {
            idCategory = null;
        } else {
            idCategory = in.readLong();
        }
        name = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (idCategory == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(idCategory);
        }
        dest.writeString(name);
    }

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
