package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lo extends bcv {
    public int fCR;
    public int nZd;
    public String pLh;
    public String vUl;
    public String vUo;
    public String vUp;
    public int vUq;
    public String vUr;
    public String vUs;
    public String vUt;
    public String vUu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vUo == null) {
                throw new b("Not all required fields were included: receiver_name");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vUo != null) {
                aVar.g(2, this.vUo);
            }
            aVar.fU(3, this.nZd);
            if (this.vUp != null) {
                aVar.g(4, this.vUp);
            }
            if (this.pLh != null) {
                aVar.g(5, this.pLh);
            }
            aVar.fU(6, this.vUq);
            aVar.fU(7, this.fCR);
            if (this.vUr != null) {
                aVar.g(8, this.vUr);
            }
            if (this.vUl != null) {
                aVar.g(9, this.vUl);
            }
            if (this.vUs != null) {
                aVar.g(10, this.vUs);
            }
            if (this.vUt != null) {
                aVar.g(11, this.vUt);
            }
            if (this.vUu == null) {
                return 0;
            }
            aVar.g(12, this.vUu);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vUo != null) {
                r0 += e.a.a.b.b.a.h(2, this.vUo);
            }
            r0 += e.a.a.a.fR(3, this.nZd);
            if (this.vUp != null) {
                r0 += e.a.a.b.b.a.h(4, this.vUp);
            }
            if (this.pLh != null) {
                r0 += e.a.a.b.b.a.h(5, this.pLh);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.vUq)) + e.a.a.a.fR(7, this.fCR);
            if (this.vUr != null) {
                r0 += e.a.a.b.b.a.h(8, this.vUr);
            }
            if (this.vUl != null) {
                r0 += e.a.a.b.b.a.h(9, this.vUl);
            }
            if (this.vUs != null) {
                r0 += e.a.a.b.b.a.h(10, this.vUs);
            }
            if (this.vUt != null) {
                r0 += e.a.a.b.b.a.h(11, this.vUt);
            }
            if (this.vUu != null) {
                r0 += e.a.a.b.b.a.h(12, this.vUu);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vUo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: receiver_name");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lo loVar = (lo) objArr[1];
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
                        loVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    loVar.vUo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    loVar.nZd = aVar3.Avy.ry();
                    return 0;
                case 4:
                    loVar.vUp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    loVar.pLh = aVar3.Avy.readString();
                    return 0;
                case 6:
                    loVar.vUq = aVar3.Avy.ry();
                    return 0;
                case 7:
                    loVar.fCR = aVar3.Avy.ry();
                    return 0;
                case 8:
                    loVar.vUr = aVar3.Avy.readString();
                    return 0;
                case 9:
                    loVar.vUl = aVar3.Avy.readString();
                    return 0;
                case 10:
                    loVar.vUs = aVar3.Avy.readString();
                    return 0;
                case 11:
                    loVar.vUt = aVar3.Avy.readString();
                    return 0;
                case 12:
                    loVar.vUu = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
