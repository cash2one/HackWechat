package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiAdDataReport$AdDataReportTask extends MainProcessTask {
    public static final Creator<JsApiAdDataReport$AdDataReportTask> CREATOR = new 1();
    private e jcq;
    private p jcr;
    private int jcs;
    private String jct;

    public JsApiAdDataReport$AdDataReportTask(e eVar, p pVar, int i, JSONObject jSONObject) {
        this.jcq = eVar;
        this.jcr = pVar;
        this.jcs = i;
        AppBrandStatObject oT = a.oT(pVar.mAppId);
        this.jct = oT.scene + "," + oT.fnp + "," + oT.fIs + "," + oT.fIt + "," + jSONObject.optString("adInfo");
    }

    public JsApiAdDataReport$AdDataReportTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.JsApiAdDataReport", "mReportStr : %s", new Object[]{this.jct});
        ((com.tencent.mm.plugin.sns.b.a) g.h(com.tencent.mm.plugin.sns.b.a.class)).e(15175, this.jct, (int) bh.Wo());
        afp();
    }

    public final void Ys() {
        this.jcr.E(this.jcs, this.jcq.e("ok", null));
    }

    public final void f(Parcel parcel) {
        this.jct = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jct);
    }
}
