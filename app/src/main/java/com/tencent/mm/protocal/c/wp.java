package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class wp extends bdf {
    public String fon;
    public LinkedList<String> wgU = new LinkedList();
    public String wgV;
    public LinkedList<String> wgW = new LinkedList();
    public LinkedList<String> wgX = new LinkedList();
    public LinkedList<wq> wgY = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.wgV == null) {
                throw new b("Not all required fields were included: JsonData");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.fon != null) {
                    aVar.g(2, this.fon);
                }
                aVar.d(3, 1, this.wgU);
                if (this.wgV != null) {
                    aVar.g(4, this.wgV);
                }
                aVar.d(5, 1, this.wgW);
                aVar.d(6, 1, this.wgX);
                aVar.d(7, 8, this.wgY);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            r0 += e.a.a.a.c(3, 1, this.wgU);
            if (this.wgV != null) {
                r0 += e.a.a.b.b.a.h(4, this.wgV);
            }
            return ((r0 + e.a.a.a.c(5, 1, this.wgW)) + e.a.a.a.c(6, 1, this.wgX)) + e.a.a.a.c(7, 8, this.wgY);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wgU.clear();
            this.wgW.clear();
            this.wgX.clear();
            this.wgY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.wgV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: JsonData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wp wpVar = (wp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        wpVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    wpVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    wpVar.wgU.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    wpVar.wgV = aVar3.Avy.readString();
                    return 0;
                case 5:
                    wpVar.wgW.add(aVar3.Avy.readString());
                    return 0;
                case 6:
                    wpVar.wgX.add(aVar3.Avy.readString());
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new wq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        wpVar.wgY.add(feVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
