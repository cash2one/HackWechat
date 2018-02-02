package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bh;

class MenuDelegate_EnableDebug$SetAppDebugModeTask extends MainProcessTask {
    public static final Creator<MenuDelegate_EnableDebug$SetAppDebugModeTask> CREATOR = new 1();
    public String appId;
    public boolean fqP;

    private MenuDelegate_EnableDebug$SetAppDebugModeTask() {
    }

    public final void Yr() {
        String str = this.appId;
        boolean z = this.fqP;
        if (!bh.ov(str) && f.Zl() != null) {
            f.Zl().aV(str + "_AppDebugEnabled", String.valueOf(z));
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.fqP = parcel.readByte() != (byte) 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByte(this.fqP ? (byte) 1 : (byte) 0);
    }
}
