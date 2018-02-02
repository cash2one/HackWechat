package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bza extends a {
    public b vIA;
    public long wYH;
    public int wZa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIA == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceData");
            }
            aVar.S(1, this.wYH);
            if (this.vIA != null) {
                aVar.b(2, this.vIA);
            }
            aVar.fU(3, this.wZa);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.wYH) + 0;
            if (this.vIA != null) {
                r0 += e.a.a.a.a(2, this.vIA);
            }
            return r0 + e.a.a.a.fR(3, this.wZa);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIA != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: VoiceData");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bza com_tencent_mm_protocal_c_bza = (bza) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bza.wYH = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bza.vIA = aVar3.cJD();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bza.wZa = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
