package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class blw extends bcv {
    public String nko;
    public String nkp;
    public String vHU;
    public int wPs;
    public int wPt;
    public LinkedList<bly> wPu = new LinkedList();
    public blv wPv;
    public int wPw;
    public LinkedList<blv> wPx = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wPs);
            if (this.nkp != null) {
                aVar.g(3, this.nkp);
            }
            if (this.nko != null) {
                aVar.g(4, this.nko);
            }
            if (this.vHU != null) {
                aVar.g(5, this.vHU);
            }
            aVar.fU(6, this.wPt);
            aVar.d(7, 8, this.wPu);
            if (this.wPv != null) {
                aVar.fW(8, this.wPv.bke());
                this.wPv.a(aVar);
            }
            aVar.fU(9, this.wPw);
            aVar.d(10, 8, this.wPx);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wPs);
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(3, this.nkp);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(4, this.nko);
            }
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(5, this.vHU);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.wPt)) + e.a.a.a.c(7, 8, this.wPu);
            if (this.wPv != null) {
                r0 += e.a.a.a.fT(8, this.wPv.bke());
            }
            return (r0 + e.a.a.a.fR(9, this.wPw)) + e.a.a.a.c(10, 8, this.wPx);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wPu.clear();
            this.wPx.clear();
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
            blw com_tencent_mm_protocal_c_blw = (blw) objArr[1];
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
                        com_tencent_mm_protocal_c_blw.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blw.wPs = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blw.nkp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blw.nko = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blw.vHU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blw.wPt = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bly();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blw.wPu.add(fdVar);
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new blv();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blw.wPv = fdVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_blw.wPw = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new blv();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blw.wPx.add(fdVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
