package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsp extends bcv {
    public int wIh;
    public int wIj;
    public bsy wTS;
    public String wpa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wTS == null) {
                throw new b("Not all required fields were included: Piece");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wTS != null) {
                aVar.fW(2, this.wTS.bke());
                this.wTS.a(aVar);
            }
            aVar.fU(3, this.wIh);
            aVar.fU(4, this.wIj);
            if (this.wpa == null) {
                return 0;
            }
            aVar.g(5, this.wpa);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wTS != null) {
                r0 += e.a.a.a.fT(2, this.wTS.bke());
            }
            r0 = (r0 + e.a.a.a.fR(3, this.wIh)) + e.a.a.a.fR(4, this.wIj);
            if (this.wpa != null) {
                r0 += e.a.a.b.b.a.h(5, this.wpa);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wTS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Piece");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsp com_tencent_mm_protocal_c_bsp = (bsp) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsp.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bsy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsp.wTS = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bsp.wIh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bsp.wIj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bsp.wpa = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
