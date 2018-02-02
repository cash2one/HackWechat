package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.z.u.b;
import java.util.HashMap;
import java.util.Map;

class d$1 implements OnClickListener {
    final /* synthetic */ p jdJ;
    final /* synthetic */ b jeN;
    final /* synthetic */ d jjk;

    d$1(d dVar, b bVar, p pVar) {
        this.jjk = dVar;
        this.jeN = bVar;
        this.jdJ = pVar;
    }

    public final void onClick(View view) {
        if (this.jeN.hA("clickable")) {
            d$a com_tencent_mm_plugin_appbrand_jsapi_coverview_d_a = new d$a();
            Map hashMap = new HashMap();
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.jeN.getString(SlookAirButtonFrequentContactAdapter.DATA, ""));
            com_tencent_mm_plugin_appbrand_jsapi_coverview_d_a.a(this.jdJ);
            com_tencent_mm_plugin_appbrand_jsapi_coverview_d_a.v(hashMap);
            if ("webview".equals(this.jeN.getString("sendTo", null))) {
                com_tencent_mm_plugin_appbrand_jsapi_coverview_d_a.f(new int[]{this.jdJ.hashCode()});
                return;
            }
            com_tencent_mm_plugin_appbrand_jsapi_coverview_d_a.afs();
        }
    }
}
