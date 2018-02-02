package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class q extends a {
    public String pax;
    public int sDZ;
    public String sDk;
    public String sDl;
    public String sDm;
    public int sEa;
    public long sEb;
    public String sEc;
    public String sEd;
    public String sEe;
    public double sEf;
    public double sEg;
    public int sEh;
    public String sEi;
    public String sEj;
    public LinkedList<b> sEk = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.sDZ);
            aVar.fU(2, this.sEa);
            aVar.S(3, this.sEb);
            if (this.sEc != null) {
                aVar.g(4, this.sEc);
            }
            if (this.sDk != null) {
                aVar.g(5, this.sDk);
            }
            if (this.sEd != null) {
                aVar.g(6, this.sEd);
            }
            if (this.sEe != null) {
                aVar.g(7, this.sEe);
            }
            if (this.sDl != null) {
                aVar.g(8, this.sDl);
            }
            if (this.sDm != null) {
                aVar.g(9, this.sDm);
            }
            aVar.b(10, this.sEf);
            aVar.b(11, this.sEg);
            aVar.fU(12, this.sEh);
            if (this.sEi != null) {
                aVar.g(13, this.sEi);
            }
            if (this.pax != null) {
                aVar.g(14, this.pax);
            }
            if (this.sEj != null) {
                aVar.g(16, this.sEj);
            }
            aVar.d(17, 6, this.sEk);
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.sDZ) + 0) + e.a.a.a.fR(2, this.sEa)) + e.a.a.a.R(3, this.sEb);
            if (this.sEc != null) {
                r0 += e.a.a.b.b.a.h(4, this.sEc);
            }
            if (this.sDk != null) {
                r0 += e.a.a.b.b.a.h(5, this.sDk);
            }
            if (this.sEd != null) {
                r0 += e.a.a.b.b.a.h(6, this.sEd);
            }
            if (this.sEe != null) {
                r0 += e.a.a.b.b.a.h(7, this.sEe);
            }
            if (this.sDl != null) {
                r0 += e.a.a.b.b.a.h(8, this.sDl);
            }
            if (this.sDm != null) {
                r0 += e.a.a.b.b.a.h(9, this.sDm);
            }
            r0 = ((r0 + (e.a.a.b.b.a.dX(10) + 8)) + (e.a.a.b.b.a.dX(11) + 8)) + e.a.a.a.fR(12, this.sEh);
            if (this.sEi != null) {
                r0 += e.a.a.b.b.a.h(13, this.sEi);
            }
            if (this.pax != null) {
                r0 += e.a.a.b.b.a.h(14, this.pax);
            }
            if (this.sEj != null) {
                r0 += e.a.a.b.b.a.h(16, this.sEj);
            }
            return r0 + e.a.a.a.c(17, 6, this.sEk);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.sEk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.sDZ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    qVar.sEa = aVar3.Avy.ry();
                    return 0;
                case 3:
                    qVar.sEb = aVar3.Avy.rz();
                    return 0;
                case 4:
                    qVar.sEc = aVar3.Avy.readString();
                    return 0;
                case 5:
                    qVar.sDk = aVar3.Avy.readString();
                    return 0;
                case 6:
                    qVar.sEd = aVar3.Avy.readString();
                    return 0;
                case 7:
                    qVar.sEe = aVar3.Avy.readString();
                    return 0;
                case 8:
                    qVar.sDl = aVar3.Avy.readString();
                    return 0;
                case 9:
                    qVar.sDm = aVar3.Avy.readString();
                    return 0;
                case 10:
                    qVar.sEf = aVar3.Avy.readDouble();
                    return 0;
                case 11:
                    qVar.sEg = aVar3.Avy.readDouble();
                    return 0;
                case 12:
                    qVar.sEh = aVar3.Avy.ry();
                    return 0;
                case 13:
                    qVar.sEi = aVar3.Avy.readString();
                    return 0;
                case 14:
                    qVar.pax = aVar3.Avy.readString();
                    return 0;
                case 16:
                    qVar.sEj = aVar3.Avy.readString();
                    return 0;
                case 17:
                    qVar.sEk.add(aVar3.cJD());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
