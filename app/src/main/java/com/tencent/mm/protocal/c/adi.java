package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adi extends bdf {
    public int cey;
    public String fGV;
    public String hbM;
    public String kJN;
    public String kJP;
    public String kJQ;
    public String kJR;
    public String kLa;
    public int qoo;
    public String qop;
    public String qoq;
    public String qor;
    public String qot;
    public boolean qou;
    public String title;
    public boolean wlG;
    public boolean wlH;
    public String wlI;
    public String wlJ;
    public int wlK;
    public String wlL;
    public int wlM;
    public String wlN;

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
            aVar.al(2, this.wlG);
            aVar.al(3, this.wlH);
            if (this.wlI != null) {
                aVar.g(4, this.wlI);
            }
            if (this.wlJ != null) {
                aVar.g(5, this.wlJ);
            }
            aVar.fU(6, this.wlK);
            if (this.wlL != null) {
                aVar.g(7, this.wlL);
            }
            aVar.fU(8, this.wlM);
            if (this.kJN != null) {
                aVar.g(9, this.kJN);
            }
            if (this.fGV != null) {
                aVar.g(10, this.fGV);
            }
            if (this.title != null) {
                aVar.g(11, this.title);
            }
            if (this.kJQ != null) {
                aVar.g(12, this.kJQ);
            }
            if (this.kJR != null) {
                aVar.g(13, this.kJR);
            }
            if (this.kLa != null) {
                aVar.g(14, this.kLa);
            }
            if (this.kJP != null) {
                aVar.g(15, this.kJP);
            }
            if (this.hbM != null) {
                aVar.g(16, this.hbM);
            }
            aVar.fU(17, this.qoo);
            if (this.qop != null) {
                aVar.g(18, this.qop);
            }
            if (this.qoq != null) {
                aVar.g(19, this.qoq);
            }
            if (this.qor != null) {
                aVar.g(20, this.qor);
            }
            aVar.fU(21, this.cey);
            if (this.qot != null) {
                aVar.g(22, this.qot);
            }
            if (this.wlN != null) {
                aVar.g(23, this.wlN);
            }
            aVar.al(24, this.qou);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + (e.a.a.b.b.a.dX(2) + 1)) + (e.a.a.b.b.a.dX(3) + 1);
            if (this.wlI != null) {
                r0 += e.a.a.b.b.a.h(4, this.wlI);
            }
            if (this.wlJ != null) {
                r0 += e.a.a.b.b.a.h(5, this.wlJ);
            }
            r0 += e.a.a.a.fR(6, this.wlK);
            if (this.wlL != null) {
                r0 += e.a.a.b.b.a.h(7, this.wlL);
            }
            r0 += e.a.a.a.fR(8, this.wlM);
            if (this.kJN != null) {
                r0 += e.a.a.b.b.a.h(9, this.kJN);
            }
            if (this.fGV != null) {
                r0 += e.a.a.b.b.a.h(10, this.fGV);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(11, this.title);
            }
            if (this.kJQ != null) {
                r0 += e.a.a.b.b.a.h(12, this.kJQ);
            }
            if (this.kJR != null) {
                r0 += e.a.a.b.b.a.h(13, this.kJR);
            }
            if (this.kLa != null) {
                r0 += e.a.a.b.b.a.h(14, this.kLa);
            }
            if (this.kJP != null) {
                r0 += e.a.a.b.b.a.h(15, this.kJP);
            }
            if (this.hbM != null) {
                r0 += e.a.a.b.b.a.h(16, this.hbM);
            }
            r0 += e.a.a.a.fR(17, this.qoo);
            if (this.qop != null) {
                r0 += e.a.a.b.b.a.h(18, this.qop);
            }
            if (this.qoq != null) {
                r0 += e.a.a.b.b.a.h(19, this.qoq);
            }
            if (this.qor != null) {
                r0 += e.a.a.b.b.a.h(20, this.qor);
            }
            r0 += e.a.a.a.fR(21, this.cey);
            if (this.qot != null) {
                r0 += e.a.a.b.b.a.h(22, this.qot);
            }
            if (this.wlN != null) {
                r0 += e.a.a.b.b.a.h(23, this.wlN);
            }
            return r0 + (e.a.a.b.b.a.dX(24) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
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
            adi com_tencent_mm_protocal_c_adi = (adi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adi.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adi.wlG = aVar3.cJC();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adi.wlH = aVar3.cJC();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adi.wlI = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adi.wlJ = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adi.wlK = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adi.wlL = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adi.wlM = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_adi.kJN = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_adi.fGV = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_adi.title = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_adi.kJQ = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_adi.kJR = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_adi.kLa = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_adi.kJP = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_adi.hbM = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_adi.qoo = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_adi.qop = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_adi.qoq = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_adi.qor = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_adi.cey = aVar3.Avy.ry();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_adi.qot = aVar3.Avy.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_adi.wlN = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_adi.qou = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
