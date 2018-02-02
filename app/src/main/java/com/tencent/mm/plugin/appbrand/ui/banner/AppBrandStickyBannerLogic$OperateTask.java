package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;

final class AppBrandStickyBannerLogic$OperateTask extends MainProcessTask {
    public static final Creator<AppBrandStickyBannerLogic$OperateTask> CREATOR = new 1();
    boolean jOx;
    int jOy;
    String jOz;
    String joe;
    int op = 0;

    AppBrandStickyBannerLogic$OperateTask() {
    }

    public final void Yr() {
        switch (this.op) {
            case 1:
                this.jOx = b.aM(this.joe, this.jOy);
                afp();
                return;
            case 2:
                b.b(this);
                return;
            case 3:
                b.aN(this.joe, this.jOy);
                return;
            default:
                return;
        }
    }

    static AppBrandStickyBannerLogic$OperateTask p(String str, int i, String str2) {
        AppBrandStickyBannerLogic$OperateTask appBrandStickyBannerLogic$OperateTask = new AppBrandStickyBannerLogic$OperateTask();
        appBrandStickyBannerLogic$OperateTask.op = 2;
        appBrandStickyBannerLogic$OperateTask.joe = str;
        appBrandStickyBannerLogic$OperateTask.jOy = i;
        appBrandStickyBannerLogic$OperateTask.jOz = str2;
        return appBrandStickyBannerLogic$OperateTask;
    }

    static AppBrandStickyBannerLogic$OperateTask aO(String str, int i) {
        AppBrandStickyBannerLogic$OperateTask appBrandStickyBannerLogic$OperateTask = new AppBrandStickyBannerLogic$OperateTask();
        appBrandStickyBannerLogic$OperateTask.op = 3;
        appBrandStickyBannerLogic$OperateTask.joe = str;
        appBrandStickyBannerLogic$OperateTask.jOy = i;
        return appBrandStickyBannerLogic$OperateTask;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.op);
        parcel.writeByte(this.jOx ? (byte) 1 : (byte) 0);
        parcel.writeString(this.joe);
        parcel.writeInt(this.jOy);
        parcel.writeString(this.jOz);
    }

    public final void f(Parcel parcel) {
        this.op = parcel.readInt();
        this.jOx = parcel.readByte() != (byte) 0;
        this.joe = parcel.readString();
        this.jOy = parcel.readInt();
        this.jOz = parcel.readString();
    }
}
