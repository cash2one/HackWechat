package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahc extends bdf {
    public int vJs;
    public String wow;
    public String wox;
    public LinkedList<String> woy = new LinkedList();

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
            if (this.wow != null) {
                aVar.g(2, this.wow);
            }
            aVar.fU(3, this.vJs);
            if (this.wox != null) {
                aVar.g(4, this.wox);
            }
            aVar.d(5, 1, this.woy);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wow != null) {
                r0 += e.a.a.b.b.a.h(2, this.wow);
            }
            r0 += e.a.a.a.fR(3, this.vJs);
            if (this.wox != null) {
                r0 += e.a.a.b.b.a.h(4, this.wox);
            }
            return r0 + e.a.a.a.c(5, 1, this.woy);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.woy.clear();
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
            ahc com_tencent_mm_protocal_c_ahc = (ahc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahc.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahc.wow = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahc.vJs = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahc.wox = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahc.woy.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
