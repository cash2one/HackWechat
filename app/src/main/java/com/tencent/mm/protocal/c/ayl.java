package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ayl extends a {
    public int nDS;
    public LinkedList<ayu> wFH = new LinkedList();
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wbh);
            aVar.S(2, this.wbi);
            aVar.d(3, 8, this.wFH);
            aVar.fU(4, this.nDS);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.wbh) + 0) + e.a.a.a.R(2, this.wbi)) + e.a.a.a.c(3, 8, this.wFH)) + e.a.a.a.fR(4, this.nDS);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wFH.clear();
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
                ayl com_tencent_mm_protocal_c_ayl = (ayl) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_ayl.wbh = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_ayl.wbi = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_ayu = new ayu();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_ayu.a(aVar4, com_tencent_mm_protocal_c_ayu, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_ayl.wFH.add(com_tencent_mm_protocal_c_ayu);
                        }
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_ayl.nDS = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
