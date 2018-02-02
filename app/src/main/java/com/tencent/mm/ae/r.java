package com.tencent.mm.ae;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.protocal.g.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class r extends a {
    private static e hnA;
    private d hmw;
    private byte[] hnB;
    private int type;

    public static void a(e eVar) {
        hnA = eVar;
    }

    public r(d dVar, int i) {
        this.hmw = dVar;
        this.type = i;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, d dVar, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        if (bh.bw(bArr)) {
            String str = "MicroMsg.RemoteReq";
            String str2 = "reqToBufNoRSA session is null :%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            x.e(str, str2, objArr);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            b bVar = (b) dVar;
            byte[] Hq = bVar.Hq();
            if (Hq == null) {
                return false;
            }
            if (bVar.cdI()) {
                byteArrayOutputStream.write(Hq);
                return true;
            }
            ac cdL = ac.cdL();
            int i = 6;
            if (z) {
                i = 7;
            }
            if (!MMProtocalJni.pack(Hq, pByteArray, bArr, bArr2, dVar.vBi, dVar.vBf, bVar.Hr(), cdL.ver, cdL.vBY.getBytes(), cdL.vBZ.getBytes(), bArr3, i)) {
                return false;
            }
            x.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i));
            byteArrayOutputStream.write(pByteArray.value);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e.getMessage());
            x.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z) {
        PByteArray pByteArray = new PByteArray();
        x.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i), bh.cgy());
        switch (i) {
            case 268369922:
                try {
                    this.hnB = ((b) this.hmw).Hq();
                    this.hmw.vBo = (long) this.hnB.length;
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
                    return false;
                }
            default:
                if (this.hmw instanceof b) {
                    try {
                        b bVar = (b) this.hmw;
                        byte[] Hq = bVar.Hq();
                        if (Hq == null) {
                            return false;
                        }
                        if (bVar.cdI()) {
                            this.hnB = Hq;
                            this.hmw.vBo = (long) this.hnB.length;
                            return true;
                        }
                        long j;
                        int i3;
                        int i4;
                        Object obj;
                        long j2 = (long) this.hmw.vBf;
                        if (com.tencent.mm.sdk.a.b.ceK() && j2 == 0) {
                            j = com.tencent.mm.protocal.d.vAy;
                        } else {
                            j = j2;
                        }
                        ac acVar = this.hmw.vBn;
                        if (!acVar.cdO()) {
                            bArr = new byte[0];
                        }
                        byte[][] bArr4 = null;
                        int i5;
                        switch (i) {
                            case 701:
                                aqe com_tencent_mm_protocal_c_aqe = ((i.d) this.hmw).vAW;
                                bArr4 = a(j, com_tencent_mm_protocal_c_aqe.wwY, com_tencent_mm_protocal_c_aqe.wwZ);
                                i5 = 1;
                                break;
                            case 702:
                                x.d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", Long.valueOf(j));
                                if (j == 0) {
                                    if (c.a.vAV == null) {
                                        i3 = -1;
                                    } else {
                                        i3 = c.a.vAV.Hm();
                                    }
                                    g.Dk();
                                    g.Dh();
                                    x.w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.kernel.a.Cg()));
                                    com.tencent.mm.plugin.report.d.pPH.a(148, 54, 1, true);
                                    if (i3 != 0) {
                                        com.tencent.mm.plugin.report.d.pPH.a(148, 55, 1, true);
                                    }
                                    if (i4 != 0) {
                                        com.tencent.mm.plugin.report.d.pPH.a(148, 56, 1, true);
                                    }
                                }
                                eg egVar = ((i.a) this.hmw).vAU;
                                bArr4 = a(j, egVar.vJD, egVar.vJE);
                                i5 = 1;
                                break;
                            default:
                                obj = null;
                                break;
                        }
                        i3 = 6;
                        if (z) {
                            i3 = 7;
                        }
                        if (obj != null) {
                            if (acVar.cdO() && bh.bw(bArr)) {
                                x.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                                return false;
                            } else if (bArr4 == null) {
                                return false;
                            } else {
                                byte[] bArr5 = bArr4[0];
                                byte[] bArr6 = bArr4[1];
                                switch (i) {
                                    case 702:
                                        if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.hmw.vBi, (int) j, bVar.Hr(), acVar.ver, bArr5, bArr6, acVar.vBY.getBytes(), acVar.vBZ.getBytes(), KF(), i3)) {
                                            x.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.hnB = pByteArray.value;
                                            break;
                                        }
                                        break;
                                    default:
                                        if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.hmw.vBi, (int) j, bVar.Hr(), acVar.ver, bArr5, bArr6, acVar.vBY.getBytes(), acVar.vBZ.getBytes(), KF(), i3)) {
                                            x.d("MicroMsg.RemoteReq", "MMEncryptCheckResUpdate reqToBuf packHybrid EncryptCheckResUpdate using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.hnB = pByteArray.value;
                                            break;
                                        }
                                        break;
                                }
                                this.hmw.vBo = (long) this.hnB.length;
                            }
                        } else if (this.hmw.vBl != null) {
                            int i6 = 6;
                            if (z) {
                                i6 = 7;
                            }
                            if (this.hmw.vBl.a(pByteArray, i, bArr2, bArr3, i6)) {
                                this.hnB = pByteArray.value;
                                this.hmw.vBo = (long) this.hnB.length;
                                x.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                            }
                            return true;
                        } else if (i != 775 && acVar.cdO() && bh.bw(bArr)) {
                            x.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                            return false;
                        } else {
                            if (i == 775) {
                                i4 = (i3 & -3) & -5;
                            } else {
                                i4 = i3;
                            }
                            x.d("MicroMsg.RemoteReq", "dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s]", bArr, Integer.valueOf(i), Integer.valueOf(i4), bh.bv(bArr3));
                            if (MMProtocalJni.pack(Hq, pByteArray, bArr, bArr2, this.hmw.vBi, (int) j, bVar.Hr(), acVar.ver, acVar.vBY.getBytes(), acVar.vBZ.getBytes(), bArr3, i4)) {
                                x.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                                this.hnB = pByteArray.value;
                            }
                            this.hmw.vBo = (long) this.hnB.length;
                        }
                        return true;
                    } catch (Throwable e2) {
                        x.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
                        return false;
                    }
                }
                x.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
                return false;
        }
    }

    public static byte[][] a(long j, com.tencent.mm.bq.a aVar, com.tencent.mm.bq.a aVar2) {
        byte[] toByteArray;
        if (j == 0) {
            x.w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            toByteArray = aVar.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", bh.i(e));
            toByteArray = null;
        }
        if (bh.bw(toByteArray)) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            return null;
        }
        byte[] toByteArray2;
        try {
            toByteArray2 = aVar2.toByteArray();
        } catch (Throwable e2) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", bh.i(e2));
            toByteArray2 = null;
        }
        if (bh.bw(toByteArray2)) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            return null;
        }
        return new byte[][]{toByteArray, toByteArray2};
    }

    public final byte[] KB() {
        return this.hnB;
    }

    public final void H(byte[] bArr) {
        d dVar = this.hmw;
        if (bArr == null) {
            bArr = new byte[0];
        }
        dVar.bjP = bArr;
    }

    public final byte[] CF() {
        return this.hmw.bjP;
    }

    public final void eE(int i) {
        this.hmw.eE(i);
    }

    public final int Cg() {
        return this.hmw.vBf;
    }

    public final void hk(int i) {
        this.hmw.vBg = i;
    }

    public final int getClientVersion() {
        return this.hmw.vBg;
    }

    public final void js(String str) {
        this.hmw.vBh = str;
    }

    public final String KC() {
        return this.hmw.vBh;
    }

    public final String KD() {
        return this.hmw.vBi;
    }

    public final void jt(String str) {
        this.hmw.vBi = str;
    }

    public final void hl(int i) {
        this.hmw.vBj = i;
    }

    public final int KE() {
        return this.hmw.vBj;
    }

    public final byte[] KF() {
        x.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        switch (this.type) {
            case 126:
                return ((y.a) this.hmw).vBS.vMi.wJD.toByteArray();
            case 381:
                return ((com.tencent.mm.protocal.r.a) this.hmw).vBI.vMi.wJD.toByteArray();
            case 701:
                return ((i.d) this.hmw).vAW.wwY.vMi.wJD.toByteArray();
            case 702:
                return ((i.a) this.hmw).vAU.vJD.vJF.wJD.toByteArray();
            default:
                if (hnA != null) {
                    byte[] a = hnA.a(this.hmw, this.type);
                    if (a != null) {
                        return a;
                    }
                }
                if (this.hmw.vBm != null) {
                    return this.hmw.vBm;
                }
                return CF();
        }
    }

    public final String getPassword() {
        switch (this.type) {
            case 126:
                return ((y.a) this.hmw).vBS.vMp;
            case 701:
                return ((i.d) this.hmw).vAW.wwY.vMp;
            default:
                return "";
        }
    }

    public final String KG() {
        switch (this.type) {
            case 701:
                return ((i.d) this.hmw).vAW.wwY.vMB;
            default:
                return "";
        }
    }

    public final String getUserName() {
        switch (this.type) {
            case 126:
                return ((y.a) this.hmw).vBS.ksU;
            case 701:
                return ((i.d) this.hmw).vAW.wwY.ksU;
            case 702:
                return ((i.a) this.hmw).username;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.hmw.getCmdId();
    }

    public final boolean KH() {
        return this.hmw.KH();
    }
}
