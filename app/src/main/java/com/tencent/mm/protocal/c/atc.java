package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class atc extends bcv {
    public String ksU;
    public String lOo;
    public bdn wAP;
    public bdn wAQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wAP == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wAQ == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.ksU != null) {
                    aVar.g(2, this.ksU);
                }
                if (this.wAP != null) {
                    aVar.fW(3, this.wAP.bke());
                    this.wAP.a(aVar);
                }
                if (this.wAQ != null) {
                    aVar.fW(4, this.wAQ.bke());
                    this.wAQ.a(aVar);
                }
                if (this.lOo == null) {
                    return 0;
                }
                aVar.g(5, this.lOo);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            if (this.wAP != null) {
                r0 += e.a.a.a.fT(3, this.wAP.bke());
            }
            if (this.wAQ != null) {
                r0 += e.a.a.a.fT(4, this.wAQ.bke());
            }
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(5, this.lOo);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wAP == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wAQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atc com_tencent_mm_protocal_c_atc = (atc) objArr[1];
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
                        com_tencent_mm_protocal_c_atc.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atc.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atc.wAP = fdVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atc.wAQ = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_atc.lOo = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
