package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class aya extends a {
    public int ksO;
    public int ktN;
    public String nfp;
    public String pbP;
    public int rYW;
    public int wFe;
    public LinkedList<anm> wFf = new LinkedList();
    public int wFg;
    public String wFh;
    public String wFi;
    public int wFj;
    public String wFk;
    public int wFl;
    public LinkedList<rc> wFm = new LinkedList();
    public String waD;
    public String wmH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wFe);
            aVar.d(2, 8, this.wFf);
            aVar.fU(3, this.ksO);
            aVar.fU(4, this.wFg);
            if (this.waD != null) {
                aVar.g(5, this.waD);
            }
            if (this.wmH != null) {
                aVar.g(6, this.wmH);
            }
            if (this.wFh != null) {
                aVar.g(7, this.wFh);
            }
            if (this.wFi != null) {
                aVar.g(8, this.wFi);
            }
            aVar.fU(9, this.ktN);
            if (this.nfp != null) {
                aVar.g(10, this.nfp);
            }
            if (this.pbP != null) {
                aVar.g(11, this.pbP);
            }
            aVar.fU(12, this.wFj);
            aVar.fU(13, this.rYW);
            if (this.wFk != null) {
                aVar.g(14, this.wFk);
            }
            aVar.fU(15, this.wFl);
            aVar.d(16, 8, this.wFm);
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.a.fR(1, this.wFe) + 0) + e.a.a.a.c(2, 8, this.wFf)) + e.a.a.a.fR(3, this.ksO)) + e.a.a.a.fR(4, this.wFg);
            if (this.waD != null) {
                r0 += e.a.a.b.b.a.h(5, this.waD);
            }
            if (this.wmH != null) {
                r0 += e.a.a.b.b.a.h(6, this.wmH);
            }
            if (this.wFh != null) {
                r0 += e.a.a.b.b.a.h(7, this.wFh);
            }
            if (this.wFi != null) {
                r0 += e.a.a.b.b.a.h(8, this.wFi);
            }
            r0 += e.a.a.a.fR(9, this.ktN);
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(10, this.nfp);
            }
            if (this.pbP != null) {
                r0 += e.a.a.b.b.a.h(11, this.pbP);
            }
            r0 = (r0 + e.a.a.a.fR(12, this.wFj)) + e.a.a.a.fR(13, this.rYW);
            if (this.wFk != null) {
                r0 += e.a.a.b.b.a.h(14, this.wFk);
            }
            return (r0 + e.a.a.a.fR(15, this.wFl)) + e.a.a.a.c(16, 8, this.wFm);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wFf.clear();
            this.wFm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            aya com_tencent_mm_protocal_c_aya = (aya) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_anm;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aya.wFe = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_anm = new anm();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_anm.a(aVar4, com_tencent_mm_protocal_c_anm, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aya.wFf.add(com_tencent_mm_protocal_c_anm);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aya.ksO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aya.wFg = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aya.waD = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aya.wmH = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aya.wFh = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aya.wFi = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aya.ktN = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aya.nfp = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aya.pbP = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aya.wFj = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aya.rYW = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aya.wFk = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aya.wFl = aVar3.Avy.ry();
                    return 0;
                case 16:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_anm = new rc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_anm.a(aVar4, com_tencent_mm_protocal_c_anm, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aya.wFm.add(com_tencent_mm_protocal_c_anm);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
