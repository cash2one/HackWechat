package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agh extends bcv {
    public String kub;
    public String lOo;
    public String vJz;
    public bdn vMi;
    public String wnH;
    public String wnI;
    public String wnJ;
    public String wnK;
    public String wnL;
    public int wnM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vMi == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vMi != null) {
                aVar.fW(2, this.vMi.bke());
                this.vMi.a(aVar);
            }
            if (this.wnH != null) {
                aVar.g(3, this.wnH);
            }
            if (this.wnI != null) {
                aVar.g(4, this.wnI);
            }
            if (this.kub != null) {
                aVar.g(5, this.kub);
            }
            if (this.wnJ != null) {
                aVar.g(6, this.wnJ);
            }
            if (this.wnK != null) {
                aVar.g(7, this.wnK);
            }
            if (this.wnL != null) {
                aVar.g(8, this.wnL);
            }
            aVar.fU(9, this.wnM);
            if (this.lOo != null) {
                aVar.g(10, this.lOo);
            }
            if (this.vJz == null) {
                return 0;
            }
            aVar.g(11, this.vJz);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vMi != null) {
                r0 += e.a.a.a.fT(2, this.vMi.bke());
            }
            if (this.wnH != null) {
                r0 += e.a.a.b.b.a.h(3, this.wnH);
            }
            if (this.wnI != null) {
                r0 += e.a.a.b.b.a.h(4, this.wnI);
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(5, this.kub);
            }
            if (this.wnJ != null) {
                r0 += e.a.a.b.b.a.h(6, this.wnJ);
            }
            if (this.wnK != null) {
                r0 += e.a.a.b.b.a.h(7, this.wnK);
            }
            if (this.wnL != null) {
                r0 += e.a.a.b.b.a.h(8, this.wnL);
            }
            r0 += e.a.a.a.fR(9, this.wnM);
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(10, this.lOo);
            }
            if (this.vJz != null) {
                r0 += e.a.a.b.b.a.h(11, this.vJz);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vMi != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agh com_tencent_mm_protocal_c_agh = (agh) objArr[1];
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
                        com_tencent_mm_protocal_c_agh.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agh.vMi = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agh.wnH = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agh.wnI = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agh.kub = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agh.wnJ = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agh.wnK = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agh.wnL = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agh.wnM = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_agh.lOo = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_agh.vJz = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
