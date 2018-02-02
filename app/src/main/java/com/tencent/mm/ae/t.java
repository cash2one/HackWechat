package com.tencent.mm.ae;

import android.os.Looper;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bak;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends com.tencent.mm.protocal.h.a {
    private static a hnK;
    private e hnI;
    private byte[] hnJ;
    private int type;

    public interface a {
        void cC(String str);
    }

    public static void a(a aVar) {
        hnK = aVar;
    }

    public t(e eVar, int i) {
        this.hnI = eVar;
        this.type = i;
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2) {
        PByteArray pByteArray = new PByteArray();
        if (this.hnI instanceof c) {
            PByteArray pByteArray2 = new PByteArray();
            PInt pInt = new PInt(0);
            c cVar = (c) this.hnI;
            PInt pInt2 = new PInt(0);
            PInt pInt3 = new PInt(0);
            PInt pInt4 = new PInt(255);
            try {
                if (cVar.cdI()) {
                    int E = cVar.E(bArr);
                    x.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                    this.hnI.vBp = E;
                    if (!bh.ov(r.idw)) {
                        this.hnI.vBr = r.idw;
                    }
                    return true;
                }
                x.i("MicroMsg.RemoteResp", "bufToResp unpack ret[%b], jType[%d], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)), Integer.valueOf(i), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value));
                b hcVar;
                boolean m;
                if (MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)) {
                    this.hnI.vBq = pInt4.value;
                    if (i != 701 && i != 702 && 10001 == r.idt && r.idu > 0) {
                        if (r.idu == 2) {
                            ac.F("", "", 0);
                        }
                        r.idu = 0;
                        pInt.value = -13;
                        x.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                    }
                    if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003) {
                        this.hnI.vBp = pInt.value;
                        if (pInt.value == -3002) {
                            try {
                                this.hnI.vBr = new String(pByteArray2.value);
                            } catch (Exception e) {
                                x.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                            }
                            x.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", Integer.valueOf(i), Integer.valueOf(pInt.value), pInt3, this.hnI.vBr);
                        }
                    } else {
                        x.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d, headExtFlags:%d", Integer.valueOf(i), Integer.valueOf(pInt2.value), Integer.valueOf(cVar.E(pByteArray2.value)), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(this.hnI.vBq));
                        this.hnI.vBp = r1;
                    }
                    this.hnI.vBo = (long) bArr.length;
                    this.hnJ = pByteArray.value;
                    if (!bh.ov(r.idw)) {
                        this.hnI.vBr = r.idw;
                    }
                    if (pInt3.value != 0) {
                        hcVar = new hc();
                        hcVar.fxm.fxn = pInt3.value;
                        if (i == 701 && this.hnI.vBp == 0) {
                            x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d]", Integer.valueOf(pInt3.value));
                            hcVar.fxm.fxo = true;
                        }
                        m = com.tencent.mm.sdk.b.a.xef.m(hcVar);
                        x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                        pInt3.value = 0;
                    }
                    return true;
                }
                x.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", Integer.valueOf(i));
                if (pInt3.value != 0) {
                    hcVar = new hc();
                    hcVar.fxm.fxn = pInt3.value;
                    m = com.tencent.mm.sdk.b.a.xef.m(hcVar);
                    x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                    pInt3.value = 0;
                }
                return false;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.RemoteResp", e2, "from Protobuf unbuild exception, check now!", new Object[0]);
                x.e("MicroMsg.RemoteResp", "exception:%s", bh.i(e2));
            }
        } else {
            x.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, PInt pInt, bdf com_tencent_mm_protocal_c_bdf) {
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        try {
            x.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, new PInt(255))), Integer.valueOf(pInt3.value), Integer.valueOf(r7.value));
            if (pInt3.value != 0) {
                b hcVar = new hc();
                hcVar.fxm.fxn = pInt3.value;
                boolean m = com.tencent.mm.sdk.b.a.xef.m(hcVar);
                x.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
            }
            if (!r1) {
                x.e("MicroMsg.RemoteResp", "unpack failed.");
                return null;
            } else if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001) {
                x.e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    x.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new af(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            if (!bh.ov(str) && t.hnK != null) {
                                t.hnK.cC(str);
                            }
                        }
                    });
                    return null;
                } catch (Exception e) {
                    x.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                x.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", Integer.valueOf(110), Integer.valueOf(pInt2.value));
                com_tencent_mm_protocal_c_bdf.aF(pByteArray2.value);
                return pByteArray2.value;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.RemoteResp", e2, "parseFrom unbuild exception, check now!", new Object[0]);
            x.e("MicroMsg.RemoteResp", "exception:%s", bh.i(e2));
        }
    }

    public final byte[] Ks() {
        return this.hnJ;
    }

    public final int KL() {
        return this.hnI.vBq;
    }

    public final String KM() {
        return this.hnI.vBr;
    }

    public final void jv(String str) {
        this.hnI.vBr = str;
    }

    public final int KN() {
        return this.hnI.vBp;
    }

    public final void hm(int i) {
        this.hnI.vBp = i;
    }

    public final byte[] CF() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((y.b) this.hnI).hZs;
            case 701:
            case 702:
                return ((g) this.hnI).hZs;
            default:
                return bArr;
        }
    }

    public final byte[] KO() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                bfl com_tencent_mm_protocal_c_bfl = ((y.b) this.hnI).vBT.wBn;
                if (com_tencent_mm_protocal_c_bfl == null || com_tencent_mm_protocal_c_bfl.vJa == null) {
                    x.d("MicroMsg.RemoteResp", "summerauth MMFunc_NewReg SecAuthRegKeySect is null");
                    break;
                }
                return com_tencent_mm_protocal_c_bfl.vJa.wJD.toByteArray();
            case 701:
            case 702:
                if (((g) this.hnI).vAZ.wRq.vJa != null) {
                    return ((g) this.hnI).vAZ.wRq.vJa.wJD.toByteArray();
                }
                break;
        }
        return bArr;
    }

    public final byte[] Ku() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((y.b) this.hnI).vBa;
            case 701:
            case 702:
                return ((g) this.hnI).vBa;
            default:
                return bArr;
        }
    }

    public final String KP() {
        if (this.type == 381) {
            bak com_tencent_mm_protocal_c_bak = ((com.tencent.mm.protocal.r.b) this.hnI).vBJ.wjz;
            if (com_tencent_mm_protocal_c_bak != null) {
                return bh.ou(com_tencent_mm_protocal_c_bak.wHf);
            }
        }
        return "";
    }

    public final String KQ() {
        if (this.type == 381) {
            bak com_tencent_mm_protocal_c_bak = ((com.tencent.mm.protocal.r.b) this.hnI).vBJ.wjz;
            if (com_tencent_mm_protocal_c_bak != null) {
                return bh.ou(com_tencent_mm_protocal_c_bak.wHe);
            }
        }
        return "";
    }

    public final int KR() {
        if (this.type == 381) {
            return ((com.tencent.mm.protocal.r.b) this.hnI).vBJ.wiI;
        }
        return 0;
    }

    public final int Cg() {
        switch (this.type) {
            case 126:
                return ((y.b) this.hnI).vBT.lOd;
            case 701:
            case 702:
                return ((g) this.hnI).vAZ.wRq.lOd;
            default:
                return 0;
        }
    }

    public final String KS() {
        switch (this.type) {
            case 126:
                return ((y.b) this.hnI).vBT.ksU;
            case 701:
            case 702:
                return ((g) this.hnI).hZv;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.hnI.getCmdId();
    }
}
