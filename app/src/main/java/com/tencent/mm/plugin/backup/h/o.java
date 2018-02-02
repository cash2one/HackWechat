package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class o extends a {
    public String ID;
    public long kte;
    public m kth;
    public int ktj;
    public long ktk;
    public long ktl;
    public int ktm;
    public int ktn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.S(2, this.ktk);
            aVar.S(3, this.ktl);
            aVar.fU(4, this.ktm);
            aVar.fU(5, this.ktn);
            aVar.S(6, this.kte);
            if (this.kth != null) {
                aVar.fW(7, this.kth.bke());
                this.kth.a(aVar);
            }
            aVar.fU(8, this.ktj);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.R(2, this.ktk)) + e.a.a.a.R(3, this.ktl)) + e.a.a.a.fR(4, this.ktm)) + e.a.a.a.fR(5, this.ktn)) + e.a.a.a.R(6, this.kte);
            if (this.kth != null) {
                r0 += e.a.a.a.fT(7, this.kth.bke());
            }
            return r0 + e.a.a.a.fR(8, this.ktj);
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
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oVar.ID = aVar3.Avy.readString();
                    return 0;
                case 2:
                    oVar.ktk = aVar3.Avy.rz();
                    return 0;
                case 3:
                    oVar.ktl = aVar3.Avy.rz();
                    return 0;
                case 4:
                    oVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 5:
                    oVar.ktn = aVar3.Avy.ry();
                    return 0;
                case 6:
                    oVar.kte = aVar3.Avy.rz();
                    return 0;
                case 7:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        oVar.kth = mVar;
                    }
                    return 0;
                case 8:
                    oVar.ktj = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
