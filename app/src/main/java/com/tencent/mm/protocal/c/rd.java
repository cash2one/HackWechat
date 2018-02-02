package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class rd extends a {
    public int vZf;
    public re vZg;
    public int vZh;
    public re vZi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZg == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.vZi == null) {
                throw new b("Not all required fields were included: AllDayTime");
            } else {
                aVar.fU(1, this.vZf);
                if (this.vZg != null) {
                    aVar.fW(2, this.vZg.bke());
                    this.vZg.a(aVar);
                }
                aVar.fU(3, this.vZh);
                if (this.vZi != null) {
                    aVar.fW(4, this.vZi.bke());
                    this.vZi.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vZf) + 0;
            if (this.vZg != null) {
                r0 += e.a.a.a.fT(2, this.vZg.bke());
            }
            r0 += e.a.a.a.fR(3, this.vZh);
            if (this.vZi != null) {
                return r0 + e.a.a.a.fT(4, this.vZi.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vZg == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.vZi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AllDayTime");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rd rdVar = (rd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a reVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rdVar.vZf = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        reVar = new re();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = reVar.a(aVar4, reVar, a.a(aVar4))) {
                        }
                        rdVar.vZg = reVar;
                    }
                    return 0;
                case 3:
                    rdVar.vZh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        reVar = new re();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = reVar.a(aVar4, reVar, a.a(aVar4))) {
                        }
                        rdVar.vZi = reVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
