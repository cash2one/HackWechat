package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class w {

    public static class b extends e implements c {
        public atj vBR = new atj();

        public final int E(byte[] bArr) {
            this.vBR = (atj) new atj().aF(bArr);
            return this.vBR.vJU;
        }

        public final int getCmdId() {
            return 1000000121;
        }
    }
}
