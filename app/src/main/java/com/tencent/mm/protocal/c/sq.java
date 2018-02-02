package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class sq extends a {
    public sr wbe;
    public sp wbf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wbe == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.wbf == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.wbe != null) {
                    aVar.fW(1, this.wbe.bke());
                    this.wbe.a(aVar);
                }
                if (this.wbf == null) {
                    return 0;
                }
                aVar.fW(2, this.wbf.bke());
                this.wbf.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wbe != null) {
                r0 = e.a.a.a.fT(1, this.wbe.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wbf != null) {
                r0 += e.a.a.a.fT(2, this.wbf.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wbe == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.wbf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sq sqVar = (sq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a srVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        srVar = new sr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = srVar.a(aVar4, srVar, a.a(aVar4))) {
                        }
                        sqVar.wbe = srVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        srVar = new sp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = srVar.a(aVar4, srVar, a.a(aVar4))) {
                        }
                        sqVar.wbf = srVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
