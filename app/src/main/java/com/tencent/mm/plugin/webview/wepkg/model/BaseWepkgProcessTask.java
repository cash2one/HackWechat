package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;

public abstract class BaseWepkgProcessTask extends WepkgMainProcessTask {
    public boolean fnI = false;

    public abstract void j(Parcel parcel);

    public abstract void v(Parcel parcel, int i);

    public final void f(Parcel parcel) {
        this.fnI = parcel.readByte() != (byte) 0;
        j(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.fnI ? 1 : 0));
        v(parcel, i);
    }
}
