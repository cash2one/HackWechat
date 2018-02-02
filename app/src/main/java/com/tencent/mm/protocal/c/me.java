package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class me extends a {
    public int kZx;
    public LinkedList<mf> vUQ = new LinkedList();
    public int vUR;
    public bdo vUS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.kZx);
            aVar.d(2, 8, this.vUQ);
            aVar.fU(3, this.vUR);
            if (this.vUS != null) {
                aVar.fW(4, this.vUS.bke());
                this.vUS.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.kZx) + 0) + e.a.a.a.c(2, 8, this.vUQ)) + e.a.a.a.fR(3, this.vUR);
            if (this.vUS != null) {
                return r0 + e.a.a.a.fT(4, this.vUS.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vUQ.clear();
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
            me meVar = (me) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a mfVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    meVar.kZx = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        mfVar = new mf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = mfVar.a(aVar4, mfVar, a.a(aVar4))) {
                        }
                        meVar.vUQ.add(mfVar);
                    }
                    return 0;
                case 3:
                    meVar.vUR = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        mfVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = mfVar.a(aVar4, mfVar, a.a(aVar4))) {
                        }
                        meVar.vUS = mfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
