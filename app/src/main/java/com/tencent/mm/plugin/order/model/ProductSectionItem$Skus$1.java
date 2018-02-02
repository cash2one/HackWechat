package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;

class ProductSectionItem$Skus$1 implements Creator<Skus> {
    ProductSectionItem$Skus$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Skus(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Skus[i];
    }
}
