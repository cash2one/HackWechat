package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ie extends a {
    public String vOl;
    public int vOm;
    public String vOn;
    public int vOo;
    public LinkedList<he> vOp = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOl != null) {
                aVar.g(1, this.vOl);
            }
            aVar.fU(2, this.vOm);
            if (this.vOn != null) {
                aVar.g(3, this.vOn);
            }
            aVar.fU(4, this.vOo);
            aVar.d(5, 8, this.vOp);
            return 0;
        } else if (i == 1) {
            if (this.vOl != null) {
                r0 = e.a.a.b.b.a.h(1, this.vOl) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vOm);
            if (this.vOn != null) {
                r0 += e.a.a.b.b.a.h(3, this.vOn);
            }
            return (r0 + e.a.a.a.fR(4, this.vOo)) + e.a.a.a.c(5, 8, this.vOp);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vOp.clear();
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
            ie ieVar = (ie) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ieVar.vOl = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ieVar.vOm = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ieVar.vOn = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ieVar.vOo = aVar3.Avy.ry();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a heVar = new he();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = heVar.a(aVar4, heVar, a.a(aVar4))) {
                        }
                        ieVar.vOp.add(heVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
