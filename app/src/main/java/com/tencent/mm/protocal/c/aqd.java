package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aqd extends bcv {
    public String hvw;
    public String ksY;
    public String lOn;
    public String lOo;
    public int nhw;
    public int vDY;
    public String vJA;
    public fb vJw;
    public String vJx;
    public int vJy;
    public String vJz;
    public String vOf;
    public String vOg;
    public String vZI;
    public String vcm;
    public String whB;
    public String wwU;
    public String wwV;
    public String wwW;
    public int wwX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vJw != null) {
                aVar.fW(2, this.vJw.bke());
                this.vJw.a(aVar);
            }
            if (this.vcm != null) {
                aVar.g(3, this.vcm);
            }
            if (this.vJx != null) {
                aVar.g(4, this.vJx);
            }
            aVar.fU(5, this.vJy);
            if (this.vJz != null) {
                aVar.g(6, this.vJz);
            }
            if (this.hvw != null) {
                aVar.g(7, this.hvw);
            }
            if (this.ksY != null) {
                aVar.g(8, this.ksY);
            }
            if (this.vJA != null) {
                aVar.g(9, this.vJA);
            }
            if (this.lOo != null) {
                aVar.g(10, this.lOo);
            }
            if (this.lOn != null) {
                aVar.g(11, this.lOn);
            }
            aVar.fU(13, this.vDY);
            aVar.fU(14, this.nhw);
            if (this.vOg != null) {
                aVar.g(15, this.vOg);
            }
            if (this.vOf != null) {
                aVar.g(16, this.vOf);
            }
            if (this.wwU != null) {
                aVar.g(17, this.wwU);
            }
            if (this.vZI != null) {
                aVar.g(18, this.vZI);
            }
            if (this.whB != null) {
                aVar.g(19, this.whB);
            }
            if (this.wwV != null) {
                aVar.g(20, this.wwV);
            }
            if (this.wwW != null) {
                aVar.g(21, this.wwW);
            }
            aVar.fU(22, this.wwX);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vJw != null) {
                r0 += e.a.a.a.fT(2, this.vJw.bke());
            }
            if (this.vcm != null) {
                r0 += e.a.a.b.b.a.h(3, this.vcm);
            }
            if (this.vJx != null) {
                r0 += e.a.a.b.b.a.h(4, this.vJx);
            }
            r0 += e.a.a.a.fR(5, this.vJy);
            if (this.vJz != null) {
                r0 += e.a.a.b.b.a.h(6, this.vJz);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(7, this.hvw);
            }
            if (this.ksY != null) {
                r0 += e.a.a.b.b.a.h(8, this.ksY);
            }
            if (this.vJA != null) {
                r0 += e.a.a.b.b.a.h(9, this.vJA);
            }
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(10, this.lOo);
            }
            if (this.lOn != null) {
                r0 += e.a.a.b.b.a.h(11, this.lOn);
            }
            r0 = (r0 + e.a.a.a.fR(13, this.vDY)) + e.a.a.a.fR(14, this.nhw);
            if (this.vOg != null) {
                r0 += e.a.a.b.b.a.h(15, this.vOg);
            }
            if (this.vOf != null) {
                r0 += e.a.a.b.b.a.h(16, this.vOf);
            }
            if (this.wwU != null) {
                r0 += e.a.a.b.b.a.h(17, this.wwU);
            }
            if (this.vZI != null) {
                r0 += e.a.a.b.b.a.h(18, this.vZI);
            }
            if (this.whB != null) {
                r0 += e.a.a.b.b.a.h(19, this.whB);
            }
            if (this.wwV != null) {
                r0 += e.a.a.b.b.a.h(20, this.wwV);
            }
            if (this.wwW != null) {
                r0 += e.a.a.b.b.a.h(21, this.wwW);
            }
            return r0 + e.a.a.a.fR(22, this.wwX);
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
            aqd com_tencent_mm_protocal_c_aqd = (aqd) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqd.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqd.vJw = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqd.vcm = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqd.vJx = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqd.vJy = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqd.vJz = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqd.hvw = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqd.ksY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqd.vJA = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqd.lOo = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqd.lOn = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aqd.vDY = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aqd.nhw = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aqd.vOg = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aqd.vOf = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aqd.wwU = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aqd.vZI = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aqd.whB = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aqd.wwV = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aqd.wwW = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aqd.wwX = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
