package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aun extends bcv {
    public int ngq;
    public String wCw;
    public pa wCx;
    public pa wCy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wCx == null) {
                throw new b("Not all required fields were included: BigContentInfo");
            } else if (this.wCy == null) {
                throw new b("Not all required fields were included: SmallContentInfo");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.wCw != null) {
                    aVar.g(2, this.wCw);
                }
                if (this.wCx != null) {
                    aVar.fW(3, this.wCx.bke());
                    this.wCx.a(aVar);
                }
                if (this.wCy != null) {
                    aVar.fW(4, this.wCy.bke());
                    this.wCy.a(aVar);
                }
                aVar.fU(5, this.ngq);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wCw != null) {
                r0 += e.a.a.b.b.a.h(2, this.wCw);
            }
            if (this.wCx != null) {
                r0 += e.a.a.a.fT(3, this.wCx.bke());
            }
            if (this.wCy != null) {
                r0 += e.a.a.a.fT(4, this.wCy.bke());
            }
            return r0 + e.a.a.a.fR(5, this.ngq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wCx == null) {
                throw new b("Not all required fields were included: BigContentInfo");
            } else if (this.wCy != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SmallContentInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aun com_tencent_mm_protocal_c_aun = (aun) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aun.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aun.wCw = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new pa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aun.wCx = fdVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new pa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aun.wCy = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aun.ngq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
