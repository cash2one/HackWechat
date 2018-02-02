package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class LaunchParcel implements Parcelable {
    public static final Creator<LaunchParcel> CREATOR = new Creator<LaunchParcel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LaunchParcel(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParcel[i];
        }
    };
    public String appId;
    public int iKd;
    public String iNW;
    public AppBrandLaunchReferrer iNZ;
    public AppBrandStatObject jyP;
    public LaunchParamsOptional jyQ;
    public String username;
    public int version;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.version);
        parcel.writeInt(this.iKd);
        parcel.writeString(this.iNW);
        parcel.writeParcelable(this.jyP, i);
        parcel.writeParcelable(this.iNZ, i);
        parcel.writeParcelable(this.jyQ, i);
    }

    private LaunchParcel(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readInt();
        this.iKd = parcel.readInt();
        this.iNW = parcel.readString();
        this.jyP = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
        this.iNZ = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.jyQ = (LaunchParamsOptional) parcel.readParcelable(LaunchParamsOptional.class.getClassLoader());
    }

    public final void b(AppBrandInitConfig appBrandInitConfig) {
        String str = null;
        if (appBrandInitConfig != null) {
            appBrandInitConfig.username = this.username;
            appBrandInitConfig.iNW = a.px(this.iNW);
            appBrandInitConfig.iNZ.a(this.iNZ);
            appBrandInitConfig.hjz = this.jyQ == null ? null : this.jyQ.hjz;
            if (this.jyQ != null) {
                str = this.jyQ.hjA;
            }
            appBrandInitConfig.hjA = str;
        }
    }
}
