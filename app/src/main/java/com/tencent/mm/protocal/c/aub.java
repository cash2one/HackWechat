package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class aub extends a {
    public b vKZ;
    public int wBX;
    public String wBY;
    public bdn wBZ;
    public int wCa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wBZ == null) {
                throw new e.a.a.b("Not all required fields were included: ClientKey");
            }
            aVar.fU(1, this.wBX);
            if (this.vKZ != null) {
                aVar.b(2, this.vKZ);
            }
            if (this.wBY != null) {
                aVar.g(3, this.wBY);
            }
            if (this.wBZ != null) {
                aVar.fW(4, this.wBZ.bke());
                this.wBZ.a(aVar);
            }
            aVar.fU(5, this.wCa);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wBX) + 0;
            if (this.vKZ != null) {
                r0 += e.a.a.a.a(2, this.vKZ);
            }
            if (this.wBY != null) {
                r0 += e.a.a.b.b.a.h(3, this.wBY);
            }
            if (this.wBZ != null) {
                r0 += e.a.a.a.fT(4, this.wBZ.bke());
            }
            return r0 + e.a.a.a.fR(5, this.wCa);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wBZ != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: ClientKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aub com_tencent_mm_protocal_c_aub = (aub) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aub.wBX = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aub.vKZ = aVar3.cJD();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aub.wBY = aVar3.Avy.readString();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aub.wBZ = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aub.wCa = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
