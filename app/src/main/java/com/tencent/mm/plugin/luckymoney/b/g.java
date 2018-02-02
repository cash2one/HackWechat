package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class g extends a {
    public int hKN;
    public int obY;
    public LinkedList<h> och = new LinkedList();
    public int ocl;
    public long ocm;
    public int ocn;
    public long oco;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ocl);
            aVar.S(2, this.ocm);
            aVar.fU(3, this.ocn);
            aVar.S(4, this.oco);
            aVar.fU(5, this.hKN);
            aVar.fU(6, this.obY);
            aVar.d(7, 8, this.och);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fR(1, this.ocl) + 0) + e.a.a.a.R(2, this.ocm)) + e.a.a.a.fR(3, this.ocn)) + e.a.a.a.R(4, this.oco)) + e.a.a.a.fR(5, this.hKN)) + e.a.a.a.fR(6, this.obY)) + e.a.a.a.c(7, 8, this.och);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.och.clear();
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
                g gVar = (g) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        gVar.ocl = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        gVar.ocm = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        gVar.ocn = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        gVar.oco = aVar3.Avy.rz();
                        return 0;
                    case 5:
                        gVar.hKN = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        gVar.obY = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a hVar = new h();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                            }
                            gVar.och.add(hVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
