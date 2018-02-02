package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiSetStorageTask extends MainProcessTask {
    public static final Creator<JsApiSetStorageTask> CREATOR = new 1();
    private String aAM;
    public String appId;
    public Runnable jcI;
    private boolean jrt;
    private int jru;
    private int jrv;
    private int jrw;
    public String result;
    private String type;
    private String value;

    JsApiSetStorageTask() {
    }

    public final void A(String str, String str2, String str3) {
        if (k.i(new String[]{str, str2, str3}) > 102400) {
            this.jru = k.i(new String[]{str});
            this.jrv = k.i(new String[]{str2});
            this.jrw = k.i(new String[]{str3});
            try {
                k.g(this.jbo, new String[]{str, str2, str3});
            } catch (Exception e) {
                x.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            }
            this.jrt = true;
            return;
        }
        this.jrt = false;
        this.aAM = str;
        this.value = str2;
        this.type = str3;
    }

    private void agM() {
        this.aAM = null;
        this.value = null;
        this.type = null;
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Yr() {
        if (this.jrt) {
            try {
                String sL = k.sL(this.jbo);
                if (sL.length() == (this.jru + this.jrv) + this.jrw) {
                    this.aAM = sL.substring(0, this.jru);
                    this.value = sL.substring(this.jru, this.jru + this.jrv);
                    this.type = sL.substring(this.jru + this.jrv, (this.jru + this.jrv) + this.jrw);
                }
                k.sM(this.jbo);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            } catch (Throwable th) {
                k.sM(this.jbo);
            }
        }
        c Zg = f.Zg();
        if (Zg == null) {
            this.result = "fail";
            agM();
            afp();
            return;
        }
        a f = Zg.f(this.appId, this.aAM, this.value, this.type);
        if (f == a.iHz) {
            this.result = "ok";
        } else if (f == a.iHD) {
            this.result = "fail:quota reached";
        } else {
            this.result = "fail";
        }
        agM();
        afp();
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
        this.result = parcel.readString();
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
        parcel.writeString(this.result);
    }
}
