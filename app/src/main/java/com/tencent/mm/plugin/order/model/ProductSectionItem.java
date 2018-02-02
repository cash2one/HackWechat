package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem implements Parcelable {
    public static final Creator<ProductSectionItem> CREATER = new 1();
    public int count;
    public String iconUrl;
    public String jumpUrl;
    public String name;
    public List<Skus> pbM;
    public String pbN;
    public String pbO;
    public int scene;

    public ProductSectionItem(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.pbM = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Skus skus = new Skus();
                skus.aAM = parcel.readString();
                skus.value = parcel.readString();
                this.pbM.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.pbN = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.pbO = parcel.readString();
        this.scene = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.pbM != null) {
            parcel.writeInt(this.pbM.size());
            for (int i2 = 0; i2 < this.pbM.size(); i2++) {
                Skus skus = (Skus) this.pbM.get(i2);
                parcel.writeString(skus.aAM);
                parcel.writeString(skus.value);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.pbN);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.pbO);
        parcel.writeInt(this.scene);
    }
}
