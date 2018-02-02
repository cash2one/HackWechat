package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afh extends bdf {
    public int liH;
    public String liI;
    public boolean sIl;
    public String wne;
    public String wnf;
    public String wng;
    public String wnh;
    public String wni;
    public boolean wnj;
    public String wnk;
    public long wnl;
    public boolean wnm;
    public boolean wnn;
    public boolean wno;
    public String wnp;
    public String wnq;
    public String wnr;
    public String wns;
    public boolean wnt;
    public LinkedList<String> wnu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.liH);
            if (this.liI != null) {
                aVar.g(3, this.liI);
            }
            if (this.wne != null) {
                aVar.g(4, this.wne);
            }
            if (this.wnf != null) {
                aVar.g(5, this.wnf);
            }
            if (this.wng != null) {
                aVar.g(6, this.wng);
            }
            if (this.wnh != null) {
                aVar.g(7, this.wnh);
            }
            if (this.wni != null) {
                aVar.g(8, this.wni);
            }
            aVar.al(9, this.wnj);
            if (this.wnk != null) {
                aVar.g(10, this.wnk);
            }
            aVar.S(11, this.wnl);
            aVar.al(12, this.wnm);
            aVar.al(13, this.wnn);
            aVar.al(14, this.wno);
            if (this.wnp != null) {
                aVar.g(15, this.wnp);
            }
            if (this.wnq != null) {
                aVar.g(16, this.wnq);
            }
            if (this.wnr != null) {
                aVar.g(17, this.wnr);
            }
            if (this.wns != null) {
                aVar.g(18, this.wns);
            }
            aVar.al(19, this.wnt);
            aVar.d(20, 1, this.wnu);
            aVar.al(21, this.sIl);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.liH);
            if (this.liI != null) {
                r0 += e.a.a.b.b.a.h(3, this.liI);
            }
            if (this.wne != null) {
                r0 += e.a.a.b.b.a.h(4, this.wne);
            }
            if (this.wnf != null) {
                r0 += e.a.a.b.b.a.h(5, this.wnf);
            }
            if (this.wng != null) {
                r0 += e.a.a.b.b.a.h(6, this.wng);
            }
            if (this.wnh != null) {
                r0 += e.a.a.b.b.a.h(7, this.wnh);
            }
            if (this.wni != null) {
                r0 += e.a.a.b.b.a.h(8, this.wni);
            }
            r0 += e.a.a.b.b.a.dX(9) + 1;
            if (this.wnk != null) {
                r0 += e.a.a.b.b.a.h(10, this.wnk);
            }
            r0 = (((r0 + e.a.a.a.R(11, this.wnl)) + (e.a.a.b.b.a.dX(12) + 1)) + (e.a.a.b.b.a.dX(13) + 1)) + (e.a.a.b.b.a.dX(14) + 1);
            if (this.wnp != null) {
                r0 += e.a.a.b.b.a.h(15, this.wnp);
            }
            if (this.wnq != null) {
                r0 += e.a.a.b.b.a.h(16, this.wnq);
            }
            if (this.wnr != null) {
                r0 += e.a.a.b.b.a.h(17, this.wnr);
            }
            if (this.wns != null) {
                r0 += e.a.a.b.b.a.h(18, this.wns);
            }
            return ((r0 + (e.a.a.b.b.a.dX(19) + 1)) + e.a.a.a.c(20, 1, this.wnu)) + (e.a.a.b.b.a.dX(21) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wnu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afh com_tencent_mm_protocal_c_afh = (afh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afh.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afh.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afh.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afh.wne = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afh.wnf = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_afh.wng = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_afh.wnh = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_afh.wni = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_afh.wnj = aVar3.cJC();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_afh.wnk = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_afh.wnl = aVar3.Avy.rz();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_afh.wnm = aVar3.cJC();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_afh.wnn = aVar3.cJC();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_afh.wno = aVar3.cJC();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_afh.wnp = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_afh.wnq = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_afh.wnr = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_afh.wns = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_afh.wnt = aVar3.cJC();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_afh.wnu.add(aVar3.Avy.readString());
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_afh.sIl = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
