package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        p b = b(jVar);
        if (b != null) {
            try {
                Integer valueOf;
                String string = jSONObject.getString(DownloadSettingTable$Columns.VALUE);
                try {
                    valueOf = Integer.valueOf(jSONObject.getInt("cursor"));
                } catch (Exception e) {
                    valueOf = null;
                }
                m.a(b, string, valueOf);
                jVar.E(i, e("ok", null));
            } catch (Exception e2) {
                jVar.E(i, e("fail:invalid data", null));
            }
        }
    }
}
