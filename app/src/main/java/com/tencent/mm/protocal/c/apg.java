package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class apg extends a {
    public int hvA;
    public String hvB;
    public String hvC;
    public String hvD;
    public String hvs;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public int hvx;
    public String hvy;
    public int hvz;
    public String vIy;
    public String vUU;
    public String vUV;
    public String whR;
    public String wvW;
    public tu wvX;
    public bla wvl;
    public pq wvm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIy != null) {
                aVar.g(1, this.vIy);
            }
            if (this.wvW != null) {
                aVar.g(2, this.wvW);
            }
            if (this.hvs != null) {
                aVar.g(3, this.hvs);
            }
            aVar.fU(4, this.hvt);
            if (this.hvu != null) {
                aVar.g(5, this.hvu);
            }
            if (this.hvv != null) {
                aVar.g(6, this.hvv);
            }
            if (this.hvw != null) {
                aVar.g(7, this.hvw);
            }
            aVar.fU(8, this.hvx);
            if (this.hvy != null) {
                aVar.g(9, this.hvy);
            }
            if (this.wvX != null) {
                aVar.fW(10, this.wvX.bke());
                this.wvX.a(aVar);
            }
            aVar.fU(11, this.hvz);
            aVar.fU(12, this.hvA);
            if (this.hvB != null) {
                aVar.g(13, this.hvB);
            }
            if (this.wvl != null) {
                aVar.fW(14, this.wvl.bke());
                this.wvl.a(aVar);
            }
            if (this.hvC != null) {
                aVar.g(15, this.hvC);
            }
            if (this.hvD != null) {
                aVar.g(16, this.hvD);
            }
            if (this.wvm != null) {
                aVar.fW(17, this.wvm.bke());
                this.wvm.a(aVar);
            }
            if (this.vUU != null) {
                aVar.g(20, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(21, this.vUV);
            }
            if (this.whR == null) {
                return 0;
            }
            aVar.g(22, this.whR);
            return 0;
        } else if (i == 1) {
            if (this.vIy != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIy) + 0;
            } else {
                r0 = 0;
            }
            if (this.wvW != null) {
                r0 += e.a.a.b.b.a.h(2, this.wvW);
            }
            if (this.hvs != null) {
                r0 += e.a.a.b.b.a.h(3, this.hvs);
            }
            r0 += e.a.a.a.fR(4, this.hvt);
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(5, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(6, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(7, this.hvw);
            }
            r0 += e.a.a.a.fR(8, this.hvx);
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(9, this.hvy);
            }
            if (this.wvX != null) {
                r0 += e.a.a.a.fT(10, this.wvX.bke());
            }
            r0 = (r0 + e.a.a.a.fR(11, this.hvz)) + e.a.a.a.fR(12, this.hvA);
            if (this.hvB != null) {
                r0 += e.a.a.b.b.a.h(13, this.hvB);
            }
            if (this.wvl != null) {
                r0 += e.a.a.a.fT(14, this.wvl.bke());
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(15, this.hvC);
            }
            if (this.hvD != null) {
                r0 += e.a.a.b.b.a.h(16, this.hvD);
            }
            if (this.wvm != null) {
                r0 += e.a.a.a.fT(17, this.wvm.bke());
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(20, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(21, this.vUV);
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(22, this.whR);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            apg com_tencent_mm_protocal_c_apg = (apg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a tuVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_apg.vIy = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apg.wvW = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apg.hvs = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apg.hvt = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apg.hvu = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apg.hvv = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_apg.hvw = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_apg.hvx = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_apg.hvy = aVar3.Avy.readString();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        tuVar = new tu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tuVar.a(aVar4, tuVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apg.wvX = tuVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_apg.hvz = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_apg.hvA = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_apg.hvB = aVar3.Avy.readString();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        tuVar = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tuVar.a(aVar4, tuVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apg.wvl = tuVar;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_apg.hvC = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_apg.hvD = aVar3.Avy.readString();
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        tuVar = new pq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tuVar.a(aVar4, tuVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apg.wvm = tuVar;
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_apg.vUU = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_apg.vUV = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_apg.whR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
