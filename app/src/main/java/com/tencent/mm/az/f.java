package com.tencent.mm.az;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class f extends a {
    public double hJA;
    public LinkedList<d> hJz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.hJz);
            aVar.b(2, this.hJA);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.hJz) + 0) + (e.a.a.b.b.a.dX(2) + 8);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.hJz.clear();
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
                f fVar = (f) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a dVar = new d();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                            }
                            fVar.hJz.add(dVar);
                        }
                        return 0;
                    case 2:
                        fVar.hJA = aVar3.Avy.readDouble();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
