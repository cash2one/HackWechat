package com.tencent.mm.plugin.exdevice.e;

import e.a.a.c.a;
import java.util.LinkedList;

public final class b extends j {
    public com.tencent.mm.bq.b lOp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lOI == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            } else if (this.lOp == null) {
                throw new e.a.a.b("Not all required fields were included: AesSessionKey");
            } else {
                if (this.lOI != null) {
                    aVar.fW(1, this.lOI.bke());
                    this.lOI.a(aVar);
                }
                if (this.lOp == null) {
                    return 0;
                }
                aVar.b(2, this.lOp);
                return 0;
            }
        } else if (i == 1) {
            if (this.lOI != null) {
                r0 = e.a.a.a.fT(1, this.lOI.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lOp != null) {
                r0 += e.a.a.a.a(2, this.lOp);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = j.a(aVar2); r0 > 0; r0 = j.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.lOI == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            } else if (this.lOp != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: AesSessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, j.a(aVar4))) {
                        }
                        bVar.lOI = eVar;
                    }
                    return 0;
                case 2:
                    bVar.lOp = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
