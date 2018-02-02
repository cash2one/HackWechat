package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class je extends a {
    public String fon;
    public int kto;
    public LinkedList<jj> ngS = new LinkedList();
    public int vNW;
    public long vPp;
    public int vPq;
    public LinkedList<String> vPr = new LinkedList();
    public String vPs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPs == null) {
                throw new b("Not all required fields were included: SearchID");
            }
            aVar.S(1, this.vPp);
            aVar.fU(2, this.vPq);
            if (this.fon != null) {
                aVar.g(3, this.fon);
            }
            aVar.d(4, 1, this.vPr);
            aVar.d(5, 8, this.ngS);
            aVar.fU(6, this.kto);
            if (this.vPs != null) {
                aVar.g(7, this.vPs);
            }
            aVar.fU(8, this.vNW);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.R(1, this.vPp) + 0) + e.a.a.a.fR(2, this.vPq);
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            r0 = ((r0 + e.a.a.a.c(4, 1, this.vPr)) + e.a.a.a.c(5, 8, this.ngS)) + e.a.a.a.fR(6, this.kto);
            if (this.vPs != null) {
                r0 += e.a.a.b.b.a.h(7, this.vPs);
            }
            return r0 + e.a.a.a.fR(8, this.vNW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vPr.clear();
            this.ngS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vPs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SearchID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            je jeVar = (je) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jeVar.vPp = aVar3.Avy.rz();
                    return 0;
                case 2:
                    jeVar.vPq = aVar3.Avy.ry();
                    return 0;
                case 3:
                    jeVar.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jeVar.vPr.add(aVar3.Avy.readString());
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a jjVar = new jj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = jjVar.a(aVar4, jjVar, a.a(aVar4))) {
                        }
                        jeVar.ngS.add(jjVar);
                    }
                    return 0;
                case 6:
                    jeVar.kto = aVar3.Avy.ry();
                    return 0;
                case 7:
                    jeVar.vPs = aVar3.Avy.readString();
                    return 0;
                case 8:
                    jeVar.vNW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
