package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ai extends a {
    public LinkedList<k> ngS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 8, this.ngS);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 8, this.ngS) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.ngS.clear();
                e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
                ai aiVar = (ai) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar2.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a kVar = new k();
                            e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = kVar.a(aVar3, kVar, a.a(aVar3))) {
                            }
                            aiVar.ngS.add(kVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
