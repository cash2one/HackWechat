package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask implements Parcelable {
    private static final Set<Object> jbB = new HashSet();
    Messenger jbC;
    public String jbo = (Process.myPid() + hashCode());

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

    public final boolean afp() {
        if (this.jbC == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.setData(AppBrandMainProcessService.a(this, false));
        try {
            this.jbC.send(obtain);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void afi() {
        jbB.add(this);
    }

    public final void afj() {
        jbB.remove(this);
    }
}
