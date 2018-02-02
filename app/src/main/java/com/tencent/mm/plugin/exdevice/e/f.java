package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class f extends i {
    public b lOt;
    public b lOu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lOH != null) {
                aVar.fW(1, this.lOH.bke());
                this.lOH.a(aVar);
            }
            if (this.lOt != null) {
                aVar.b(2, this.lOt);
            }
            if (this.lOu == null) {
                return 0;
            }
            aVar.b(3, this.lOu);
            return 0;
        } else if (i == 1) {
            if (this.lOH != null) {
                r0 = e.a.a.a.fT(1, this.lOH.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lOt != null) {
                r0 += e.a.a.a.a(2, this.lOt);
            }
            if (this.lOu != null) {
                r0 += e.a.a.a.a(3, this.lOu);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = i.a(aVar2); r0 > 0; r0 = i.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
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
                        fVar.lOH = dVar;
                    }
                    return 0;
                case 2:
                    fVar.lOt = aVar3.cJD();
                    return 0;
                case 3:
                    fVar.lOu = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
