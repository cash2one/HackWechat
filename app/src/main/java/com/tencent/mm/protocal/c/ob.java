package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ob extends a implements bir {
    public int vJU;
    public int vWR;
    public int vWS;
    public int vWT;
    public LinkedList<bmd> vWU = new LinkedList();
    public LinkedList<bmd> vWV = new LinkedList();
    public LinkedList<bmd> vWW = new LinkedList();
    public int vWX;
    public int vWY;
    public int vWZ;
    public akd vXa;

    public final int getRet() {
        return this.vJU;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vJU);
            aVar.fU(2, this.vWR);
            aVar.fU(3, this.vWS);
            aVar.fU(4, this.vWT);
            aVar.d(5, 8, this.vWU);
            aVar.d(6, 8, this.vWV);
            aVar.d(7, 8, this.vWW);
            aVar.fU(8, this.vWX);
            aVar.fU(9, this.vWY);
            aVar.fU(10, this.vWZ);
            if (this.vXa != null) {
                aVar.fW(11, this.vXa.bke());
                this.vXa.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((((((e.a.a.a.fR(1, this.vJU) + 0) + e.a.a.a.fR(2, this.vWR)) + e.a.a.a.fR(3, this.vWS)) + e.a.a.a.fR(4, this.vWT)) + e.a.a.a.c(5, 8, this.vWU)) + e.a.a.a.c(6, 8, this.vWV)) + e.a.a.a.c(7, 8, this.vWW)) + e.a.a.a.fR(8, this.vWX)) + e.a.a.a.fR(9, this.vWY)) + e.a.a.a.fR(10, this.vWZ);
            if (this.vXa != null) {
                return r0 + e.a.a.a.fT(11, this.vXa.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vWU.clear();
            this.vWV.clear();
            this.vWW.clear();
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
            ob obVar = (ob) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bmd;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    obVar.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    obVar.vWR = aVar3.Avy.ry();
                    return 0;
                case 3:
                    obVar.vWS = aVar3.Avy.ry();
                    return 0;
                case 4:
                    obVar.vWT = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bmd = new bmd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bmd.a(aVar4, com_tencent_mm_protocal_c_bmd, a.a(aVar4))) {
                        }
                        obVar.vWU.add(com_tencent_mm_protocal_c_bmd);
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bmd = new bmd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bmd.a(aVar4, com_tencent_mm_protocal_c_bmd, a.a(aVar4))) {
                        }
                        obVar.vWV.add(com_tencent_mm_protocal_c_bmd);
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bmd = new bmd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bmd.a(aVar4, com_tencent_mm_protocal_c_bmd, a.a(aVar4))) {
                        }
                        obVar.vWW.add(com_tencent_mm_protocal_c_bmd);
                    }
                    return 0;
                case 8:
                    obVar.vWX = aVar3.Avy.ry();
                    return 0;
                case 9:
                    obVar.vWY = aVar3.Avy.ry();
                    return 0;
                case 10:
                    obVar.vWZ = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bmd = new akd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bmd.a(aVar4, com_tencent_mm_protocal_c_bmd, a.a(aVar4))) {
                        }
                        obVar.vXa = com_tencent_mm_protocal_c_bmd;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
