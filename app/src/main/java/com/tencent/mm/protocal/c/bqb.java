package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bqb extends bcv {
    public int blZ;
    public String ffq;
    public String frg;
    public String hcp;
    public String wJS;
    public int wRE;
    public int wRF;
    public String wRG;
    public int wRH;
    public String wRI;
    public LinkedList<blo> wRJ = new LinkedList();
    public int wRK;
    public int wRL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ffq != null) {
                aVar.g(2, this.ffq);
            }
            if (this.frg != null) {
                aVar.g(3, this.frg);
            }
            aVar.fU(4, this.wRE);
            aVar.fU(5, this.wRF);
            aVar.fU(6, this.blZ);
            if (this.wRG != null) {
                aVar.g(7, this.wRG);
            }
            if (this.wJS != null) {
                aVar.g(8, this.wJS);
            }
            if (this.hcp != null) {
                aVar.g(9, this.hcp);
            }
            aVar.fU(10, this.wRH);
            if (this.wRI != null) {
                aVar.g(11, this.wRI);
            }
            aVar.d(12, 8, this.wRJ);
            aVar.fU(13, this.wRK);
            aVar.fU(14, this.wRL);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ffq != null) {
                r0 += e.a.a.b.b.a.h(2, this.ffq);
            }
            if (this.frg != null) {
                r0 += e.a.a.b.b.a.h(3, this.frg);
            }
            r0 = ((r0 + e.a.a.a.fR(4, this.wRE)) + e.a.a.a.fR(5, this.wRF)) + e.a.a.a.fR(6, this.blZ);
            if (this.wRG != null) {
                r0 += e.a.a.b.b.a.h(7, this.wRG);
            }
            if (this.wJS != null) {
                r0 += e.a.a.b.b.a.h(8, this.wJS);
            }
            if (this.hcp != null) {
                r0 += e.a.a.b.b.a.h(9, this.hcp);
            }
            r0 += e.a.a.a.fR(10, this.wRH);
            if (this.wRI != null) {
                r0 += e.a.a.b.b.a.h(11, this.wRI);
            }
            return ((r0 + e.a.a.a.c(12, 8, this.wRJ)) + e.a.a.a.fR(13, this.wRK)) + e.a.a.a.fR(14, this.wRL);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wRJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            bqb com_tencent_mm_protocal_c_bqb = (bqb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqb.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqb.ffq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqb.frg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqb.wRE = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqb.wRF = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqb.blZ = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bqb.wRG = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bqb.wJS = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bqb.hcp = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bqb.wRH = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bqb.wRI = aVar3.Avy.readString();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new blo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqb.wRJ.add(fdVar);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bqb.wRK = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bqb.wRL = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
