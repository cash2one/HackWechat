package com.tencent.mm.az;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> hJo = new LinkedList();
    public int hJp;
    public int hJq;
    public int hJr;
    public int hJs;
    public String hJt;
    public String hJu;
    public int hJv;
    public int hJw;
    public int hJx;
    public int maxSize;
    public String name;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.hJo);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            aVar.fU(3, this.hJp);
            aVar.fU(4, this.hJq);
            aVar.fU(5, this.hJr);
            aVar.fU(6, this.hJs);
            if (this.hJt != null) {
                aVar.g(7, this.hJt);
            }
            if (this.hJu != null) {
                aVar.g(8, this.hJu);
            }
            aVar.fU(9, this.hJv);
            aVar.fU(10, this.hJw);
            aVar.fU(11, this.hJx);
            aVar.fU(12, this.maxSize);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.hJo) + 0;
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            r0 = (((r0 + e.a.a.a.fR(3, this.hJp)) + e.a.a.a.fR(4, this.hJq)) + e.a.a.a.fR(5, this.hJr)) + e.a.a.a.fR(6, this.hJs);
            if (this.hJt != null) {
                r0 += e.a.a.b.b.a.h(7, this.hJt);
            }
            if (this.hJu != null) {
                r0 += e.a.a.b.b.a.h(8, this.hJu);
            }
            return (((r0 + e.a.a.a.fR(9, this.hJv)) + e.a.a.a.fR(10, this.hJw)) + e.a.a.a.fR(11, this.hJx)) + e.a.a.a.fR(12, this.maxSize);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hJo.clear();
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dVar.hJo.add(eVar);
                    }
                    return 0;
                case 2:
                    dVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dVar.hJp = aVar3.Avy.ry();
                    return 0;
                case 4:
                    dVar.hJq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    dVar.hJr = aVar3.Avy.ry();
                    return 0;
                case 6:
                    dVar.hJs = aVar3.Avy.ry();
                    return 0;
                case 7:
                    dVar.hJt = aVar3.Avy.readString();
                    return 0;
                case 8:
                    dVar.hJu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    dVar.hJv = aVar3.Avy.ry();
                    return 0;
                case 10:
                    dVar.hJw = aVar3.Avy.ry();
                    return 0;
                case 11:
                    dVar.hJx = aVar3.Avy.ry();
                    return 0;
                case 12:
                    dVar.maxSize = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
