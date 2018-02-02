package com.tencent.mm.protocal.c;

import d.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ado extends bdf {
    public int kLO;
    public String kLP;
    public b sOJ;
    public String wiF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.kLO);
            if (this.kLP != null) {
                aVar.g(3, this.kLP);
            }
            if (this.sOJ != null) {
                aVar.fW(4, this.sOJ.bke());
                this.sOJ.a(aVar);
            }
            if (this.wiF == null) {
                return 0;
            }
            aVar.g(5, this.wiF);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.kLO);
            if (this.kLP != null) {
                r0 += e.a.a.b.b.a.h(3, this.kLP);
            }
            if (this.sOJ != null) {
                r0 += e.a.a.a.fT(4, this.sOJ.bke());
            }
            if (this.wiF != null) {
                r0 += e.a.a.b.b.a.h(5, this.wiF);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ado com_tencent_mm_protocal_c_ado = (ado) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ado.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ado.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ado.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ado.sOJ = feVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ado.wiF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
