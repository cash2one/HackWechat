package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bee extends bcv {
    public String fFm;
    public String state;
    public int wBG;
    public LinkedList<String> wBH = new LinkedList();
    public String wJS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(3, this.wBG);
            aVar.d(4, 1, this.wBH);
            if (this.fFm != null) {
                aVar.g(5, this.fFm);
            }
            if (this.state != null) {
                aVar.g(6, this.state);
            }
            if (this.wJS == null) {
                return 0;
            }
            aVar.g(7, this.wJS);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(3, this.wBG)) + e.a.a.a.c(4, 1, this.wBH);
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(5, this.fFm);
            }
            if (this.state != null) {
                r0 += e.a.a.b.b.a.h(6, this.state);
            }
            if (this.wJS != null) {
                r0 += e.a.a.b.b.a.h(7, this.wJS);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wBH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bee com_tencent_mm_protocal_c_bee = (bee) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bee.wIV = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bee.wBG = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bee.wBH.add(aVar3.Avy.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bee.fFm = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bee.state = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bee.wJS = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
