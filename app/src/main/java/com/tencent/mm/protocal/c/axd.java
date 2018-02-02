package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class axd extends bdf {
    public String kub;
    public int ngq;
    public String wCw;
    public int wEq;
    public int wEr;
    public int wEs;
    public int wjl;
    public int wjm;
    public String wli;

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
            aVar.fU(2, this.wEq);
            aVar.fU(3, this.ngq);
            if (this.wCw != null) {
                aVar.g(4, this.wCw);
            }
            if (this.wli != null) {
                aVar.g(5, this.wli);
            }
            if (this.kub != null) {
                aVar.g(6, this.kub);
            }
            aVar.fU(7, this.wEr);
            aVar.fU(8, this.wjl);
            aVar.fU(9, this.wjm);
            aVar.fU(10, this.wEs);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.wEq)) + e.a.a.a.fR(3, this.ngq);
            if (this.wCw != null) {
                r0 += e.a.a.b.b.a.h(4, this.wCw);
            }
            if (this.wli != null) {
                r0 += e.a.a.b.b.a.h(5, this.wli);
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(6, this.kub);
            }
            return (((r0 + e.a.a.a.fR(7, this.wEr)) + e.a.a.a.fR(8, this.wjl)) + e.a.a.a.fR(9, this.wjm)) + e.a.a.a.fR(10, this.wEs);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            axd com_tencent_mm_protocal_c_axd = (axd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axd.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axd.wEq = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axd.ngq = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axd.wCw = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axd.wli = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axd.kub = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axd.wEr = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axd.wjl = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axd.wjm = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axd.wEs = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
