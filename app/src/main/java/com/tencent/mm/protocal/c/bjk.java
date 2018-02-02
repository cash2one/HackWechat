package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bjk extends a {
    public int ktN;
    public String nje;
    public int pbl;
    public int vHW;
    public String vIy;
    public int wMB;
    public String wMQ;
    public int wMv;
    public int wMw;
    public int wMx;
    public long wMy;
    public long wMz;
    public String wvW;
    public int wzr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIy != null) {
                aVar.g(1, this.vIy);
            }
            if (this.wvW != null) {
                aVar.g(2, this.wvW);
            }
            aVar.fU(3, this.vHW);
            aVar.fU(4, this.ktN);
            if (this.nje != null) {
                aVar.g(5, this.nje);
            }
            aVar.fU(6, this.pbl);
            aVar.fU(7, this.wMw);
            aVar.fU(8, this.wMv);
            if (this.wMQ != null) {
                aVar.g(9, this.wMQ);
            }
            aVar.fU(10, this.wMx);
            aVar.S(11, this.wMy);
            aVar.S(12, this.wMz);
            aVar.fU(13, this.wzr);
            aVar.fU(14, this.wMB);
            return 0;
        } else if (i == 1) {
            if (this.vIy != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIy) + 0;
            } else {
                r0 = 0;
            }
            if (this.wvW != null) {
                r0 += e.a.a.b.b.a.h(2, this.wvW);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.vHW)) + e.a.a.a.fR(4, this.ktN);
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(5, this.nje);
            }
            r0 = ((r0 + e.a.a.a.fR(6, this.pbl)) + e.a.a.a.fR(7, this.wMw)) + e.a.a.a.fR(8, this.wMv);
            if (this.wMQ != null) {
                r0 += e.a.a.b.b.a.h(9, this.wMQ);
            }
            return ((((r0 + e.a.a.a.fR(10, this.wMx)) + e.a.a.a.R(11, this.wMy)) + e.a.a.a.R(12, this.wMz)) + e.a.a.a.fR(13, this.wzr)) + e.a.a.a.fR(14, this.wMB);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjk com_tencent_mm_protocal_c_bjk = (bjk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bjk.vIy = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjk.wvW = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjk.vHW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjk.ktN = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjk.nje = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjk.pbl = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjk.wMw = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bjk.wMv = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bjk.wMQ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bjk.wMx = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bjk.wMy = aVar3.Avy.rz();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bjk.wMz = aVar3.Avy.rz();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bjk.wzr = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bjk.wMB = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
