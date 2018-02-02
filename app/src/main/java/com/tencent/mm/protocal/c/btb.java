package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btb extends bcv {
    public int vLj;
    public int vNW;
    public int vOI;
    public bdn vXz;
    public bdo wIS;
    public String wRR;
    public int wRT;
    public int wUe;
    public LinkedList<bdo> wUf = new LinkedList();
    public int wUg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vXz != null) {
                aVar.fW(2, this.vXz.bke());
                this.vXz.a(aVar);
            }
            aVar.fU(3, this.vNW);
            if (this.wRR != null) {
                aVar.g(4, this.wRR);
            }
            aVar.fU(5, this.vLj);
            aVar.fU(6, this.wRT);
            aVar.fU(7, this.vOI);
            aVar.fU(8, this.wUe);
            aVar.d(9, 8, this.wUf);
            if (this.wIS != null) {
                aVar.fW(10, this.wIS.bke());
                this.wIS.a(aVar);
            }
            aVar.fU(11, this.wUg);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(2, this.vXz.bke());
            }
            r0 += e.a.a.a.fR(3, this.vNW);
            if (this.wRR != null) {
                r0 += e.a.a.b.b.a.h(4, this.wRR);
            }
            r0 = ((((r0 + e.a.a.a.fR(5, this.vLj)) + e.a.a.a.fR(6, this.wRT)) + e.a.a.a.fR(7, this.vOI)) + e.a.a.a.fR(8, this.wUe)) + e.a.a.a.c(9, 8, this.wUf);
            if (this.wIS != null) {
                r0 += e.a.a.a.fT(10, this.wIS.bke());
            }
            return r0 + e.a.a.a.fR(11, this.wUg);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wUf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btb com_tencent_mm_protocal_c_btb = (btb) objArr[1];
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
                        com_tencent_mm_protocal_c_btb.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btb.vXz = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_btb.vNW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_btb.wRR = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_btb.vLj = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_btb.wRT = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_btb.vOI = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_btb.wUe = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btb.wUf.add(fdVar);
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btb.wIS = fdVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_btb.wUg = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
