package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public class l extends a {
    public String peS;
    public int peT;
    public LinkedList<e> peU = new LinkedList();
    public int pem;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.peS == null) {
                throw new b("Not all required fields were included: id_info");
            }
            if (this.peS != null) {
                aVar.g(1, this.peS);
            }
            aVar.fU(2, this.peT);
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            aVar.d(4, 8, this.peU);
            aVar.fU(5, this.pem);
            return 0;
        } else if (i == 1) {
            if (this.peS != null) {
                r0 = e.a.a.b.b.a.h(1, this.peS) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.peT);
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(3, this.url);
            }
            return (r0 + e.a.a.a.c(4, 8, this.peU)) + e.a.a.a.fR(5, this.pem);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.peU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.peS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: id_info");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.peS = aVar3.Avy.readString();
                    return 0;
                case 2:
                    lVar.peT = aVar3.Avy.ry();
                    return 0;
                case 3:
                    lVar.url = aVar3.Avy.readString();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        lVar.peU.add(eVar);
                    }
                    return 0;
                case 5:
                    lVar.pem = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
