package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SnsTagList$1 implements Creator<SnsTagList> {
    SnsTagList$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        SnsTagList snsTagList = new SnsTagList();
        SnsTagList.a(snsTagList, parcel.readInt());
        for (int i = 0; i < SnsTagList.a(snsTagList); i++) {
            SnsTagList.b(snsTagList).add(Long.valueOf(parcel.readLong()));
        }
        return snsTagList;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SnsTagList[i];
    }
}
