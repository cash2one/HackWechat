package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bxf extends a {
    public String pbI;
    public int rYW;
    public String wII;
    public String wXU;
    public String wXV;
    public int wXW;
    public String wXX;
    public String wXY;
    public String wXZ;
    public String wwM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXU != null) {
                aVar.g(1, this.wXU);
            }
            if (this.wXV != null) {
                aVar.g(2, this.wXV);
            }
            if (this.wwM != null) {
                aVar.g(3, this.wwM);
            }
            if (this.wII != null) {
                aVar.g(4, this.wII);
            }
            aVar.fU(5, this.wXW);
            if (this.pbI != null) {
                aVar.g(6, this.pbI);
            }
            if (this.wXX != null) {
                aVar.g(7, this.wXX);
            }
            if (this.wXY != null) {
                aVar.g(8, this.wXY);
            }
            aVar.fU(9, this.rYW);
            if (this.wXZ == null) {
                return 0;
            }
            aVar.g(19, this.wXZ);
            return 0;
        } else if (i == 1) {
            if (this.wXU != null) {
                r0 = e.a.a.b.b.a.h(1, this.wXU) + 0;
            } else {
                r0 = 0;
            }
            if (this.wXV != null) {
                r0 += e.a.a.b.b.a.h(2, this.wXV);
            }
            if (this.wwM != null) {
                r0 += e.a.a.b.b.a.h(3, this.wwM);
            }
            if (this.wII != null) {
                r0 += e.a.a.b.b.a.h(4, this.wII);
            }
            r0 += e.a.a.a.fR(5, this.wXW);
            if (this.pbI != null) {
                r0 += e.a.a.b.b.a.h(6, this.pbI);
            }
            if (this.wXX != null) {
                r0 += e.a.a.b.b.a.h(7, this.wXX);
            }
            if (this.wXY != null) {
                r0 += e.a.a.b.b.a.h(8, this.wXY);
            }
            r0 += e.a.a.a.fR(9, this.rYW);
            if (this.wXZ != null) {
                r0 += e.a.a.b.b.a.h(19, this.wXZ);
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
            bxf com_tencent_mm_protocal_c_bxf = (bxf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bxf.wXU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bxf.wXV = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bxf.wwM = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bxf.wII = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bxf.wXW = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bxf.pbI = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bxf.wXX = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bxf.wXY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bxf.rYW = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bxf.wXZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
