package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class dr extends a {
    public i nkc;
    public dp nkd;
    public dp nke;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkc != null) {
                aVar.fW(1, this.nkc.bke());
                this.nkc.a(aVar);
            }
            if (this.nkd != null) {
                aVar.fW(2, this.nkd.bke());
                this.nkd.a(aVar);
            }
            if (this.nke == null) {
                return 0;
            }
            aVar.fW(3, this.nke.bke());
            this.nke.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nkc != null) {
                r0 = e.a.a.a.fT(1, this.nkc.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nkd != null) {
                r0 += e.a.a.a.fT(2, this.nkd.bke());
            }
            if (this.nke != null) {
                r0 += e.a.a.a.fT(3, this.nke.bke());
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
            dr drVar = (dr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a iVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        drVar.nkc = iVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        iVar = new dp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        drVar.nkd = iVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        iVar = new dp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        drVar.nke = iVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
