package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class i extends a {
    public int vCd;
    public int vCr;
    public int vCt;
    public LinkedList<e> vCu = new LinkedList();
    public b vCv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vCd);
            aVar.fU(2, this.vCt);
            aVar.fU(3, this.vCr);
            aVar.d(4, 8, this.vCu);
            if (this.vCv != null) {
                aVar.b(5, this.vCv);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.a.fR(1, this.vCd) + 0) + e.a.a.a.fR(2, this.vCt)) + e.a.a.a.fR(3, this.vCr)) + e.a.a.a.c(4, 8, this.vCu);
            if (this.vCv != null) {
                return r0 + e.a.a.a.a(5, this.vCv);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vCu.clear();
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
                    iVar.vCd = aVar3.Avy.ry();
                    return 0;
                case 2:
                    iVar.vCt = aVar3.Avy.ry();
                    return 0;
                case 3:
                    iVar.vCr = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        iVar.vCu.add(eVar);
                    }
                    return 0;
                case 5:
                    iVar.vCv = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
