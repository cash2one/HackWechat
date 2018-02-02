package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class cg extends a {
    public cu nfB;
    public String nfg;
    public String nfn;
    public String niY;
    public String niZ;
    public String nja;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfn != null) {
                aVar.g(1, this.nfn);
            }
            if (this.niY != null) {
                aVar.g(2, this.niY);
            }
            if (this.niZ != null) {
                aVar.g(3, this.niZ);
            }
            if (this.nja != null) {
                aVar.g(4, this.nja);
            }
            if (this.nfB != null) {
                aVar.fW(5, this.nfB.bke());
                this.nfB.a(aVar);
            }
            if (this.nfg == null) {
                return 0;
            }
            aVar.g(6, this.nfg);
            return 0;
        } else if (i == 1) {
            if (this.nfn != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfn) + 0;
            } else {
                r0 = 0;
            }
            if (this.niY != null) {
                r0 += e.a.a.b.b.a.h(2, this.niY);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(3, this.niZ);
            }
            if (this.nja != null) {
                r0 += e.a.a.b.b.a.h(4, this.nja);
            }
            if (this.nfB != null) {
                r0 += e.a.a.a.fT(5, this.nfB.bke());
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfg);
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
            cg cgVar = (cg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cgVar.niY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cgVar.niZ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cgVar.nja = aVar3.Avy.readString();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a cuVar = new cu();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cuVar.a(aVar4, cuVar, a.a(aVar4))) {
                        }
                        cgVar.nfB = cuVar;
                    }
                    return 0;
                case 6:
                    cgVar.nfg = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
