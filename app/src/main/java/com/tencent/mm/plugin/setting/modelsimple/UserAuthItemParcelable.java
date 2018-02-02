package com.tencent.mm.plugin.setting.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserAuthItemParcelable implements Parcelable {
    public static final Creator<UserAuthItemParcelable> CREATOR = new 1();
    public String qgh;
    public int qgi;
    public String scope;
    public int state;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.scope);
        parcel.writeString(this.qgh);
        parcel.writeInt(this.state);
        parcel.writeInt(this.qgi);
    }
}
