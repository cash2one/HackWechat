package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class avi extends a {
    public int ktH;
    public int ktM;
    public String nfp;
    public int nkn;
    public bdn vHV;
    public String vZL;
    public bdn wCY;
    public String war;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.nkn);
            aVar.fU(2, this.ktM);
            if (this.nfp != null) {
                aVar.g(3, this.nfp);
            }
            aVar.fU(4, this.ktH);
            if (this.vHV != null) {
                aVar.fW(5, this.vHV.bke());
                this.vHV.a(aVar);
            }
            if (this.war != null) {
                aVar.g(6, this.war);
            }
            if (this.wCY != null) {
                aVar.fW(7, this.wCY.bke());
                this.wCY.a(aVar);
            }
            if (this.vZL != null) {
                aVar.g(8, this.vZL);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.nkn) + 0) + e.a.a.a.fR(2, this.ktM);
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfp);
            }
            r0 += e.a.a.a.fR(4, this.ktH);
            if (this.vHV != null) {
                r0 += e.a.a.a.fT(5, this.vHV.bke());
            }
            if (this.war != null) {
                r0 += e.a.a.b.b.a.h(6, this.war);
            }
            if (this.wCY != null) {
                r0 += e.a.a.a.fT(7, this.wCY.bke());
            }
            if (this.vZL != null) {
                return r0 + e.a.a.b.b.a.h(8, this.vZL);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            avi com_tencent_mm_protocal_c_avi = (avi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_avi.nkn = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avi.ktM = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avi.nfp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avi.ktH = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avi.vHV = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avi.war = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avi.wCY = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avi.vZL = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
