package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.b;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.fe;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bl extends bdf {
    public String nfO;
    public LinkedList<ag> niv = new LinkedList();
    public b niw;
    public boolean nix;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.d(2, 8, this.niv);
            if (this.niw != null) {
                aVar.b(3, this.niw);
            }
            aVar.al(4, this.nix);
            if (this.nfO == null) {
                return 0;
            }
            aVar.g(5, this.nfO);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.niv);
            if (this.niw != null) {
                r0 += e.a.a.a.a(3, this.niw);
            }
            r0 += e.a.a.b.b.a.dX(4) + 1;
            if (this.nfO != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfO);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.niv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bl blVar = (bl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        blVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ag();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        blVar.niv.add(feVar);
                    }
                    return 0;
                case 3:
                    blVar.niw = aVar3.cJD();
                    return 0;
                case 4:
                    blVar.nix = aVar3.cJC();
                    return 0;
                case 5:
                    blVar.nfO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
