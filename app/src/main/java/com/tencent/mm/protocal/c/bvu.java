package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bvu extends a {
    public String wWL;
    public LinkedList<String> wWM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWL != null) {
                aVar.g(1, this.wWL);
            }
            aVar.d(2, 1, this.wWM);
            return 0;
        } else if (i == 1) {
            if (this.wWL != null) {
                r0 = e.a.a.b.b.a.h(1, this.wWL) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 1, this.wWM);
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
            bvu com_tencent_mm_protocal_c_bvu = (bvu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bvu.wWL = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bvu.wWM.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
