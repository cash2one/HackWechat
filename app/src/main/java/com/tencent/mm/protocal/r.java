package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bh;

public final class r {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public aan vBI = new aan();

        public final byte[] Hq() {
            this.vBn = ac.cdN();
            this.vBI.vMi = new bdn().bj(bh.cgp());
            this.vBI.wjy = ac.cdL().ver;
            this.vBI.wIV = k.a(this);
            return this.vBI.toByteArray();
        }

        public final int Hr() {
            return 381;
        }

        public final int getCmdId() {
            return 179;
        }
    }

    public static class b extends e implements c {
        public aao vBJ = new aao();

        public final int E(byte[] bArr) {
            this.vBJ = (aao) new aao().aF(bArr);
            k.a(this, this.vBJ.wJr);
            return this.vBJ.wJr.vJU;
        }

        public final int getCmdId() {
            return 1000000179;
        }
    }
}
