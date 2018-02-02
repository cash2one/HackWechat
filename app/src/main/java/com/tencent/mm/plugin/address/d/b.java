package com.tencent.mm.plugin.address.d;

import com.tencent.mm.bq.a;

public final class b extends a {
    public int id;
    public String imj;
    public String imk;
    public String iml;
    public String imm;
    public String imn;
    public String imo;
    public String imp;
    public String imq;
    public String imr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.id);
            if (this.imj != null) {
                aVar.g(2, this.imj);
            }
            if (this.imk != null) {
                aVar.g(3, this.imk);
            }
            if (this.iml != null) {
                aVar.g(4, this.iml);
            }
            if (this.imm != null) {
                aVar.g(5, this.imm);
            }
            if (this.imn != null) {
                aVar.g(6, this.imn);
            }
            if (this.imo != null) {
                aVar.g(7, this.imo);
            }
            if (this.imp != null) {
                aVar.g(8, this.imp);
            }
            if (this.imq != null) {
                aVar.g(9, this.imq);
            }
            if (this.imr != null) {
                aVar.g(10, this.imr);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.id) + 0;
            if (this.imj != null) {
                r0 += e.a.a.b.b.a.h(2, this.imj);
            }
            if (this.imk != null) {
                r0 += e.a.a.b.b.a.h(3, this.imk);
            }
            if (this.iml != null) {
                r0 += e.a.a.b.b.a.h(4, this.iml);
            }
            if (this.imm != null) {
                r0 += e.a.a.b.b.a.h(5, this.imm);
            }
            if (this.imn != null) {
                r0 += e.a.a.b.b.a.h(6, this.imn);
            }
            if (this.imo != null) {
                r0 += e.a.a.b.b.a.h(7, this.imo);
            }
            if (this.imp != null) {
                r0 += e.a.a.b.b.a.h(8, this.imp);
            }
            if (this.imq != null) {
                r0 += e.a.a.b.b.a.h(9, this.imq);
            }
            if (this.imr != null) {
                return r0 + e.a.a.b.b.a.h(10, this.imr);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.id = aVar3.Avy.ry();
                    return 0;
                case 2:
                    bVar.imj = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bVar.imk = aVar3.Avy.readString();
                    return 0;
                case 4:
                    bVar.iml = aVar3.Avy.readString();
                    return 0;
                case 5:
                    bVar.imm = aVar3.Avy.readString();
                    return 0;
                case 6:
                    bVar.imn = aVar3.Avy.readString();
                    return 0;
                case 7:
                    bVar.imo = aVar3.Avy.readString();
                    return 0;
                case 8:
                    bVar.imp = aVar3.Avy.readString();
                    return 0;
                case 9:
                    bVar.imq = aVar3.Avy.readString();
                    return 0;
                case 10:
                    bVar.imr = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
