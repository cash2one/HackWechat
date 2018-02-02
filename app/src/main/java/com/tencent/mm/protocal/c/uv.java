package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class uv extends a {
    public String appId;
    public String desc;
    public ve fEH;
    public String fnl;
    public String fzO;
    public String title;
    public int type;
    public String weE;
    public LinkedList<String> weF = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.fzO != null) {
                aVar.g(3, this.fzO);
            }
            if (this.weE != null) {
                aVar.g(4, this.weE);
            }
            if (this.appId != null) {
                aVar.g(5, this.appId);
            }
            if (this.fnl != null) {
                aVar.g(6, this.fnl);
            }
            aVar.d(7, 1, this.weF);
            aVar.fU(8, this.type);
            if (this.fEH == null) {
                return 0;
            }
            aVar.fW(9, this.fEH.bke());
            this.fEH.a(aVar);
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
            if (this.fzO != null) {
                r0 += e.a.a.b.b.a.h(3, this.fzO);
            }
            if (this.weE != null) {
                r0 += e.a.a.b.b.a.h(4, this.weE);
            }
            if (this.appId != null) {
                r0 += e.a.a.b.b.a.h(5, this.appId);
            }
            if (this.fnl != null) {
                r0 += e.a.a.b.b.a.h(6, this.fnl);
            }
            r0 = (r0 + e.a.a.a.c(7, 1, this.weF)) + e.a.a.a.fR(8, this.type);
            if (this.fEH != null) {
                r0 += e.a.a.a.fT(9, this.fEH.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.weF.clear();
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
            uv uvVar = (uv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    uvVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    uvVar.desc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    uvVar.fzO = aVar3.Avy.readString();
                    return 0;
                case 4:
                    uvVar.weE = aVar3.Avy.readString();
                    return 0;
                case 5:
                    uvVar.appId = aVar3.Avy.readString();
                    return 0;
                case 6:
                    uvVar.fnl = aVar3.Avy.readString();
                    return 0;
                case 7:
                    uvVar.weF.add(aVar3.Avy.readString());
                    return 0;
                case 8:
                    uvVar.type = aVar3.Avy.ry();
                    return 0;
                case 9:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a veVar = new ve();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = veVar.a(aVar4, veVar, a.a(aVar4))) {
                        }
                        uvVar.fEH = veVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
