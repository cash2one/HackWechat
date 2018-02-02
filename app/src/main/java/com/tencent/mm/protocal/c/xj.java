package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xj extends bdf {
    public int waZ;
    public LinkedList<b> wia = new LinkedList();
    public int wib;
    public LinkedList<Integer> wic = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.d(2, 6, this.wia);
            aVar.fU(3, this.wib);
            aVar.fU(4, this.waZ);
            aVar.d(5, 2, this.wic);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.c(2, 6, this.wia)) + e.a.a.a.fR(3, this.wib)) + e.a.a.a.fR(4, this.waZ)) + e.a.a.a.c(5, 2, this.wic);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wia.clear();
            this.wic.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xj xjVar = (xj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xjVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    xjVar.wia.add(aVar3.cJD());
                    return 0;
                case 3:
                    xjVar.wib = aVar3.Avy.ry();
                    return 0;
                case 4:
                    xjVar.waZ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    xjVar.wic.add(Integer.valueOf(aVar3.Avy.ry()));
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
