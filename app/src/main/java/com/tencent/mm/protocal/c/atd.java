package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class atd extends bdf {
    public int vEy;
    public int vPq;
    public bdn wAP;
    public bdn wAQ;
    public int wAR;
    public int wAS;
    public LinkedList<ol> wAT = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wAP == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wAQ == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.wAP != null) {
                    aVar.fW(2, this.wAP.bke());
                    this.wAP.a(aVar);
                }
                if (this.wAQ != null) {
                    aVar.fW(3, this.wAQ.bke());
                    this.wAQ.a(aVar);
                }
                aVar.fU(4, this.vPq);
                aVar.fU(5, this.wAR);
                aVar.fU(6, this.wAS);
                aVar.d(7, 8, this.wAT);
                aVar.fU(8, this.vEy);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wAP != null) {
                r0 += e.a.a.a.fT(2, this.wAP.bke());
            }
            if (this.wAQ != null) {
                r0 += e.a.a.a.fT(3, this.wAQ.bke());
            }
            return ((((r0 + e.a.a.a.fR(4, this.vPq)) + e.a.a.a.fR(5, this.wAR)) + e.a.a.a.fR(6, this.wAS)) + e.a.a.a.c(7, 8, this.wAT)) + e.a.a.a.fR(8, this.vEy);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wAT.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wAP == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wAQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atd com_tencent_mm_protocal_c_atd = (atd) objArr[1];
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
                        com_tencent_mm_protocal_c_atd.wJr = feVar;
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
                        com_tencent_mm_protocal_c_atd.wAP = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atd.wAQ = feVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_atd.vPq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_atd.wAR = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_atd.wAS = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ol();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atd.wAT.add(feVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_atd.vEy = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
