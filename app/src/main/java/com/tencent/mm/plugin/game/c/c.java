package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class c extends a {
    public int ktN;
    public e nfh;
    public b nfk;
    public String nfl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ktN);
            if (this.nfh != null) {
                aVar.fW(2, this.nfh.bke());
                this.nfh.a(aVar);
            }
            if (this.nfk != null) {
                aVar.fW(3, this.nfk.bke());
                this.nfk.a(aVar);
            }
            if (this.nfl != null) {
                aVar.g(4, this.nfl);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktN) + 0;
            if (this.nfh != null) {
                r0 += e.a.a.a.fT(2, this.nfh.bke());
            }
            if (this.nfk != null) {
                r0 += e.a.a.a.fT(3, this.nfk.bke());
            }
            if (this.nfl != null) {
                return r0 + e.a.a.b.b.a.h(4, this.nfl);
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a eVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        cVar.nfh = eVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        eVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        cVar.nfk = eVar;
                    }
                    return 0;
                case 4:
                    cVar.nfl = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
