package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class vi extends a {
    public int nhx;
    public String weY;
    public LinkedList<vc> weZ = new LinkedList();
    public vc wfa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.nhx);
            if (this.weY != null) {
                aVar.g(2, this.weY);
            }
            aVar.d(3, 8, this.weZ);
            if (this.wfa != null) {
                aVar.fW(4, this.wfa.bke());
                this.wfa.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.nhx) + 0;
            if (this.weY != null) {
                r0 += e.a.a.b.b.a.h(2, this.weY);
            }
            r0 += e.a.a.a.c(3, 8, this.weZ);
            if (this.wfa != null) {
                return r0 + e.a.a.a.fT(4, this.wfa.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.weZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            vi viVar = (vi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a vcVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    viVar.nhx = aVar3.Avy.ry();
                    return 0;
                case 2:
                    viVar.weY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vcVar = new vc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vcVar.a(aVar4, vcVar, a.a(aVar4))) {
                        }
                        viVar.weZ.add(vcVar);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vcVar = new vc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vcVar.a(aVar4, vcVar, a.a(aVar4))) {
                        }
                        viVar.wfa = vcVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
