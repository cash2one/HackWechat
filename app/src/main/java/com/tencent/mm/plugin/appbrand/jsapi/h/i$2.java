package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class i$2 implements a<String> {
    final /* synthetic */ i jpP;

    i$2(i iVar) {
        this.jpP = iVar;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        String str = (String) obj;
        b bVar = this.jpP;
        if (bVar.kcP != null) {
            bVar.kcP.hide();
        }
        if (!z) {
            bVar.f("cancel", null);
        } else if (bh.ov(str)) {
            bVar.f("fail", null);
        } else {
            Map hashMap = new HashMap(1);
            hashMap.put(DownloadSettingTable$Columns.VALUE, str);
            bVar.f("ok", hashMap);
        }
    }
}
