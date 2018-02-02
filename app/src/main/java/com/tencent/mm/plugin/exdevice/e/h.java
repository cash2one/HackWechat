package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class h extends a {
    public b ksB;
    public int ktN;
    public c lOG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.lOG == null) {
                throw new e.a.a.b("Not all required fields were included: BasePush");
            } else if (this.ksB == null) {
                throw new e.a.a.b("Not all required fields were included: Data");
            } else {
                if (this.lOG != null) {
                    aVar.fW(1, this.lOG.bke());
                    this.lOG.a(aVar);
                }
                if (this.ksB != null) {
                    aVar.b(2, this.ksB);
                }
                aVar.fU(3, this.ktN);
                return 0;
            }
        } else if (i == 1) {
            if (this.lOG != null) {
                r0 = e.a.a.a.fT(1, this.lOG.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksB != null) {
                r0 += e.a.a.a.a(2, this.ksB);
            }
            return r0 + e.a.a.a.fR(3, this.ktN);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.lOG == null) {
                throw new e.a.a.b("Not all required fields were included: BasePush");
            } else if (this.ksB != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a cVar = new c();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        hVar.lOG = cVar;
                    }
                    return 0;
                case 2:
                    hVar.ksB = aVar3.cJD();
                    return 0;
                case 3:
                    hVar.ktN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
