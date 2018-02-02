package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class f extends a {
    public String sDA;
    public a sDB;
    public double sDn;
    public double sDo;
    public double sDp;
    public String sDq;
    public LinkedList<q> sDr = new LinkedList();
    public g sDs;
    public int sDt;
    public String sDu;
    public String sDv;
    public double sDw;
    public double sDx;
    public int sDy;
    public String sDz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.b(1, this.sDn);
            aVar.b(2, this.sDo);
            aVar.b(3, this.sDp);
            if (this.sDq != null) {
                aVar.g(4, this.sDq);
            }
            aVar.d(5, 8, this.sDr);
            if (this.sDs != null) {
                aVar.fW(6, this.sDs.bke());
                this.sDs.a(aVar);
            }
            aVar.fU(7, this.sDt);
            if (this.sDu != null) {
                aVar.g(8, this.sDu);
            }
            if (this.sDv != null) {
                aVar.g(9, this.sDv);
            }
            aVar.b(10, this.sDw);
            aVar.b(11, this.sDx);
            aVar.fU(12, this.sDy);
            if (this.sDz != null) {
                aVar.g(13, this.sDz);
            }
            if (this.sDA != null) {
                aVar.g(14, this.sDA);
            }
            if (this.sDB != null) {
                aVar.fW(15, this.sDB.bke());
                this.sDB.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.b.b.a.dX(1) + 8) + 0) + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8);
            if (this.sDq != null) {
                r0 += e.a.a.b.b.a.h(4, this.sDq);
            }
            r0 += e.a.a.a.c(5, 8, this.sDr);
            if (this.sDs != null) {
                r0 += e.a.a.a.fT(6, this.sDs.bke());
            }
            r0 += e.a.a.a.fR(7, this.sDt);
            if (this.sDu != null) {
                r0 += e.a.a.b.b.a.h(8, this.sDu);
            }
            if (this.sDv != null) {
                r0 += e.a.a.b.b.a.h(9, this.sDv);
            }
            r0 = ((r0 + (e.a.a.b.b.a.dX(10) + 8)) + (e.a.a.b.b.a.dX(11) + 8)) + e.a.a.a.fR(12, this.sDy);
            if (this.sDz != null) {
                r0 += e.a.a.b.b.a.h(13, this.sDz);
            }
            if (this.sDA != null) {
                r0 += e.a.a.b.b.a.h(14, this.sDA);
            }
            if (this.sDB != null) {
                return r0 + e.a.a.a.fT(15, this.sDB.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.sDr.clear();
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
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a qVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fVar.sDn = aVar3.Avy.readDouble();
                    return 0;
                case 2:
                    fVar.sDo = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    fVar.sDp = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    fVar.sDq = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        qVar = new q();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        fVar.sDr.add(qVar);
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        qVar = new g();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        fVar.sDs = qVar;
                    }
                    return 0;
                case 7:
                    fVar.sDt = aVar3.Avy.ry();
                    return 0;
                case 8:
                    fVar.sDu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    fVar.sDv = aVar3.Avy.readString();
                    return 0;
                case 10:
                    fVar.sDw = aVar3.Avy.readDouble();
                    return 0;
                case 11:
                    fVar.sDx = aVar3.Avy.readDouble();
                    return 0;
                case 12:
                    fVar.sDy = aVar3.Avy.ry();
                    return 0;
                case 13:
                    fVar.sDz = aVar3.Avy.readString();
                    return 0;
                case 14:
                    fVar.sDA = aVar3.Avy.readString();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        qVar = new a();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        fVar.sDB = qVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
