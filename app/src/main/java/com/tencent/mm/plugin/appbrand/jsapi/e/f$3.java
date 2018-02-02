package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.e.f.b;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.a.c;
import com.tencent.mm.z.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class f$3 implements c {
    final /* synthetic */ String fgU;
    final /* synthetic */ AppBrandInputInvokeHandler jjV;
    final /* synthetic */ f jkd;
    final /* synthetic */ int jkf;

    f$3(f fVar, AppBrandInputInvokeHandler appBrandInputInvokeHandler, String str, int i) {
        this.jkd = fVar;
        this.jjV = appBrandInputInvokeHandler;
        this.fgU = str;
        this.jkf = i;
    }

    public final void aB(String str, int i) {
        int inputId = this.jjV.getInputId();
        b bVar = new b();
        Map hashMap = new HashMap();
        hashMap.put(DownloadSettingTable$Columns.VALUE, com.tencent.mm.plugin.appbrand.q.c.uF(str));
        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, u.GK().t("AppBrandJsInput@" + inputId, true).getString("passing_data", ""));
        hashMap.put("cursor", Integer.valueOf(i));
        hashMap.put("inputId", Integer.valueOf(inputId));
        bVar.az(this.fgU, this.jkf).v(hashMap).afs();
    }
}
