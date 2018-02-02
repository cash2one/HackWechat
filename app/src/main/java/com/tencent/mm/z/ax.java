package com.tencent.mm.z;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bsr;
import com.tencent.mm.protocal.c.bss;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bh;

public final class ax {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public bsr hgq = new bsr();

        public final byte[] Hq() {
            this.vBn = ac.cdL();
            this.hgq.vMi = new bdn().bj(bh.cgp());
            this.hgq.wIV = k.a(this);
            return this.hgq.toByteArray();
        }

        public final int Hr() {
            return 617;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public bss hgr = new bss();

        public final int E(byte[] bArr) {
            this.hgr = (bss) new bss().aF(bArr);
            k.a(this, this.hgr.wJr);
            return this.hgr.wJr.vJU;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
