package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class b extends a {
    public String fpb;
    public int id;
    public String title;
    public LinkedList<a> vCS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.id);
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.fpb != null) {
                aVar.g(3, this.fpb);
            }
            aVar.d(4, 8, this.vCS);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.id) + 0;
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(2, this.title);
            }
            if (this.fpb != null) {
                r0 += e.a.a.b.b.a.h(3, this.fpb);
            }
            return r0 + e.a.a.a.c(4, 8, this.vCS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vCS.clear();
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.id = aVar3.Avy.ry();
                    return 0;
                case 2:
                    bVar.title = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bVar.fpb = aVar3.Avy.readString();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a aVar4 = new a();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.vCS.add(aVar4);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
