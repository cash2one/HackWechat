package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class j extends a {
    public int fDt;
    public g peQ;
    public String peR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.fDt);
            if (this.peQ != null) {
                aVar.fW(2, this.peQ.bke());
                this.peQ.a(aVar);
            }
            if (this.peR != null) {
                aVar.g(3, this.peR);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.fDt) + 0;
            if (this.peQ != null) {
                r0 += e.a.a.a.fT(2, this.peQ.bke());
            }
            if (this.peR != null) {
                return r0 + e.a.a.b.b.a.h(3, this.peR);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.fDt = aVar3.Avy.ry();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a gVar = new g();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        jVar.peQ = gVar;
                    }
                    return 0;
                case 3:
                    jVar.peR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
