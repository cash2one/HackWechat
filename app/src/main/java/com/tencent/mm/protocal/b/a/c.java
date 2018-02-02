package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uy;
import java.util.LinkedList;

public final class c extends a {
    public String desc;
    public LinkedList<uq> hdX = new LinkedList();
    public String title;
    public String vCT;
    public uy vCU;
    public long vCV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.d(3, 8, this.hdX);
            if (this.vCT != null) {
                aVar.g(4, this.vCT);
            }
            if (this.vCU != null) {
                aVar.fW(5, this.vCU.bke());
                this.vCU.a(aVar);
            }
            aVar.S(6, this.vCV);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(2, this.desc);
            }
            r0 += e.a.a.a.c(3, 8, this.hdX);
            if (this.vCT != null) {
                r0 += e.a.a.b.b.a.h(4, this.vCT);
            }
            if (this.vCU != null) {
                r0 += e.a.a.a.fT(5, this.vCU.bke());
            }
            return r0 + e.a.a.a.R(6, this.vCV);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hdX.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a uqVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cVar.desc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        uqVar = new uq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = uqVar.a(aVar4, uqVar, a.a(aVar4))) {
                        }
                        cVar.hdX.add(uqVar);
                    }
                    return 0;
                case 4:
                    cVar.vCT = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        uqVar = new uy();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = uqVar.a(aVar4, uqVar, a.a(aVar4))) {
                        }
                        cVar.vCU = uqVar;
                    }
                    return 0;
                case 6:
                    cVar.vCV = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
