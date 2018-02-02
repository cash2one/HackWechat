package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class jr extends bcv {
    public String ngo;
    public String nko;
    public String nkp;
    public int rYW;
    public String vFC;
    public String vFD;
    public String vFE;
    public int vHW;
    public String vHc;
    public String vQA;
    public int vQB;
    public int vQC;
    public int vQD;
    public String vQp;
    public int vQq;
    public int vQr;
    public bdn vQs;
    public float vQt;
    public float vQu;
    public String vQv;
    public int vQw;
    public int vQx;
    public int vQy;
    public int vQz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vQp != null) {
                aVar.g(1, this.vQp);
            }
            if (this.nkp != null) {
                aVar.g(2, this.nkp);
            }
            if (this.nko != null) {
                aVar.g(3, this.nko);
            }
            aVar.fU(4, this.vQq);
            aVar.fU(5, this.vQr);
            if (this.vHc != null) {
                aVar.g(6, this.vHc);
            }
            if (this.vQs != null) {
                aVar.fW(7, this.vQs.bke());
                this.vQs.a(aVar);
            }
            aVar.fU(8, this.rYW);
            aVar.m(9, this.vQt);
            aVar.m(10, this.vQu);
            if (this.vQv != null) {
                aVar.g(11, this.vQv);
            }
            aVar.fU(12, this.vQw);
            aVar.fU(13, this.vQx);
            aVar.fU(14, this.vQy);
            aVar.fU(15, this.vQz);
            if (this.vQA != null) {
                aVar.g(16, this.vQA);
            }
            aVar.fU(17, this.vQB);
            aVar.fU(18, this.vQC);
            aVar.fU(19, this.vQD);
            aVar.fU(20, this.vHW);
            if (this.ngo != null) {
                aVar.g(21, this.ngo);
            }
            if (this.vFE != null) {
                aVar.g(22, this.vFE);
            }
            if (this.vFD != null) {
                aVar.g(23, this.vFD);
            }
            if (this.vFC == null) {
                return 0;
            }
            aVar.g(24, this.vFC);
            return 0;
        } else if (i == 1) {
            if (this.vQp != null) {
                r0 = e.a.a.b.b.a.h(1, this.vQp) + 0;
            } else {
                r0 = 0;
            }
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nkp);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(3, this.nko);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.vQq)) + e.a.a.a.fR(5, this.vQr);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(6, this.vHc);
            }
            if (this.vQs != null) {
                r0 += e.a.a.a.fT(7, this.vQs.bke());
            }
            r0 = ((r0 + e.a.a.a.fR(8, this.rYW)) + (e.a.a.b.b.a.dX(9) + 4)) + (e.a.a.b.b.a.dX(10) + 4);
            if (this.vQv != null) {
                r0 += e.a.a.b.b.a.h(11, this.vQv);
            }
            r0 = (((r0 + e.a.a.a.fR(12, this.vQw)) + e.a.a.a.fR(13, this.vQx)) + e.a.a.a.fR(14, this.vQy)) + e.a.a.a.fR(15, this.vQz);
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(16, this.vQA);
            }
            r0 = (((r0 + e.a.a.a.fR(17, this.vQB)) + e.a.a.a.fR(18, this.vQC)) + e.a.a.a.fR(19, this.vQD)) + e.a.a.a.fR(20, this.vHW);
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(21, this.ngo);
            }
            if (this.vFE != null) {
                r0 += e.a.a.b.b.a.h(22, this.vFE);
            }
            if (this.vFD != null) {
                r0 += e.a.a.b.b.a.h(23, this.vFD);
            }
            if (this.vFC != null) {
                r0 += e.a.a.b.b.a.h(24, this.vFC);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jr jrVar = (jr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jrVar.vQp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    jrVar.nkp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    jrVar.nko = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jrVar.vQq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    jrVar.vQr = aVar3.Avy.ry();
                    return 0;
                case 6:
                    jrVar.vHc = aVar3.Avy.readString();
                    return 0;
                case 7:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, bcv.a(aVar4))) {
                        }
                        jrVar.vQs = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 8:
                    jrVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 9:
                    jrVar.vQt = aVar3.Avy.readFloat();
                    return 0;
                case 10:
                    jrVar.vQu = aVar3.Avy.readFloat();
                    return 0;
                case 11:
                    jrVar.vQv = aVar3.Avy.readString();
                    return 0;
                case 12:
                    jrVar.vQw = aVar3.Avy.ry();
                    return 0;
                case 13:
                    jrVar.vQx = aVar3.Avy.ry();
                    return 0;
                case 14:
                    jrVar.vQy = aVar3.Avy.ry();
                    return 0;
                case 15:
                    jrVar.vQz = aVar3.Avy.ry();
                    return 0;
                case 16:
                    jrVar.vQA = aVar3.Avy.readString();
                    return 0;
                case 17:
                    jrVar.vQB = aVar3.Avy.ry();
                    return 0;
                case 18:
                    jrVar.vQC = aVar3.Avy.ry();
                    return 0;
                case 19:
                    jrVar.vQD = aVar3.Avy.ry();
                    return 0;
                case 20:
                    jrVar.vHW = aVar3.Avy.ry();
                    return 0;
                case 21:
                    jrVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 22:
                    jrVar.vFE = aVar3.Avy.readString();
                    return 0;
                case 23:
                    jrVar.vFD = aVar3.Avy.readString();
                    return 0;
                case 24:
                    jrVar.vFC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
