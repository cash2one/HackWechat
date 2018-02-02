package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class df extends a {
    public String ngr;
    public dh njL;
    public dh njM;
    public dh njN;
    public dh njO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.njL != null) {
                aVar.fW(1, this.njL.bke());
                this.njL.a(aVar);
            }
            if (this.njM != null) {
                aVar.fW(2, this.njM.bke());
                this.njM.a(aVar);
            }
            if (this.njN != null) {
                aVar.fW(3, this.njN.bke());
                this.njN.a(aVar);
            }
            if (this.njO != null) {
                aVar.fW(4, this.njO.bke());
                this.njO.a(aVar);
            }
            if (this.ngr == null) {
                return 0;
            }
            aVar.g(5, this.ngr);
            return 0;
        } else if (i == 1) {
            if (this.njL != null) {
                r0 = e.a.a.a.fT(1, this.njL.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.njM != null) {
                r0 += e.a.a.a.fT(2, this.njM.bke());
            }
            if (this.njN != null) {
                r0 += e.a.a.a.fT(3, this.njN.bke());
            }
            if (this.njO != null) {
                r0 += e.a.a.a.fT(4, this.njO.bke());
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
            df dfVar = (df) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a dhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.njL = dhVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.njM = dhVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.njN = dhVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.njO = dhVar;
                    }
                    return 0;
                case 5:
                    dfVar.ngr = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
