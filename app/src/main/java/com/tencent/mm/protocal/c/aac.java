package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aac extends bdf {
    public String content;
    public String hbM;
    public String kJN;
    public String kKO;
    public String kKP;
    public String vEQ;
    public String vER;
    public String vES;
    public String vET;
    public String vEU;
    public String vEV;
    public String vEW;
    public String vEX;
    public String vEY;
    public String vEZ;
    public String vFa;
    public String vFb;
    public boolean vFc = false;
    public int vFd;
    public int vFe;
    public int vFf;
    public String vFg;
    public String vFh;
    public int vFi;
    public String vFj;
    public String vFk;
    public String vFl;
    public String vFm;
    public String vFn;
    public String vFo;
    public String vFp;
    public String vFq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            if (this.vEQ != null) {
                aVar.g(2, this.vEQ);
            }
            if (this.vER != null) {
                aVar.g(3, this.vER);
            }
            if (this.vES != null) {
                aVar.g(4, this.vES);
            }
            if (this.content != null) {
                aVar.g(5, this.content);
            }
            if (this.vET != null) {
                aVar.g(6, this.vET);
            }
            if (this.vEU != null) {
                aVar.g(7, this.vEU);
            }
            if (this.vEV != null) {
                aVar.g(8, this.vEV);
            }
            if (this.vEW != null) {
                aVar.g(9, this.vEW);
            }
            if (this.vEX != null) {
                aVar.g(10, this.vEX);
            }
            if (this.vEY != null) {
                aVar.g(11, this.vEY);
            }
            if (this.vEZ != null) {
                aVar.g(12, this.vEZ);
            }
            if (this.vFa != null) {
                aVar.g(13, this.vFa);
            }
            if (this.kKO != null) {
                aVar.g(14, this.kKO);
            }
            if (this.kKP != null) {
                aVar.g(15, this.kKP);
            }
            if (this.vFb != null) {
                aVar.g(16, this.vFb);
            }
            aVar.al(17, this.vFc);
            aVar.fU(18, this.vFd);
            aVar.fU(19, this.vFe);
            aVar.fU(20, this.vFf);
            if (this.hbM != null) {
                aVar.g(21, this.hbM);
            }
            if (this.vFg != null) {
                aVar.g(22, this.vFg);
            }
            if (this.vFh != null) {
                aVar.g(23, this.vFh);
            }
            aVar.fU(24, this.vFi);
            if (this.vFj != null) {
                aVar.g(25, this.vFj);
            }
            if (this.vFk != null) {
                aVar.g(26, this.vFk);
            }
            if (this.vFl != null) {
                aVar.g(27, this.vFl);
            }
            if (this.vFm != null) {
                aVar.g(28, this.vFm);
            }
            if (this.vFn != null) {
                aVar.g(29, this.vFn);
            }
            if (this.vFo != null) {
                aVar.g(30, this.vFo);
            }
            if (this.vFp != null) {
                aVar.g(31, this.vFp);
            }
            if (this.kJN != null) {
                aVar.g(32, this.kJN);
            }
            if (this.vFq == null) {
                return 0;
            }
            aVar.g(33, this.vFq);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vEQ != null) {
                r0 += e.a.a.b.b.a.h(2, this.vEQ);
            }
            if (this.vER != null) {
                r0 += e.a.a.b.b.a.h(3, this.vER);
            }
            if (this.vES != null) {
                r0 += e.a.a.b.b.a.h(4, this.vES);
            }
            if (this.content != null) {
                r0 += e.a.a.b.b.a.h(5, this.content);
            }
            if (this.vET != null) {
                r0 += e.a.a.b.b.a.h(6, this.vET);
            }
            if (this.vEU != null) {
                r0 += e.a.a.b.b.a.h(7, this.vEU);
            }
            if (this.vEV != null) {
                r0 += e.a.a.b.b.a.h(8, this.vEV);
            }
            if (this.vEW != null) {
                r0 += e.a.a.b.b.a.h(9, this.vEW);
            }
            if (this.vEX != null) {
                r0 += e.a.a.b.b.a.h(10, this.vEX);
            }
            if (this.vEY != null) {
                r0 += e.a.a.b.b.a.h(11, this.vEY);
            }
            if (this.vEZ != null) {
                r0 += e.a.a.b.b.a.h(12, this.vEZ);
            }
            if (this.vFa != null) {
                r0 += e.a.a.b.b.a.h(13, this.vFa);
            }
            if (this.kKO != null) {
                r0 += e.a.a.b.b.a.h(14, this.kKO);
            }
            if (this.kKP != null) {
                r0 += e.a.a.b.b.a.h(15, this.kKP);
            }
            if (this.vFb != null) {
                r0 += e.a.a.b.b.a.h(16, this.vFb);
            }
            r0 = (((r0 + (e.a.a.b.b.a.dX(17) + 1)) + e.a.a.a.fR(18, this.vFd)) + e.a.a.a.fR(19, this.vFe)) + e.a.a.a.fR(20, this.vFf);
            if (this.hbM != null) {
                r0 += e.a.a.b.b.a.h(21, this.hbM);
            }
            if (this.vFg != null) {
                r0 += e.a.a.b.b.a.h(22, this.vFg);
            }
            if (this.vFh != null) {
                r0 += e.a.a.b.b.a.h(23, this.vFh);
            }
            r0 += e.a.a.a.fR(24, this.vFi);
            if (this.vFj != null) {
                r0 += e.a.a.b.b.a.h(25, this.vFj);
            }
            if (this.vFk != null) {
                r0 += e.a.a.b.b.a.h(26, this.vFk);
            }
            if (this.vFl != null) {
                r0 += e.a.a.b.b.a.h(27, this.vFl);
            }
            if (this.vFm != null) {
                r0 += e.a.a.b.b.a.h(28, this.vFm);
            }
            if (this.vFn != null) {
                r0 += e.a.a.b.b.a.h(29, this.vFn);
            }
            if (this.vFo != null) {
                r0 += e.a.a.b.b.a.h(30, this.vFo);
            }
            if (this.vFp != null) {
                r0 += e.a.a.b.b.a.h(31, this.vFp);
            }
            if (this.kJN != null) {
                r0 += e.a.a.b.b.a.h(32, this.kJN);
            }
            if (this.vFq != null) {
                r0 += e.a.a.b.b.a.h(33, this.vFq);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aac com_tencent_mm_protocal_c_aac = (aac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aac.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aac.vEQ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aac.vER = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aac.vES = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aac.content = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aac.vET = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aac.vEU = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aac.vEV = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aac.vEW = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aac.vEX = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aac.vEY = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aac.vEZ = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aac.vFa = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aac.kKO = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aac.kKP = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aac.vFb = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aac.vFc = aVar3.cJC();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aac.vFd = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aac.vFe = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aac.vFf = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aac.hbM = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aac.vFg = aVar3.Avy.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aac.vFh = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aac.vFi = aVar3.Avy.ry();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_aac.vFj = aVar3.Avy.readString();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_aac.vFk = aVar3.Avy.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_aac.vFl = aVar3.Avy.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_aac.vFm = aVar3.Avy.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_aac.vFn = aVar3.Avy.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_aac.vFo = aVar3.Avy.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_aac.vFp = aVar3.Avy.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_aac.kJN = aVar3.Avy.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_aac.vFq = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
