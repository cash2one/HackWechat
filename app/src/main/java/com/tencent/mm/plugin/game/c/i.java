package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class i extends a {
    public String fon;
    public String nfK;
    public String nfL;
    public LinkedList<w> nfM = new LinkedList();
    public String nfe;
    public String nff;
    public String nfg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(2, this.nfe);
            }
            if (this.nff != null) {
                aVar.g(3, this.nff);
            }
            if (this.nfg != null) {
                aVar.g(4, this.nfg);
            }
            if (this.nfK != null) {
                aVar.g(5, this.nfK);
            }
            if (this.nfL != null) {
                aVar.g(6, this.nfL);
            }
            aVar.d(7, 8, this.nfM);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(3, this.nff);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfg);
            }
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfK);
            }
            if (this.nfL != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfL);
            }
            return r0 + e.a.a.a.c(7, 8, this.nfM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nfM.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    iVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    iVar.nff = aVar3.Avy.readString();
                    return 0;
                case 4:
                    iVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 5:
                    iVar.nfK = aVar3.Avy.readString();
                    return 0;
                case 6:
                    iVar.nfL = aVar3.Avy.readString();
                    return 0;
                case 7:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a wVar = new w();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = wVar.a(aVar4, wVar, a.a(aVar4))) {
                        }
                        iVar.nfM.add(wVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
