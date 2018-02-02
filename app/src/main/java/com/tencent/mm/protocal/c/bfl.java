package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bfl extends a {
    public rt vIY;
    public bdn vIZ;
    public bdn vJa;
    public int vJo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJa == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.vIY == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vIZ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else {
                if (this.vJa != null) {
                    aVar.fW(1, this.vJa.bke());
                    this.vJa.a(aVar);
                }
                if (this.vIY != null) {
                    aVar.fW(2, this.vIY.bke());
                    this.vIY.a(aVar);
                }
                if (this.vIZ != null) {
                    aVar.fW(3, this.vIZ.bke());
                    this.vIZ.a(aVar);
                }
                aVar.fU(4, this.vJo);
                return 0;
            }
        } else if (i == 1) {
            if (this.vJa != null) {
                r0 = e.a.a.a.fT(1, this.vJa.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIY != null) {
                r0 += e.a.a.a.fT(2, this.vIY.bke());
            }
            if (this.vIZ != null) {
                r0 += e.a.a.a.fT(3, this.vIZ.bke());
            }
            return r0 + e.a.a.a.fR(4, this.vJo);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vJa == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.vIY == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vIZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfl com_tencent_mm_protocal_c_bfl = (bfl) objArr[1];
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
                        com_tencent_mm_protocal_c_bfl.vJa = com_tencent_mm_protocal_c_bdn;
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
                        com_tencent_mm_protocal_c_bfl.vIY = com_tencent_mm_protocal_c_bdn;
                    }
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
                        com_tencent_mm_protocal_c_bfl.vIZ = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfl.vJo = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
