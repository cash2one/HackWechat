package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class ji extends a {
    public String pbQ;
    public String vPA;
    public String vPB;
    public String vPC;
    public int vPD;
    public String vPE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPA == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.pbQ == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.vPB == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.vPC == null) {
                throw new b("Not all required fields were included: SellerUserName");
            } else {
                if (this.vPA != null) {
                    aVar.g(1, this.vPA);
                }
                if (this.pbQ != null) {
                    aVar.g(2, this.pbQ);
                }
                if (this.vPB != null) {
                    aVar.g(3, this.vPB);
                }
                if (this.vPC != null) {
                    aVar.g(4, this.vPC);
                }
                aVar.fU(5, this.vPD);
                if (this.vPE == null) {
                    return 0;
                }
                aVar.g(6, this.vPE);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPA != null) {
                r0 = e.a.a.b.b.a.h(1, this.vPA) + 0;
            } else {
                r0 = 0;
            }
            if (this.pbQ != null) {
                r0 += e.a.a.b.b.a.h(2, this.pbQ);
            }
            if (this.vPB != null) {
                r0 += e.a.a.b.b.a.h(3, this.vPB);
            }
            if (this.vPC != null) {
                r0 += e.a.a.b.b.a.h(4, this.vPC);
            }
            r0 += e.a.a.a.fR(5, this.vPD);
            if (this.vPE != null) {
                r0 += e.a.a.b.b.a.h(6, this.vPE);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vPA == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.pbQ == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.vPB == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.vPC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SellerUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ji jiVar = (ji) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jiVar.vPA = aVar3.Avy.readString();
                    return 0;
                case 2:
                    jiVar.pbQ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    jiVar.vPB = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jiVar.vPC = aVar3.Avy.readString();
                    return 0;
                case 5:
                    jiVar.vPD = aVar3.Avy.ry();
                    return 0;
                case 6:
                    jiVar.vPE = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
