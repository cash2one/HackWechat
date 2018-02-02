package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ab extends a {
    public String nfK;
    public ei ngv;
    public ae ngw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngv != null) {
                aVar.fW(1, this.ngv.bke());
                this.ngv.a(aVar);
            }
            if (this.ngw != null) {
                aVar.fW(2, this.ngw.bke());
                this.ngw.a(aVar);
            }
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(3, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.ngv != null) {
                r0 = e.a.a.a.fT(1, this.ngv.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngw != null) {
                r0 += e.a.a.a.fT(2, this.ngw.bke());
            }
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfK);
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
            ab abVar = (ab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a eiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        eiVar = new ei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eiVar.a(aVar4, eiVar, a.a(aVar4))) {
                        }
                        abVar.ngv = eiVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        eiVar = new ae();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eiVar.a(aVar4, eiVar, a.a(aVar4))) {
                        }
                        abVar.ngw = eiVar;
                    }
                    return 0;
                case 3:
                    abVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
