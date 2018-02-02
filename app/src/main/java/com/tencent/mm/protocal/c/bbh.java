package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bbh extends bcv {
    public String pQt;
    public String vOf;
    public String vOg;
    public String vOh;
    public String vOi;
    public String vOj;
    public int wuu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vOf != null) {
                aVar.g(2, this.vOf);
            }
            if (this.vOg != null) {
                aVar.g(3, this.vOg);
            }
            if (this.vOh != null) {
                aVar.g(4, this.vOh);
            }
            if (this.vOi != null) {
                aVar.g(5, this.vOi);
            }
            if (this.vOj != null) {
                aVar.g(6, this.vOj);
            }
            aVar.fU(7, this.wuu);
            if (this.pQt == null) {
                return 0;
            }
            aVar.g(8, this.pQt);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vOf != null) {
                r0 += e.a.a.b.b.a.h(2, this.vOf);
            }
            if (this.vOg != null) {
                r0 += e.a.a.b.b.a.h(3, this.vOg);
            }
            if (this.vOh != null) {
                r0 += e.a.a.b.b.a.h(4, this.vOh);
            }
            if (this.vOi != null) {
                r0 += e.a.a.b.b.a.h(5, this.vOi);
            }
            if (this.vOj != null) {
                r0 += e.a.a.b.b.a.h(6, this.vOj);
            }
            r0 += e.a.a.a.fR(7, this.wuu);
            if (this.pQt != null) {
                r0 += e.a.a.b.b.a.h(8, this.pQt);
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
            bbh com_tencent_mm_protocal_c_bbh = (bbh) objArr[1];
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
                        com_tencent_mm_protocal_c_bbh.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbh.vOf = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbh.vOg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbh.vOh = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbh.vOi = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bbh.vOj = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bbh.wuu = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bbh.pQt = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
