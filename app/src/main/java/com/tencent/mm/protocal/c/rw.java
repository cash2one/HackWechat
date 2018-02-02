package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class rw extends a {
    public String nfX;
    public String pbP;
    public String vIR;
    public String vZL;
    public String vZM;
    public String vZN;
    public String vZO;
    public String vZP;
    public String vZQ;
    public String vZR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZL == null) {
                throw new b("Not all required fields were included: Md5");
            }
            if (this.vZL != null) {
                aVar.g(1, this.vZL);
            }
            if (this.nfX != null) {
                aVar.g(2, this.nfX);
            }
            if (this.pbP != null) {
                aVar.g(3, this.pbP);
            }
            if (this.vZM != null) {
                aVar.g(4, this.vZM);
            }
            if (this.vZN != null) {
                aVar.g(5, this.vZN);
            }
            if (this.vZO != null) {
                aVar.g(6, this.vZO);
            }
            if (this.vIR != null) {
                aVar.g(7, this.vIR);
            }
            if (this.vZP != null) {
                aVar.g(8, this.vZP);
            }
            if (this.vZQ != null) {
                aVar.g(9, this.vZQ);
            }
            if (this.vZR == null) {
                return 0;
            }
            aVar.g(10, this.vZR);
            return 0;
        } else if (i == 1) {
            if (this.vZL != null) {
                r0 = e.a.a.b.b.a.h(1, this.vZL) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfX);
            }
            if (this.pbP != null) {
                r0 += e.a.a.b.b.a.h(3, this.pbP);
            }
            if (this.vZM != null) {
                r0 += e.a.a.b.b.a.h(4, this.vZM);
            }
            if (this.vZN != null) {
                r0 += e.a.a.b.b.a.h(5, this.vZN);
            }
            if (this.vZO != null) {
                r0 += e.a.a.b.b.a.h(6, this.vZO);
            }
            if (this.vIR != null) {
                r0 += e.a.a.b.b.a.h(7, this.vIR);
            }
            if (this.vZP != null) {
                r0 += e.a.a.b.b.a.h(8, this.vZP);
            }
            if (this.vZQ != null) {
                r0 += e.a.a.b.b.a.h(9, this.vZQ);
            }
            if (this.vZR != null) {
                r0 += e.a.a.b.b.a.h(10, this.vZR);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vZL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Md5");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rw rwVar = (rw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rwVar.vZL = aVar3.Avy.readString();
                    return 0;
                case 2:
                    rwVar.nfX = aVar3.Avy.readString();
                    return 0;
                case 3:
                    rwVar.pbP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    rwVar.vZM = aVar3.Avy.readString();
                    return 0;
                case 5:
                    rwVar.vZN = aVar3.Avy.readString();
                    return 0;
                case 6:
                    rwVar.vZO = aVar3.Avy.readString();
                    return 0;
                case 7:
                    rwVar.vIR = aVar3.Avy.readString();
                    return 0;
                case 8:
                    rwVar.vZP = aVar3.Avy.readString();
                    return 0;
                case 9:
                    rwVar.vZQ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    rwVar.vZR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
