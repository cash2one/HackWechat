package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ph extends bdf {
    public String sIT;
    public LinkedList<kf> vYo = new LinkedList();
    public int vYp;
    public int vYq;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.d(2, 8, this.vYo);
            aVar.fU(3, this.version);
            aVar.fU(4, this.vYp);
            aVar.fU(5, this.vYq);
            if (this.sIT == null) {
                return 0;
            }
            aVar.g(6, this.sIT);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + e.a.a.a.c(2, 8, this.vYo)) + e.a.a.a.fR(3, this.version)) + e.a.a.a.fR(4, this.vYp)) + e.a.a.a.fR(5, this.vYq);
            if (this.sIT != null) {
                r0 += e.a.a.b.b.a.h(6, this.sIT);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vYo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ph phVar = (ph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        phVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new kf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        phVar.vYo.add(feVar);
                    }
                    return 0;
                case 3:
                    phVar.version = aVar3.Avy.ry();
                    return 0;
                case 4:
                    phVar.vYp = aVar3.Avy.ry();
                    return 0;
                case 5:
                    phVar.vYq = aVar3.Avy.ry();
                    return 0;
                case 6:
                    phVar.sIT = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
