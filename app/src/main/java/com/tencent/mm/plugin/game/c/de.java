package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class de extends a {
    public String ngr;
    public dg njG;
    public dg njH;
    public dg njI;
    public dg njJ;
    public dg njK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.njG != null) {
                aVar.fW(1, this.njG.bke());
                this.njG.a(aVar);
            }
            if (this.njH != null) {
                aVar.fW(2, this.njH.bke());
                this.njH.a(aVar);
            }
            if (this.njI != null) {
                aVar.fW(3, this.njI.bke());
                this.njI.a(aVar);
            }
            if (this.njJ != null) {
                aVar.fW(4, this.njJ.bke());
                this.njJ.a(aVar);
            }
            if (this.njK != null) {
                aVar.fW(6, this.njK.bke());
                this.njK.a(aVar);
            }
            if (this.ngr == null) {
                return 0;
            }
            aVar.g(5, this.ngr);
            return 0;
        } else if (i == 1) {
            if (this.njG != null) {
                r0 = e.a.a.a.fT(1, this.njG.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.njH != null) {
                r0 += e.a.a.a.fT(2, this.njH.bke());
            }
            if (this.njI != null) {
                r0 += e.a.a.a.fT(3, this.njI.bke());
            }
            if (this.njJ != null) {
                r0 += e.a.a.a.fT(4, this.njJ.bke());
            }
            if (this.njK != null) {
                r0 += e.a.a.a.fT(6, this.njK.bke());
            }
            if (this.ngr != null) {
                r0 += e.a.a.b.b.a.h(5, this.ngr);
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
            de deVar = (de) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a dgVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.njG = dgVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.njH = dgVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.njI = dgVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.njJ = dgVar;
                    }
                    return 0;
                case 5:
                    deVar.ngr = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.njK = dgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
