package com.tencent.mm.plugin.setting.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SwitchAccountModel implements Parcelable {
    public static final Creator<SwitchAccountModel> CREATOR = new Creator<SwitchAccountModel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SwitchAccountModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SwitchAccountModel[i];
        }
    };
    public final String moS;
    public final String qge;
    public final String qgf;
    public final int qgg;
    public final String username;

    public SwitchAccountModel(String str, String str2, String str3, String str4, int i) {
        this.qge = str;
        this.username = str2;
        this.moS = str3;
        this.qgf = str4;
        this.qgg = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.qge);
        parcel.writeString(this.username);
        parcel.writeString(this.moS);
        parcel.writeString(this.qgf);
        parcel.writeInt(this.qgg);
    }
}
