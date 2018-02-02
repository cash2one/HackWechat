package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ae.i;
import com.tencent.mm.plugin.soter.b.c.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class b extends i {
    a rSb = new a();
    com.tencent.mm.plugin.soter.b.c.b rSc = new com.tencent.mm.plugin.soter.b.c.b();

    b() {
    }

    public final int getType() {
        return 627;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    public final e Hp() {
        return this.rSc;
    }

    protected final d Ho() {
        return this.rSb;
    }

    public final int JY() {
        return 1;
    }
}
