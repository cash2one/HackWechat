package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class e extends a {
    public int nettype;
    public int uin;
    public int vCb;
    public LinkedList<d> vCc = new LinkedList();
    public String vCl;
    public String vCm;
    public String vCn;
    public String vCo;
    public String vCp;
    public int vCq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.uin);
            aVar.fU(2, this.vCb);
            aVar.fU(3, this.nettype);
            aVar.d(4, 8, this.vCc);
            if (this.vCl != null) {
                aVar.g(5, this.vCl);
            }
            if (this.vCm != null) {
                aVar.g(6, this.vCm);
            }
            if (this.vCn != null) {
                aVar.g(7, this.vCn);
            }
            if (this.vCo != null) {
                aVar.g(8, this.vCo);
            }
            if (this.vCp != null) {
                aVar.g(9, this.vCp);
            }
            aVar.fU(10, this.vCq);
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.a.fR(1, this.uin) + 0) + e.a.a.a.fR(2, this.vCb)) + e.a.a.a.fR(3, this.nettype)) + e.a.a.a.c(4, 8, this.vCc);
            if (this.vCl != null) {
                r0 += e.a.a.b.b.a.h(5, this.vCl);
            }
            if (this.vCm != null) {
                r0 += e.a.a.b.b.a.h(6, this.vCm);
            }
            if (this.vCn != null) {
                r0 += e.a.a.b.b.a.h(7, this.vCn);
            }
            if (this.vCo != null) {
                r0 += e.a.a.b.b.a.h(8, this.vCo);
            }
            if (this.vCp != null) {
                r0 += e.a.a.b.b.a.h(9, this.vCp);
            }
            return r0 + e.a.a.a.fR(10, this.vCq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vCc.clear();
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
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.uin = aVar3.Avy.ry();
                    return 0;
                case 2:
                    eVar.vCb = aVar3.Avy.ry();
                    return 0;
                case 3:
                    eVar.nettype = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        eVar.vCc.add(dVar);
                    }
                    return 0;
                case 5:
                    eVar.vCl = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eVar.vCm = aVar3.Avy.readString();
                    return 0;
                case 7:
                    eVar.vCn = aVar3.Avy.readString();
                    return 0;
                case 8:
                    eVar.vCo = aVar3.Avy.readString();
                    return 0;
                case 9:
                    eVar.vCp = aVar3.Avy.readString();
                    return 0;
                case 10:
                    eVar.vCq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
