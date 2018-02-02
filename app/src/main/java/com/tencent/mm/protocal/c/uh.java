package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class uh extends bcv {
    public String fFm;
    public String wcf;
    public long wck;
    public String wcl;
    public String wcm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.fFm != null) {
                aVar.g(2, this.fFm);
            }
            aVar.S(3, this.wck);
            if (this.wcf != null) {
                aVar.g(4, this.wcf);
            }
            if (this.wcl != null) {
                aVar.g(5, this.wcl);
            }
            if (this.wcm == null) {
                return 0;
            }
            aVar.g(6, this.wcm);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(2, this.fFm);
            }
            r0 += e.a.a.a.R(3, this.wck);
            if (this.wcf != null) {
                r0 += e.a.a.b.b.a.h(4, this.wcf);
            }
            if (this.wcl != null) {
                r0 += e.a.a.b.b.a.h(5, this.wcl);
            }
            if (this.wcm != null) {
                r0 += e.a.a.b.b.a.h(6, this.wcm);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uh uhVar = (uh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        uhVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    uhVar.fFm = aVar3.Avy.readString();
                    return 0;
                case 3:
                    uhVar.wck = aVar3.Avy.rz();
                    return 0;
                case 4:
                    uhVar.wcf = aVar3.Avy.readString();
                    return 0;
                case 5:
                    uhVar.wcl = aVar3.Avy.readString();
                    return 0;
                case 6:
                    uhVar.wcm = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
