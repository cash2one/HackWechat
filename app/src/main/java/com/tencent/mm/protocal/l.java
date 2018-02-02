package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.gl;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends a {

    public static class b extends e implements c {
        public gl vBt = new gl();

        public final int E(byte[] bArr) {
            this.vBt = (gl) new gl().aF(bArr);
            x.d("MicroMsg.MMBgFg", "retcode:" + this.vBt.liH);
            return this.vBt.liH;
        }

        public final int getCmdId() {
            return 1000000312;
        }

        public final boolean cdI() {
            return true;
        }
    }
}
