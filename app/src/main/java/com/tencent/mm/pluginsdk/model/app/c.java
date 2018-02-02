package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class c extends i<b> {
    public static final String[] gJN = new String[]{i.a(b.gJc, "appattach")};
    e gJP;

    public c(e eVar) {
        super(eVar, b.gJc, "appattach", null);
        this.gJP = eVar;
    }

    public final b Rz(String str) {
        b bVar = new b();
        bVar.field_mediaSvrId = str;
        if (b(bVar, new String[]{"mediaSvrId"})) {
            return bVar;
        }
        return !b(bVar, new String[]{"mediaId"}) ? null : bVar;
    }

    public final b fo(long j) {
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_msgInfoId = j;
        return b(bVar, new String[]{"msgInfoId"}) ? bVar : null;
    }
}
