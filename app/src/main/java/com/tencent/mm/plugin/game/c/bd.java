package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bd extends a {
    public String fon;
    public String nfT;
    public String nff;
    public e nfh;
    public String ngo;
    public LinkedList<String> nhB = new LinkedList();
    public String nhC;
    public String nhD;
    public String nhE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nfT != null) {
                aVar.g(2, this.nfT);
            }
            aVar.d(3, 1, this.nhB);
            if (this.nhC != null) {
                aVar.g(4, this.nhC);
            }
            if (this.nff != null) {
                aVar.g(5, this.nff);
            }
            if (this.nhD != null) {
                aVar.g(6, this.nhD);
            }
            if (this.nhE != null) {
                aVar.g(8, this.nhE);
            }
            if (this.ngo != null) {
                aVar.g(9, this.ngo);
            }
            if (this.nfh == null) {
                return 0;
            }
            aVar.fW(10, this.nfh.bke());
            this.nfh.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfT);
            }
            r0 += e.a.a.a.c(3, 1, this.nhB);
            if (this.nhC != null) {
                r0 += e.a.a.b.b.a.h(4, this.nhC);
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(5, this.nff);
            }
            if (this.nhD != null) {
                r0 += e.a.a.b.b.a.h(6, this.nhD);
            }
            if (this.nhE != null) {
                r0 += e.a.a.b.b.a.h(8, this.nhE);
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(9, this.ngo);
            }
            if (this.nfh != null) {
                r0 += e.a.a.a.fT(10, this.nfh.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nhB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            bd bdVar = (bd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bdVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    bdVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bdVar.nhB.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    bdVar.nhC = aVar3.Avy.readString();
                    return 0;
                case 5:
                    bdVar.nff = aVar3.Avy.readString();
                    return 0;
                case 6:
                    bdVar.nhD = aVar3.Avy.readString();
                    return 0;
                case 8:
                    bdVar.nhE = aVar3.Avy.readString();
                    return 0;
                case 9:
                    bdVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 10:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        bdVar.nfh = eVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
