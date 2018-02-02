package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cf extends a {
    public String nhF;
    public dp vHy;
    public LinkedList<aji> vHz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHy == null) {
                throw new b("Not all required fields were included: ArtisAuthor");
            }
            if (this.vHy != null) {
                aVar.fW(1, this.vHy.bke());
                this.vHy.a(aVar);
            }
            aVar.d(2, 8, this.vHz);
            if (this.nhF == null) {
                return 0;
            }
            aVar.g(3, this.nhF);
            return 0;
        } else if (i == 1) {
            if (this.vHy != null) {
                r0 = e.a.a.a.fT(1, this.vHy.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.vHz);
            if (this.nhF != null) {
                r0 += e.a.a.b.b.a.h(3, this.nhF);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vHz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vHy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisAuthor");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cf cfVar = (cf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a dpVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dpVar = new dp();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dpVar.a(aVar4, dpVar, a.a(aVar4))) {
                        }
                        cfVar.vHy = dpVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dpVar = new aji();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dpVar.a(aVar4, dpVar, a.a(aVar4))) {
                        }
                        cfVar.vHz.add(dpVar);
                    }
                    return 0;
                case 3:
                    cfVar.nhF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
