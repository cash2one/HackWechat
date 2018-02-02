package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageInfoTask> CREATOR = new 1();
    public String appId;
    public int asN;
    public Runnable jcI;
    public ArrayList<String> jrs;
    public int size;

    public final void Yr() {
        c Zg = f.Zg();
        if (Zg == null) {
            afp();
            return;
        }
        Object[] pR = Zg.pR(this.appId);
        this.jrs = (ArrayList) pR[0];
        this.size = (int) Math.ceil(((Integer) pR[1]).doubleValue() / 1000.0d);
        this.asN = (int) Math.ceil(((Integer) pR[2]).doubleValue() / 1000.0d);
        afp();
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.jrs = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.asN = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeStringList(this.jrs);
        parcel.writeInt(this.size);
        parcel.writeInt(this.asN);
    }
}
