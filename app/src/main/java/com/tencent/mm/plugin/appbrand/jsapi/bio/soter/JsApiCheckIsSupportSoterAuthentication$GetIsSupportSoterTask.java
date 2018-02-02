package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask extends MainProcessTask {
    public static final Creator<JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask> CREATOR = new 1();
    private j iqB = null;
    private int jcs = -1;
    private JsApiCheckIsSupportSoterAuthentication jhy;
    private int jhz = 0;

    public final void Ys() {
        super.Ys();
        x.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[]{Integer.valueOf(this.jhz)});
        Map hashMap = new HashMap(2);
        hashMap.put("supportMode", a.kr(this.jhz));
        this.iqB.E(this.jcs, this.jhy.e("ok", hashMap));
        c.bk(this);
    }

    public final void Yr() {
        this.jhz = ((a) g.h(a.class)).abt();
        x.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[]{Integer.valueOf(this.jhz)});
        afp();
    }

    public JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(j jVar, int i, JsApiCheckIsSupportSoterAuthentication jsApiCheckIsSupportSoterAuthentication) {
        this.iqB = jVar;
        this.jcs = i;
        this.jhy = jsApiCheckIsSupportSoterAuthentication;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.jhz);
    }

    protected JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(Parcel parcel) {
        f(parcel);
    }

    public final void f(Parcel parcel) {
        super.f(parcel);
        this.jhz = parcel.readInt();
    }
}
