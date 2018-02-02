package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.ci;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class c {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public ch nyp = new ch();

        public final byte[] Hq() {
            this.nyp.wIV = k.a(this);
            return this.nyp.toByteArray();
        }

        public final int getCmdId() {
            return 289;
        }

        public final int Hr() {
            return 623;
        }
    }

    public static class b extends e implements com.tencent.mm.protocal.k.c {
        public ci nyq = new ci();

        public final int E(byte[] bArr) {
            this.nyq = (ci) new ci().aF(bArr);
            k.a(this, this.nyq.wJr);
            return this.nyq.wJr.vJU;
        }

        public final int getCmdId() {
            return 1000000289;
        }
    }
}
