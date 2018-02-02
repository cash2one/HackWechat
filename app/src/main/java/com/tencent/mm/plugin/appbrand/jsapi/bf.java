package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class bf extends a {
    public static final int CTRL_INDEX = 389;
    public static final String NAME = "setTabBarBadge";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        try {
            int i2 = jSONObject.getInt("index");
            String optString = jSONObject.optString(DownloadSettingTable$Columns.TYPE, "none");
            String optString2 = jSONObject.optString("badgeValue", "");
            String optString3 = jSONObject.optString("badgeColor", "");
            String optString4 = jSONObject.optString("badgeTextColor", "");
            l aiT = jVar.irP.iqC.aiT();
            if (aiT instanceof e) {
                c cVar = ((e) aiT).jCV;
                optString2 = optString2.substring(0, optString2.length() < 4 ? optString2.length() : 4);
                int aK = com.tencent.mm.plugin.appbrand.ui.j.aK(optString3, 0);
                int aK2 = com.tencent.mm.plugin.appbrand.ui.j.aK(optString4, -1);
                for (int i3 = 0; i3 < cVar.jUz.size(); i3++) {
                    if (i3 == i2) {
                        ((a) cVar.jUz.get(i3)).amh();
                        if ("redDot".equals(optString)) {
                            ((a) cVar.jUz.get(i3)).jUL = true;
                        } else if ("text".equals(optString)) {
                            ((a) cVar.jUz.get(i3)).jUM = optString2;
                            ((a) cVar.jUz.get(i3)).jUN = aK;
                            ((a) cVar.jUz.get(i3)).jUO = aK2;
                        }
                    }
                }
                cVar.amg();
                jVar.E(i, e("ok", null));
                return;
            }
            jVar.E(i, e("fail:not TabBar page", null));
        } catch (Exception e) {
            jVar.E(i, e("fail", null));
        }
    }
}
