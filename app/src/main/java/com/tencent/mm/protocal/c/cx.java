package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class cx extends a {
    public int ktN;
    public String ngo;
    public String nje;
    public String nko;
    public String nkp;
    public int pbl;
    public int vHT;
    public String vHU;
    public bdn vHV;
    public int vHW;
    public int vHX;
    public String vHY;
    public String vHZ;
    public String vHc;
    public String vIa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkp != null) {
                aVar.g(1, this.nkp);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            aVar.fU(3, this.vHT);
            if (this.nko != null) {
                aVar.g(4, this.nko);
            }
            aVar.fU(5, this.ktN);
            if (this.nje != null) {
                aVar.g(6, this.nje);
            }
            aVar.fU(7, this.pbl);
            if (this.vHU != null) {
                aVar.g(8, this.vHU);
            }
            if (this.vHV != null) {
                aVar.fW(9, this.vHV.bke());
                this.vHV.a(aVar);
            }
            aVar.fU(10, this.vHW);
            aVar.fU(11, this.vHX);
            if (this.vHc != null) {
                aVar.g(12, this.vHc);
            }
            if (this.vHY != null) {
                aVar.g(13, this.vHY);
            }
            if (this.vHZ != null) {
                aVar.g(14, this.vHZ);
            }
            if (this.vIa == null) {
                return 0;
            }
            aVar.g(15, this.vIa);
            return 0;
        } else if (i == 1) {
            if (this.nkp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nkp) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            r0 += e.a.a.a.fR(3, this.vHT);
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(4, this.nko);
            }
            r0 += e.a.a.a.fR(5, this.ktN);
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(6, this.nje);
            }
            r0 += e.a.a.a.fR(7, this.pbl);
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(8, this.vHU);
            }
            if (this.vHV != null) {
                r0 += e.a.a.a.fT(9, this.vHV.bke());
            }
            r0 = (r0 + e.a.a.a.fR(10, this.vHW)) + e.a.a.a.fR(11, this.vHX);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(12, this.vHc);
            }
            if (this.vHY != null) {
                r0 += e.a.a.b.b.a.h(13, this.vHY);
            }
            if (this.vHZ != null) {
                r0 += e.a.a.b.b.a.h(14, this.vHZ);
            }
            if (this.vIa != null) {
                r0 += e.a.a.b.b.a.h(15, this.vIa);
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
            cx cxVar = (cx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cxVar.nkp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cxVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cxVar.vHT = aVar3.Avy.ry();
                    return 0;
                case 4:
                    cxVar.nko = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cxVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 6:
                    cxVar.nje = aVar3.Avy.readString();
                    return 0;
                case 7:
                    cxVar.pbl = aVar3.Avy.ry();
                    return 0;
                case 8:
                    cxVar.vHU = aVar3.Avy.readString();
                    return 0;
                case 9:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        cxVar.vHV = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 10:
                    cxVar.vHW = aVar3.Avy.ry();
                    return 0;
                case 11:
                    cxVar.vHX = aVar3.Avy.ry();
                    return 0;
                case 12:
                    cxVar.vHc = aVar3.Avy.readString();
                    return 0;
                case 13:
                    cxVar.vHY = aVar3.Avy.readString();
                    return 0;
                case 14:
                    cxVar.vHZ = aVar3.Avy.readString();
                    return 0;
                case 15:
                    cxVar.vIa = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
