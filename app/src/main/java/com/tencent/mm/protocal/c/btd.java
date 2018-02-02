package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btd extends bdf {
    public int wHb;
    public int wUi;
    public LinkedList<bta> wUj = new LinkedList();
    public int wUk;

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
            aVar.fU(2, this.wUi);
            aVar.d(3, 8, this.wUj);
            aVar.fU(4, this.wHb);
            aVar.fU(5, this.wUk);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.fR(2, this.wUi)) + e.a.a.a.c(3, 8, this.wUj)) + e.a.a.a.fR(4, this.wHb)) + e.a.a.a.fR(5, this.wUk);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wUj.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            btd com_tencent_mm_protocal_c_btd = (btd) objArr[1];
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
                        com_tencent_mm_protocal_c_btd.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_btd.wUi = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bta();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btd.wUj.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_btd.wHb = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_btd.wUk = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
