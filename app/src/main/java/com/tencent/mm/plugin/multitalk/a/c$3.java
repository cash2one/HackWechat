package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.voip.model.a;

class c$3 implements a {
    final /* synthetic */ c oFW;

    c$3(c cVar) {
        this.oFW = cVar;
    }

    public final int L(byte[] bArr, int i) {
        int P;
        if (this.oFW.oFU != null) {
            P = this.oFW.oFU.P(bArr, i);
        } else {
            P = 0;
        }
        if (P < 0) {
            return -1;
        }
        return 0;
    }
}
