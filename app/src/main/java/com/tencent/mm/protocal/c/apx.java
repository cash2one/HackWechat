package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class apx extends a {
    public int ktN;
    public int scene;
    public String vOe;
    public String vPs;
    public long wwE;
    public long wwF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.scene);
            if (this.vOe != null) {
                aVar.g(2, this.vOe);
            }
            aVar.S(3, this.wwE);
            aVar.S(4, this.wwF);
            if (this.vPs != null) {
                aVar.g(5, this.vPs);
            }
            aVar.fU(6, this.ktN);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.scene) + 0;
            if (this.vOe != null) {
                r0 += e.a.a.b.b.a.h(2, this.vOe);
            }
            r0 = (r0 + e.a.a.a.R(3, this.wwE)) + e.a.a.a.R(4, this.wwF);
            if (this.vPs != null) {
                r0 += e.a.a.b.b.a.h(5, this.vPs);
            }
            return r0 + e.a.a.a.fR(6, this.ktN);
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
            apx com_tencent_mm_protocal_c_apx = (apx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_apx.scene = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apx.vOe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apx.wwE = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apx.wwF = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apx.vPs = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apx.ktN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
