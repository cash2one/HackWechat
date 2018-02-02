package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ee extends bcv {
    public String hvw;
    public String ksY;
    public String lOn;
    public String lOo;
    public int vDY;
    public String vJA;
    public bdn vJa;
    public fb vJw;
    public String vJx;
    public int vJy;
    public String vJz;
    public String vcm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vJa == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vJw != null) {
                aVar.fW(2, this.vJw.bke());
                this.vJw.a(aVar);
            }
            if (this.vJa != null) {
                aVar.fW(3, this.vJa.bke());
                this.vJa.a(aVar);
            }
            if (this.vcm != null) {
                aVar.g(4, this.vcm);
            }
            if (this.vJx != null) {
                aVar.g(5, this.vJx);
            }
            aVar.fU(6, this.vJy);
            if (this.vJz != null) {
                aVar.g(7, this.vJz);
            }
            if (this.hvw != null) {
                aVar.g(8, this.hvw);
            }
            if (this.ksY != null) {
                aVar.g(9, this.ksY);
            }
            if (this.vJA != null) {
                aVar.g(10, this.vJA);
            }
            if (this.lOo != null) {
                aVar.g(11, this.lOo);
            }
            if (this.lOn != null) {
                aVar.g(12, this.lOn);
            }
            aVar.fU(13, this.vDY);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vJw != null) {
                r0 += e.a.a.a.fT(2, this.vJw.bke());
            }
            if (this.vJa != null) {
                r0 += e.a.a.a.fT(3, this.vJa.bke());
            }
            if (this.vcm != null) {
                r0 += e.a.a.b.b.a.h(4, this.vcm);
            }
            if (this.vJx != null) {
                r0 += e.a.a.b.b.a.h(5, this.vJx);
            }
            r0 += e.a.a.a.fR(6, this.vJy);
            if (this.vJz != null) {
                r0 += e.a.a.b.b.a.h(7, this.vJz);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(8, this.hvw);
            }
            if (this.ksY != null) {
                r0 += e.a.a.b.b.a.h(9, this.ksY);
            }
            if (this.vJA != null) {
                r0 += e.a.a.b.b.a.h(10, this.vJA);
            }
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(11, this.lOo);
            }
            if (this.lOn != null) {
                r0 += e.a.a.b.b.a.h(12, this.lOn);
            }
            return r0 + e.a.a.a.fR(13, this.vDY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vJa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AutoAuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ee eeVar = (ee) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        eeVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        eeVar.vJw = fdVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        eeVar.vJa = fdVar;
                    }
                    return 0;
                case 4:
                    eeVar.vcm = aVar3.Avy.readString();
                    return 0;
                case 5:
                    eeVar.vJx = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eeVar.vJy = aVar3.Avy.ry();
                    return 0;
                case 7:
                    eeVar.vJz = aVar3.Avy.readString();
                    return 0;
                case 8:
                    eeVar.hvw = aVar3.Avy.readString();
                    return 0;
                case 9:
                    eeVar.ksY = aVar3.Avy.readString();
                    return 0;
                case 10:
                    eeVar.vJA = aVar3.Avy.readString();
                    return 0;
                case 11:
                    eeVar.lOo = aVar3.Avy.readString();
                    return 0;
                case 12:
                    eeVar.lOn = aVar3.Avy.readString();
                    return 0;
                case 13:
                    eeVar.vDY = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
