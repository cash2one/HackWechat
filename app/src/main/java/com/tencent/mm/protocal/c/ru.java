package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ru extends bcv {
    public String lOo;
    public int vJL;
    public String vJz;
    public String vLN;
    public bdn vMi;
    public String vMp;
    public String vZH;
    public String vZI;
    public int vZJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vMi == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vMi != null) {
                aVar.fW(2, this.vMi.bke());
                this.vMi.a(aVar);
            }
            aVar.fU(3, this.vJL);
            if (this.vLN != null) {
                aVar.g(4, this.vLN);
            }
            if (this.lOo != null) {
                aVar.g(5, this.lOo);
            }
            if (this.vMp != null) {
                aVar.g(6, this.vMp);
            }
            if (this.vZH != null) {
                aVar.g(7, this.vZH);
            }
            if (this.vJz != null) {
                aVar.g(8, this.vJz);
            }
            if (this.vZI != null) {
                aVar.g(9, this.vZI);
            }
            aVar.fU(10, this.vZJ);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vMi != null) {
                r0 += e.a.a.a.fT(2, this.vMi.bke());
            }
            r0 += e.a.a.a.fR(3, this.vJL);
            if (this.vLN != null) {
                r0 += e.a.a.b.b.a.h(4, this.vLN);
            }
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(5, this.lOo);
            }
            if (this.vMp != null) {
                r0 += e.a.a.b.b.a.h(6, this.vMp);
            }
            if (this.vZH != null) {
                r0 += e.a.a.b.b.a.h(7, this.vZH);
            }
            if (this.vJz != null) {
                r0 += e.a.a.b.b.a.h(8, this.vJz);
            }
            if (this.vZI != null) {
                r0 += e.a.a.b.b.a.h(9, this.vZI);
            }
            return r0 + e.a.a.a.fR(10, this.vZJ);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vMi != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ru ruVar = (ru) objArr[1];
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
                        ruVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ruVar.vMi = fdVar;
                    }
                    return 0;
                case 3:
                    ruVar.vJL = aVar3.Avy.ry();
                    return 0;
                case 4:
                    ruVar.vLN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ruVar.lOo = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ruVar.vMp = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ruVar.vZH = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ruVar.vJz = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ruVar.vZI = aVar3.Avy.readString();
                    return 0;
                case 10:
                    ruVar.vZJ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
