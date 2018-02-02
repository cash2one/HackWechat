package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.z.aw.a;

final class b extends i {
    a sgx = new a();
    com.tencent.mm.z.aw.b sgy = new com.tencent.mm.z.aw.b();

    b() {
    }

    public final int getType() {
        return 618;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    public final e Hp() {
        return this.sgy;
    }

    protected final d Ho() {
        return this.sgx;
    }

    public final int JY() {
        return 1;
    }
}
