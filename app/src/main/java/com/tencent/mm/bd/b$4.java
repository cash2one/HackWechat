package com.tencent.mm.bd;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements a {
    final /* synthetic */ b hLN;

    b$4(b bVar) {
        this.hLN = bVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.Rs();
        this.hLN.Rm();
        return false;
    }
}
