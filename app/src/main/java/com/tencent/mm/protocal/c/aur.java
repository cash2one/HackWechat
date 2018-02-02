package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aur extends bcv {
    public int fCy;
    public String oZz;
    public String sIF;
    public String vLI;
    public String vLJ;
    public String wCE;
    public String wCF;
    public int wCG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vLI != null) {
                aVar.g(2, this.vLI);
            }
            if (this.vLJ != null) {
                aVar.g(3, this.vLJ);
            }
            if (this.wCE != null) {
                aVar.g(4, this.wCE);
            }
            if (this.wCF != null) {
                aVar.g(5, this.wCF);
            }
            if (this.sIF != null) {
                aVar.g(6, this.sIF);
            }
            if (this.oZz != null) {
                aVar.g(7, this.oZz);
            }
            aVar.fU(8, this.fCy);
            aVar.fU(9, this.wCG);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vLI != null) {
                r0 += e.a.a.b.b.a.h(2, this.vLI);
            }
            if (this.vLJ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vLJ);
            }
            if (this.wCE != null) {
                r0 += e.a.a.b.b.a.h(4, this.wCE);
            }
            if (this.wCF != null) {
                r0 += e.a.a.b.b.a.h(5, this.wCF);
            }
            if (this.sIF != null) {
                r0 += e.a.a.b.b.a.h(6, this.sIF);
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(7, this.oZz);
            }
            return (r0 + e.a.a.a.fR(8, this.fCy)) + e.a.a.a.fR(9, this.wCG);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aur com_tencent_mm_protocal_c_aur = (aur) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aur.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aur.vLI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aur.vLJ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aur.wCE = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aur.wCF = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aur.sIF = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aur.oZz = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aur.fCy = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aur.wCG = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
