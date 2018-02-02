package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class k extends a {
    public String nfK;
    public String nfO;
    public int nfP;
    public a nfQ;
    public du nfR;
    public int nfS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfO != null) {
                aVar.g(1, this.nfO);
            }
            aVar.fU(2, this.nfP);
            if (this.nfQ != null) {
                aVar.fW(3, this.nfQ.bke());
                this.nfQ.a(aVar);
            }
            if (this.nfR != null) {
                aVar.fW(4, this.nfR.bke());
                this.nfR.a(aVar);
            }
            aVar.fU(5, this.nfS);
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(6, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.nfO != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfO) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.nfP);
            if (this.nfQ != null) {
                r0 += e.a.a.a.fT(3, this.nfQ.bke());
            }
            if (this.nfR != null) {
                r0 += e.a.a.a.fT(4, this.nfR.bke());
            }
            r0 += e.a.a.a.fR(5, this.nfS);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfK);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a aVar4;
            e.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 1:
                    kVar.nfO = aVar3.Avy.readString();
                    return 0;
                case 2:
                    kVar.nfP = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        aVar4 = new a();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        kVar.nfQ = aVar4;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        aVar4 = new du();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        kVar.nfR = aVar4;
                    }
                    return 0;
                case 5:
                    kVar.nfS = aVar3.Avy.ry();
                    return 0;
                case 6:
                    kVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
