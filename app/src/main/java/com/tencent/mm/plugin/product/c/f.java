package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class f extends a {
    public j peN;
    public String peO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.peN != null) {
                aVar.fW(1, this.peN.bke());
                this.peN.a(aVar);
            }
            if (this.peO == null) {
                return 0;
            }
            aVar.g(2, this.peO);
            return 0;
        } else if (i == 1) {
            if (this.peN != null) {
                r0 = e.a.a.a.fT(1, this.peN.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.peO != null) {
                r0 += e.a.a.b.b.a.h(2, this.peO);
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
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a jVar = new j();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jVar.a(aVar4, jVar, a.a(aVar4))) {
                        }
                        fVar.peN = jVar;
                    }
                    return 0;
                case 2:
                    fVar.peO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
