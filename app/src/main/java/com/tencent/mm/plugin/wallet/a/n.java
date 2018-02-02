package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;

public final class n extends a {
    public String desc;
    public String id;
    public String name;
    public String sDM;
    public String sDN;
    public String sDO = "0";
    public String sDP = "0";
    public int sDQ = 0;
    public int status;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.fU(4, this.status);
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            aVar.fU(6, this.type);
            if (this.sDM != null) {
                aVar.g(7, this.sDM);
            }
            if (this.sDN != null) {
                aVar.g(8, this.sDN);
            }
            if (this.sDO != null) {
                aVar.g(9, this.sDO);
            }
            if (this.sDP != null) {
                aVar.g(10, this.sDP);
            }
            aVar.fU(11, this.sDQ);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                r0 = e.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(3, this.desc);
            }
            r0 += e.a.a.a.fR(4, this.status);
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(5, this.url);
            }
            r0 += e.a.a.a.fR(6, this.type);
            if (this.sDM != null) {
                r0 += e.a.a.b.b.a.h(7, this.sDM);
            }
            if (this.sDN != null) {
                r0 += e.a.a.b.b.a.h(8, this.sDN);
            }
            if (this.sDO != null) {
                r0 += e.a.a.b.b.a.h(9, this.sDO);
            }
            if (this.sDP != null) {
                r0 += e.a.a.b.b.a.h(10, this.sDP);
            }
            return r0 + e.a.a.a.fR(11, this.sDQ);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.id = aVar3.Avy.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    nVar.desc = aVar3.Avy.readString();
                    return 0;
                case 4:
                    nVar.status = aVar3.Avy.ry();
                    return 0;
                case 5:
                    nVar.url = aVar3.Avy.readString();
                    return 0;
                case 6:
                    nVar.type = aVar3.Avy.ry();
                    return 0;
                case 7:
                    nVar.sDM = aVar3.Avy.readString();
                    return 0;
                case 8:
                    nVar.sDN = aVar3.Avy.readString();
                    return 0;
                case 9:
                    nVar.sDO = aVar3.Avy.readString();
                    return 0;
                case 10:
                    nVar.sDP = aVar3.Avy.readString();
                    return 0;
                case 11:
                    nVar.sDQ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
