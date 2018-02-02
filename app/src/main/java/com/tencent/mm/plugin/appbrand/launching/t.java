package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends i<u> {
    public static final String iPh = i.a(u.iEJ, "LaunchWxaAppRespTable");

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((u) cVar, strArr);
    }

    public t(e eVar) {
        super(eVar, u.iEJ, "LaunchWxaAppRespTable", u.fMK);
    }

    public final boolean a(u uVar, boolean z, String... strArr) {
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    uVar.field_appIdHash = uVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.a(uVar, z, strArr);
    }

    public final boolean a(u uVar, String... strArr) {
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    uVar.field_appIdHash = uVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(uVar, strArr);
    }

    public final boolean a(u uVar, boolean z) {
        uVar.field_appIdHash = uVar.field_appId.hashCode();
        super.a(uVar, z);
        x.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[]{uVar.field_appId, Boolean.valueOf(a(uVar, "appId"))});
        return a(uVar, "appId");
    }

    public final boolean b(u uVar, boolean z, String... strArr) {
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    uVar.field_appIdHash = uVar.field_appId.hashCode();
                    break;
                }
            }
        }
        x.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[]{uVar.field_appId, Boolean.valueOf(super.b(uVar, z, strArr))});
        return super.b(uVar, z, strArr);
    }
}
