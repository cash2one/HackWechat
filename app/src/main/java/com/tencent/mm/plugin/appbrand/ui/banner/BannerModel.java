package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;

final class BannerModel implements Parcelable {
    public static final Creator<BannerModel> CREATOR = new 1();
    private static volatile BannerModel jOG;
    String appId;
    String appName;
    int iKd;
    String iKm;
    String jOF;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.iKd);
        parcel.writeString(this.appName);
        parcel.writeString(this.iKm);
        parcel.writeString(this.jOF);
    }

    BannerModel() {
    }

    private BannerModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.iKd = parcel.readInt();
        this.appName = parcel.readString();
        this.iKm = parcel.readString();
        this.jOF = parcel.readString();
    }

    static BannerModel all() {
        BannerModel alc;
        synchronized (BannerModel.class) {
            alc = ((e) g.h(e.class)).alc();
            jOG = alc;
        }
        return alc;
    }

    static BannerModel alm() {
        BannerModel bannerModel;
        synchronized (BannerModel.class) {
            bannerModel = jOG;
        }
        return bannerModel;
    }
}
