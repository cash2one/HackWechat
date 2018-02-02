package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;
import org.json.JSONObject;

public final class i extends com.tencent.mm.sdk.e.i<h> {
    public static final String[] iEK = new String[]{com.tencent.mm.sdk.e.i.a(h.iEJ, "DevPkgLaunchExtInfo")};

    public i(e eVar) {
        super(eVar, h.iEJ, "DevPkgLaunchExtInfo", h.fMK);
    }

    public final boolean m(String str, int i, String str2) {
        boolean z;
        if (bh.ov(str)) {
            z = false;
        } else {
            c hVar = new h();
            hVar.field_appId = str;
            hVar.field_versionType = i;
            if (super.b(hVar, h.iEI)) {
                hVar.field_extJson = bh.az(str2, "{}");
                z = super.c(hVar, new String[0]);
            } else {
                hVar.field_extJson = bh.az(str2, "{}");
                z = super.b(hVar);
            }
        }
        if (z) {
            List list = null;
            try {
                list = WxaAttributes.e.rc(new JSONObject(str2).optString("module_list"));
            } catch (Exception e) {
            }
            if (!bh.cA(list)) {
                f.Zo().a(str, i, -1, list);
            }
        }
        return z;
    }

    public final String aE(String str, int i) {
        if (bh.ov(str)) {
            return "";
        }
        c hVar = new h();
        hVar.field_appId = str;
        hVar.field_versionType = i;
        if (super.b(hVar, h.iEI)) {
            return hVar.field_extJson;
        }
        return "";
    }
}
