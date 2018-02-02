package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dm extends a {
    public String fon;
    public String niR;
    public String niS;
    public LinkedList<dn> njS = new LinkedList();
    public String njT;
    public String njU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            aVar.d(2, 8, this.njS);
            if (this.niR != null) {
                aVar.g(3, this.niR);
            }
            if (this.niS != null) {
                aVar.g(4, this.niS);
            }
            if (this.njT != null) {
                aVar.g(5, this.njT);
            }
            if (this.njU == null) {
                return 0;
            }
            aVar.g(6, this.njU);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.njS);
            if (this.niR != null) {
                r0 += e.a.a.b.b.a.h(3, this.niR);
            }
            if (this.niS != null) {
                r0 += e.a.a.b.b.a.h(4, this.niS);
            }
            if (this.njT != null) {
                r0 += e.a.a.b.b.a.h(5, this.njT);
            }
            if (this.njU != null) {
                r0 += e.a.a.b.b.a.h(6, this.njU);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.njS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dm dmVar = (dm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dmVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a dnVar = new dn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = dnVar.a(aVar4, dnVar, a.a(aVar4))) {
                        }
                        dmVar.njS.add(dnVar);
                    }
                    return 0;
                case 3:
                    dmVar.niR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dmVar.niS = aVar3.Avy.readString();
                    return 0;
                case 5:
                    dmVar.njT = aVar3.Avy.readString();
                    return 0;
                case 6:
                    dmVar.njU = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
