package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class dk extends a {
    public String fon;
    public LinkedList<z> nfM = new LinkedList();
    public String nfe;
    public String nff;
    public e nfh;
    public String ngo;
    public String ngu;
    public String nhE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            if (this.nff != null) {
                aVar.g(3, this.nff);
            }
            if (this.nfe != null) {
                aVar.g(4, this.nfe);
            }
            if (this.nhE != null) {
                aVar.g(5, this.nhE);
            }
            if (this.nfh != null) {
                aVar.fW(6, this.nfh.bke());
                this.nfh.a(aVar);
            }
            aVar.d(7, 8, this.nfM);
            if (this.ngu == null) {
                return 0;
            }
            aVar.g(8, this.ngu);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(3, this.nff);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfe);
            }
            if (this.nhE != null) {
                r0 += e.a.a.b.b.a.h(5, this.nhE);
            }
            if (this.nfh != null) {
                r0 += e.a.a.a.fT(6, this.nfh.bke());
            }
            r0 += e.a.a.a.c(7, 8, this.nfM);
            if (this.ngu != null) {
                r0 += e.a.a.b.b.a.h(8, this.ngu);
            }
            return r0;
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
            dk dkVar = (dk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a eVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dkVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dkVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dkVar.nff = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dkVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    dkVar.nhE = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dkVar.nfh = eVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        eVar = new z();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dkVar.nfM.add(eVar);
                    }
                    return 0;
                case 8:
                    dkVar.ngu = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
