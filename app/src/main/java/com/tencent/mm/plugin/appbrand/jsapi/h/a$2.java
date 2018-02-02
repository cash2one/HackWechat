package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class a$2 implements a<String> {
    final /* synthetic */ a jpp;

    a$2(a aVar) {
        this.jpp = aVar;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        String str = (String) obj;
        b bVar = this.jpp;
        if (bVar.kcP != null) {
            if (!z) {
                bVar.f("cancel", null);
            }
            if (bh.ov(str)) {
                bVar.f("fail", null);
            } else {
                Map hashMap = new HashMap(1);
                hashMap.put(DownloadSettingTable$Columns.VALUE, str);
                bVar.f("ok", hashMap);
            }
            bVar.kcP.hide();
        }
    }
}
