package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class awb extends bcv {
    public String ael;
    public String wDB;
    public String wDC;
    public String wDD;
    public int wDz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wDz);
            if (this.ael != null) {
                aVar.g(3, this.ael);
            }
            if (this.wDB != null) {
                aVar.g(4, this.wDB);
            }
            if (this.wDC != null) {
                aVar.g(5, this.wDC);
            }
            if (this.wDD == null) {
                return 0;
            }
            aVar.g(6, this.wDD);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wDz);
            if (this.ael != null) {
                r0 += e.a.a.b.b.a.h(3, this.ael);
            }
            if (this.wDB != null) {
                r0 += e.a.a.b.b.a.h(4, this.wDB);
            }
            if (this.wDC != null) {
                r0 += e.a.a.b.b.a.h(5, this.wDC);
            }
            if (this.wDD != null) {
                r0 += e.a.a.b.b.a.h(6, this.wDD);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awb com_tencent_mm_protocal_c_awb = (awb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awb.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awb.wDz = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awb.ael = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awb.wDB = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awb.wDC = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awb.wDD = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
