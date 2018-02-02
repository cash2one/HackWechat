package com.tencent.mm.bd;

import com.tencent.map.a.a.c;
import com.tencent.mm.sdk.platformtools.x;

class b$6 implements c {
    final /* synthetic */ b hLN;

    b$6(b bVar) {
        this.hLN = bVar;
    }

    public final void onMessage(int i, String str) {
        x.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[]{Integer.valueOf(i), str});
        if (i != 0 && b.o(this.hLN) > 3) {
            x.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[]{Integer.valueOf(3)});
            b.Rt();
            this.hLN.Rm();
        }
    }
}
