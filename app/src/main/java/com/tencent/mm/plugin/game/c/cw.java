package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class cw extends a {
    public String nfe;
    public String nfg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfe == null) {
                throw new b("Not all required fields were included: Desc");
            }
            if (this.nfe != null) {
                aVar.g(1, this.nfe);
            }
            if (this.nfg == null) {
                return 0;
            }
            aVar.g(2, this.nfg);
            return 0;
        } else if (i == 1) {
            if (this.nfe != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfe) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfg);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Desc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cw cwVar = (cw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cwVar.nfg = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
