package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aad extends bcv {
    public String fGU;
    public String fGV;
    public int fGW;
    public String kKY;
    public String vEG;
    public String vEH;
    public int vEI;
    public blp vEK;
    public String wjt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fGU == null) {
                throw new b("Not all required fields were included: card_id");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.fGU != null) {
                aVar.g(2, this.fGU);
            }
            aVar.fU(3, this.fGW);
            if (this.kKY != null) {
                aVar.g(4, this.kKY);
            }
            if (this.fGV != null) {
                aVar.g(5, this.fGV);
            }
            if (this.vEG != null) {
                aVar.g(6, this.vEG);
            }
            if (this.vEH != null) {
                aVar.g(7, this.vEH);
            }
            aVar.fU(8, this.vEI);
            if (this.wjt != null) {
                aVar.g(9, this.wjt);
            }
            if (this.vEK == null) {
                return 0;
            }
            aVar.fW(10, this.vEK.bke());
            this.vEK.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fGU != null) {
                r0 += e.a.a.b.b.a.h(2, this.fGU);
            }
            r0 += e.a.a.a.fR(3, this.fGW);
            if (this.kKY != null) {
                r0 += e.a.a.b.b.a.h(4, this.kKY);
            }
            if (this.fGV != null) {
                r0 += e.a.a.b.b.a.h(5, this.fGV);
            }
            if (this.vEG != null) {
                r0 += e.a.a.b.b.a.h(6, this.vEG);
            }
            if (this.vEH != null) {
                r0 += e.a.a.b.b.a.h(7, this.vEH);
            }
            r0 += e.a.a.a.fR(8, this.vEI);
            if (this.wjt != null) {
                r0 += e.a.a.b.b.a.h(9, this.wjt);
            }
            if (this.vEK != null) {
                r0 += e.a.a.a.fT(10, this.vEK.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fGU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: card_id");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aad com_tencent_mm_protocal_c_aad = (aad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aad.fGU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aad.fGW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aad.kKY = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aad.fGV = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aad.vEG = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aad.vEH = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aad.vEI = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aad.wjt = aVar3.Avy.readString();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new blp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.vEK = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
