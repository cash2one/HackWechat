package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class zs extends a implements bir {
    public int vJU;
    public int wjl;
    public int wjm;
    public int wjn;
    public LinkedList<bdo> wjo = new LinkedList();

    public final int getRet() {
        return this.vJU;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vJU);
            aVar.fU(2, this.wjl);
            aVar.fU(3, this.wjm);
            aVar.fU(4, this.wjn);
            aVar.d(5, 8, this.wjo);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.vJU) + 0) + e.a.a.a.fR(2, this.wjl)) + e.a.a.a.fR(3, this.wjm)) + e.a.a.a.fR(4, this.wjn)) + e.a.a.a.c(5, 8, this.wjo);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wjo.clear();
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
                zs zsVar = (zs) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        zsVar.vJU = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        zsVar.wjl = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        zsVar.wjm = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        zsVar.wjn = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_bdo = new bdo();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                            }
                            zsVar.wjo.add(com_tencent_mm_protocal_c_bdo);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
