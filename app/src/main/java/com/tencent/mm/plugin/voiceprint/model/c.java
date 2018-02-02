package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.z.ax.a;
import com.tencent.mm.z.ax.b;

final class c extends i {
    b sgA = new b();
    a sgz = new a();

    c() {
    }

    public final int getType() {
        return 617;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
    }

    public final e Hp() {
        return this.sgA;
    }

    protected final d Ho() {
        return this.sgz;
    }

    public final int JY() {
        return 1;
    }
}
