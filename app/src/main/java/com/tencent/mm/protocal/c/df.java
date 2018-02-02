package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class df extends a {
    public int vIn;
    public int vIo;
    public int vIv;
    public dg vIw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vIn);
            aVar.fU(2, this.vIo);
            aVar.fU(3, this.vIv);
            if (this.vIw != null) {
                aVar.fW(4, this.vIw.bke());
                this.vIw.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.vIn) + 0) + e.a.a.a.fR(2, this.vIo)) + e.a.a.a.fR(3, this.vIv);
            if (this.vIw != null) {
                return r0 + e.a.a.a.fT(4, this.vIw.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            df dfVar = (df) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dfVar.vIn = aVar3.Avy.ry();
                    return 0;
                case 2:
                    dfVar.vIo = aVar3.Avy.ry();
                    return 0;
                case 3:
                    dfVar.vIv = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a dgVar = new dg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        dfVar.vIw = dgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
