package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.protocal.c.bbu;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bh;

public final class j {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public bbt mfe = new bbt();

        public final byte[] Hq() {
            this.vBn = ac.cdL();
            this.mfe.vMi = new bdn().bj(bh.cgp());
            this.mfe.wIV = k.a(this);
            this.vBm = this.mfe.vMi.wJD.toByteArray();
            return this.mfe.toByteArray();
        }

        public final int Hr() {
            return 931;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public bbu mff = new bbu();

        public final int E(byte[] bArr) {
            this.mff = (bbu) new bbu().aF(bArr);
            k.a(this, this.mff.wJr);
            return this.mff.wJr.vJU;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
