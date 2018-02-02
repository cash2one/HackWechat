package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rj extends bdf {
    public String ksU;
    public String ngo;
    public int vIB;
    public int vIC;
    public int vID;
    public bdn vXz;
    public String vZq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.ngo != null) {
                    aVar.g(2, this.ngo);
                }
                if (this.vZq != null) {
                    aVar.g(3, this.vZq);
                }
                if (this.ksU != null) {
                    aVar.g(4, this.ksU);
                }
                aVar.fU(5, this.vIB);
                aVar.fU(6, this.vIC);
                aVar.fU(7, this.vID);
                if (this.vXz == null) {
                    return 0;
                }
                aVar.fW(8, this.vXz.bke());
                this.vXz.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.vZq != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZq);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(4, this.ksU);
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.vIB)) + e.a.a.a.fR(6, this.vIC)) + e.a.a.a.fR(7, this.vID);
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(8, this.vXz.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vXz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rj rjVar = (rj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        rjVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    rjVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    rjVar.vZq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    rjVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    rjVar.vIB = aVar3.Avy.ry();
                    return 0;
                case 6:
                    rjVar.vIC = aVar3.Avy.ry();
                    return 0;
                case 7:
                    rjVar.vID = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        rjVar.vXz = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
