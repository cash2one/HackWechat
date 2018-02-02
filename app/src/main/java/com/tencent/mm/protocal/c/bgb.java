package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bgb extends a {
    public String fqR;
    public int hUs;
    public int hVH;
    public int hbn;
    public int hbo;
    public String hbp;
    public String raP;
    public String url;
    public LinkedList<bnx> wKI = new LinkedList();
    public int wKJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.raP == null) {
                throw new b("Not all required fields were included: clientID");
            }
            aVar.d(1, 8, this.wKI);
            if (this.raP != null) {
                aVar.g(2, this.raP);
            }
            if (this.fqR != null) {
                aVar.g(3, this.fqR);
            }
            if (this.hbp != null) {
                aVar.g(4, this.hbp);
            }
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            aVar.fU(6, this.hVH);
            aVar.fU(7, this.hUs);
            aVar.fU(8, this.wKJ);
            aVar.fU(9, this.hbn);
            aVar.fU(10, this.hbo);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.wKI) + 0;
            if (this.raP != null) {
                r0 += e.a.a.b.b.a.h(2, this.raP);
            }
            if (this.fqR != null) {
                r0 += e.a.a.b.b.a.h(3, this.fqR);
            }
            if (this.hbp != null) {
                r0 += e.a.a.b.b.a.h(4, this.hbp);
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(5, this.url);
            }
            return ((((r0 + e.a.a.a.fR(6, this.hVH)) + e.a.a.a.fR(7, this.hUs)) + e.a.a.a.fR(8, this.wKJ)) + e.a.a.a.fR(9, this.hbn)) + e.a.a.a.fR(10, this.hbo);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wKI.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.raP != null) {
                return 0;
            }
            throw new b("Not all required fields were included: clientID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgb com_tencent_mm_protocal_c_bgb = (bgb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bnx = new bnx();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bnx.a(aVar4, com_tencent_mm_protocal_c_bnx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bgb.wKI.add(com_tencent_mm_protocal_c_bnx);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgb.raP = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgb.fqR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bgb.hbp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bgb.url = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bgb.hVH = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bgb.hUs = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bgb.wKJ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bgb.hbn = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bgb.hbo = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
