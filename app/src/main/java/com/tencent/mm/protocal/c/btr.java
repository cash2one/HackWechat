package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btr extends bdf {
    public int nDI;
    public int nDO;
    public int nDP;
    public int nDT;
    public LinkedList<btl> vJP = new LinkedList();
    public b wFF;
    public long wUT;
    public int wUY;
    public int wUZ;
    public int wVa;
    public int wVb;
    public LinkedList<btl> wVc = new LinkedList();
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.S(2, this.wUT);
            aVar.S(3, this.wbi);
            aVar.d(4, 8, this.vJP);
            aVar.fU(5, this.wUY);
            aVar.fU(6, this.nDO);
            aVar.fU(7, this.nDP);
            aVar.fU(8, this.nDI);
            aVar.fU(9, this.nDT);
            aVar.fU(10, this.wUZ);
            aVar.fU(11, this.wVa);
            if (this.wFF != null) {
                aVar.b(12, this.wFF);
            }
            aVar.fU(13, this.wVb);
            aVar.d(14, 8, this.wVc);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((((((((r0 + e.a.a.a.R(2, this.wUT)) + e.a.a.a.R(3, this.wbi)) + e.a.a.a.c(4, 8, this.vJP)) + e.a.a.a.fR(5, this.wUY)) + e.a.a.a.fR(6, this.nDO)) + e.a.a.a.fR(7, this.nDP)) + e.a.a.a.fR(8, this.nDI)) + e.a.a.a.fR(9, this.nDT)) + e.a.a.a.fR(10, this.wUZ)) + e.a.a.a.fR(11, this.wVa);
            if (this.wFF != null) {
                r0 += e.a.a.a.a(12, this.wFF);
            }
            return (r0 + e.a.a.a.fR(13, this.wVb)) + e.a.a.a.c(14, 8, this.wVc);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vJP.clear();
            this.wVc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btr com_tencent_mm_protocal_c_btr = (btr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btr.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_btr.wUT = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_btr.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new btl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btr.vJP.add(feVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_btr.wUY = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_btr.nDO = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_btr.nDP = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_btr.nDI = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_btr.nDT = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_btr.wUZ = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_btr.wVa = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_btr.wFF = aVar3.cJD();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_btr.wVb = aVar3.Avy.ry();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new btl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btr.wVc.add(feVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
