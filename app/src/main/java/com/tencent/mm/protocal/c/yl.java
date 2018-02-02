package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class yl extends bcv {
    public String appId;
    public String fqD;
    public String mFp;
    public String mFq;
    public String mFr;
    public String sign;
    public String vDZ;
    public int vEa;
    public cn wiH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.appId != null) {
                aVar.g(2, this.appId);
            }
            if (this.mFp != null) {
                aVar.g(3, this.mFp);
            }
            if (this.mFq != null) {
                aVar.g(4, this.mFq);
            }
            if (this.mFr != null) {
                aVar.g(5, this.mFr);
            }
            if (this.fqD != null) {
                aVar.g(6, this.fqD);
            }
            if (this.sign != null) {
                aVar.g(7, this.sign);
            }
            if (this.wiH != null) {
                aVar.fW(8, this.wiH.bke());
                this.wiH.a(aVar);
            }
            if (this.vDZ != null) {
                aVar.g(9, this.vDZ);
            }
            aVar.fU(10, this.vEa);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.appId != null) {
                r0 += e.a.a.b.b.a.h(2, this.appId);
            }
            if (this.mFp != null) {
                r0 += e.a.a.b.b.a.h(3, this.mFp);
            }
            if (this.mFq != null) {
                r0 += e.a.a.b.b.a.h(4, this.mFq);
            }
            if (this.mFr != null) {
                r0 += e.a.a.b.b.a.h(5, this.mFr);
            }
            if (this.fqD != null) {
                r0 += e.a.a.b.b.a.h(6, this.fqD);
            }
            if (this.sign != null) {
                r0 += e.a.a.b.b.a.h(7, this.sign);
            }
            if (this.wiH != null) {
                r0 += e.a.a.a.fT(8, this.wiH.bke());
            }
            if (this.vDZ != null) {
                r0 += e.a.a.b.b.a.h(9, this.vDZ);
            }
            return r0 + e.a.a.a.fR(10, this.vEa);
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
            yl ylVar = (yl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ylVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    ylVar.appId = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ylVar.mFp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ylVar.mFq = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ylVar.mFr = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ylVar.fqD = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ylVar.sign = aVar3.Avy.readString();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ylVar.wiH = fdVar;
                    }
                    return 0;
                case 9:
                    ylVar.vDZ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    ylVar.vEa = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
