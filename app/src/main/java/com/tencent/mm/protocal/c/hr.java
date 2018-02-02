package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class hr extends a {
    public int vNA;
    public int vNB;
    public int vNC;
    public int vND;
    public long vNE;
    public long vNF;
    public int vNG;
    public boolean vNH;
    public int vNI;
    public boolean vNJ;
    public fa vNK;
    public boolean vNL;
    public String vNq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNq == null) {
                throw new b("Not all required fields were included: brand_user_name");
            }
            if (this.vNq != null) {
                aVar.g(1, this.vNq);
            }
            aVar.fU(2, this.vNA);
            aVar.fU(3, this.vNB);
            aVar.fU(4, this.vNC);
            aVar.fU(5, this.vND);
            aVar.S(6, this.vNE);
            aVar.S(7, this.vNF);
            aVar.fU(8, this.vNG);
            aVar.al(9, this.vNH);
            aVar.fU(10, this.vNI);
            aVar.al(11, this.vNJ);
            if (this.vNK != null) {
                aVar.fW(12, this.vNK.bke());
                this.vNK.a(aVar);
            }
            aVar.al(13, this.vNL);
            return 0;
        } else if (i == 1) {
            if (this.vNq != null) {
                r0 = e.a.a.b.b.a.h(1, this.vNq) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((((((((r0 + e.a.a.a.fR(2, this.vNA)) + e.a.a.a.fR(3, this.vNB)) + e.a.a.a.fR(4, this.vNC)) + e.a.a.a.fR(5, this.vND)) + e.a.a.a.R(6, this.vNE)) + e.a.a.a.R(7, this.vNF)) + e.a.a.a.fR(8, this.vNG)) + (e.a.a.b.b.a.dX(9) + 1)) + e.a.a.a.fR(10, this.vNI)) + (e.a.a.b.b.a.dX(11) + 1);
            if (this.vNK != null) {
                r0 += e.a.a.a.fT(12, this.vNK.bke());
            }
            return r0 + (e.a.a.b.b.a.dX(13) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vNq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: brand_user_name");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hr hrVar = (hr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hrVar.vNq = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hrVar.vNA = aVar3.Avy.ry();
                    return 0;
                case 3:
                    hrVar.vNB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    hrVar.vNC = aVar3.Avy.ry();
                    return 0;
                case 5:
                    hrVar.vND = aVar3.Avy.ry();
                    return 0;
                case 6:
                    hrVar.vNE = aVar3.Avy.rz();
                    return 0;
                case 7:
                    hrVar.vNF = aVar3.Avy.rz();
                    return 0;
                case 8:
                    hrVar.vNG = aVar3.Avy.ry();
                    return 0;
                case 9:
                    hrVar.vNH = aVar3.cJC();
                    return 0;
                case 10:
                    hrVar.vNI = aVar3.Avy.ry();
                    return 0;
                case 11:
                    hrVar.vNJ = aVar3.cJC();
                    return 0;
                case 12:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a faVar = new fa();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = faVar.a(aVar4, faVar, a.a(aVar4))) {
                        }
                        hrVar.vNK = faVar;
                    }
                    return 0;
                case 13:
                    hrVar.vNL = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
