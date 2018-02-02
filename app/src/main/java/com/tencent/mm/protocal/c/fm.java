package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class fm extends bdf {
    public LinkedList<String> vJK = new LinkedList();
    public int vLg;
    public int vLj;
    public LinkedList<rw> vLk = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.vLg);
            aVar.d(3, 1, this.vJK);
            aVar.fU(4, this.vLj);
            aVar.d(5, 8, this.vLk);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.fR(2, this.vLg)) + e.a.a.a.c(3, 1, this.vJK)) + e.a.a.a.fR(4, this.vLj)) + e.a.a.a.c(5, 8, this.vLk);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vJK.clear();
            this.vLk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fm fmVar = (fm) objArr[1];
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
                        fmVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    fmVar.vLg = aVar3.Avy.ry();
                    return 0;
                case 3:
                    fmVar.vJK.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    fmVar.vLj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rw();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        fmVar.vLk.add(feVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
