package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class afv extends bcv {
    public String code;
    public String fGU;
    public String kJN;
    public int scene;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.fGU != null) {
                aVar.g(2, this.fGU);
            }
            aVar.fU(3, this.scene);
            if (this.kJN != null) {
                aVar.g(4, this.kJN);
            }
            if (this.code == null) {
                return 0;
            }
            aVar.g(5, this.code);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fGU != null) {
                r0 += e.a.a.b.b.a.h(2, this.fGU);
            }
            r0 += e.a.a.a.fR(3, this.scene);
            if (this.kJN != null) {
                r0 += e.a.a.b.b.a.h(4, this.kJN);
            }
            if (this.code != null) {
                r0 += e.a.a.b.b.a.h(5, this.code);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afv com_tencent_mm_protocal_c_afv = (afv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afv.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afv.fGU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afv.scene = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afv.kJN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afv.code = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
