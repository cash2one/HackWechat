package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class byt extends a {
    public LinkedList<Integer> wYQ = new LinkedList();
    public boolean wYR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 2, this.wYQ);
            aVar.al(2, this.wYR);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 2, this.wYQ) + 0) + (e.a.a.b.b.a.dX(2) + 1);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.wYQ.clear();
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
                byt com_tencent_mm_protocal_c_byt = (byt) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_byt.wYQ.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_byt.wYR = aVar3.cJC();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
