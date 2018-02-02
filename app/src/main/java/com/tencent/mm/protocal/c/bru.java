package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bru extends a {
    public int fgt;
    public String nfe;
    public bdn wTs;
    public bdn wTt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wTs == null) {
                throw new b("Not all required fields were included: Icon");
            } else if (this.wTt == null) {
                throw new b("Not all required fields were included: HDIcon");
            } else {
                aVar.fU(1, this.fgt);
                if (this.nfe != null) {
                    aVar.g(2, this.nfe);
                }
                if (this.wTs != null) {
                    aVar.fW(3, this.wTs.bke());
                    this.wTs.a(aVar);
                }
                if (this.wTt != null) {
                    aVar.fW(4, this.wTt.bke());
                    this.wTt.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.fgt) + 0;
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            if (this.wTs != null) {
                r0 += e.a.a.a.fT(3, this.wTs.bke());
            }
            if (this.wTt != null) {
                return r0 + e.a.a.a.fT(4, this.wTt.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wTs == null) {
                throw new b("Not all required fields were included: Icon");
            } else if (this.wTt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HDIcon");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bru com_tencent_mm_protocal_c_bru = (bru) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bru.fgt = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bru.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bru.wTs = com_tencent_mm_protocal_c_bdn;
                    }
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
                        com_tencent_mm_protocal_c_bru.wTt = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
