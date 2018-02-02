package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ahl;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public final class u {

    public static class a extends d implements b {
        public ahl vBN = new ahl();

        public final byte[] Hq() {
            this.vBn = ac.cdN();
            this.vBN.vMi = new bdn().bj(bh.cgp());
            this.vBN.wIV = k.a(this);
            return this.vBN.toByteArray();
        }

        public final int Hr() {
            return 107;
        }

        public final int getCmdId() {
            return 48;
        }
    }
}
