package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

final class AppBrandTaskUsageRecorder$LaunchCheckParams implements Parcelable {
    public static final Creator<AppBrandTaskUsageRecorder$LaunchCheckParams> CREATOR = new 1();
    final int iGL;
    final boolean iUn = true;
    final String irG;
    final int jhr;
    final AppBrandInitConfig jxs;
    final AppBrandStatObject jxt;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.jxs, i);
        parcel.writeParcelable(this.jxt, i);
        parcel.writeInt(this.iGL);
        parcel.writeInt(this.jhr);
        parcel.writeString(this.irG);
    }

    public AppBrandTaskUsageRecorder$LaunchCheckParams(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject, int i, int i2, String str) {
        this.jxs = appBrandInitConfig;
        this.jxt = appBrandStatObject;
        this.iGL = i;
        this.jhr = i2;
        this.irG = str;
    }

    AppBrandTaskUsageRecorder$LaunchCheckParams(Parcel parcel) {
        this.jxs = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
        this.jxt = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
        this.iGL = parcel.readInt();
        this.jhr = parcel.readInt();
        this.irG = parcel.readString();
    }
}
