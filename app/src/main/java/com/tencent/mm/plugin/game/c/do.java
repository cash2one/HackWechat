package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class do extends a {
    public String fon;
    public String nfK;
    public String nfe;
    public String nff;
    public String nfg;
    public String ngo;
    public String niZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.niZ == null) {
                throw new b("Not all required fields were included: AppName");
            }
            if (this.niZ != null) {
                aVar.g(1, this.niZ);
            }
            if (this.nff != null) {
                aVar.g(2, this.nff);
            }
            if (this.fon != null) {
                aVar.g(3, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(4, this.nfe);
            }
            if (this.nfK != null) {
                aVar.g(5, this.nfK);
            }
            if (this.nfg != null) {
                aVar.g(6, this.nfg);
            }
            if (this.ngo == null) {
                return 0;
            }
            aVar.g(7, this.ngo);
            return 0;
        } else if (i == 1) {
            if (this.niZ != null) {
                r0 = e.a.a.b.b.a.h(1, this.niZ) + 0;
            } else {
                r0 = 0;
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(2, this.nff);
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfe);
            }
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfK);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfg);
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(7, this.ngo);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.niZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            do doVar = (do) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doVar.niZ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    doVar.nff = aVar3.Avy.readString();
                    return 0;
                case 3:
                    doVar.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    doVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    doVar.nfK = aVar3.Avy.readString();
                    return 0;
                case 6:
                    doVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 7:
                    doVar.ngo = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
