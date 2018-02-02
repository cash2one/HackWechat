package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ca extends a {
    public String desc;
    public LinkedList<ci> kNr = new LinkedList();
    public String niP;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.niP != null) {
                aVar.g(1, this.niP);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.d(3, 8, this.kNr);
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            if (this.title == null) {
                return 0;
            }
            aVar.g(5, this.title);
            return 0;
        } else if (i == 1) {
            if (this.niP != null) {
                r0 = e.a.a.b.b.a.h(1, this.niP) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(2, this.desc);
            }
            r0 += e.a.a.a.c(3, 8, this.kNr);
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(4, this.url);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(5, this.title);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.kNr.clear();
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
            ca caVar = (ca) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    caVar.niP = aVar3.Avy.readString();
                    return 0;
                case 2:
                    caVar.desc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a ciVar = new ci();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = ciVar.a(aVar4, ciVar, a.a(aVar4))) {
                        }
                        caVar.kNr.add(ciVar);
                    }
                    return 0;
                case 4:
                    caVar.url = aVar3.Avy.readString();
                    return 0;
                case 5:
                    caVar.title = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
