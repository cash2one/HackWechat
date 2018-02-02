package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aaf extends bcv {
    public int fGW;
    public String sign;
    public String vEG;
    public String vEH;
    public int vEI;
    public LinkedList<kh> vEL = new LinkedList();
    public String vHA;
    public String wjt;
    public String wju;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.d(2, 8, this.vEL);
            aVar.fU(3, this.fGW);
            if (this.wju != null) {
                aVar.g(4, this.wju);
            }
            if (this.vHA != null) {
                aVar.g(5, this.vHA);
            }
            if (this.sign != null) {
                aVar.g(6, this.sign);
            }
            if (this.vEG != null) {
                aVar.g(7, this.vEG);
            }
            if (this.vEH != null) {
                aVar.g(8, this.vEH);
            }
            if (this.wjt != null) {
                aVar.g(9, this.wjt);
            }
            aVar.fU(10, this.vEI);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.c(2, 8, this.vEL)) + e.a.a.a.fR(3, this.fGW);
            if (this.wju != null) {
                r0 += e.a.a.b.b.a.h(4, this.wju);
            }
            if (this.vHA != null) {
                r0 += e.a.a.b.b.a.h(5, this.vHA);
            }
            if (this.sign != null) {
                r0 += e.a.a.b.b.a.h(6, this.sign);
            }
            if (this.vEG != null) {
                r0 += e.a.a.b.b.a.h(7, this.vEG);
            }
            if (this.vEH != null) {
                r0 += e.a.a.b.b.a.h(8, this.vEH);
            }
            if (this.wjt != null) {
                r0 += e.a.a.b.b.a.h(9, this.wjt);
            }
            return r0 + e.a.a.a.fR(10, this.vEI);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vEL.clear();
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
            aaf com_tencent_mm_protocal_c_aaf = (aaf) objArr[1];
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
                        com_tencent_mm_protocal_c_aaf.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new kh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aaf.vEL.add(fdVar);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aaf.fGW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aaf.wju = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aaf.vHA = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aaf.sign = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aaf.vEG = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aaf.vEH = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aaf.wjt = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aaf.vEI = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
