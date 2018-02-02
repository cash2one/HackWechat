package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class brj extends a {
    public int apptype;
    public String fFm;
    public String hcp;
    public String kNs;
    public LinkedList<brk> wSQ = new LinkedList();
    public String wSR;
    public int wSS;
    public int wzO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fFm != null) {
                aVar.g(1, this.fFm);
            }
            if (this.hcp != null) {
                aVar.g(2, this.hcp);
            }
            aVar.fU(3, this.apptype);
            aVar.d(4, 8, this.wSQ);
            aVar.fU(5, this.wzO);
            if (this.wSR != null) {
                aVar.g(6, this.wSR);
            }
            if (this.kNs != null) {
                aVar.g(7, this.kNs);
            }
            aVar.fU(8, this.wSS);
            return 0;
        } else if (i == 1) {
            if (this.fFm != null) {
                r0 = e.a.a.b.b.a.h(1, this.fFm) + 0;
            } else {
                r0 = 0;
            }
            if (this.hcp != null) {
                r0 += e.a.a.b.b.a.h(2, this.hcp);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.apptype)) + e.a.a.a.c(4, 8, this.wSQ)) + e.a.a.a.fR(5, this.wzO);
            if (this.wSR != null) {
                r0 += e.a.a.b.b.a.h(6, this.wSR);
            }
            if (this.kNs != null) {
                r0 += e.a.a.b.b.a.h(7, this.kNs);
            }
            return r0 + e.a.a.a.fR(8, this.wSS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wSQ.clear();
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
            brj com_tencent_mm_protocal_c_brj = (brj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_brj.fFm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brj.hcp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_brj.apptype = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_brk = new brk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_brk.a(aVar4, com_tencent_mm_protocal_c_brk, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brj.wSQ.add(com_tencent_mm_protocal_c_brk);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_brj.wzO = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_brj.wSR = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_brj.kNs = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_brj.wSS = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
