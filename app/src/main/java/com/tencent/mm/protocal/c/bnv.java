package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bnv extends a {
    public int state;
    public String vWt;
    public LinkedList<bnu> wQD = new LinkedList();
    public int wQE;
    public int wQF;
    public bdb wQG;
    public int wQH;
    public LinkedList<bnt> wQI = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vWt == null) {
                throw new b("Not all required fields were included: patchid");
            }
            if (this.vWt != null) {
                aVar.g(1, this.vWt);
            }
            aVar.fU(2, this.state);
            aVar.d(3, 8, this.wQD);
            aVar.fU(4, this.wQE);
            aVar.fU(5, this.wQF);
            if (this.wQG != null) {
                aVar.fW(6, this.wQG.bke());
                this.wQG.a(aVar);
            }
            aVar.fU(7, this.wQH);
            aVar.d(8, 8, this.wQI);
            return 0;
        } else if (i == 1) {
            if (this.vWt != null) {
                r0 = e.a.a.b.b.a.h(1, this.vWt) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + e.a.a.a.fR(2, this.state)) + e.a.a.a.c(3, 8, this.wQD)) + e.a.a.a.fR(4, this.wQE)) + e.a.a.a.fR(5, this.wQF);
            if (this.wQG != null) {
                r0 += e.a.a.a.fT(6, this.wQG.bke());
            }
            return (r0 + e.a.a.a.fR(7, this.wQH)) + e.a.a.a.c(8, 8, this.wQI);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wQD.clear();
            this.wQI.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vWt != null) {
                return 0;
            }
            throw new b("Not all required fields were included: patchid");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnv com_tencent_mm_protocal_c_bnv = (bnv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bnu;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bnv.vWt = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnv.state = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bnu = new bnu();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bnu.a(aVar4, com_tencent_mm_protocal_c_bnu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnv.wQD.add(com_tencent_mm_protocal_c_bnu);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnv.wQE = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bnv.wQF = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bnu = new bdb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bnu.a(aVar4, com_tencent_mm_protocal_c_bnu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnv.wQG = com_tencent_mm_protocal_c_bnu;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bnv.wQH = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bnu = new bnt();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bnu.a(aVar4, com_tencent_mm_protocal_c_bnu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnv.wQI.add(com_tencent_mm_protocal_c_bnu);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
