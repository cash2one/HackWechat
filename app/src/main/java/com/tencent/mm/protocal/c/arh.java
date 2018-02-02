package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class arh extends a {
    public String hvC;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public String ksU;
    public int ktN;
    public String vUU;
    public String vUV;
    public int wyY;
    public int wyZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            aVar.fU(2, this.ktN);
            aVar.fU(3, this.hvt);
            if (this.hvv != null) {
                aVar.g(4, this.hvv);
            }
            if (this.hvu != null) {
                aVar.g(5, this.hvu);
            }
            if (this.hvw != null) {
                aVar.g(6, this.hvw);
            }
            aVar.fU(7, this.wyY);
            aVar.fU(8, this.wyZ);
            if (this.hvC != null) {
                aVar.g(9, this.hvC);
            }
            if (this.vUU != null) {
                aVar.g(10, this.vUU);
            }
            if (this.vUV == null) {
                return 0;
            }
            aVar.g(11, this.vUV);
            return 0;
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.ktN)) + e.a.a.a.fR(3, this.hvt);
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(4, this.hvv);
            }
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(5, this.hvu);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(6, this.hvw);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.wyY)) + e.a.a.a.fR(8, this.wyZ);
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(9, this.hvC);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(10, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(11, this.vUV);
            }
            return r0;
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
            arh com_tencent_mm_protocal_c_arh = (arh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_arh.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arh.ktN = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arh.hvt = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arh.hvv = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_arh.hvu = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_arh.hvw = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_arh.wyY = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_arh.wyZ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_arh.hvC = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_arh.vUU = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_arh.vUV = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
