package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class WxaAttributes$WxaEntryInfo implements Parcelable {
    public static final Creator<WxaAttributes$WxaEntryInfo> CREATOR = new Creator<WxaAttributes$WxaEntryInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaAttributes$WxaEntryInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaAttributes$WxaEntryInfo[i];
        }
    };
    public String iPE;
    public String iconUrl;
    public String title;
    public String username;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.title);
        parcel.writeString(this.iPE);
        parcel.writeString(this.iconUrl);
    }

    protected WxaAttributes$WxaEntryInfo(Parcel parcel) {
        this.username = parcel.readString();
        this.title = parcel.readString();
        this.iPE = parcel.readString();
        this.iconUrl = parcel.readString();
    }
}
