package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bzp extends a {
    public int rYW;
    public int vNW;
    public String vPs;
    public int wIL;
    public int wYe = 2;
    public String wYh;
    public int wZl;
    public LinkedList<or> wZm = new LinkedList();
    public String wgS;
    public int wwH;
    public aoh wwI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vNW);
            aVar.fU(2, this.wwH);
            aVar.fU(3, this.wIL);
            if (this.wgS != null) {
                aVar.g(4, this.wgS);
            }
            if (this.wwI != null) {
                aVar.fW(5, this.wwI.bke());
                this.wwI.a(aVar);
            }
            aVar.fU(6, this.rYW);
            if (this.vPs != null) {
                aVar.g(7, this.vPs);
            }
            aVar.fU(8, this.wZl);
            aVar.fU(9, this.wYe);
            aVar.d(10, 8, this.wZm);
            if (this.wYh != null) {
                aVar.g(11, this.wYh);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.vNW) + 0) + e.a.a.a.fR(2, this.wwH)) + e.a.a.a.fR(3, this.wIL);
            if (this.wgS != null) {
                r0 += e.a.a.b.b.a.h(4, this.wgS);
            }
            if (this.wwI != null) {
                r0 += e.a.a.a.fT(5, this.wwI.bke());
            }
            r0 += e.a.a.a.fR(6, this.rYW);
            if (this.vPs != null) {
                r0 += e.a.a.b.b.a.h(7, this.vPs);
            }
            r0 = ((r0 + e.a.a.a.fR(8, this.wZl)) + e.a.a.a.fR(9, this.wYe)) + e.a.a.a.c(10, 8, this.wZm);
            if (this.wYh != null) {
                return r0 + e.a.a.b.b.a.h(11, this.wYh);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wZm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            bzp com_tencent_mm_protocal_c_bzp = (bzp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_aoh;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bzp.vNW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzp.wwH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzp.wIL = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzp.wgS = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new aoh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzp.wwI = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bzp.rYW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bzp.vPs = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bzp.wZl = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bzp.wYe = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new or();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzp.wZm.add(com_tencent_mm_protocal_c_aoh);
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bzp.wYh = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
