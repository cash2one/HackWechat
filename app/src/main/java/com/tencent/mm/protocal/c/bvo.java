package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bvo extends a {
    public String wWP;
    public String wWQ;
    public String wWR;
    public String wWS;
    public int wWT;
    public float wWU;
    public float wWV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWP != null) {
                aVar.g(1, this.wWP);
            }
            if (this.wWQ != null) {
                aVar.g(2, this.wWQ);
            }
            if (this.wWR != null) {
                aVar.g(3, this.wWR);
            }
            if (this.wWS != null) {
                aVar.g(4, this.wWS);
            }
            aVar.fU(5, this.wWT);
            aVar.m(6, this.wWU);
            aVar.m(7, this.wWV);
            return 0;
        } else if (i == 1) {
            if (this.wWP != null) {
                r0 = e.a.a.b.b.a.h(1, this.wWP) + 0;
            } else {
                r0 = 0;
            }
            if (this.wWQ != null) {
                r0 += e.a.a.b.b.a.h(2, this.wWQ);
            }
            if (this.wWR != null) {
                r0 += e.a.a.b.b.a.h(3, this.wWR);
            }
            if (this.wWS != null) {
                r0 += e.a.a.b.b.a.h(4, this.wWS);
            }
            return ((r0 + e.a.a.a.fR(5, this.wWT)) + (e.a.a.b.b.a.dX(6) + 4)) + (e.a.a.b.b.a.dX(7) + 4);
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
            bvo com_tencent_mm_protocal_c_bvo = (bvo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bvo.wWP = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bvo.wWQ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bvo.wWR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bvo.wWS = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bvo.wWT = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bvo.wWU = aVar3.Avy.readFloat();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bvo.wWV = aVar3.Avy.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
