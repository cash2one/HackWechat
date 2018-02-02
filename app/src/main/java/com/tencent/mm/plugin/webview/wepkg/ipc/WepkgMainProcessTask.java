package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class WepkgMainProcessTask implements Parcelable {
    private static final Set<Object> jbl = new HashSet();
    Messenger jbC;
    int mTaskId;

    public abstract void Yr();

    public void Ys() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void Dn() {
        if (this.jbC != null) {
            Message obtain = Message.obtain();
            obtain.what = this.mTaskId;
            obtain.setData(WepkgMainProcessService.c(this));
            try {
                this.jbC.send(obtain);
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.WepkgMainProcessTask", e.getMessage());
            }
        }
    }

    public final void afi() {
        jbl.add(this);
    }

    public final void afj() {
        jbl.remove(this);
    }
}
