package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import java.util.Locale;

final class AppBrandPrepareTask$PrepareParams implements Parcelable {
    public static final Creator<AppBrandPrepareTask$PrepareParams> CREATOR = new 1();
    private boolean jwY;
    private int jxh;
    private int jxi;
    private String jxj;
    private int jxk;
    private AppBrandLaunchReferrer jxl;
    private String jxm;
    private int jxn;
    private String mAppId;

    public final String toShortString() {
        return String.format(Locale.US, "[%s|%d]", new Object[]{this.mAppId, Integer.valueOf(this.jxk)});
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jxh);
        parcel.writeInt(this.jxi);
        parcel.writeString(this.jxj);
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.jxk);
        parcel.writeParcelable(this.jxl, i);
        parcel.writeString(this.jxm);
        parcel.writeInt(this.jxn);
        parcel.writeInt(this.jwY ? 1 : 0);
    }

    AppBrandPrepareTask$PrepareParams() {
    }

    AppBrandPrepareTask$PrepareParams(Parcel parcel) {
        this.jxh = parcel.readInt();
        this.jxi = parcel.readInt();
        this.jxj = parcel.readString();
        this.mAppId = parcel.readString();
        this.jxk = parcel.readInt();
        this.jxl = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.jxm = parcel.readString();
        this.jxn = parcel.readInt();
        this.jwY = parcel.readInt() == 1;
    }
}
