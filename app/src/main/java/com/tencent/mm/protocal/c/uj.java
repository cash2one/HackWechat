package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class uj extends bcv {
    public String fFm;
    public long wck;
    public String wcl;
    public String wcp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.S(2, this.wck);
            if (this.wcp != null) {
                aVar.g(3, this.wcp);
            }
            if (this.fFm != null) {
                aVar.g(4, this.fFm);
            }
            if (this.wcl == null) {
                return 0;
            }
            aVar.g(5, this.wcl);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.R(2, this.wck);
            if (this.wcp != null) {
                r0 += e.a.a.b.b.a.h(3, this.wcp);
            }
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(4, this.fFm);
            }
            if (this.wcl != null) {
                r0 += e.a.a.b.b.a.h(5, this.wcl);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uj ujVar = (uj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ujVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    ujVar.wck = aVar3.Avy.rz();
                    return 0;
                case 3:
                    ujVar.wcp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ujVar.fFm = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ujVar.wcl = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
