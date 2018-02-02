package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;

public final class c extends i<b> {
    public static final String[] iEK = new String[]{i.a(b.iGc, "AppBrandCommonKVData")};
    public final e iHy;

    public c(e eVar) {
        super(eVar, b.iGc, "AppBrandCommonKVData", null);
        this.iHy = eVar;
    }

    public final boolean aV(String str, String str2) {
        if (bh.ov(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        bVar.field_value = str2;
        if (!bh.ov(bVar.field_value)) {
            return super.a(bVar);
        }
        if (super.a(bVar, new String[0])) {
            return false;
        }
        return true;
    }

    public final String get(String str, String str2) {
        if (bh.ov(str)) {
            return str2;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        if (super.b(bVar, new String[0])) {
            return bVar.field_value;
        }
        return str2;
    }

    public final void qB(String str) {
        super.fx("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandCommonKVData", "key", str}));
    }
}
