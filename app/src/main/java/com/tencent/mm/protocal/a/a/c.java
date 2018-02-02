package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class c extends a {
    public int ret;
    public int vCd;
    public int vCe;
    public o vCf;
    public o vCg;
    public int vCh;
    public int vCi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ret);
            aVar.fU(2, this.vCd);
            aVar.fU(3, this.vCe);
            if (this.vCf != null) {
                aVar.fW(4, this.vCf.bke());
                this.vCf.a(aVar);
            }
            if (this.vCg != null) {
                aVar.fW(5, this.vCg.bke());
                this.vCg.a(aVar);
            }
            aVar.fU(6, this.vCh);
            aVar.fU(7, this.vCi);
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.ret) + 0) + e.a.a.a.fR(2, this.vCd)) + e.a.a.a.fR(3, this.vCe);
            if (this.vCf != null) {
                r0 += e.a.a.a.fT(4, this.vCf.bke());
            }
            if (this.vCg != null) {
                r0 += e.a.a.a.fT(5, this.vCg.bke());
            }
            return (r0 + e.a.a.a.fR(6, this.vCh)) + e.a.a.a.fR(7, this.vCi);
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a oVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.ret = aVar3.Avy.ry();
                    return 0;
                case 2:
                    cVar.vCd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    cVar.vCe = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.vCf = oVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.vCg = oVar;
                    }
                    return 0;
                case 6:
                    cVar.vCh = aVar3.Avy.ry();
                    return 0;
                case 7:
                    cVar.vCi = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
