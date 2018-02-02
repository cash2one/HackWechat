package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class azg extends a {
    public String fGU;
    public int wGi;
    public boolean wGj;
    public String wGk;
    public int wGl;
    public int wGm;
    public LinkedList<azf> wGn = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGU != null) {
                aVar.g(1, this.fGU);
            }
            aVar.fU(2, this.wGi);
            aVar.al(3, this.wGj);
            if (this.wGk != null) {
                aVar.g(4, this.wGk);
            }
            aVar.fU(5, this.wGl);
            aVar.fU(6, this.wGm);
            aVar.d(7, 8, this.wGn);
            return 0;
        } else if (i == 1) {
            if (this.fGU != null) {
                r0 = e.a.a.b.b.a.h(1, this.fGU) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.wGi)) + (e.a.a.b.b.a.dX(3) + 1);
            if (this.wGk != null) {
                r0 += e.a.a.b.b.a.h(4, this.wGk);
            }
            return ((r0 + e.a.a.a.fR(5, this.wGl)) + e.a.a.a.fR(6, this.wGm)) + e.a.a.a.c(7, 8, this.wGn);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wGn.clear();
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
            azg com_tencent_mm_protocal_c_azg = (azg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_azg.fGU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azg.wGi = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azg.wGj = aVar3.cJC();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azg.wGk = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azg.wGl = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azg.wGm = aVar3.Avy.ry();
                    return 0;
                case 7:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_azf = new azf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_azf.a(aVar4, com_tencent_mm_protocal_c_azf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azg.wGn.add(com_tencent_mm_protocal_c_azf);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
