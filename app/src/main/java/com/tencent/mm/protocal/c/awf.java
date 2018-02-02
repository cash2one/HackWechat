package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class awf extends a {
    public String hCk;
    public String pLr;
    public String paz;
    public int wDO;
    public String wDP;
    public int wDQ;
    public String wDR;
    public int wDS;
    public String wDT;
    public long wDU;
    public LinkedList<avw> wDV = new LinkedList();
    public String wsn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wDO);
            if (this.wDP != null) {
                aVar.g(2, this.wDP);
            }
            if (this.wsn != null) {
                aVar.g(3, this.wsn);
            }
            aVar.fU(4, this.wDQ);
            if (this.paz != null) {
                aVar.g(5, this.paz);
            }
            if (this.wDR != null) {
                aVar.g(6, this.wDR);
            }
            if (this.pLr != null) {
                aVar.g(7, this.pLr);
            }
            aVar.fU(8, this.wDS);
            if (this.hCk != null) {
                aVar.g(9, this.hCk);
            }
            if (this.wDT != null) {
                aVar.g(10, this.wDT);
            }
            aVar.S(11, this.wDU);
            aVar.d(12, 8, this.wDV);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wDO) + 0;
            if (this.wDP != null) {
                r0 += e.a.a.b.b.a.h(2, this.wDP);
            }
            if (this.wsn != null) {
                r0 += e.a.a.b.b.a.h(3, this.wsn);
            }
            r0 += e.a.a.a.fR(4, this.wDQ);
            if (this.paz != null) {
                r0 += e.a.a.b.b.a.h(5, this.paz);
            }
            if (this.wDR != null) {
                r0 += e.a.a.b.b.a.h(6, this.wDR);
            }
            if (this.pLr != null) {
                r0 += e.a.a.b.b.a.h(7, this.pLr);
            }
            r0 += e.a.a.a.fR(8, this.wDS);
            if (this.hCk != null) {
                r0 += e.a.a.b.b.a.h(9, this.hCk);
            }
            if (this.wDT != null) {
                r0 += e.a.a.b.b.a.h(10, this.wDT);
            }
            return (r0 + e.a.a.a.R(11, this.wDU)) + e.a.a.a.c(12, 8, this.wDV);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wDV.clear();
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
            awf com_tencent_mm_protocal_c_awf = (awf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_awf.wDO = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awf.wDP = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awf.wsn = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awf.wDQ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awf.paz = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awf.wDR = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awf.pLr = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_awf.wDS = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_awf.hCk = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_awf.wDT = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_awf.wDU = aVar3.Avy.rz();
                    return 0;
                case 12:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awf.wDV.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
