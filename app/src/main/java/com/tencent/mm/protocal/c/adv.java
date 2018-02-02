package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adv extends bdf {
    public int vQP;
    public String vQQ;
    public String wmn;
    public String wmo;

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
            aVar.fU(2, this.vQP);
            if (this.vQQ != null) {
                aVar.g(3, this.vQQ);
            }
            if (this.wmn != null) {
                aVar.g(4, this.wmn);
            }
            if (this.wmo == null) {
                return 0;
            }
            aVar.g(5, this.wmo);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vQP);
            if (this.vQQ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vQQ);
            }
            if (this.wmn != null) {
                r0 += e.a.a.b.b.a.h(4, this.wmn);
            }
            if (this.wmo != null) {
                r0 += e.a.a.b.b.a.h(5, this.wmo);
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
            adv com_tencent_mm_protocal_c_adv = (adv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adv.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adv.vQP = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adv.vQQ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adv.wmn = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adv.wmo = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
