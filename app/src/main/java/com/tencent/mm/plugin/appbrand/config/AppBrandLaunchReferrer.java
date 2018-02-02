package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer implements Parcelable {
    public static final Creator<AppBrandLaunchReferrer> CREATOR = new 1();
    public String appId;
    public int fqd;
    public int iOd;
    public String iOe;
    public String url;

    public final String toString() {
        return "AppBrandLaunchReferrer{launchScene=" + this.iOd + ", appId='" + this.appId + '\'' + ", extraData='" + this.iOe + '\'' + ", url='" + this.url + '\'' + ", sourceType='" + this.fqd + '\'' + '}';
    }

    final void g(Parcel parcel) {
        this.iOd = parcel.readInt();
        this.appId = parcel.readString();
        this.iOe = parcel.readString();
        this.url = parcel.readString();
        this.fqd = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iOd);
        parcel.writeString(this.appId);
        parcel.writeString(this.iOe);
        parcel.writeString(this.url);
        parcel.writeInt(this.fqd);
    }

    public final void a(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer != null) {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            appBrandLaunchReferrer.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            g(obtain);
            obtain.recycle();
        }
    }

    public final JSONObject abW() {
        Object jSONObject;
        try {
            jSONObject = new JSONObject(this.iOe);
        } catch (Exception e) {
            jSONObject = this.iOe;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appId", this.appId);
            jSONObject2.put("extraData", jSONObject);
        } catch (Exception e2) {
        }
        return jSONObject2.length() == 0 ? null : jSONObject2;
    }

    public final int describeContents() {
        return 0;
    }

    private AppBrandLaunchReferrer(Parcel parcel) {
        g(parcel);
    }
}
