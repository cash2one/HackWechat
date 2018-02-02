package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.x;

public final class k {

    public interface a {
        boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2);
    }

    public interface b {
        byte[] Hq();

        int Hr();

        boolean cdI();
    }

    public interface c {
        int E(byte[] bArr);

        boolean cdI();
    }

    public static class d {
        public byte[] bjP = new byte[0];
        public int vBf = 0;
        public int vBg = 0;
        public String vBh = "";
        public String vBi = "";
        public int vBj = 0;
        public boolean vBk = true;
        public a vBl;
        public byte[] vBm;
        public ac vBn = new ac("", "", 0);
        public long vBo = 0;

        public void eE(int i) {
            this.vBf = i;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean cdI() {
            return false;
        }

        public boolean KH() {
            return this.vBk;
        }
    }

    public static class e {
        public long vBo = 0;
        public int vBp = -99;
        public int vBq = 255;
        public String vBr = "";

        public int getCmdId() {
            return 0;
        }

        public boolean cdI() {
            return false;
        }
    }

    public static fd a(d dVar) {
        fd fdVar = new fd();
        fdVar.vLa = dVar.vBg;
        fdVar.rYW = dVar.vBj;
        fdVar.lOd = dVar.vBf;
        fdVar.vKZ = com.tencent.mm.bq.b.bc(dVar.vBi.getBytes());
        if (fdVar.vKZ.oz.length >= 16) {
            fdVar.vKZ = fdVar.vKZ.CD(16);
        }
        fdVar.vLb = com.tencent.mm.bq.b.bc(dVar.vBh.getBytes());
        if (fdVar.vLb.oz.length >= 132) {
            fdVar.vLb = fdVar.vLb.CD(132);
        }
        fdVar.vKY = com.tencent.mm.bq.b.bc(dVar.bjP);
        if (fdVar.vKY.oz.length >= 36) {
            fdVar.vKY = fdVar.vKY.CD(36);
        }
        return fdVar;
    }

    public static void a(e eVar, fe feVar) {
        if (feVar.vLc != null) {
            eVar.vBr = feVar.vLc.wJF;
            return;
        }
        eVar.vBr = "";
        x.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    }
}
