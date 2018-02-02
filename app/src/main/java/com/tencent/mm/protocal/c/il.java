package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class il extends a {
    public int vOG;
    public int vOH;
    public int vOI;
    public LinkedList<ik> vOJ = new LinkedList();
    public LinkedList<ik> vOK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vOG);
            aVar.fU(2, this.vOH);
            aVar.fU(5, this.vOI);
            aVar.d(3, 8, this.vOJ);
            aVar.d(4, 8, this.vOK);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.vOG) + 0) + e.a.a.a.fR(2, this.vOH)) + e.a.a.a.fR(5, this.vOI)) + e.a.a.a.c(3, 8, this.vOJ)) + e.a.a.a.c(4, 8, this.vOK);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vOJ.clear();
                this.vOK.clear();
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
                il ilVar = (il) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList Jl;
                int size;
                a ikVar;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        ilVar.vOG = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        ilVar.vOH = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            ikVar = new ik();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = ikVar.a(aVar4, ikVar, a.a(aVar4))) {
                            }
                            ilVar.vOJ.add(ikVar);
                        }
                        return 0;
                    case 4:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            ikVar = new ik();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = ikVar.a(aVar4, ikVar, a.a(aVar4))) {
                            }
                            ilVar.vOK.add(ikVar);
                        }
                        return 0;
                    case 5:
                        ilVar.vOI = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
