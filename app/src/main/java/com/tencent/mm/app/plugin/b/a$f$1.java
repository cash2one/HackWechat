package com.tencent.mm.app.plugin.b;

import com.tencent.mm.app.plugin.b.a.f;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class a$f$1 implements a {
    final /* synthetic */ f fhQ;

    a$f$1(f fVar) {
        this.fhQ = fVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
        this.fhQ.fhN = true;
        this.fhQ.uE();
        return false;
    }
}
