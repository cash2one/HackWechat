package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bzc extends a {
    public int vNW;
    public boolean wYx;
    public LinkedList<bxy> wkl = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wkl);
            aVar.fU(2, this.vNW);
            aVar.al(3, this.wYx);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.c(1, 8, this.wkl) + 0) + e.a.a.a.fR(2, this.vNW)) + (e.a.a.b.b.a.dX(3) + 1);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wkl.clear();
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
                bzc com_tencent_mm_protocal_c_bzc = (bzc) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_bxy = new bxy();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bxy.a(aVar4, com_tencent_mm_protocal_c_bxy, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bzc.wkl.add(com_tencent_mm_protocal_c_bxy);
                        }
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bzc.vNW = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bzc.wYx = aVar3.cJC();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
