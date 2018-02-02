package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class AppBrandPreInitTask extends MainProcessTask {
    public static final Creator<AppBrandPreInitTask> CREATOR = new Creator<AppBrandPreInitTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandPreInitTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPreInitTask[i];
        }
    };
    private String appId;
    private int iKd;
    private transient a jwP;
    private AppBrandInitConfig jwQ;
    private AppBrandStatObject jwR;

    public AppBrandPreInitTask(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.appId = str;
        this.iKd = i;
        this.jwR = appBrandStatObject;
        this.jwP = aVar;
    }

    public final void Ys() {
        if (this.jwP != null) {
            this.jwP.a(this.jwQ);
        }
        afj();
    }

    public final void Yr() {
        c.Dm().F(new c(this.appId, this.iKd, this.jwR, new 1(this)));
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.iKd);
        parcel.writeParcelable(this.jwQ, i);
        parcel.writeParcelable(this.jwR, i);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.iKd = parcel.readInt();
        this.jwQ = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
        this.jwR = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
    }

    private AppBrandPreInitTask(Parcel parcel) {
        f(parcel);
    }
}
