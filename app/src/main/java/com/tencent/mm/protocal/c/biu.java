package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class biu extends a {
    public int pbw;
    public String vQO;
    public LinkedList<aya> wMe = new LinkedList();
    public ti wMf;
    public LinkedList<bbk> wMg = new LinkedList();
    public int wMh;
    public cb wlA;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.pbw);
            aVar.d(2, 8, this.wMe);
            if (this.wMf != null) {
                aVar.fW(3, this.wMf.bke());
                this.wMf.a(aVar);
            }
            if (this.wlA != null) {
                aVar.fW(4, this.wlA.bke());
                this.wlA.a(aVar);
            }
            aVar.d(5, 8, this.wMg);
            aVar.fU(6, this.wMh);
            if (this.vQO != null) {
                aVar.g(7, this.vQO);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.pbw) + 0) + e.a.a.a.c(2, 8, this.wMe);
            if (this.wMf != null) {
                r0 += e.a.a.a.fT(3, this.wMf.bke());
            }
            if (this.wlA != null) {
                r0 += e.a.a.a.fT(4, this.wlA.bke());
            }
            r0 = (r0 + e.a.a.a.c(5, 8, this.wMg)) + e.a.a.a.fR(6, this.wMh);
            if (this.vQO != null) {
                return r0 + e.a.a.b.b.a.h(7, this.vQO);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wMe.clear();
            this.wMg.clear();
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
            biu com_tencent_mm_protocal_c_biu = (biu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_aya;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_biu.pbw = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aya = new aya();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aya.a(aVar4, com_tencent_mm_protocal_c_aya, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biu.wMe.add(com_tencent_mm_protocal_c_aya);
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aya = new ti();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aya.a(aVar4, com_tencent_mm_protocal_c_aya, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biu.wMf = com_tencent_mm_protocal_c_aya;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aya = new cb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aya.a(aVar4, com_tencent_mm_protocal_c_aya, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biu.wlA = com_tencent_mm_protocal_c_aya;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aya = new bbk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aya.a(aVar4, com_tencent_mm_protocal_c_aya, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biu.wMg.add(com_tencent_mm_protocal_c_aya);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_biu.wMh = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_biu.vQO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
