package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class m extends a {
    public String nfU;
    public String nfV;
    public String nfW;
    public String nfX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfU == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.nfV == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.nfW == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.nfX == null) {
                throw new b("Not all required fields were included: Url");
            } else {
                if (this.nfU != null) {
                    aVar.g(1, this.nfU);
                }
                if (this.nfV != null) {
                    aVar.g(2, this.nfV);
                }
                if (this.nfW != null) {
                    aVar.g(3, this.nfW);
                }
                if (this.nfX == null) {
                    return 0;
                }
                aVar.g(4, this.nfX);
                return 0;
            }
        } else if (i == 1) {
            if (this.nfU != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfU) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfV != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfV);
            }
            if (this.nfW != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfW);
            }
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfX);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfU == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.nfV == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.nfW == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.nfX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.nfU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    mVar.nfV = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mVar.nfW = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mVar.nfX = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
