package com.tencent.mm.plugin.order.model;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class i extends a {
    public String niZ;
    public double pbA;
    public String pbB;
    public String pbi;
    public double pbj;
    public String pbk;
    public int pbl;
    public String pbm;
    public int pbn;
    public String pbo;
    public int pbp;
    public int pbq;
    public String pbr;
    public String pbs;
    public String pbt;
    public String pbu;
    public String pbv;
    public int pbw;
    public LinkedList<k> pbx = new LinkedList();
    public String pby;
    public String pbz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pbi != null) {
                aVar.g(1, this.pbi);
            }
            aVar.b(2, this.pbj);
            if (this.pbk != null) {
                aVar.g(3, this.pbk);
            }
            aVar.fU(4, this.pbl);
            if (this.pbm != null) {
                aVar.g(5, this.pbm);
            }
            aVar.fU(6, this.pbn);
            if (this.pbo != null) {
                aVar.g(7, this.pbo);
            }
            aVar.fU(8, this.pbp);
            aVar.fU(9, this.pbq);
            if (this.pbr != null) {
                aVar.g(10, this.pbr);
            }
            if (this.niZ != null) {
                aVar.g(11, this.niZ);
            }
            if (this.pbs != null) {
                aVar.g(12, this.pbs);
            }
            if (this.pbt != null) {
                aVar.g(13, this.pbt);
            }
            if (this.pbu != null) {
                aVar.g(14, this.pbu);
            }
            if (this.pbv != null) {
                aVar.g(15, this.pbv);
            }
            aVar.fU(16, this.pbw);
            aVar.d(17, 8, this.pbx);
            if (this.pby != null) {
                aVar.g(18, this.pby);
            }
            if (this.pbz != null) {
                aVar.g(19, this.pbz);
            }
            aVar.b(20, this.pbA);
            if (this.pbB == null) {
                return 0;
            }
            aVar.g(21, this.pbB);
            return 0;
        } else if (i == 1) {
            if (this.pbi != null) {
                r0 = e.a.a.b.b.a.h(1, this.pbi) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.b.b.a.dX(2) + 8;
            if (this.pbk != null) {
                r0 += e.a.a.b.b.a.h(3, this.pbk);
            }
            r0 += e.a.a.a.fR(4, this.pbl);
            if (this.pbm != null) {
                r0 += e.a.a.b.b.a.h(5, this.pbm);
            }
            r0 += e.a.a.a.fR(6, this.pbn);
            if (this.pbo != null) {
                r0 += e.a.a.b.b.a.h(7, this.pbo);
            }
            r0 = (r0 + e.a.a.a.fR(8, this.pbp)) + e.a.a.a.fR(9, this.pbq);
            if (this.pbr != null) {
                r0 += e.a.a.b.b.a.h(10, this.pbr);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(11, this.niZ);
            }
            if (this.pbs != null) {
                r0 += e.a.a.b.b.a.h(12, this.pbs);
            }
            if (this.pbt != null) {
                r0 += e.a.a.b.b.a.h(13, this.pbt);
            }
            if (this.pbu != null) {
                r0 += e.a.a.b.b.a.h(14, this.pbu);
            }
            if (this.pbv != null) {
                r0 += e.a.a.b.b.a.h(15, this.pbv);
            }
            r0 = (r0 + e.a.a.a.fR(16, this.pbw)) + e.a.a.a.c(17, 8, this.pbx);
            if (this.pby != null) {
                r0 += e.a.a.b.b.a.h(18, this.pby);
            }
            if (this.pbz != null) {
                r0 += e.a.a.b.b.a.h(19, this.pbz);
            }
            r0 += e.a.a.b.b.a.dX(20) + 8;
            if (this.pbB != null) {
                r0 += e.a.a.b.b.a.h(21, this.pbB);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.pbx.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.pbi = aVar3.Avy.readString();
                    return 0;
                case 2:
                    iVar.pbj = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    iVar.pbk = aVar3.Avy.readString();
                    return 0;
                case 4:
                    iVar.pbl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    iVar.pbm = aVar3.Avy.readString();
                    return 0;
                case 6:
                    iVar.pbn = aVar3.Avy.ry();
                    return 0;
                case 7:
                    iVar.pbo = aVar3.Avy.readString();
                    return 0;
                case 8:
                    iVar.pbp = aVar3.Avy.ry();
                    return 0;
                case 9:
                    iVar.pbq = aVar3.Avy.ry();
                    return 0;
                case 10:
                    iVar.pbr = aVar3.Avy.readString();
                    return 0;
                case 11:
                    iVar.niZ = aVar3.Avy.readString();
                    return 0;
                case 12:
                    iVar.pbs = aVar3.Avy.readString();
                    return 0;
                case 13:
                    iVar.pbt = aVar3.Avy.readString();
                    return 0;
                case 14:
                    iVar.pbu = aVar3.Avy.readString();
                    return 0;
                case 15:
                    iVar.pbv = aVar3.Avy.readString();
                    return 0;
                case 16:
                    iVar.pbw = aVar3.Avy.ry();
                    return 0;
                case 17:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a kVar = new k();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        iVar.pbx.add(kVar);
                    }
                    return 0;
                case 18:
                    iVar.pby = aVar3.Avy.readString();
                    return 0;
                case 19:
                    iVar.pbz = aVar3.Avy.readString();
                    return 0;
                case 20:
                    iVar.pbA = aVar3.Avy.readDouble();
                    return 0;
                case 21:
                    iVar.pbB = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
