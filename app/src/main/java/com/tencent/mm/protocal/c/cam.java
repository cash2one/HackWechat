package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cam extends a {
    public int rYW;
    public int vNa;
    public int wtc;
    public int wwA;
    public int wwB;
    public String wwC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wtc);
            aVar.fU(2, this.vNa);
            aVar.fU(3, this.rYW);
            if (this.wwC != null) {
                aVar.g(4, this.wwC);
            }
            aVar.fU(5, this.wwB);
            aVar.fU(6, this.wwA);
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.wtc) + 0) + e.a.a.a.fR(2, this.vNa)) + e.a.a.a.fR(3, this.rYW);
            if (this.wwC != null) {
                r0 += e.a.a.b.b.a.h(4, this.wwC);
            }
            return (r0 + e.a.a.a.fR(5, this.wwB)) + e.a.a.a.fR(6, this.wwA);
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
            cam com_tencent_mm_protocal_c_cam = (cam) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cam.wtc = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cam.vNa = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cam.rYW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cam.wwC = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cam.wwB = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_cam.wwA = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
