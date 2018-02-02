package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bhu extends bcv {
    public int vDW;
    public float vQt;
    public float vQu;
    public int wLx;
    public int wLy;
    public int wcr;
    public String wcs;
    public String wct;
    public int wcu;
    public bdn wvs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vDW);
            aVar.m(3, this.vQt);
            aVar.m(4, this.vQu);
            aVar.fU(5, this.wcr);
            if (this.wcs != null) {
                aVar.g(6, this.wcs);
            }
            if (this.wct != null) {
                aVar.g(7, this.wct);
            }
            aVar.fU(8, this.wLx);
            aVar.fU(9, this.wLy);
            aVar.fU(10, this.wcu);
            if (this.wvs == null) {
                return 0;
            }
            aVar.fW(11, this.wvs.bke());
            this.wvs.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + e.a.a.a.fR(2, this.vDW)) + (e.a.a.b.b.a.dX(3) + 4)) + (e.a.a.b.b.a.dX(4) + 4)) + e.a.a.a.fR(5, this.wcr);
            if (this.wcs != null) {
                r0 += e.a.a.b.b.a.h(6, this.wcs);
            }
            if (this.wct != null) {
                r0 += e.a.a.b.b.a.h(7, this.wct);
            }
            r0 = ((r0 + e.a.a.a.fR(8, this.wLx)) + e.a.a.a.fR(9, this.wLy)) + e.a.a.a.fR(10, this.wcu);
            if (this.wvs != null) {
                r0 += e.a.a.a.fT(11, this.wvs.bke());
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
            bhu com_tencent_mm_protocal_c_bhu = (bhu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhu.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhu.vDW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhu.vQt = aVar3.Avy.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhu.vQu = aVar3.Avy.readFloat();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhu.wcr = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhu.wcs = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhu.wct = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhu.wLx = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhu.wLy = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bhu.wcu = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhu.wvs = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
