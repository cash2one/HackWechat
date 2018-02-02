package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ow extends bcv {
    public String ngo;
    public String vJA;
    public String vXI;
    public String vXJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXI == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.vJA == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.vXJ == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.ngo == null) {
                throw new b("Not all required fields were included: AppId");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.vXI != null) {
                    aVar.g(2, this.vXI);
                }
                if (this.vJA != null) {
                    aVar.g(3, this.vJA);
                }
                if (this.vXJ != null) {
                    aVar.g(4, this.vXJ);
                }
                if (this.ngo == null) {
                    return 0;
                }
                aVar.g(5, this.ngo);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vXI != null) {
                r0 += e.a.a.b.b.a.h(2, this.vXI);
            }
            if (this.vJA != null) {
                r0 += e.a.a.b.b.a.h(3, this.vJA);
            }
            if (this.vXJ != null) {
                r0 += e.a.a.b.b.a.h(4, this.vXJ);
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(5, this.ngo);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXI == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.vJA == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.vXJ == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.ngo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ow owVar = (ow) objArr[1];
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
                        owVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    owVar.vXI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    owVar.vJA = aVar3.Avy.readString();
                    return 0;
                case 4:
                    owVar.vXJ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    owVar.ngo = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
