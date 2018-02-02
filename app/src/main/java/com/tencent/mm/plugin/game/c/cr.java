package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cr extends a {
    public e nfh;
    public String njr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfh == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.njr == null) {
                throw new b("Not all required fields were included: Rank");
            } else {
                if (this.nfh != null) {
                    aVar.fW(1, this.nfh.bke());
                    this.nfh.a(aVar);
                }
                if (this.njr == null) {
                    return 0;
                }
                aVar.g(2, this.njr);
                return 0;
            }
        } else if (i == 1) {
            if (this.nfh != null) {
                r0 = e.a.a.a.fT(1, this.nfh.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.njr != null) {
                r0 += e.a.a.b.b.a.h(2, this.njr);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfh == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.njr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Rank");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cr crVar = (cr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        crVar.nfh = eVar;
                    }
                    return 0;
                case 2:
                    crVar.njr = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
