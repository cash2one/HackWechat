package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class cp extends a {
    public ea njm;
    public df njn;
    public v njo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.njm != null) {
                aVar.fW(1, this.njm.bke());
                this.njm.a(aVar);
            }
            if (this.njn != null) {
                aVar.fW(2, this.njn.bke());
                this.njn.a(aVar);
            }
            if (this.njo == null) {
                return 0;
            }
            aVar.fW(3, this.njo.bke());
            this.njo.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.njm != null) {
                r0 = e.a.a.a.fT(1, this.njm.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.njn != null) {
                r0 += e.a.a.a.fT(2, this.njn.bke());
            }
            if (this.njo != null) {
                r0 += e.a.a.a.fT(3, this.njo.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            cp cpVar = (cp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a eaVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        eaVar = new ea();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eaVar.a(aVar4, eaVar, a.a(aVar4))) {
                        }
                        cpVar.njm = eaVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        eaVar = new df();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eaVar.a(aVar4, eaVar, a.a(aVar4))) {
                        }
                        cpVar.njn = eaVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        eaVar = new v();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eaVar.a(aVar4, eaVar, a.a(aVar4))) {
                        }
                        cpVar.njo = eaVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
