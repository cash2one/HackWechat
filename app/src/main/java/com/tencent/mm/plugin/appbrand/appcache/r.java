package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class r extends i<q> {
    public static final String[] iEK = new String[]{i.a(q.iEJ, "PkgUpdateStats")};

    public r(e eVar) {
        super(eVar, q.iEJ, "PkgUpdateStats", q.fMK);
    }

    final boolean af(String str, int i) {
        c qVar = new q();
        qVar.field_key = str;
        qVar.field_version = i;
        return super.a(qVar, q.iEI);
    }
}
