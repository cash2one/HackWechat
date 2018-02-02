package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adk extends bdf {
    public String hvv;
    public int vPq;
    public String vPs;
    public bdn wlO;
    public int wlT;
    public LinkedList<bdo> wlU = new LinkedList();
    public int wlV;
    public LinkedList<aof> wlW = new LinkedList();
    public String wlX;
    public int wlY;
    public int wlZ;
    public aog wma;
    public String wmb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wlO == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.wlO != null) {
                    aVar.fW(2, this.wlO.bke());
                    this.wlO.a(aVar);
                }
                aVar.fU(3, this.wlT);
                aVar.d(4, 8, this.wlU);
                aVar.fU(5, this.wlV);
                aVar.d(6, 8, this.wlW);
                aVar.fU(7, this.vPq);
                if (this.wlX != null) {
                    aVar.g(8, this.wlX);
                }
                if (this.vPs != null) {
                    aVar.g(9, this.vPs);
                }
                aVar.fU(10, this.wlY);
                if (this.hvv != null) {
                    aVar.g(11, this.hvv);
                }
                aVar.fU(12, this.wlZ);
                if (this.wma != null) {
                    aVar.fW(13, this.wma.bke());
                    this.wma.a(aVar);
                }
                if (this.wmb == null) {
                    return 0;
                }
                aVar.g(14, this.wmb);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wlO != null) {
                r0 += e.a.a.a.fT(2, this.wlO.bke());
            }
            r0 = ((((r0 + e.a.a.a.fR(3, this.wlT)) + e.a.a.a.c(4, 8, this.wlU)) + e.a.a.a.fR(5, this.wlV)) + e.a.a.a.c(6, 8, this.wlW)) + e.a.a.a.fR(7, this.vPq);
            if (this.wlX != null) {
                r0 += e.a.a.b.b.a.h(8, this.wlX);
            }
            if (this.vPs != null) {
                r0 += e.a.a.b.b.a.h(9, this.vPs);
            }
            r0 += e.a.a.a.fR(10, this.wlY);
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(11, this.hvv);
            }
            r0 += e.a.a.a.fR(12, this.wlZ);
            if (this.wma != null) {
                r0 += e.a.a.a.fT(13, this.wma.bke());
            }
            if (this.wmb != null) {
                r0 += e.a.a.b.b.a.h(14, this.wmb);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wlU.clear();
            this.wlW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wlO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adk com_tencent_mm_protocal_c_adk = (adk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adk.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adk.wlO = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adk.wlT = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adk.wlU.add(feVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adk.wlV = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new aof();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adk.wlW.add(feVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adk.vPq = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adk.wlX = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_adk.vPs = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_adk.wlY = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_adk.hvv = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_adk.wlZ = aVar3.Avy.ry();
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new aog();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adk.wma = feVar;
                    }
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_adk.wmb = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
