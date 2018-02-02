package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aqf extends a {
    public String ksU;
    public rt vJG;
    public String vMB;
    public bdn vMi;
    public String vMp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMi == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.vJG == null) {
                throw new b("Not all required fields were included: CliPubECDHKey");
            } else {
                if (this.vMi != null) {
                    aVar.fW(1, this.vMi.bke());
                    this.vMi.a(aVar);
                }
                if (this.vJG != null) {
                    aVar.fW(2, this.vJG.bke());
                    this.vJG.a(aVar);
                }
                if (this.ksU != null) {
                    aVar.g(3, this.ksU);
                }
                if (this.vMp != null) {
                    aVar.g(4, this.vMp);
                }
                if (this.vMB == null) {
                    return 0;
                }
                aVar.g(5, this.vMB);
                return 0;
            }
        } else if (i == 1) {
            if (this.vMi != null) {
                r0 = e.a.a.a.fT(1, this.vMi.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vJG != null) {
                r0 += e.a.a.a.fT(2, this.vJG.bke());
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(3, this.ksU);
            }
            if (this.vMp != null) {
                r0 += e.a.a.b.b.a.h(4, this.vMp);
            }
            if (this.vMB != null) {
                r0 += e.a.a.b.b.a.h(5, this.vMB);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vMi == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.vJG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CliPubECDHKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqf com_tencent_mm_protocal_c_aqf = (aqf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqf.vMi = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new rt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqf.vJG = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqf.ksU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqf.vMp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqf.vMB = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
