package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;

public final class m extends i<l> {
    public static final String[] iEK = new String[]{i.a(l.iGc, "WxaWidgetInfo")};
    public static final String[] jVc = new String[0];

    public m(e eVar) {
        super(eVar, l.iGc, "WxaWidgetInfo", jVc);
    }

    public final l uS(String str) {
        if (bh.ov(str)) {
            return null;
        }
        c lVar = new l();
        lVar.field_appId = str;
        lVar.field_appIdHash = str.hashCode();
        if (b(lVar, "appIdHash")) {
            return lVar;
        }
        return null;
    }
}
