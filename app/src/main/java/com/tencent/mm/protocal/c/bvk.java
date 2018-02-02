package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bvk extends a {
    public String wWK;
    public String wWL;
    public LinkedList<String> wWM = new LinkedList();
    public int wWN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWK != null) {
                aVar.g(1, this.wWK);
            }
            if (this.wWL != null) {
                aVar.g(2, this.wWL);
            }
            aVar.d(3, 1, this.wWM);
            aVar.fU(4, this.wWN);
            return 0;
        } else if (i == 1) {
            if (this.wWK != null) {
                r0 = e.a.a.b.b.a.h(1, this.wWK) + 0;
            } else {
                r0 = 0;
            }
            if (this.wWL != null) {
                r0 += e.a.a.b.b.a.h(2, this.wWL);
            }
            return (r0 + e.a.a.a.c(3, 1, this.wWM)) + e.a.a.a.fR(4, this.wWN);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wWM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvk com_tencent_mm_protocal_c_bvk = (bvk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bvk.wWK = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bvk.wWL = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bvk.wWM.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bvk.wWN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
