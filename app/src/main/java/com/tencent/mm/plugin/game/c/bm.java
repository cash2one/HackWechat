package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.fd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bm extends bcv {
    public String hvC;
    public String nhF;
    public int nhG;
    public LinkedList<String> nic = new LinkedList();
    public s nid;
    public int nie;
    public boolean nif;

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
            aVar.d(3, 1, this.nic);
            if (this.hvC != null) {
                aVar.g(4, this.hvC);
            }
            if (this.nid != null) {
                aVar.fW(5, this.nid.bke());
                this.nid.a(aVar);
            }
            aVar.fU(6, this.nie);
            aVar.al(7, this.nif);
            aVar.fU(8, this.nhG);
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
            r0 += e.a.a.a.c(3, 1, this.nic);
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(4, this.hvC);
            }
            if (this.nid != null) {
                r0 += e.a.a.a.fT(5, this.nid.bke());
            }
            return ((r0 + e.a.a.a.fR(6, this.nie)) + (e.a.a.b.b.a.dX(7) + 1)) + e.a.a.a.fR(8, this.nhG);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nic.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            bm bmVar = (bm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        bmVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    bmVar.nhF = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bmVar.nic.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    bmVar.hvC = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new s();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        bmVar.nid = fdVar;
                    }
                    return 0;
                case 6:
                    bmVar.nie = aVar3.Avy.ry();
                    return 0;
                case 7:
                    bmVar.nif = aVar3.cJC();
                    return 0;
                case 8:
                    bmVar.nhG = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
