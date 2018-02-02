package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class sd extends a {
    public so waf;
    public se wag;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.waf == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.wag == null) {
                throw new b("Not all required fields were included: BannerImg");
            } else {
                if (this.waf != null) {
                    aVar.fW(1, this.waf.bke());
                    this.waf.a(aVar);
                }
                if (this.wag == null) {
                    return 0;
                }
                aVar.fW(2, this.wag.bke());
                this.wag.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.waf != null) {
                r0 = e.a.a.a.fT(1, this.waf.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wag != null) {
                r0 += e.a.a.a.fT(2, this.wag.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.waf == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.wag != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BannerImg");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sd sdVar = (sd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a soVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        soVar = new so();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = soVar.a(aVar4, soVar, a.a(aVar4))) {
                        }
                        sdVar.waf = soVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        soVar = new se();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = soVar.a(aVar4, soVar, a.a(aVar4))) {
                        }
                        sdVar.wag = soVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
