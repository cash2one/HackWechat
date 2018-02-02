package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class RuntimeLoadModuleTask$LoadParams implements Parcelable {
    public static final Creator<RuntimeLoadModuleTask$LoadParams> CREATOR = new 1();
    public final String appId;
    public final int fvM;
    public final String iEF;
    public final int iGL;

    private RuntimeLoadModuleTask$LoadParams(String str, int i, int i2, String str2) {
        this.appId = str;
        this.fvM = i;
        this.iGL = i2;
        this.iEF = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.fvM);
        parcel.writeInt(this.iGL);
        parcel.writeString(this.iEF);
    }

    RuntimeLoadModuleTask$LoadParams(Parcel parcel) {
        this.appId = parcel.readString();
        this.fvM = parcel.readInt();
        this.iGL = parcel.readInt();
        this.iEF = parcel.readString();
    }
}
