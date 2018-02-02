package com.tencent.mm.y;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public class j extends a {
    public String fGA;
    public String fGz;
    public String gjD;
    public LinkedList<m> hdX = new LinkedList();
    public int hdY;
    public String name;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.type);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.fGz != null) {
                aVar.g(3, this.fGz);
            }
            if (this.fGA != null) {
                aVar.g(4, this.fGA);
            }
            if (this.gjD != null) {
                aVar.g(5, this.gjD);
            }
            aVar.d(6, 8, this.hdX);
            aVar.fU(7, this.hdY);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.type) + 0;
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.fGz != null) {
                r0 += e.a.a.b.b.a.h(3, this.fGz);
            }
            if (this.fGA != null) {
                r0 += e.a.a.b.b.a.h(4, this.fGA);
            }
            if (this.gjD != null) {
                r0 += e.a.a.b.b.a.h(5, this.gjD);
            }
            return (r0 + e.a.a.a.c(6, 8, this.hdX)) + e.a.a.a.fR(7, this.hdY);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.type = aVar3.Avy.ry();
                    return 0;
                case 2:
                    jVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    jVar.fGz = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jVar.fGA = aVar3.Avy.readString();
                    return 0;
                case 5:
                    jVar.gjD = aVar3.Avy.readString();
                    return 0;
                case 6:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        jVar.hdX.add(mVar);
                    }
                    return 0;
                case 7:
                    jVar.hdY = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
