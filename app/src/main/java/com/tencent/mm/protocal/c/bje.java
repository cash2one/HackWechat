package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bje extends a {
    public int ktN;
    public String nje;
    public int pbl;
    public int vHW;
    public String wFM;
    public bdn wMA;
    public int wMB;
    public String wMt;
    public String wMu;
    public int wMv;
    public int wMw;
    public int wMx;
    public long wMy;
    public long wMz;
    public String wbg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wFM != null) {
                aVar.g(1, this.wFM);
            }
            if (this.wbg != null) {
                aVar.g(2, this.wbg);
            }
            if (this.wMt != null) {
                aVar.g(3, this.wMt);
            }
            if (this.wMu != null) {
                aVar.g(4, this.wMu);
            }
            aVar.fU(5, this.ktN);
            aVar.fU(6, this.vHW);
            aVar.fU(7, this.pbl);
            if (this.nje != null) {
                aVar.g(8, this.nje);
            }
            aVar.fU(9, this.wMv);
            aVar.fU(10, this.wMw);
            aVar.fU(11, this.wMx);
            aVar.S(12, this.wMy);
            aVar.S(13, this.wMz);
            if (this.wMA != null) {
                aVar.fW(14, this.wMA.bke());
                this.wMA.a(aVar);
            }
            aVar.fU(15, this.wMB);
            return 0;
        } else if (i == 1) {
            if (this.wFM != null) {
                r0 = e.a.a.b.b.a.h(1, this.wFM) + 0;
            } else {
                r0 = 0;
            }
            if (this.wbg != null) {
                r0 += e.a.a.b.b.a.h(2, this.wbg);
            }
            if (this.wMt != null) {
                r0 += e.a.a.b.b.a.h(3, this.wMt);
            }
            if (this.wMu != null) {
                r0 += e.a.a.b.b.a.h(4, this.wMu);
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.ktN)) + e.a.a.a.fR(6, this.vHW)) + e.a.a.a.fR(7, this.pbl);
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(8, this.nje);
            }
            r0 = ((((r0 + e.a.a.a.fR(9, this.wMv)) + e.a.a.a.fR(10, this.wMw)) + e.a.a.a.fR(11, this.wMx)) + e.a.a.a.R(12, this.wMy)) + e.a.a.a.R(13, this.wMz);
            if (this.wMA != null) {
                r0 += e.a.a.a.fT(14, this.wMA.bke());
            }
            return r0 + e.a.a.a.fR(15, this.wMB);
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
            bje com_tencent_mm_protocal_c_bje = (bje) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bje.wFM = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bje.wbg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bje.wMt = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bje.wMu = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bje.ktN = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bje.vHW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bje.pbl = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bje.nje = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bje.wMv = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bje.wMw = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bje.wMx = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bje.wMy = aVar3.Avy.rz();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bje.wMz = aVar3.Avy.rz();
                    return 0;
                case 14:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bje.wMA = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bje.wMB = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
