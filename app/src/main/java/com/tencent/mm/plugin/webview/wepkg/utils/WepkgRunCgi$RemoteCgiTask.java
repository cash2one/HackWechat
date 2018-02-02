package com.tencent.mm.plugin.webview.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;

final class WepkgRunCgi$RemoteCgiTask extends WepkgMainProcessTask implements a {
    public static final Creator<WepkgRunCgi$RemoteCgiTask> CREATOR = new 1();
    private String jcD;
    private int lJY;
    private int lKk;
    public int tOd = 0;
    private b tOe;
    public b tOf;
    public WepkgRunCgi.a tOg;

    public final void Yr() {
        u.a(this.tOf, this, true);
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        this.lKk = i;
        this.lJY = i2;
        this.jcD = str;
        this.tOe = bVar;
        this.tOd = 2;
        Dn();
        return 0;
    }

    public final void Ys() {
        d.bk(this);
        if (this.tOg != null) {
            this.tOg.a(this.lKk, this.lJY, this.jcD, this.tOe);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.tOd);
        switch (this.tOd) {
            case 1:
                WepkgRunCgi.a(this.tOf, parcel);
                return;
            case 2:
                parcel.writeInt(this.lKk);
                parcel.writeInt(this.lJY);
                parcel.writeString(this.jcD);
                WepkgRunCgi.a(this.tOe, parcel);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        super.f(parcel);
        this.tOd = parcel.readInt();
        switch (this.tOd) {
            case 1:
                this.tOf = WepkgRunCgi.k(parcel);
                return;
            case 2:
                this.lKk = parcel.readInt();
                this.lJY = parcel.readInt();
                this.jcD = parcel.readString();
                this.tOe = WepkgRunCgi.k(parcel);
                return;
            default:
                return;
        }
    }

    WepkgRunCgi$RemoteCgiTask(Parcel parcel) {
        f(parcel);
    }
}
