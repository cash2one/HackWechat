package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiGetStorageTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageTask> CREATOR = new 1();
    public String aAM;
    public String appId;
    public Runnable jcI;
    private boolean jrt;
    private int jru;
    private int jrv;
    private int jrw;
    public String type;
    public String value;

    public final void Yr() {
        c Zg = f.Zg();
        if (Zg == null) {
            afp();
            return;
        }
        Object[] aL = Zg.aL(this.appId, this.aAM);
        if (((a) aL[0]) == a.iHz) {
            if (k.i(new String[]{(String) aL[1], (String) aL[2]}) > 102400) {
                this.jrv = k.i(new String[]{(String) aL[1]});
                this.jrw = k.i(new String[]{r1});
                try {
                    k.g(this.jbo, new String[]{r0, r1});
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                }
                this.jrt = true;
            } else {
                this.jrt = false;
                this.value = r0;
                this.type = r1;
            }
        }
        afp();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ys() {
        if (this.jrt) {
            try {
                String sL = k.sL(this.jbo);
                if (sL.length() == this.jrv + this.jrw) {
                    this.value = sL.substring(0, this.jrv);
                    this.type = sL.substring(this.jrv, this.jrv + this.jrw);
                }
                k.sM(this.jbo);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
            } catch (Throwable th) {
                k.sM(this.jbo);
            }
        }
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.jrt = parcel.readByte() != (byte) 0;
        this.jru = parcel.readInt();
        this.jrv = parcel.readInt();
        this.jrw = parcel.readInt();
        this.aAM = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByte(this.jrt ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.jru);
        parcel.writeInt(this.jrv);
        parcel.writeInt(this.jrw);
        parcel.writeString(this.aAM);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
    }
}
