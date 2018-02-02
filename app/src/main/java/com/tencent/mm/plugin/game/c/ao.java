package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ao extends a {
    public ck nhc;
    public ck nhd;
    public ck nhe;
    public ds nhf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nhc != null) {
                aVar.fW(1, this.nhc.bke());
                this.nhc.a(aVar);
            }
            if (this.nhd != null) {
                aVar.fW(2, this.nhd.bke());
                this.nhd.a(aVar);
            }
            if (this.nhe != null) {
                aVar.fW(3, this.nhe.bke());
                this.nhe.a(aVar);
            }
            if (this.nhf == null) {
                return 0;
            }
            aVar.fW(4, this.nhf.bke());
            this.nhf.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nhc != null) {
                r0 = e.a.a.a.fT(1, this.nhc.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nhd != null) {
                r0 += e.a.a.a.fT(2, this.nhd.bke());
            }
            if (this.nhe != null) {
                r0 += e.a.a.a.fT(3, this.nhe.bke());
            }
            if (this.nhf != null) {
                r0 += e.a.a.a.fT(4, this.nhf.bke());
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
            ao aoVar = (ao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a ckVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        ckVar = new ck();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nhc = ckVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        ckVar = new ck();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nhd = ckVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        ckVar = new ck();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nhe = ckVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        ckVar = new ds();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nhf = ckVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
