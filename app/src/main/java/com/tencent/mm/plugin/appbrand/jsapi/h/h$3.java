package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.d$a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class h$3 implements d$a<String> {
    final /* synthetic */ h jpG;
    final /* synthetic */ a jpH;
    final /* synthetic */ AppBrandOptionsPicker jpI;

    h$3(h hVar, a aVar, AppBrandOptionsPicker appBrandOptionsPicker) {
        this.jpG = hVar;
        this.jpH = aVar;
        this.jpI = appBrandOptionsPicker;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        this.jpH.hide();
        if (z) {
            Map hashMap = new HashMap(2);
            hashMap.put(DownloadSettingTable$Columns.VALUE, this.jpI.anL());
            hashMap.put("index", Integer.valueOf(this.jpI.getValue()));
            this.jpG.f("ok", hashMap);
            return;
        }
        this.jpG.f("cancel", null);
    }
}
