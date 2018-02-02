package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ProductSectionItem$Skus implements Parcelable {
    public static final Creator<ProductSectionItem$Skus> CREATER = new 1();
    public String aAM;
    public String value;

    public ProductSectionItem$Skus(Parcel parcel) {
        this.aAM = parcel.readString();
        this.value = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aAM);
        parcel.writeString(this.value);
    }

    public static String bk(List<ProductSectionItem$Skus> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ProductSectionItem$Skus productSectionItem$Skus = (ProductSectionItem$Skus) list.get(i);
            if (i != 0) {
                stringBuilder.append("、");
            }
            stringBuilder.append(productSectionItem$Skus.value);
        }
        return stringBuilder.toString();
    }
}
