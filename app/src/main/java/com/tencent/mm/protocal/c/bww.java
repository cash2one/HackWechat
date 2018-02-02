package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bww extends a {
    public bdn vHb;
    public String vMC;
    public bdn vMG;
    public String wXK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMG == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wXK != null) {
                    aVar.g(1, this.wXK);
                }
                if (this.vMG != null) {
                    aVar.fW(2, this.vMG.bke());
                    this.vMG.a(aVar);
                }
                if (this.vMC != null) {
                    aVar.g(3, this.vMC);
                }
                if (this.vHb == null) {
                    return 0;
                }
                aVar.fW(4, this.vHb.bke());
                this.vHb.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wXK != null) {
                r0 = e.a.a.b.b.a.h(1, this.wXK) + 0;
            } else {
                r0 = 0;
            }
            if (this.vMG != null) {
                r0 += e.a.a.a.fT(2, this.vMG.bke());
            }
            if (this.vMC != null) {
                r0 += e.a.a.b.b.a.h(3, this.vMC);
            }
            if (this.vHb != null) {
                r0 += e.a.a.a.fT(4, this.vHb.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vMG == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.vHb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bww com_tencent_mm_protocal_c_bww = (bww) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bww.wXK = aVar3.Avy.readString();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bww.vMG = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bww.vMC = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bww.vHb = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
