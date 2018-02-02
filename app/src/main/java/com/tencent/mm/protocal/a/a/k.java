package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class k extends a {
    public int vCx;
    public LinkedList<l> vCy = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vCx);
            aVar.d(2, 8, this.vCy);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fR(1, this.vCx) + 0) + e.a.a.a.c(2, 8, this.vCy);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vCy.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                k kVar = (k) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        kVar.vCx = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a lVar = new l();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = lVar.a(aVar4, lVar, a.a(aVar4))) {
                            }
                            kVar.vCy.add(lVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
