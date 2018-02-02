package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class boo extends bdf {
    public int fts;
    public String ftt;
    public int version;
    public String wQW;
    public String wQX;
    public bih wQY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.fts);
            if (this.ftt != null) {
                aVar.g(3, this.ftt);
            }
            if (this.wQW != null) {
                aVar.g(4, this.wQW);
            }
            if (this.wQX != null) {
                aVar.g(5, this.wQX);
            }
            if (this.wQY != null) {
                aVar.fW(6, this.wQY.bke());
                this.wQY.a(aVar);
            }
            aVar.fU(7, this.version);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.fts);
            if (this.ftt != null) {
                r0 += e.a.a.b.b.a.h(3, this.ftt);
            }
            if (this.wQW != null) {
                r0 += e.a.a.b.b.a.h(4, this.wQW);
            }
            if (this.wQX != null) {
                r0 += e.a.a.b.b.a.h(5, this.wQX);
            }
            if (this.wQY != null) {
                r0 += e.a.a.a.fT(6, this.wQY.bke());
            }
            return r0 + e.a.a.a.fR(7, this.version);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            boo com_tencent_mm_protocal_c_boo = (boo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_boo.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_boo.fts = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_boo.ftt = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_boo.wQW = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_boo.wQX = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bih();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_boo.wQY = feVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_boo.version = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
