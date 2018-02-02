package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ait extends bdf {
    public can vVA;
    public int wqb;
    public LinkedList<cbk> wqh = new LinkedList();
    public cbk wqi;
    public String wqj;
    public int wqk;
    public String wql;
    public String wqm;
    public String wqn;
    public String wqo;

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
            if (this.vVA != null) {
                aVar.fW(2, this.vVA.bke());
                this.vVA.a(aVar);
            }
            aVar.d(3, 8, this.wqh);
            if (this.wqi != null) {
                aVar.fW(4, this.wqi.bke());
                this.wqi.a(aVar);
            }
            if (this.wqj != null) {
                aVar.g(5, this.wqj);
            }
            aVar.fU(6, this.wqk);
            if (this.wql != null) {
                aVar.g(7, this.wql);
            }
            if (this.wqm != null) {
                aVar.g(8, this.wqm);
            }
            if (this.wqn != null) {
                aVar.g(9, this.wqn);
            }
            if (this.wqo != null) {
                aVar.g(10, this.wqo);
            }
            aVar.fU(11, this.wqb);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vVA != null) {
                r0 += e.a.a.a.fT(2, this.vVA.bke());
            }
            r0 += e.a.a.a.c(3, 8, this.wqh);
            if (this.wqi != null) {
                r0 += e.a.a.a.fT(4, this.wqi.bke());
            }
            if (this.wqj != null) {
                r0 += e.a.a.b.b.a.h(5, this.wqj);
            }
            r0 += e.a.a.a.fR(6, this.wqk);
            if (this.wql != null) {
                r0 += e.a.a.b.b.a.h(7, this.wql);
            }
            if (this.wqm != null) {
                r0 += e.a.a.b.b.a.h(8, this.wqm);
            }
            if (this.wqn != null) {
                r0 += e.a.a.b.b.a.h(9, this.wqn);
            }
            if (this.wqo != null) {
                r0 += e.a.a.b.b.a.h(10, this.wqo);
            }
            return r0 + e.a.a.a.fR(11, this.wqb);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wqh.clear();
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
            ait com_tencent_mm_protocal_c_ait = (ait) objArr[1];
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
                        com_tencent_mm_protocal_c_ait.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new can();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ait.vVA = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new cbk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ait.wqh.add(feVar);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new cbk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ait.wqi = feVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ait.wqj = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ait.wqk = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ait.wql = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ait.wqm = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ait.wqn = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ait.wqo = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ait.wqb = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
