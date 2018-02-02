package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bkl extends a {
    public float biF;
    public int rui;
    public float wNU;
    public float wNV;
    public float wNW;
    public float wNX;
    public int wNY;
    public long wNZ;
    public long wOa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.wNU);
            aVar.m(2, this.wNV);
            aVar.m(3, this.wNW);
            aVar.m(4, this.wNX);
            aVar.fU(5, this.wNY);
            aVar.S(6, this.wNZ);
            aVar.S(7, this.wOa);
            aVar.m(8, this.biF);
            aVar.fU(9, this.rui);
            return 0;
        } else if (i == 1) {
            return (((((((((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4)) + (e.a.a.b.b.a.dX(4) + 4)) + e.a.a.a.fR(5, this.wNY)) + e.a.a.a.R(6, this.wNZ)) + e.a.a.a.R(7, this.wOa)) + (e.a.a.b.b.a.dX(8) + 4)) + e.a.a.a.fR(9, this.rui);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                bkl com_tencent_mm_protocal_c_bkl = (bkl) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bkl.wNU = aVar3.Avy.readFloat();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bkl.wNV = aVar3.Avy.readFloat();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bkl.wNW = aVar3.Avy.readFloat();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bkl.wNX = aVar3.Avy.readFloat();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_bkl.wNY = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_bkl.wNZ = aVar3.Avy.rz();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_bkl.wOa = aVar3.Avy.rz();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_bkl.biF = aVar3.Avy.readFloat();
                        return 0;
                    case 9:
                        com_tencent_mm_protocal_c_bkl.rui = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
