package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.fe;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class dy extends bdf {
    public String fon;
    public String nfU;
    public boolean nfv;
    public m nkm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfU == null) {
                throw new b("Not all required fields were included: Message");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.al(2, this.nfv);
                if (this.fon != null) {
                    aVar.g(3, this.fon);
                }
                if (this.nfU != null) {
                    aVar.g(4, this.nfU);
                }
                if (this.nkm == null) {
                    return 0;
                }
                aVar.fW(5, this.nkm.bke());
                this.nkm.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.b.b.a.dX(2) + 1;
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.nfU != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfU);
            }
            if (this.nkm != null) {
                r0 += e.a.a.a.fT(5, this.nkm.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Message");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dy dyVar = (dy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        dyVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    dyVar.nfv = aVar3.cJC();
                    return 0;
                case 3:
                    dyVar.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dyVar.nfU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new m();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        dyVar.nkm = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
