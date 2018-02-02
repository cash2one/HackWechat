package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class n extends a {
    public String ID;
    public long kte;
    public long ktf;
    public long ktg;
    public m kth;
    public long kti;
    public int ktj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.S(2, this.kte);
            aVar.S(3, this.ktf);
            aVar.S(4, this.ktg);
            if (this.kth != null) {
                aVar.fW(5, this.kth.bke());
                this.kth.a(aVar);
            }
            aVar.S(6, this.kti);
            aVar.fU(7, this.ktj);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.R(2, this.kte)) + e.a.a.a.R(3, this.ktf)) + e.a.a.a.R(4, this.ktg);
            if (this.kth != null) {
                r0 += e.a.a.a.fT(5, this.kth.bke());
            }
            return (r0 + e.a.a.a.R(6, this.kti)) + e.a.a.a.fR(7, this.ktj);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nVar.ID = aVar3.Avy.readString();
                    return 0;
                case 2:
                    nVar.kte = aVar3.Avy.rz();
                    return 0;
                case 3:
                    nVar.ktf = aVar3.Avy.rz();
                    return 0;
                case 4:
                    nVar.ktg = aVar3.Avy.rz();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        nVar.kth = mVar;
                    }
                    return 0;
                case 6:
                    nVar.kti = aVar3.Avy.rz();
                    return 0;
                case 7:
                    nVar.ktj = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
