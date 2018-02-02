package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class io extends a {
    public LinkedList<vv> vON = new LinkedList();
    public LinkedList<vu> vOO = new LinkedList();
    public String vOP;
    public String vOQ;
    public String vOR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vON);
            aVar.d(2, 8, this.vOO);
            if (this.vOP != null) {
                aVar.g(3, this.vOP);
            }
            if (this.vOQ != null) {
                aVar.g(4, this.vOQ);
            }
            if (this.vOR != null) {
                aVar.g(5, this.vOR);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.c(1, 8, this.vON) + 0) + e.a.a.a.c(2, 8, this.vOO);
            if (this.vOP != null) {
                r0 += e.a.a.b.b.a.h(3, this.vOP);
            }
            if (this.vOQ != null) {
                r0 += e.a.a.b.b.a.h(4, this.vOQ);
            }
            if (this.vOR != null) {
                return r0 + e.a.a.b.b.a.h(5, this.vOR);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vON.clear();
            this.vOO.clear();
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
            io ioVar = (io) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a vvVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vvVar = new vv();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vvVar.a(aVar4, vvVar, a.a(aVar4))) {
                        }
                        ioVar.vON.add(vvVar);
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vvVar = new vu();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vvVar.a(aVar4, vvVar, a.a(aVar4))) {
                        }
                        ioVar.vOO.add(vvVar);
                    }
                    return 0;
                case 3:
                    ioVar.vOP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ioVar.vOQ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ioVar.vOR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
