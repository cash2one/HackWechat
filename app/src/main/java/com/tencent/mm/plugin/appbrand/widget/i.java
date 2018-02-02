package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bh;

public final class i extends com.tencent.mm.sdk.e.i<j> {
    public static final String iPh = com.tencent.mm.sdk.e.i.a(j.iEJ, "LaunchWxaWidgetRespData");

    public final /* synthetic */ boolean a(c cVar, boolean z, String[] strArr) {
        j jVar = (j) cVar;
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.a(jVar, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        return a((j) cVar, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((j) cVar, strArr);
    }

    public i(e eVar) {
        super(eVar, j.iEJ, "LaunchWxaWidgetRespData", j.fMK);
    }

    public final j a(String str, int i, int i2, aoc com_tencent_mm_protocal_c_aoc) {
        if (bh.ov(str) || com_tencent_mm_protocal_c_aoc == null) {
            return null;
        }
        j jVar = new j();
        jVar.field_appIdHash = str.hashCode();
        jVar.field_appId = str;
        jVar.field_pkgType = i;
        jVar.field_widgetType = i2;
        if (a(jVar, "appId", "pkgType", "widgetType")) {
            boolean z = false;
        } else {
            int i3 = 1;
        }
        if (com.tencent.mm.plugin.appbrand.p.i.a(jVar.field_launchAction, com_tencent_mm_protocal_c_aoc.wvb)) {
            boolean z2 = false;
        } else {
            jVar.field_launchAction = com_tencent_mm_protocal_c_aoc.wvb;
            int i4 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.p.i.a(jVar.field_jsApiInfo, com_tencent_mm_protocal_c_aoc.wuW)) {
            jVar.field_jsApiInfo = com_tencent_mm_protocal_c_aoc.wuW;
            i4 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.p.i.a(jVar.field_versionInfo, com_tencent_mm_protocal_c_aoc.wvc)) {
            jVar.field_versionInfo = com_tencent_mm_protocal_c_aoc.wvc;
            i4 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.p.i.a(jVar.field_widgetSetting, com_tencent_mm_protocal_c_aoc.wvd)) {
            jVar.field_widgetSetting = com_tencent_mm_protocal_c_aoc.wvd;
            i4 = 1;
        }
        if (i4 != 0) {
            if (i3 != 0) {
                a(jVar, false);
            } else {
                a(jVar, false, "appId", "pkgType", "widgetType");
            }
        }
        if (i4 != 0) {
            a(jVar, "appId", "pkgType", "widgetType");
        }
        return jVar;
    }

    public final boolean a(j jVar, String... strArr) {
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(jVar, strArr);
    }

    private boolean a(j jVar, boolean z) {
        jVar.field_appIdHash = jVar.field_appId.hashCode();
        super.a(jVar, z);
        return a(jVar, "appId");
    }

    private boolean a(j jVar, boolean z, String... strArr) {
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(jVar, z, strArr);
    }
}
