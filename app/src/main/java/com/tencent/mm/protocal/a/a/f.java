package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class f extends a {
    public int ret;
    public int vCd;
    public int vCe;
    public o vCf;
    public o vCg;
    public int vCh;
    public int vCi;
    public int vCr;
    public o vCs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ret);
            aVar.fU(2, this.vCd);
            aVar.fU(3, this.vCe);
            aVar.fU(4, this.vCr);
            if (this.vCf != null) {
                aVar.fW(5, this.vCf.bke());
                this.vCf.a(aVar);
            }
            if (this.vCg != null) {
                aVar.fW(6, this.vCg.bke());
                this.vCg.a(aVar);
            }
            if (this.vCs != null) {
                aVar.fW(7, this.vCs.bke());
                this.vCs.a(aVar);
            }
            aVar.fU(8, this.vCh);
            aVar.fU(9, this.vCi);
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.a.fR(1, this.ret) + 0) + e.a.a.a.fR(2, this.vCd)) + e.a.a.a.fR(3, this.vCe)) + e.a.a.a.fR(4, this.vCr);
            if (this.vCf != null) {
                r0 += e.a.a.a.fT(5, this.vCf.bke());
            }
            if (this.vCg != null) {
                r0 += e.a.a.a.fT(6, this.vCg.bke());
            }
            if (this.vCs != null) {
                r0 += e.a.a.a.fT(7, this.vCs.bke());
            }
            return (r0 + e.a.a.a.fR(8, this.vCh)) + e.a.a.a.fR(9, this.vCi);
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
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a oVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fVar.ret = aVar3.Avy.ry();
                    return 0;
                case 2:
                    fVar.vCd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    fVar.vCe = aVar3.Avy.ry();
                    return 0;
                case 4:
                    fVar.vCr = aVar3.Avy.ry();
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
                        fVar.vCf = oVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        fVar.vCg = oVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        fVar.vCs = oVar;
                    }
                    return 0;
                case 8:
                    fVar.vCh = aVar3.Avy.ry();
                    return 0;
                case 9:
                    fVar.vCi = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
