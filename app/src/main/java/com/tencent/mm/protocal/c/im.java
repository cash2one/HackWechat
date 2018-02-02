package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class im extends bcv {
    public String pLn;
    public String vHq;
    public String vHr;
    public String vHs;
    public int vHv;
    public b vOL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vHq != null) {
                aVar.g(2, this.vHq);
            }
            if (this.vHr != null) {
                aVar.g(3, this.vHr);
            }
            if (this.pLn != null) {
                aVar.g(4, this.pLn);
            }
            aVar.fU(5, this.vHv);
            if (this.vOL != null) {
                aVar.b(6, this.vOL);
            }
            if (this.vHs == null) {
                return 0;
            }
            aVar.g(7, this.vHs);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHq != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHq);
            }
            if (this.vHr != null) {
                r0 += e.a.a.b.b.a.h(3, this.vHr);
            }
            if (this.pLn != null) {
                r0 += e.a.a.b.b.a.h(4, this.pLn);
            }
            r0 += e.a.a.a.fR(5, this.vHv);
            if (this.vOL != null) {
                r0 += e.a.a.a.a(6, this.vOL);
            }
            if (this.vHs != null) {
                r0 += e.a.a.b.b.a.h(7, this.vHs);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            im imVar = (im) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        imVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    imVar.vHq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    imVar.vHr = aVar3.Avy.readString();
                    return 0;
                case 4:
                    imVar.pLn = aVar3.Avy.readString();
                    return 0;
                case 5:
                    imVar.vHv = aVar3.Avy.ry();
                    return 0;
                case 6:
                    imVar.vOL = aVar3.cJD();
                    return 0;
                case 7:
                    imVar.vHs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
