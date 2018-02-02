package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ben extends a {
    public int rYW;
    public int vNW;
    public long vPp;
    public String vPs;
    public int wKa;
    public LinkedList<bro> wKb = new LinkedList();
    public String wkq;
    public aoh wwI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wkq == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.S(1, this.vPp);
            if (this.wkq != null) {
                aVar.g(2, this.wkq);
            }
            aVar.fU(3, this.vNW);
            if (this.wwI != null) {
                aVar.fW(4, this.wwI.bke());
                this.wwI.a(aVar);
            }
            aVar.fU(5, this.wKa);
            aVar.d(6, 8, this.wKb);
            aVar.fU(7, this.rYW);
            if (this.vPs != null) {
                aVar.g(8, this.vPs);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.vPp) + 0;
            if (this.wkq != null) {
                r0 += e.a.a.b.b.a.h(2, this.wkq);
            }
            r0 += e.a.a.a.fR(3, this.vNW);
            if (this.wwI != null) {
                r0 += e.a.a.a.fT(4, this.wwI.bke());
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.wKa)) + e.a.a.a.c(6, 8, this.wKb)) + e.a.a.a.fR(7, this.rYW);
            if (this.vPs != null) {
                return r0 + e.a.a.b.b.a.h(8, this.vPs);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wKb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wkq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ben com_tencent_mm_protocal_c_ben = (ben) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_aoh;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ben.vPp = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ben.wkq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ben.vNW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new aoh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ben.wwI = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ben.wKa = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new bro();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ben.wKb.add(com_tencent_mm_protocal_c_aoh);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ben.rYW = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ben.vPs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
