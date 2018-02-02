package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SnsCmdList$1 implements Creator<SnsCmdList> {
    SnsCmdList$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        SnsCmdList snsCmdList = new SnsCmdList();
        SnsCmdList.a(snsCmdList, parcel.readInt());
        SnsCmdList.a(snsCmdList).clear();
        for (int i2 = 0; i2 < SnsCmdList.b(snsCmdList); i2++) {
            SnsCmdList.a(snsCmdList).add(Integer.valueOf(parcel.readInt()));
        }
        SnsCmdList.b(snsCmdList, parcel.readInt());
        SnsCmdList.c(snsCmdList).clear();
        while (i < SnsCmdList.d(snsCmdList)) {
            SnsCmdList.c(snsCmdList).add(Integer.valueOf(parcel.readInt()));
            i++;
        }
        return snsCmdList;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SnsCmdList[i];
    }
}
