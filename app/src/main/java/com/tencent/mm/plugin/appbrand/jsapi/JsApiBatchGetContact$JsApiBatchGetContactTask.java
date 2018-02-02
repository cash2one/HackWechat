package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;

class JsApiBatchGetContact$JsApiBatchGetContactTask extends MainProcessTask {
    public static final Creator<JsApiBatchGetContact$JsApiBatchGetContactTask> CREATOR = new 2();
    private String fnL;
    public ArrayList<String> jcK;
    private e jcL;
    private j jcM;
    private int jcN;
    private String jcO;

    public JsApiBatchGetContact$JsApiBatchGetContactTask(e eVar, j jVar, int i, ArrayList<String> arrayList) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
        this.jcK = arrayList;
    }

    public JsApiBatchGetContact$JsApiBatchGetContactTask(Parcel parcel) {
        f(parcel);
    }

    public final void Ys() {
        if (bh.ov(this.jcO)) {
            this.jcM.E(this.jcN, this.jcL.e(this.fnL, null));
        } else {
            this.jcM.E(this.jcN, this.jcO);
        }
        afj();
    }

    public final void Yr() {
        e.post(new 1(this), "AppBrandJsApiBatchGetContact");
    }

    public final void f(Parcel parcel) {
        this.jcK = parcel.readArrayList(getClass().getClassLoader());
        this.jcO = parcel.readString();
        this.fnL = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.jcK);
        parcel.writeString(this.jcO);
        parcel.writeString(this.fnL);
    }
}
