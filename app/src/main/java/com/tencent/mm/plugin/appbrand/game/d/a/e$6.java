package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.widget.input.u.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class e$6 implements e {
    final /* synthetic */ e iZK;
    final /* synthetic */ WAGamePanelInputEditText iZL;
    final /* synthetic */ j iZy;

    e$6(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, j jVar) {
        this.iZK = eVar;
        this.iZL = wAGamePanelInputEditText;
        this.iZy = jVar;
    }

    public final void kf(int i) {
        if (2 == i) {
            a aVar = this.iZK.iZD;
            String obj = this.iZL.getEditableText().toString();
            c cVar = this.iZy;
            Map hashMap = new HashMap(2);
            hashMap.put("errMsg", "ok");
            hashMap.put(DownloadSettingTable$Columns.VALUE, obj);
            aVar.v(hashMap).a(cVar).afs();
        }
    }
}
