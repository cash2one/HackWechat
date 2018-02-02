package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.y.g;

public final class k extends i<g> {
    public static final String[] gJN = new String[]{i.a(g.gJc, "AppMessage")};

    public k(e eVar) {
        super(eVar, g.gJc, "AppMessage", null);
    }

    public final g fp(long j) {
        c gVar = new g();
        gVar.field_msgId = j;
        return super.b(gVar, new String[0]) ? gVar : null;
    }
}
