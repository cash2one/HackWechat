package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class blb extends bcv {
    public int vHW;
    public String vIy;
    public String wMJ;
    public long wMK;
    public long wOg;
    public int wOh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wMJ != null) {
                aVar.g(2, this.wMJ);
            }
            if (this.vIy != null) {
                aVar.g(3, this.vIy);
            }
            aVar.S(4, this.wMK);
            aVar.fU(5, this.vHW);
            aVar.S(6, this.wOg);
            aVar.fU(7, this.wOh);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wMJ != null) {
                r0 += e.a.a.b.b.a.h(2, this.wMJ);
            }
            if (this.vIy != null) {
                r0 += e.a.a.b.b.a.h(3, this.vIy);
            }
            return (((r0 + e.a.a.a.R(4, this.wMK)) + e.a.a.a.fR(5, this.vHW)) + e.a.a.a.R(6, this.wOg)) + e.a.a.a.fR(7, this.wOh);
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
            blb com_tencent_mm_protocal_c_blb = (blb) objArr[1];
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
                        com_tencent_mm_protocal_c_blb.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blb.wMJ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blb.vIy = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blb.wMK = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blb.vHW = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blb.wOg = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blb.wOh = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
