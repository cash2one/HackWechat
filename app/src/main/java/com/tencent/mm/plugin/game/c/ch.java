package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ch extends a {
    public dz njb;
    public de njc;
    public u njd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.njb != null) {
                aVar.fW(1, this.njb.bke());
                this.njb.a(aVar);
            }
            if (this.njc != null) {
                aVar.fW(2, this.njc.bke());
                this.njc.a(aVar);
            }
            if (this.njd == null) {
                return 0;
            }
            aVar.fW(3, this.njd.bke());
            this.njd.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.njb != null) {
                r0 = e.a.a.a.fT(1, this.njb.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.njc != null) {
                r0 += e.a.a.a.fT(2, this.njc.bke());
            }
            if (this.njd != null) {
                r0 += e.a.a.a.fT(3, this.njd.bke());
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
            ch chVar = (ch) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a dzVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dzVar = new dz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dzVar.a(aVar4, dzVar, a.a(aVar4))) {
                        }
                        chVar.njb = dzVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dzVar = new de();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dzVar.a(aVar4, dzVar, a.a(aVar4))) {
                        }
                        chVar.njc = dzVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dzVar = new u();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dzVar.a(aVar4, dzVar, a.a(aVar4))) {
                        }
                        chVar.njd = dzVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
