package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class StIDKeyDataInfo implements Parcelable {
    public static final Creator<StIDKeyDataInfo> CREATOR = new Creator<StIDKeyDataInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new StIDKeyDataInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StIDKeyDataInfo[i];
        }
    };
    public long key;
    public boolean pQh;
    public long pRd;
    public long value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.pRd);
        parcel.writeLong(this.key);
        parcel.writeLong(this.value);
        parcel.writeInt(this.pQh ? 1 : 0);
    }

    protected StIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        this.pRd = parcel.readLong();
        this.key = parcel.readLong();
        this.value = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.pQh = z;
    }
}
