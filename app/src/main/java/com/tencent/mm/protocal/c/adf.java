package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class adf extends bcv {
    public String vZK;
    public String wgs;
    public String wgt;
    public String wgu;
    public String wlD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wgs != null) {
                aVar.g(2, this.wgs);
            }
            if (this.wlD != null) {
                aVar.g(3, this.wlD);
            }
            if (this.wgt != null) {
                aVar.g(4, this.wgt);
            }
            if (this.wgu != null) {
                aVar.g(5, this.wgu);
            }
            if (this.vZK == null) {
                return 0;
            }
            aVar.g(6, this.vZK);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wgs != null) {
                r0 += e.a.a.b.b.a.h(2, this.wgs);
            }
            if (this.wlD != null) {
                r0 += e.a.a.b.b.a.h(3, this.wlD);
            }
            if (this.wgt != null) {
                r0 += e.a.a.b.b.a.h(4, this.wgt);
            }
            if (this.wgu != null) {
                r0 += e.a.a.b.b.a.h(5, this.wgu);
            }
            if (this.vZK != null) {
                r0 += e.a.a.b.b.a.h(6, this.vZK);
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
            adf com_tencent_mm_protocal_c_adf = (adf) objArr[1];
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
                        com_tencent_mm_protocal_c_adf.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adf.wgs = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adf.wlD = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adf.wgt = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adf.wgu = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adf.vZK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
