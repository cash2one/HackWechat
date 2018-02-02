package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ag extends a {
    public int vEA;
    public int vEB;
    public int vEC;
    public LinkedList<ae> vED = new LinkedList();
    public int vEE;
    public LinkedList<ae> vEF = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vEA);
            aVar.fU(2, this.vEC);
            aVar.d(3, 8, this.vED);
            aVar.fU(4, this.vEB);
            aVar.fU(5, this.vEE);
            aVar.d(6, 8, this.vEF);
            return 0;
        } else if (i == 1) {
            return (((((e.a.a.a.fR(1, this.vEA) + 0) + e.a.a.a.fR(2, this.vEC)) + e.a.a.a.c(3, 8, this.vED)) + e.a.a.a.fR(4, this.vEB)) + e.a.a.a.fR(5, this.vEE)) + e.a.a.a.c(6, 8, this.vEF);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vED.clear();
                this.vEF.clear();
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
                ag agVar = (ag) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList Jl;
                int size;
                a aeVar;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        agVar.vEA = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        agVar.vEC = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            aeVar = new ae();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = aeVar.a(aVar4, aeVar, a.a(aVar4))) {
                            }
                            agVar.vED.add(aeVar);
                        }
                        return 0;
                    case 4:
                        agVar.vEB = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        agVar.vEE = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            aeVar = new ae();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = aeVar.a(aVar4, aeVar, a.a(aVar4))) {
                            }
                            agVar.vEF.add(aeVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
