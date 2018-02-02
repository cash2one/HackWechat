package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.i;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;

public class s$b extends i {
    private final a hwt = new a();
    private final b hwu = new b();

    protected final d Ho() {
        return this.hwt;
    }

    public final e Hp() {
        return this.hwu;
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/bindopmobileforreg";
    }

    public final int JY() {
        return 1;
    }
}
