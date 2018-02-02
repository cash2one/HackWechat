package com.tencent.mm.protocal;

import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;

public final class i {

    public interface c {

        public static class a {
            public static c vAV;
        }

        int Hm();

        void a(f fVar, g gVar, int i, int i2, String str);

        q aW(int i, int i2);
    }

    public static abstract class f extends com.tencent.mm.protocal.k.d implements com.tencent.mm.protocal.k.b {
        public byte[] vAY;

        public abstract String getUri();

        public final void bd(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.vAY = bArr;
        }
    }

    public static abstract class g extends com.tencent.mm.protocal.k.e implements com.tencent.mm.protocal.k.c {
        public byte[] hZs;
        public String hZv;
        public bpb vAZ = new bpb();
        public byte[] vBa;
        public int vBb = 0;

        public final void be(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.hZs = bArr;
        }
    }

    public static class a extends f implements com.tencent.mm.protocal.k.b {
        public String username;
        public eg vAU = new eg();

        public final byte[] Hq() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.fF("");
            if (this.vBj == 12) {
                i = 1;
            } else {
                com.tencent.mm.kernel.g.Dk();
                i = com.tencent.mm.kernel.g.Dj().gQd.Dl(46);
            }
            x.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r3), Integer.valueOf(i));
            this.vBn = ac.cdL();
            if (10002 == r.idt && r.idu > 0) {
                r.idu = 0;
                ac.F("", "", 0);
            }
            bcv com_tencent_mm_protocal_c_bcv = this.vAU.vJE;
            com_tencent_mm_protocal_c_bcv.wIV = k.a(this);
            x.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf[%d]", Integer.valueOf(this.vBf));
            com_tencent_mm_protocal_c_bcv.vcm = com.tencent.mm.compatible.d.q.yE();
            com_tencent_mm_protocal_c_bcv.vJx = com.tencent.mm.plugin.normsg.a.d.oSu.tX(i);
            com_tencent_mm_protocal_c_bcv.vJy = 0;
            com_tencent_mm_protocal_c_bcv.vJz = com.tencent.mm.kernel.a.CB();
            com_tencent_mm_protocal_c_bcv.hvw = bh.fa(ac.getContext());
            com_tencent_mm_protocal_c_bcv.ksY = d.vAx;
            com_tencent_mm_protocal_c_bcv.vJA = be.cjW();
            com_tencent_mm_protocal_c_bcv.lOo = w.cfi();
            com_tencent_mm_protocal_c_bcv.lOn = bh.cgr();
            com_tencent_mm_protocal_c_bcv.vDY = com.tencent.mm.sdk.platformtools.f.fdS;
            com.tencent.mm.kernel.g.Dk();
            x.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", (String) com.tencent.mm.kernel.g.Dj().gQd.get(18), Integer.valueOf(com_tencent_mm_protocal_c_bcv.vJw.vKU));
            com_tencent_mm_protocal_c_bcv.vJw.vKS.vMG = new bdn().bj(bh.VD(r0));
            eh ehVar = this.vAU.vJD;
            rt rtVar = new rt();
            rtVar.vZG = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(rtVar.vZG, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bd(bArr2);
            String str = "MicroMsg.AutoReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(rtVar.vZG);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bh.bv(bArr);
            objArr[5] = bh.bv(bArr2);
            x.d(str, str2, objArr);
            rtVar.vJC = new bdn().bj(bArr);
            ehVar.vJG = rtVar;
            x.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", com_tencent_mm_protocal_c_bcv.vcm, com_tencent_mm_protocal_c_bcv.vJx, com_tencent_mm_protocal_c_bcv.vJz, com_tencent_mm_protocal_c_bcv.hvw, com_tencent_mm_protocal_c_bcv.ksY, com_tencent_mm_protocal_c_bcv.vJA, com_tencent_mm_protocal_c_bcv.lOo, com_tencent_mm_protocal_c_bcv.lOn, Integer.valueOf(com_tencent_mm_protocal_c_bcv.vDY), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fdS), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.xex));
            try {
                return this.vAU.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", bh.i(e));
                return null;
            }
        }

        public final int Hr() {
            return 702;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    public static class b extends g implements com.tencent.mm.protocal.k.c {
        public final int E(byte[] bArr) {
            try {
                this.vAZ = (bpb) this.vAZ.aF(bArr);
                k.a(this, this.vAZ.wJr);
                this.vBb = 0;
                if (this.vAZ.wJr.vJU == 0 && (this.vAZ.wRq == null || this.vAZ.wRq.lOd == 0 || bh.bw(n.a(this.vAZ.wRq.vIZ)))) {
                    x.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vAZ.wJr.vJU = -1;
                }
                x.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", this.vBr);
                com.tencent.mm.kernel.a.fF(r0);
                return this.vAZ.wJr.vJU;
            } catch (Throwable e) {
                x.e("MicroMsg.MMAuth", "toProtoBuf :%s", bh.i(e));
                this.vAZ.wJr.vJU = -1;
                return -1;
            }
        }
    }

    public static class d extends f implements com.tencent.mm.protocal.k.b {
        public aqe vAW = new aqe();
        public boolean vAX = false;

        public final byte[] Hq() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.fF("");
            if (this.vBj == 16) {
                i = 1;
            } else if (this.vAX) {
                i = 3;
            } else {
                com.tencent.mm.kernel.g.Dk();
                i = com.tencent.mm.kernel.g.Dj().gQd.Dl(46);
            }
            x.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r4), Integer.valueOf(i));
            if (10002 == r.idt && r.idu > 0) {
                r.idu = 0;
                ac.F("", "", 0);
            }
            this.vBn = ac.cdL();
            bcv com_tencent_mm_protocal_c_bcv = this.vAW.wwZ;
            com_tencent_mm_protocal_c_bcv.wIV = k.a(this);
            com_tencent_mm_protocal_c_bcv.vcm = com.tencent.mm.compatible.d.q.yE();
            com_tencent_mm_protocal_c_bcv.vJx = com.tencent.mm.plugin.normsg.a.d.oSu.tX(i);
            com_tencent_mm_protocal_c_bcv.vJy = 0;
            com_tencent_mm_protocal_c_bcv.vJz = com.tencent.mm.kernel.a.CB();
            com_tencent_mm_protocal_c_bcv.hvw = bh.fa(ac.getContext());
            com_tencent_mm_protocal_c_bcv.ksY = d.vAx;
            com_tencent_mm_protocal_c_bcv.vJA = be.cjW();
            com_tencent_mm_protocal_c_bcv.lOo = w.cfi();
            com_tencent_mm_protocal_c_bcv.lOn = bh.cgr();
            com_tencent_mm_protocal_c_bcv.vDY = com.tencent.mm.sdk.platformtools.f.fdS;
            if (10012 == r.idt && r.idu > 0) {
                com_tencent_mm_protocal_c_bcv.vDY = r.idu;
            }
            com_tencent_mm_protocal_c_bcv.vOg = d.vAs;
            com_tencent_mm_protocal_c_bcv.vOf = d.vAt;
            com_tencent_mm_protocal_c_bcv.wwU = d.vAu;
            com_tencent_mm_protocal_c_bcv.vZI = com.tencent.mm.compatible.d.q.getSimCountryIso();
            com.tencent.mm.kernel.g.Dk();
            x.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", (String) com.tencent.mm.kernel.g.Dj().gQd.get(18), Integer.valueOf(com_tencent_mm_protocal_c_bcv.vJw.vKU));
            com_tencent_mm_protocal_c_bcv.vJw.vKS.vMG = new bdn().bj(bh.VD(r0));
            aqf com_tencent_mm_protocal_c_aqf = this.vAW.wwY;
            com_tencent_mm_protocal_c_aqf.vMi = new bdn().bj(bh.cgp());
            rt rtVar = new rt();
            rtVar.vZG = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(rtVar.vZG, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bd(bArr2);
            String str = "MicroMsg.ManualReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(rtVar.vZG);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bh.bv(bArr);
            objArr[5] = bh.bv(bArr2);
            x.d(str, str2, objArr);
            rtVar.vJC = new bdn().bj(bArr);
            com_tencent_mm_protocal_c_aqf.vJG = rtVar;
            x.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", com_tencent_mm_protocal_c_bcv.vcm, com_tencent_mm_protocal_c_bcv.vJx, com_tencent_mm_protocal_c_bcv.vJz, com_tencent_mm_protocal_c_bcv.hvw, com_tencent_mm_protocal_c_bcv.ksY, com_tencent_mm_protocal_c_bcv.vJA, com_tencent_mm_protocal_c_bcv.lOo, com_tencent_mm_protocal_c_bcv.lOn, Integer.valueOf(com_tencent_mm_protocal_c_bcv.vDY), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fdS), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.xex), com_tencent_mm_protocal_c_bcv.vOg, com_tencent_mm_protocal_c_bcv.vOf, com_tencent_mm_protocal_c_bcv.wwU, com_tencent_mm_protocal_c_bcv.vZI);
            try {
                return this.vAW.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", bh.i(e));
                return null;
            }
        }

        public final int Hr() {
            return 701;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    public static class e extends g implements com.tencent.mm.protocal.k.c {
        public final int E(byte[] bArr) {
            try {
                this.vAZ = (bpb) this.vAZ.aF(bArr);
                k.a(this, this.vAZ.wJr);
                this.vBb = 0;
                if (this.vAZ.wJr.vJU == 0 && (this.vAZ.wRq == null || this.vAZ.wRq.lOd == 0 || bh.bw(n.a(this.vAZ.wRq.vIZ)))) {
                    x.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vAZ.wJr.vJU = -1;
                }
                x.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", this.vBr);
                com.tencent.mm.kernel.a.fF(r0);
                return this.vAZ.wJr.vJU;
            } catch (Throwable e) {
                x.e("MicroMsg.MMAuth", "toProtoBuf :%s", bh.i(e));
                this.vAZ.wJr.vJU = -1;
                return -1;
            }
        }
    }
}
