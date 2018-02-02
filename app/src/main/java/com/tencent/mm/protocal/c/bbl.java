package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bbl extends a {
    public bdo wHO;
    public int wHP;
    public LinkedList<bfd> wHQ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wHO == null) {
                throw new b("Not all required fields were included: GroupName");
            }
            if (this.wHO != null) {
                aVar.fW(1, this.wHO.bke());
                this.wHO.a(aVar);
            }
            aVar.fU(2, this.wHP);
            aVar.d(3, 8, this.wHQ);
            return 0;
        } else if (i == 1) {
            if (this.wHO != null) {
                r0 = e.a.a.a.fT(1, this.wHO.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + e.a.a.a.fR(2, this.wHP)) + e.a.a.a.c(3, 8, this.wHQ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wHQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wHO != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GroupName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbl com_tencent_mm_protocal_c_bbl = (bbl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbl.wHO = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbl.wHP = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bfd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbl.wHQ.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
