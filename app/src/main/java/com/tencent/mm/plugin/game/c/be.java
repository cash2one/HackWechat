package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.fd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class be extends bcv {
    public String hvC;
    public String nhF;
    public int nhG;
    public d nhH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nhF == null) {
                throw new b("Not all required fields were included: Lang");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.nhF != null) {
                aVar.g(2, this.nhF);
            }
            if (this.hvC != null) {
                aVar.g(3, this.hvC);
            }
            aVar.fU(4, this.nhG);
            if (this.nhH == null) {
                return 0;
            }
            aVar.fW(5, this.nhH.bke());
            this.nhH.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nhF != null) {
                r0 += e.a.a.b.b.a.h(2, this.nhF);
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(3, this.hvC);
            }
            r0 += e.a.a.a.fR(4, this.nhG);
            if (this.nhH != null) {
                r0 += e.a.a.a.fT(5, this.nhH.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nhF != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Lang");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            be beVar = (be) objArr[1];
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
                        beVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    beVar.nhF = aVar3.Avy.readString();
                    return 0;
                case 3:
                    beVar.hvC = aVar3.Avy.readString();
                    return 0;
                case 4:
                    beVar.nhG = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new d();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        beVar.nhH = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
