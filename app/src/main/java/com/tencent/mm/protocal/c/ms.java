package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ms extends bdf {
    public String nko;
    public String vVt;
    public String vVu;
    public String vVv;

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
            if (this.vVt != null) {
                aVar.g(2, this.vVt);
            }
            if (this.nko != null) {
                aVar.g(3, this.nko);
            }
            if (this.vVu != null) {
                aVar.g(4, this.vVu);
            }
            if (this.vVv == null) {
                return 0;
            }
            aVar.g(5, this.vVv);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vVt != null) {
                r0 += e.a.a.b.b.a.h(2, this.vVt);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(3, this.nko);
            }
            if (this.vVu != null) {
                r0 += e.a.a.b.b.a.h(4, this.vVu);
            }
            if (this.vVv != null) {
                r0 += e.a.a.b.b.a.h(5, this.vVv);
            }
            return r0;
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
            ms msVar = (ms) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        msVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    msVar.vVt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    msVar.nko = aVar3.Avy.readString();
                    return 0;
                case 4:
                    msVar.vVu = aVar3.Avy.readString();
                    return 0;
                case 5:
                    msVar.vVv = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
