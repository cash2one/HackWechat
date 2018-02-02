package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetSysConfig implements Parcelable {
    public static final Creator<WidgetSysConfig> CREATOR = new 1();
    public int iNA;
    public int iNy;
    public int iNz;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iNy);
        parcel.writeInt(this.iNz);
        parcel.writeInt(this.iNA);
    }
}
