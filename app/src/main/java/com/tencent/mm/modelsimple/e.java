package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.protocal.z.b;

final class e extends i {
    private final a hMC = new a();
    private final b hMD = new b();

    e() {
    }

    protected final d Ho() {
        return this.hMC;
    }

    public final com.tencent.mm.protocal.k.e Hp() {
        return this.hMD;
    }

    public final int getType() {
        return 26;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/sendcard";
    }
}
