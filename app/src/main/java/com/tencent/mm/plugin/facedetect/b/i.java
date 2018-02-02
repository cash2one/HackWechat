package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class i {

    public static class b extends e implements c {
        public zc mfd = new zc();

        public final int E(byte[] bArr) {
            this.mfd = (zc) new zc().aF(bArr);
            k.a(this, this.mfd.wJr);
            return this.mfd.wJr.vJU;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
