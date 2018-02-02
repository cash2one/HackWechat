package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class cv extends a {
    public LinkedList<b> nju = new LinkedList();
    public di njv;
    public LinkedList<n> njw = new LinkedList();
    public db njx;
    public LinkedList<dv> njy = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nju);
            if (this.njv != null) {
                aVar.fW(2, this.njv.bke());
                this.njv.a(aVar);
            }
            aVar.d(3, 8, this.njw);
            if (this.njx != null) {
                aVar.fW(4, this.njx.bke());
                this.njx.a(aVar);
            }
            aVar.d(5, 8, this.njy);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.nju) + 0;
            if (this.njv != null) {
                r0 += e.a.a.a.fT(2, this.njv.bke());
            }
            r0 += e.a.a.a.c(3, 8, this.njw);
            if (this.njx != null) {
                r0 += e.a.a.a.fT(4, this.njx.bke());
            }
            return r0 + e.a.a.a.c(5, 8, this.njy);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nju.clear();
            this.njw.clear();
            this.njy.clear();
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
            cv cvVar = (cv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a bVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        bVar = new b();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.nju.add(bVar);
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        bVar = new di();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.njv = bVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        bVar = new n();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.njw.add(bVar);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        bVar = new db();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.njx = bVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        bVar = new dv();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.njy.add(bVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
