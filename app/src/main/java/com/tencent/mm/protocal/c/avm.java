package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class avm extends bcv {
    public String nfr;
    public String ngo;
    public String niZ;
    public au vQS;
    public String vWg;
    public String vWh;
    public String vWi;
    public String vWj;
    public String wDg;
    public String wDh;
    public String wDi;
    public String wDj;
    public String wDk;
    public String whq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            if (this.wDg != null) {
                aVar.g(3, this.wDg);
            }
            if (this.whq != null) {
                aVar.g(4, this.whq);
            }
            if (this.vWg != null) {
                aVar.g(5, this.vWg);
            }
            if (this.wDh != null) {
                aVar.g(6, this.wDh);
            }
            if (this.vWh != null) {
                aVar.g(7, this.vWh);
            }
            if (this.vWi != null) {
                aVar.g(8, this.vWi);
            }
            if (this.vWj != null) {
                aVar.g(9, this.vWj);
            }
            if (this.wDi != null) {
                aVar.g(10, this.wDi);
            }
            if (this.vQS != null) {
                aVar.fW(11, this.vQS.bke());
                this.vQS.a(aVar);
            }
            if (this.wDj != null) {
                aVar.g(12, this.wDj);
            }
            if (this.nfr != null) {
                aVar.g(13, this.nfr);
            }
            if (this.niZ != null) {
                aVar.g(14, this.niZ);
            }
            if (this.wDk == null) {
                return 0;
            }
            aVar.g(15, this.wDk);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.wDg != null) {
                r0 += e.a.a.b.b.a.h(3, this.wDg);
            }
            if (this.whq != null) {
                r0 += e.a.a.b.b.a.h(4, this.whq);
            }
            if (this.vWg != null) {
                r0 += e.a.a.b.b.a.h(5, this.vWg);
            }
            if (this.wDh != null) {
                r0 += e.a.a.b.b.a.h(6, this.wDh);
            }
            if (this.vWh != null) {
                r0 += e.a.a.b.b.a.h(7, this.vWh);
            }
            if (this.vWi != null) {
                r0 += e.a.a.b.b.a.h(8, this.vWi);
            }
            if (this.vWj != null) {
                r0 += e.a.a.b.b.a.h(9, this.vWj);
            }
            if (this.wDi != null) {
                r0 += e.a.a.b.b.a.h(10, this.wDi);
            }
            if (this.vQS != null) {
                r0 += e.a.a.a.fT(11, this.vQS.bke());
            }
            if (this.wDj != null) {
                r0 += e.a.a.b.b.a.h(12, this.wDj);
            }
            if (this.nfr != null) {
                r0 += e.a.a.b.b.a.h(13, this.nfr);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(14, this.niZ);
            }
            if (this.wDk != null) {
                r0 += e.a.a.b.b.a.h(15, this.wDk);
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
            avm com_tencent_mm_protocal_c_avm = (avm) objArr[1];
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
                        com_tencent_mm_protocal_c_avm.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avm.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avm.wDg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avm.whq = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avm.vWg = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avm.wDh = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avm.vWh = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avm.vWi = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avm.vWj = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avm.wDi = aVar3.Avy.readString();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new au();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avm.vQS = fdVar;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_avm.wDj = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_avm.nfr = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_avm.niZ = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_avm.wDk = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
