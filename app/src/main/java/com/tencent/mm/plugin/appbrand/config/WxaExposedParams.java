package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WxaExposedParams implements Parcelable {
    public static final Creator<WxaExposedParams> CREATOR = new 1();
    public String appId;
    public String fCp;
    public String fpL;
    public int fqe;
    public int iGK;
    public int iGL;
    public String iPL;
    public String iPM;
    public String iconUrl;
    public String username;

    private WxaExposedParams(a aVar) {
        this.appId = aVar.appId;
        this.username = aVar.username;
        this.fpL = aVar.fpL;
        this.iconUrl = aVar.iconUrl;
        this.iGK = aVar.iGK;
        this.iGL = aVar.iGL;
        this.iPL = aVar.iPL;
        this.fqe = aVar.fqe;
        this.fCp = aVar.fCp;
        this.iPM = aVar.iPM;
    }

    protected WxaExposedParams(Parcel parcel) {
        this.appId = parcel.readString();
        this.username = parcel.readString();
        this.fpL = parcel.readString();
        this.iconUrl = parcel.readString();
        this.iGK = parcel.readInt();
        this.iGL = parcel.readInt();
        this.iPL = parcel.readString();
        this.fqe = parcel.readInt();
        this.fCp = parcel.readString();
        this.iPM = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.username);
        parcel.writeString(this.fpL);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.iGK);
        parcel.writeInt(this.iGL);
        parcel.writeString(this.iPL);
        parcel.writeInt(this.fqe);
        parcel.writeString(this.fCp);
        parcel.writeString(this.iPM);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.fpL + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.iGK + ", pkgVersion=" + this.iGL + ", pkgMD5='" + this.iPL + '\'' + ", from=" + this.fqe + ", pageId='" + this.fCp + '\'' + ", errorUrl='" + this.iPM + '\'' + '}';
    }
}
