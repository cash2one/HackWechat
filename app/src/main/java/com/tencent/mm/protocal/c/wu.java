package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class wu extends a {
    public wn whk;
    public LinkedList<String> whl = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whk == null) {
                throw new b("Not all required fields were included: GameItem");
            }
            if (this.whk != null) {
                aVar.fW(1, this.whk.bke());
                this.whk.a(aVar);
            }
            aVar.d(2, 1, this.whl);
            return 0;
        } else if (i == 1) {
            if (this.whk != null) {
                r0 = e.a.a.a.fT(1, this.whk.bke()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 1, this.whl);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.whl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.whk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GameItem");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wu wuVar = (wu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a wnVar = new wn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = wnVar.a(aVar4, wnVar, a.a(aVar4))) {
                        }
                        wuVar.whk = wnVar;
                    }
                    return 0;
                case 2:
                    wuVar.whl.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
