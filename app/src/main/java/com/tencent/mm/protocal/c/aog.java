package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aog extends a {
    public float vQt;
    public float vQu;
    public int wcr;
    public String wcs;
    public String wct;
    public int wcu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.vQt);
            aVar.m(2, this.vQu);
            aVar.fU(3, this.wcr);
            if (this.wcs != null) {
                aVar.g(4, this.wcs);
            }
            if (this.wct != null) {
                aVar.g(5, this.wct);
            }
            aVar.fU(6, this.wcu);
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + e.a.a.a.fR(3, this.wcr);
            if (this.wcs != null) {
                r0 += e.a.a.b.b.a.h(4, this.wcs);
            }
            if (this.wct != null) {
                r0 += e.a.a.b.b.a.h(5, this.wct);
            }
            return r0 + e.a.a.a.fR(6, this.wcu);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aog com_tencent_mm_protocal_c_aog = (aog) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aog.vQt = aVar3.Avy.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aog.vQu = aVar3.Avy.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aog.wcr = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aog.wcs = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aog.wct = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aog.wcu = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
