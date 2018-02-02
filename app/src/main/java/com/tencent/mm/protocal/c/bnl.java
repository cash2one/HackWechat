package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnl extends bcv {
    public String sign;
    public bdn wEj;
    public String wQi;
    public int wru;
    public int wrv;
    public bdn wrw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wrw == null) {
                throw new b("Not all required fields were included: ReqText");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wru);
            aVar.fU(3, this.wrv);
            if (this.wrw != null) {
                aVar.fW(4, this.wrw.bke());
                this.wrw.a(aVar);
            }
            if (this.wEj != null) {
                aVar.fW(5, this.wEj.bke());
                this.wEj.a(aVar);
            }
            if (this.sign != null) {
                aVar.g(6, this.sign);
            }
            if (this.wQi == null) {
                return 0;
            }
            aVar.g(7, this.wQi);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.wru)) + e.a.a.a.fR(3, this.wrv);
            if (this.wrw != null) {
                r0 += e.a.a.a.fT(4, this.wrw.bke());
            }
            if (this.wEj != null) {
                r0 += e.a.a.a.fT(5, this.wEj.bke());
            }
            if (this.sign != null) {
                r0 += e.a.a.b.b.a.h(6, this.sign);
            }
            if (this.wQi != null) {
                r0 += e.a.a.b.b.a.h(7, this.wQi);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wrw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReqText");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnl com_tencent_mm_protocal_c_bnl = (bnl) objArr[1];
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
                        com_tencent_mm_protocal_c_bnl.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnl.wru = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnl.wrv = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnl.wrw = fdVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnl.wEj = fdVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bnl.sign = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bnl.wQi = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
