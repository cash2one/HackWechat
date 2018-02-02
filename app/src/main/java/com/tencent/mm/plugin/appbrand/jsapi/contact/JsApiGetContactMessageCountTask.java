package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.h;

class JsApiGetContactMessageCountTask extends MainProcessTask {
    public static final Creator<JsApiGetContactMessageCountTask> CREATOR = new 1();
    public int fnm;
    public Runnable jcI;
    public String username;

    public JsApiGetContactMessageCountTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        aj WY = ((h) g.h(h.class)).Fd().WY(this.username);
        if (WY == null) {
            this.fnm = -1;
            afp();
            return;
        }
        this.fnm = WY.field_unReadCount;
        afp();
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        this.username = parcel.readString();
        this.fnm = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.fnm);
    }
}
