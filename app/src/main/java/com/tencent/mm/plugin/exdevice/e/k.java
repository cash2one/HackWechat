package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class k extends i {
    public b ksB;
    public int ktN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ksB == null) {
                throw new e.a.a.b("Not all required fields were included: Data");
            }
            if (this.lOH != null) {
                aVar.fW(1, this.lOH.bke());
                this.lOH.a(aVar);
            }
            if (this.ksB != null) {
                aVar.b(2, this.ksB);
            }
            aVar.fU(3, this.ktN);
            return 0;
        } else if (i == 1) {
            if (this.lOH != null) {
                r0 = e.a.a.a.fT(1, this.lOH.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksB != null) {
                r0 += e.a.a.a.a(2, this.ksB);
            }
            return r0 + e.a.a.a.fR(3, this.ktN);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = i.a(aVar2); r0 > 0; r0 = i.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksB != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, i.a(aVar4))) {
                        }
                        kVar.lOH = dVar;
                    }
                    return 0;
                case 2:
                    kVar.ksB = aVar3.cJD();
                    return 0;
                case 3:
                    kVar.ktN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
