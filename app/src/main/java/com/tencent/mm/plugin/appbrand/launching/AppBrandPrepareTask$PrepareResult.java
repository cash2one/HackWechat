package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;

final class AppBrandPrepareTask$PrepareResult implements Parcelable {
    public static final Creator<AppBrandPrepareTask$PrepareResult> CREATOR = new 1();
    private AppBrandSysConfig iqx;
    private int jxo;
    private AppBrandLaunchErrorAction jxp;
    private int jxq;
    private a jxr;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jxo);
        parcel.writeParcelable(this.jxp, i);
        parcel.writeParcelable(this.iqx, i);
        parcel.writeInt(this.jxq);
        if (this.jxo == 5) {
            parcel.writeString(this.jxr.toString());
        }
    }

    AppBrandPrepareTask$PrepareResult() {
    }

    AppBrandPrepareTask$PrepareResult(Parcel parcel) {
        this.jxo = parcel.readInt();
        this.jxp = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
        this.iqx = (AppBrandSysConfig) parcel.readParcelable(AppBrandSysConfig.class.getClassLoader());
        this.jxq = parcel.readInt();
        if (this.jxo == 5) {
            this.jxr = a.sN(parcel.readString());
        }
    }
}
