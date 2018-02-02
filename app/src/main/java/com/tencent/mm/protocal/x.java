package com.tencent.mm.protocal;

import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bh;

public final class x {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] fvp = null;
        public long hHE = -1;

        public final byte[] Hq() {
            Object obj = new byte[(this.fvp.length + 8)];
            int Wp = (int) (bh.Wp() - this.hHE);
            obj[0] = (byte) ((Wp >> 24) & 255);
            obj[1] = (byte) ((Wp >> 16) & 255);
            obj[2] = (byte) ((Wp >> 8) & 255);
            obj[3] = (byte) (Wp & 255);
            obj[4] = (byte) ((this.fvp.length >> 24) & 255);
            obj[5] = (byte) ((this.fvp.length >> 16) & 255);
            obj[6] = (byte) ((this.fvp.length >> 8) & 255);
            obj[7] = (byte) (this.fvp.length & 255);
            System.arraycopy(this.fvp, 0, obj, 8, this.fvp.length);
            bh.bv(obj);
            return obj;
        }

        public final int getCmdId() {
            return 1000000190;
        }

        public final int Hr() {
            return 268369922;
        }

        public final boolean KH() {
            return false;
        }
    }

    public static class b extends e implements c {
        public final int E(byte[] bArr) {
            return 0;
        }

        public final int getCmdId() {
            return -1;
        }
    }
}
