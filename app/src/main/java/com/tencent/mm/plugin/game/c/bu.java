package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.fd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bu extends bcv {
    public String hvC;
    public String nhF;
    public int niD;
    public int niE;
    public int niF;
    public boolean niG;
    public LinkedList<String> nic = new LinkedList();

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
            aVar.fU(2, this.niD);
            aVar.fU(3, this.niE);
            if (this.nhF != null) {
                aVar.g(4, this.nhF);
            }
            aVar.d(5, 1, this.nic);
            if (this.hvC != null) {
                aVar.g(6, this.hvC);
            }
            aVar.fU(7, this.niF);
            aVar.al(8, this.niG);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.niD)) + e.a.a.a.fR(3, this.niE);
            if (this.nhF != null) {
                r0 += e.a.a.b.b.a.h(4, this.nhF);
            }
            r0 += e.a.a.a.c(5, 1, this.nic);
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(6, this.hvC);
            }
            return (r0 + e.a.a.a.fR(7, this.niF)) + (e.a.a.b.b.a.dX(8) + 1);
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
            bu buVar = (bu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        buVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    buVar.niD = aVar3.Avy.ry();
                    return 0;
                case 3:
                    buVar.niE = aVar3.Avy.ry();
                    return 0;
                case 4:
                    buVar.nhF = aVar3.Avy.readString();
                    return 0;
                case 5:
                    buVar.nic.add(aVar3.Avy.readString());
                    return 0;
                case 6:
                    buVar.hvC = aVar3.Avy.readString();
                    return 0;
                case 7:
                    buVar.niF = aVar3.Avy.ry();
                    return 0;
                case 8:
                    buVar.niG = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
