package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class hn extends a {
    public hq vNt;
    public String vNu;
    public String vNv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNt != null) {
                aVar.fW(1, this.vNt.bke());
                this.vNt.a(aVar);
            }
            if (this.vNu != null) {
                aVar.g(2, this.vNu);
            }
            if (this.vNv == null) {
                return 0;
            }
            aVar.g(3, this.vNv);
            return 0;
        } else if (i == 1) {
            if (this.vNt != null) {
                r0 = e.a.a.a.fT(1, this.vNt.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vNu != null) {
                r0 += e.a.a.b.b.a.h(2, this.vNu);
            }
            if (this.vNv != null) {
                r0 += e.a.a.b.b.a.h(3, this.vNv);
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
            hn hnVar = (hn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a hqVar = new hq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hqVar.a(aVar4, hqVar, a.a(aVar4))) {
                        }
                        hnVar.vNt = hqVar;
                    }
                    return 0;
                case 2:
                    hnVar.vNu = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hnVar.vNv = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
