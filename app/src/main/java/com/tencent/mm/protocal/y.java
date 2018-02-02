package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;

public final class y {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] vAY;
        public atf vBS = new atf();

        public final byte[] Hq() {
            int i = -1;
            this.vBn = ac.cdL();
            this.vBS.vMi = new bdn().bj(bh.cgp());
            this.vBS.wIV = k.a(this);
            this.vBS.wAV = f.xex;
            rt rtVar = new rt();
            rtVar.vZG = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(rtVar.vZG, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            this.vAY = bArr2 != null ? bArr2 : new byte[0];
            String str = "MicroMsg.MMReg2.Req";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(rtVar.vZG);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = bh.bv(bArr);
            objArr[5] = bh.bv(bArr2);
            x.d(str, str2, objArr);
            rtVar.vJC = new bdn().bj(bArr);
            this.vBS.vJG = rtVar;
            return this.vBS.toByteArray();
        }

        public final int Hr() {
            return 126;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public byte[] hZs;
        public atg vBT = new atg();
        public byte[] vBa;
        public int vBb = 0;

        public final int E(byte[] bArr) {
            this.vBb = 0;
            this.vBT = (atg) new atg().aF(bArr);
            k.a(this, this.vBT.wJr);
            this.vBb = 0;
            return this.vBT.wJr.vJU;
        }

        public final int getCmdId() {
            return 0;
        }

        public final void be(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.hZs = bArr;
        }
    }
}
