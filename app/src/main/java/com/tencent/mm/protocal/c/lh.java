package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class lh extends a {
    public lg vUf;
    public lg vUg;
    public lg vUh;
    public lg vUi;
    public lg vUj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUf != null) {
                aVar.fW(1, this.vUf.bke());
                this.vUf.a(aVar);
            }
            if (this.vUg != null) {
                aVar.fW(2, this.vUg.bke());
                this.vUg.a(aVar);
            }
            if (this.vUh != null) {
                aVar.fW(3, this.vUh.bke());
                this.vUh.a(aVar);
            }
            if (this.vUi != null) {
                aVar.fW(4, this.vUi.bke());
                this.vUi.a(aVar);
            }
            if (this.vUj == null) {
                return 0;
            }
            aVar.fW(5, this.vUj.bke());
            this.vUj.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vUf != null) {
                r0 = e.a.a.a.fT(1, this.vUf.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vUg != null) {
                r0 += e.a.a.a.fT(2, this.vUg.bke());
            }
            if (this.vUh != null) {
                r0 += e.a.a.a.fT(3, this.vUh.bke());
            }
            if (this.vUi != null) {
                r0 += e.a.a.a.fT(4, this.vUi.bke());
            }
            if (this.vUj != null) {
                r0 += e.a.a.a.fT(5, this.vUj.bke());
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
            lh lhVar = (lh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a lgVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        lgVar = new lg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lgVar.a(aVar4, lgVar, a.a(aVar4))) {
                        }
                        lhVar.vUf = lgVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        lgVar = new lg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lgVar.a(aVar4, lgVar, a.a(aVar4))) {
                        }
                        lhVar.vUg = lgVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        lgVar = new lg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lgVar.a(aVar4, lgVar, a.a(aVar4))) {
                        }
                        lhVar.vUh = lgVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        lgVar = new lg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lgVar.a(aVar4, lgVar, a.a(aVar4))) {
                        }
                        lhVar.vUi = lgVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        lgVar = new lg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lgVar.a(aVar4, lgVar, a.a(aVar4))) {
                        }
                        lhVar.vUj = lgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
