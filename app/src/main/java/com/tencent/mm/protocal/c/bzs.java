package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bzs extends a {
    public String lOo;
    public int rYW;
    public long vPp;
    public LinkedList<String> wZp = new LinkedList();
    public LinkedList<or> wZq = new LinkedList();
    public String whF;
    public int wwH;
    public aoh wwI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.wZp);
            aVar.fU(2, this.wwH);
            if (this.lOo != null) {
                aVar.g(3, this.lOo);
            }
            aVar.fU(4, this.rYW);
            aVar.S(5, this.vPp);
            if (this.whF != null) {
                aVar.g(6, this.whF);
            }
            if (this.wwI != null) {
                aVar.fW(7, this.wwI.bke());
                this.wwI.a(aVar);
            }
            aVar.d(8, 8, this.wZq);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.c(1, 1, this.wZp) + 0) + e.a.a.a.fR(2, this.wwH);
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(3, this.lOo);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.rYW)) + e.a.a.a.R(5, this.vPp);
            if (this.whF != null) {
                r0 += e.a.a.b.b.a.h(6, this.whF);
            }
            if (this.wwI != null) {
                r0 += e.a.a.a.fT(7, this.wwI.bke());
            }
            return r0 + e.a.a.a.c(8, 8, this.wZq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wZp.clear();
            this.wZq.clear();
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
            bzs com_tencent_mm_protocal_c_bzs = (bzs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_aoh;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bzs.wZp.add(aVar3.Avy.readString());
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzs.wwH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzs.lOo = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzs.rYW = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bzs.vPp = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bzs.whF = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new aoh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzs.wwI = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new or();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzs.wZq.add(com_tencent_mm_protocal_c_aoh);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
