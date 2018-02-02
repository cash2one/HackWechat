package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class vz extends bcv {
    public String pbQ;
    public String vMb;
    public String vZK;
    public String wgs;
    public String wgt;
    public String wgu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wgs != null) {
                aVar.g(2, this.wgs);
            }
            if (this.vMb != null) {
                aVar.g(3, this.vMb);
            }
            if (this.pbQ != null) {
                aVar.g(4, this.pbQ);
            }
            if (this.wgt != null) {
                aVar.g(5, this.wgt);
            }
            if (this.wgu != null) {
                aVar.g(6, this.wgu);
            }
            if (this.vZK == null) {
                return 0;
            }
            aVar.g(7, this.vZK);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wgs != null) {
                r0 += e.a.a.b.b.a.h(2, this.wgs);
            }
            if (this.vMb != null) {
                r0 += e.a.a.b.b.a.h(3, this.vMb);
            }
            if (this.pbQ != null) {
                r0 += e.a.a.b.b.a.h(4, this.pbQ);
            }
            if (this.wgt != null) {
                r0 += e.a.a.b.b.a.h(5, this.wgt);
            }
            if (this.wgu != null) {
                r0 += e.a.a.b.b.a.h(6, this.wgu);
            }
            if (this.vZK != null) {
                r0 += e.a.a.b.b.a.h(7, this.vZK);
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
            vz vzVar = (vz) objArr[1];
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
                        vzVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    vzVar.wgs = aVar3.Avy.readString();
                    return 0;
                case 3:
                    vzVar.vMb = aVar3.Avy.readString();
                    return 0;
                case 4:
                    vzVar.pbQ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    vzVar.wgt = aVar3.Avy.readString();
                    return 0;
                case 6:
                    vzVar.wgu = aVar3.Avy.readString();
                    return 0;
                case 7:
                    vzVar.vZK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
