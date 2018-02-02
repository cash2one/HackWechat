package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ac extends a {
    public int ksA;
    public int ktm;
    public q kuf;
    public p kug;
    public r kuh;
    public s kui;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ksA);
            aVar.fU(2, this.ktm);
            if (this.kuf != null) {
                aVar.fW(3, this.kuf.bke());
                this.kuf.a(aVar);
            }
            if (this.kug != null) {
                aVar.fW(4, this.kug.bke());
                this.kug.a(aVar);
            }
            if (this.kuh != null) {
                aVar.fW(5, this.kuh.bke());
                this.kuh.a(aVar);
            }
            if (this.kui != null) {
                aVar.fW(6, this.kui.bke());
                this.kui.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.ksA) + 0) + e.a.a.a.fR(2, this.ktm);
            if (this.kuf != null) {
                r0 += e.a.a.a.fT(3, this.kuf.bke());
            }
            if (this.kug != null) {
                r0 += e.a.a.a.fT(4, this.kug.bke());
            }
            if (this.kuh != null) {
                r0 += e.a.a.a.fT(5, this.kuh.bke());
            }
            if (this.kui != null) {
                return r0 + e.a.a.a.fT(6, this.kui.bke());
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
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a qVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    acVar.ksA = aVar3.Avy.ry();
                    return 0;
                case 2:
                    acVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        qVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kuf = qVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        qVar = new p();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kug = qVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        qVar = new r();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kuh = qVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        qVar = new s();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kui = qVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
