package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bho extends bdf {
    public int cey;
    public String fGV;
    public String hbM;
    public String kJN;
    public String kJP;
    public String kJQ;
    public String kJR;
    public String kLa;
    public int kLy;
    public int qol;
    public int qoo;
    public String qop;
    public String qoq;
    public String qor;
    public String qos;
    public String qot;
    public boolean qou;
    public String title;

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
            aVar.fU(2, this.kLy);
            if (this.kJN != null) {
                aVar.g(3, this.kJN);
            }
            if (this.fGV != null) {
                aVar.g(4, this.fGV);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.kJQ != null) {
                aVar.g(6, this.kJQ);
            }
            if (this.kJR != null) {
                aVar.g(7, this.kJR);
            }
            if (this.kLa != null) {
                aVar.g(8, this.kLa);
            }
            if (this.kJP != null) {
                aVar.g(9, this.kJP);
            }
            if (this.hbM != null) {
                aVar.g(10, this.hbM);
            }
            aVar.fU(11, this.qol);
            aVar.fU(12, this.qoo);
            if (this.qop != null) {
                aVar.g(13, this.qop);
            }
            if (this.qoq != null) {
                aVar.g(14, this.qoq);
            }
            if (this.qor != null) {
                aVar.g(19, this.qor);
            }
            if (this.qos != null) {
                aVar.g(21, this.qos);
            }
            aVar.fU(22, this.cey);
            if (this.qot != null) {
                aVar.g(23, this.qot);
            }
            aVar.al(24, this.qou);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.kLy);
            if (this.kJN != null) {
                r0 += e.a.a.b.b.a.h(3, this.kJN);
            }
            if (this.fGV != null) {
                r0 += e.a.a.b.b.a.h(4, this.fGV);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(5, this.title);
            }
            if (this.kJQ != null) {
                r0 += e.a.a.b.b.a.h(6, this.kJQ);
            }
            if (this.kJR != null) {
                r0 += e.a.a.b.b.a.h(7, this.kJR);
            }
            if (this.kLa != null) {
                r0 += e.a.a.b.b.a.h(8, this.kLa);
            }
            if (this.kJP != null) {
                r0 += e.a.a.b.b.a.h(9, this.kJP);
            }
            if (this.hbM != null) {
                r0 += e.a.a.b.b.a.h(10, this.hbM);
            }
            r0 = (r0 + e.a.a.a.fR(11, this.qol)) + e.a.a.a.fR(12, this.qoo);
            if (this.qop != null) {
                r0 += e.a.a.b.b.a.h(13, this.qop);
            }
            if (this.qoq != null) {
                r0 += e.a.a.b.b.a.h(14, this.qoq);
            }
            if (this.qor != null) {
                r0 += e.a.a.b.b.a.h(19, this.qor);
            }
            if (this.qos != null) {
                r0 += e.a.a.b.b.a.h(21, this.qos);
            }
            r0 += e.a.a.a.fR(22, this.cey);
            if (this.qot != null) {
                r0 += e.a.a.b.b.a.h(23, this.qot);
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
            bho com_tencent_mm_protocal_c_bho = (bho) objArr[1];
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
                        com_tencent_mm_protocal_c_bho.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bho.kLy = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bho.kJN = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bho.fGV = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bho.title = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bho.kJQ = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bho.kJR = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bho.kLa = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bho.kJP = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bho.hbM = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bho.qol = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bho.qoo = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bho.qop = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bho.qoq = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bho.qor = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bho.qos = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bho.cey = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bho.qot = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bho.qou = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
