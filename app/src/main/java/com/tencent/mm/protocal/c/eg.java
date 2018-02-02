package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class eg extends a {
    public eh vJD;
    public ee vJE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJD == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.vJE == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.vJD != null) {
                    aVar.fW(1, this.vJD.bke());
                    this.vJD.a(aVar);
                }
                if (this.vJE == null) {
                    return 0;
                }
                aVar.fW(2, this.vJE.bke());
                this.vJE.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vJD != null) {
                r0 = e.a.a.a.fT(1, this.vJD.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vJE != null) {
                r0 += e.a.a.a.fT(2, this.vJE.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vJD == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.vJE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            eg egVar = (eg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a ehVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        ehVar = new eh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ehVar.a(aVar4, ehVar, a.a(aVar4))) {
                        }
                        egVar.vJD = ehVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        ehVar = new ee();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ehVar.a(aVar4, ehVar, a.a(aVar4))) {
                        }
                        egVar.vJE = ehVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
