package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class os extends bcv {
    public String vGQ;
    public int vIB;
    public int vIC;
    public int vID;
    public String vXA;
    public String vXB;
    public int vXC;
    public bdn vXz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vGQ != null) {
                aVar.g(2, this.vGQ);
            }
            aVar.fU(3, this.vIB);
            aVar.fU(4, this.vIC);
            aVar.fU(5, this.vID);
            if (this.vXz != null) {
                aVar.fW(6, this.vXz.bke());
                this.vXz.a(aVar);
            }
            if (this.vXA != null) {
                aVar.g(7, this.vXA);
            }
            if (this.vXB != null) {
                aVar.g(9, this.vXB);
            }
            aVar.fU(10, this.vXC);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vGQ != null) {
                r0 += e.a.a.b.b.a.h(2, this.vGQ);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.vIB)) + e.a.a.a.fR(4, this.vIC)) + e.a.a.a.fR(5, this.vID);
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(6, this.vXz.bke());
            }
            if (this.vXA != null) {
                r0 += e.a.a.b.b.a.h(7, this.vXA);
            }
            if (this.vXB != null) {
                r0 += e.a.a.b.b.a.h(9, this.vXB);
            }
            return r0 + e.a.a.a.fR(10, this.vXC);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            os osVar = (os) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        osVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    osVar.vGQ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    osVar.vIB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    osVar.vIC = aVar3.Avy.ry();
                    return 0;
                case 5:
                    osVar.vID = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        osVar.vXz = fdVar;
                    }
                    return 0;
                case 7:
                    osVar.vXA = aVar3.Avy.readString();
                    return 0;
                case 9:
                    osVar.vXB = aVar3.Avy.readString();
                    return 0;
                case 10:
                    osVar.vXC = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
