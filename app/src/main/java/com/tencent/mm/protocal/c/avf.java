package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public class avf extends a {
    public String hvu;
    public String hvv;
    public String nfp;
    public String oPA;
    public double vNO;
    public double vNP;
    public String vYy;
    public String vYz;
    public String wCR;
    public String wCS;
    public String wCT;
    public String wCU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfp != null) {
                aVar.g(1, this.nfp);
            }
            if (this.wCR != null) {
                aVar.g(2, this.wCR);
            }
            aVar.b(3, this.vNO);
            aVar.b(4, this.vNP);
            if (this.wCS != null) {
                aVar.g(5, this.wCS);
            }
            if (this.oPA != null) {
                aVar.g(6, this.oPA);
            }
            if (this.wCT != null) {
                aVar.g(7, this.wCT);
            }
            if (this.hvu != null) {
                aVar.g(8, this.hvu);
            }
            if (this.hvv != null) {
                aVar.g(9, this.hvv);
            }
            if (this.vYy != null) {
                aVar.g(10, this.vYy);
            }
            if (this.vYz != null) {
                aVar.g(11, this.vYz);
            }
            if (this.wCU == null) {
                return 0;
            }
            aVar.g(12, this.wCU);
            return 0;
        } else if (i == 1) {
            if (this.nfp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfp) + 0;
            } else {
                r0 = 0;
            }
            if (this.wCR != null) {
                r0 += e.a.a.b.b.a.h(2, this.wCR);
            }
            r0 = (r0 + (e.a.a.b.b.a.dX(3) + 8)) + (e.a.a.b.b.a.dX(4) + 8);
            if (this.wCS != null) {
                r0 += e.a.a.b.b.a.h(5, this.wCS);
            }
            if (this.oPA != null) {
                r0 += e.a.a.b.b.a.h(6, this.oPA);
            }
            if (this.wCT != null) {
                r0 += e.a.a.b.b.a.h(7, this.wCT);
            }
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(8, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(9, this.hvv);
            }
            if (this.vYy != null) {
                r0 += e.a.a.b.b.a.h(10, this.vYy);
            }
            if (this.vYz != null) {
                r0 += e.a.a.b.b.a.h(11, this.vYz);
            }
            if (this.wCU != null) {
                r0 += e.a.a.b.b.a.h(12, this.wCU);
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
            avf com_tencent_mm_protocal_c_avf = (avf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avf.nfp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avf.wCR = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avf.vNO = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avf.vNP = aVar3.Avy.readDouble();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avf.wCS = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avf.oPA = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avf.wCT = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avf.hvu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avf.hvv = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avf.vYy = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_avf.vYz = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_avf.wCU = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
