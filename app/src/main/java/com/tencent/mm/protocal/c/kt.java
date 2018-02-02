package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public class kt extends a {
    public String kJQ;
    public String kNs;
    public String oZC;
    public String title;
    public String url;
    public String vRx;
    public String vRy;
    public long vSM;
    public String vSN;
    public String vSO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.kJQ != null) {
                aVar.g(2, this.kJQ);
            }
            if (this.kNs != null) {
                aVar.g(3, this.kNs);
            }
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            aVar.S(5, this.vSM);
            if (this.vSN != null) {
                aVar.g(6, this.vSN);
            }
            if (this.vSO != null) {
                aVar.g(7, this.vSO);
            }
            if (this.oZC != null) {
                aVar.g(8, this.oZC);
            }
            if (this.vRx != null) {
                aVar.g(9, this.vRx);
            }
            if (this.vRy == null) {
                return 0;
            }
            aVar.g(10, this.vRy);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.kJQ != null) {
                r0 += e.a.a.b.b.a.h(2, this.kJQ);
            }
            if (this.kNs != null) {
                r0 += e.a.a.b.b.a.h(3, this.kNs);
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(4, this.url);
            }
            r0 += e.a.a.a.R(5, this.vSM);
            if (this.vSN != null) {
                r0 += e.a.a.b.b.a.h(6, this.vSN);
            }
            if (this.vSO != null) {
                r0 += e.a.a.b.b.a.h(7, this.vSO);
            }
            if (this.oZC != null) {
                r0 += e.a.a.b.b.a.h(8, this.oZC);
            }
            if (this.vRx != null) {
                r0 += e.a.a.b.b.a.h(9, this.vRx);
            }
            if (this.vRy != null) {
                r0 += e.a.a.b.b.a.h(10, this.vRy);
            }
            return r0;
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
            kt ktVar = (kt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ktVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ktVar.kJQ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ktVar.kNs = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ktVar.url = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ktVar.vSM = aVar3.Avy.rz();
                    return 0;
                case 6:
                    ktVar.vSN = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ktVar.vSO = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ktVar.oZC = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ktVar.vRx = aVar3.Avy.readString();
                    return 0;
                case 10:
                    ktVar.vRy = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
