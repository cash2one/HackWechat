package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.z.av.b;

final class a extends i {
    com.tencent.mm.z.av.a sgv = new com.tencent.mm.z.av.a();
    b sgw = new b();

    a() {
    }

    public final int getType() {
        return 616;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    public final e Hp() {
        return this.sgw;
    }

    protected final d Ho() {
        return this.sgv;
    }

    public final int JY() {
        return 1;
    }
}
