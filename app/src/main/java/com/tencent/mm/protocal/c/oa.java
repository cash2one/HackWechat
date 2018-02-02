package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class oa extends a {
    public int vWL;
    public int vWM;
    public int vWN;
    public LinkedList<nz> vWO = new LinkedList();
    public b vWP;
    public akc vWQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vWL);
            aVar.fU(2, this.vWM);
            aVar.fU(3, this.vWN);
            aVar.d(4, 8, this.vWO);
            if (this.vWP != null) {
                aVar.b(5, this.vWP);
            }
            if (this.vWQ != null) {
                aVar.fW(6, this.vWQ.bke());
                this.vWQ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.a.fR(1, this.vWL) + 0) + e.a.a.a.fR(2, this.vWM)) + e.a.a.a.fR(3, this.vWN)) + e.a.a.a.c(4, 8, this.vWO);
            if (this.vWP != null) {
                r0 += e.a.a.a.a(5, this.vWP);
            }
            if (this.vWQ != null) {
                return r0 + e.a.a.a.fT(6, this.vWQ.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vWO.clear();
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
            oa oaVar = (oa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a nzVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    oaVar.vWL = aVar3.Avy.ry();
                    return 0;
                case 2:
                    oaVar.vWM = aVar3.Avy.ry();
                    return 0;
                case 3:
                    oaVar.vWN = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        nzVar = new nz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nzVar.a(aVar4, nzVar, a.a(aVar4))) {
                        }
                        oaVar.vWO.add(nzVar);
                    }
                    return 0;
                case 5:
                    oaVar.vWP = aVar3.cJD();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        nzVar = new akc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nzVar.a(aVar4, nzVar, a.a(aVar4))) {
                        }
                        oaVar.vWQ = nzVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
