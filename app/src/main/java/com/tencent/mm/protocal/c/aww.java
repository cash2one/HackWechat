package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aww extends bdf {
    public int wEk;
    public String wEl;
    public int wrA;
    public bdn wrx;
    public int wry;
    public String wrz;

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
            if (this.wrx != null) {
                aVar.fW(2, this.wrx.bke());
                this.wrx.a(aVar);
            }
            aVar.fU(3, this.wry);
            if (this.wrz != null) {
                aVar.g(4, this.wrz);
            }
            aVar.fU(5, this.wrA);
            aVar.fU(6, this.wEk);
            if (this.wEl == null) {
                return 0;
            }
            aVar.g(7, this.wEl);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wrx != null) {
                r0 += e.a.a.a.fT(2, this.wrx.bke());
            }
            r0 += e.a.a.a.fR(3, this.wry);
            if (this.wrz != null) {
                r0 += e.a.a.b.b.a.h(4, this.wrz);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.wrA)) + e.a.a.a.fR(6, this.wEk);
            if (this.wEl != null) {
                r0 += e.a.a.b.b.a.h(7, this.wEl);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
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
            aww com_tencent_mm_protocal_c_aww = (aww) objArr[1];
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
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aww.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aww.wrx = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aww.wry = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aww.wrz = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aww.wrA = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aww.wEk = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aww.wEl = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
