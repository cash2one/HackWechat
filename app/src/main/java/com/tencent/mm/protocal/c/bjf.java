package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bjf extends a {
    public String vGQ;
    public long vPO;
    public long wMC;
    public bje wMD;
    public bje wME;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMD == null) {
                throw new b("Not all required fields were included: CurrentAction");
            }
            aVar.S(1, this.vPO);
            aVar.S(2, this.wMC);
            if (this.wMD != null) {
                aVar.fW(3, this.wMD.bke());
                this.wMD.a(aVar);
            }
            if (this.wME != null) {
                aVar.fW(4, this.wME.bke());
                this.wME.a(aVar);
            }
            if (this.vGQ != null) {
                aVar.g(5, this.vGQ);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.R(1, this.vPO) + 0) + e.a.a.a.R(2, this.wMC);
            if (this.wMD != null) {
                r0 += e.a.a.a.fT(3, this.wMD.bke());
            }
            if (this.wME != null) {
                r0 += e.a.a.a.fT(4, this.wME.bke());
            }
            if (this.vGQ != null) {
                return r0 + e.a.a.b.b.a.h(5, this.vGQ);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wMD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CurrentAction");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjf com_tencent_mm_protocal_c_bjf = (bjf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bje;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bjf.vPO = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjf.wMC = aVar3.Avy.rz();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bje = new bje();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bje.a(aVar4, com_tencent_mm_protocal_c_bje, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjf.wMD = com_tencent_mm_protocal_c_bje;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bje = new bje();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bje.a(aVar4, com_tencent_mm_protocal_c_bje, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjf.wME = com_tencent_mm_protocal_c_bje;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjf.vGQ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
