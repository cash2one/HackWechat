package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ar extends a {
    public String fon;
    public String nfK;
    public String nhm;
    public LinkedList<dl> nhn = new LinkedList();
    public ei nho;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nhm != null) {
                aVar.g(1, this.nhm);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            aVar.d(3, 8, this.nhn);
            if (this.nho != null) {
                aVar.fW(4, this.nho.bke());
                this.nho.a(aVar);
            }
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(5, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.nhm != null) {
                r0 = e.a.a.b.b.a.h(1, this.nhm) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            r0 += e.a.a.a.c(3, 8, this.nhn);
            if (this.nho != null) {
                r0 += e.a.a.a.fT(4, this.nho.bke());
            }
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfK);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nhn.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            ar arVar = (ar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a dlVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    arVar.nhm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    arVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dlVar = new dl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        arVar.nhn.add(dlVar);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dlVar = new ei();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        arVar.nho = dlVar;
                    }
                    return 0;
                case 5:
                    arVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
