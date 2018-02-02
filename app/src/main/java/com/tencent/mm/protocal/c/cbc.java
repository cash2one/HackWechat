package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class cbc extends a {
    public int vNa;
    public LinkedList<kr> vYB = new LinkedList();
    public int xar;
    public String xas;
    public String xat;
    public int xau;
    public cy xav;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vNa);
            aVar.fU(2, this.xar);
            if (this.xas != null) {
                aVar.g(3, this.xas);
            }
            if (this.xat != null) {
                aVar.g(4, this.xat);
            }
            aVar.fU(5, this.xau);
            aVar.d(6, 8, this.vYB);
            if (this.xav != null) {
                aVar.fW(7, this.xav.bke());
                this.xav.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.vNa) + 0) + e.a.a.a.fR(2, this.xar);
            if (this.xas != null) {
                r0 += e.a.a.b.b.a.h(3, this.xas);
            }
            if (this.xat != null) {
                r0 += e.a.a.b.b.a.h(4, this.xat);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.xau)) + e.a.a.a.c(6, 8, this.vYB);
            if (this.xav != null) {
                return r0 + e.a.a.a.fT(7, this.xav.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vYB.clear();
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
            cbc com_tencent_mm_protocal_c_cbc = (cbc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a krVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_cbc.vNa = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbc.xar = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cbc.xas = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cbc.xat = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cbc.xau = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        krVar = new kr();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = krVar.a(aVar4, krVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_cbc.vYB.add(krVar);
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        krVar = new cy();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = krVar.a(aVar4, krVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_cbc.xav = krVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
