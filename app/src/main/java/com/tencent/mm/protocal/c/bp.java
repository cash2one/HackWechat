package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bp extends bcv {
    public String nfX;
    public String nkv;
    public int vDY;
    public String vDZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.nkv != null) {
                aVar.g(2, this.nkv);
            }
            if (this.nfX != null) {
                aVar.g(3, this.nfX);
            }
            aVar.fU(4, this.vDY);
            if (this.vDZ == null) {
                return 0;
            }
            aVar.g(5, this.vDZ);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nkv != null) {
                r0 += e.a.a.b.b.a.h(2, this.nkv);
            }
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfX);
            }
            r0 += e.a.a.a.fR(4, this.vDY);
            if (this.vDZ != null) {
                r0 += e.a.a.b.b.a.h(5, this.vDZ);
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
            bp bpVar = (bp) objArr[1];
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
                        bpVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    bpVar.nkv = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bpVar.nfX = aVar3.Avy.readString();
                    return 0;
                case 4:
                    bpVar.vDY = aVar3.Avy.ry();
                    return 0;
                case 5:
                    bpVar.vDZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
