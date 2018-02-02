package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String content;
    public int poc;
    public String pod;
    public LinkedList<i> poe = new LinkedList();
    public LinkedList<i> pof = new LinkedList();
    public LinkedList<i> pog = new LinkedList();
    public LinkedList<y> poh = new LinkedList();
    public String poi;
    public int poj = 5;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.content == null) {
                throw new b("Not all required fields were included: content");
            }
            aVar.fU(1, this.poc);
            if (this.pod != null) {
                aVar.g(2, this.pod);
            }
            aVar.d(3, 8, this.poe);
            aVar.d(4, 8, this.pof);
            aVar.d(5, 8, this.pog);
            aVar.d(6, 8, this.poh);
            if (this.poi != null) {
                aVar.g(7, this.poi);
            }
            if (this.content != null) {
                aVar.g(8, this.content);
            }
            aVar.fU(9, this.poj);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.poc) + 0;
            if (this.pod != null) {
                r0 += e.a.a.b.b.a.h(2, this.pod);
            }
            r0 = (((r0 + e.a.a.a.c(3, 8, this.poe)) + e.a.a.a.c(4, 8, this.pof)) + e.a.a.a.c(5, 8, this.pog)) + e.a.a.a.c(6, 8, this.poh);
            if (this.poi != null) {
                r0 += e.a.a.b.b.a.h(7, this.poi);
            }
            if (this.content != null) {
                r0 += e.a.a.b.b.a.h(8, this.content);
            }
            return r0 + e.a.a.a.fR(9, this.poj);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.poe.clear();
            this.pof.clear();
            this.pog.clear();
            this.poh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.content != null) {
                return 0;
            }
            throw new b("Not all required fields were included: content");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a iVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dVar.poc = aVar3.Avy.ry();
                    return 0;
                case 2:
                    dVar.pod = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.poe.add(iVar);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.pof.add(iVar);
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.pog.add(iVar);
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        iVar = new y();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.poh.add(iVar);
                    }
                    return 0;
                case 7:
                    dVar.poi = aVar3.Avy.readString();
                    return 0;
                case 8:
                    dVar.content = aVar3.Avy.readString();
                    return 0;
                case 9:
                    dVar.poj = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
