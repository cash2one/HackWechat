package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class yh extends bcv {
    public String kJN;
    public String kJT;
    public b kMm;
    public int kUc;
    public String kUd;
    public String kUe;
    public String kUf;
    public String kUg;
    public int time_stamp;
    public int wiB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.kJT != null) {
                aVar.g(2, this.kJT);
            }
            aVar.fU(3, this.kUc);
            if (this.kUd != null) {
                aVar.g(4, this.kUd);
            }
            if (this.kUe != null) {
                aVar.g(5, this.kUe);
            }
            aVar.fU(6, this.time_stamp);
            if (this.kUf != null) {
                aVar.g(7, this.kUf);
            }
            if (this.kJN != null) {
                aVar.g(8, this.kJN);
            }
            if (this.kUg != null) {
                aVar.g(9, this.kUg);
            }
            if (this.kMm != null) {
                aVar.b(10, this.kMm);
            }
            aVar.fU(11, this.wiB);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.kJT != null) {
                r0 += e.a.a.b.b.a.h(2, this.kJT);
            }
            r0 += e.a.a.a.fR(3, this.kUc);
            if (this.kUd != null) {
                r0 += e.a.a.b.b.a.h(4, this.kUd);
            }
            if (this.kUe != null) {
                r0 += e.a.a.b.b.a.h(5, this.kUe);
            }
            r0 += e.a.a.a.fR(6, this.time_stamp);
            if (this.kUf != null) {
                r0 += e.a.a.b.b.a.h(7, this.kUf);
            }
            if (this.kJN != null) {
                r0 += e.a.a.b.b.a.h(8, this.kJN);
            }
            if (this.kUg != null) {
                r0 += e.a.a.b.b.a.h(9, this.kUg);
            }
            if (this.kMm != null) {
                r0 += e.a.a.a.a(10, this.kMm);
            }
            return r0 + e.a.a.a.fR(11, this.wiB);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yh yhVar = (yh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        yhVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    yhVar.kJT = aVar3.Avy.readString();
                    return 0;
                case 3:
                    yhVar.kUc = aVar3.Avy.ry();
                    return 0;
                case 4:
                    yhVar.kUd = aVar3.Avy.readString();
                    return 0;
                case 5:
                    yhVar.kUe = aVar3.Avy.readString();
                    return 0;
                case 6:
                    yhVar.time_stamp = aVar3.Avy.ry();
                    return 0;
                case 7:
                    yhVar.kUf = aVar3.Avy.readString();
                    return 0;
                case 8:
                    yhVar.kJN = aVar3.Avy.readString();
                    return 0;
                case 9:
                    yhVar.kUg = aVar3.Avy.readString();
                    return 0;
                case 10:
                    yhVar.kMm = aVar3.cJD();
                    return 0;
                case 11:
                    yhVar.wiB = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
