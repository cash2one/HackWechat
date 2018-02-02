package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bqv extends a {
    public int vDW;
    public LinkedList<String> wSo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vDW);
            aVar.d(2, 1, this.wSo);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fR(1, this.vDW) + 0) + e.a.a.a.c(2, 1, this.wSo);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.wSo.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                bqv com_tencent_mm_protocal_c_bqv = (bqv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bqv.vDW = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bqv.wSo.add(aVar3.Avy.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
