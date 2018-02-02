package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bnp extends a {
    public int hbg;
    public String ksU;
    public String nGJ;
    public int pbl;
    public at qYu;
    public bzu qYw;
    public String rLO;
    public String rtA;
    public String vmS;
    public String vmT;
    public String wQl;
    public aoy wQm;
    public cu wQn;
    public pb wQo;
    public String wQp;
    public int wQq;
    public int wQr;
    public String wQs;
    public bme wQt;
    public bxv wQu;
    public int wQv;
    public int wxG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nGJ != null) {
                aVar.g(1, this.nGJ);
            }
            if (this.ksU != null) {
                aVar.g(2, this.ksU);
            }
            aVar.fU(3, this.wxG);
            aVar.fU(4, this.pbl);
            if (this.wQl != null) {
                aVar.g(5, this.wQl);
            }
            if (this.wQm != null) {
                aVar.fW(6, this.wQm.bke());
                this.wQm.a(aVar);
            }
            if (this.wQn != null) {
                aVar.fW(7, this.wQn.bke());
                this.wQn.a(aVar);
            }
            if (this.wQo != null) {
                aVar.fW(8, this.wQo.bke());
                this.wQo.a(aVar);
            }
            if (this.vmS != null) {
                aVar.g(9, this.vmS);
            }
            if (this.vmT != null) {
                aVar.g(10, this.vmT);
            }
            if (this.wQp != null) {
                aVar.g(11, this.wQp);
            }
            aVar.fU(12, this.wQq);
            aVar.fU(13, this.wQr);
            if (this.wQs != null) {
                aVar.g(14, this.wQs);
            }
            if (this.qYu != null) {
                aVar.fW(15, this.qYu.bke());
                this.qYu.a(aVar);
            }
            aVar.fU(16, this.hbg);
            if (this.wQt != null) {
                aVar.fW(17, this.wQt.bke());
                this.wQt.a(aVar);
            }
            if (this.rtA != null) {
                aVar.g(18, this.rtA);
            }
            if (this.rLO != null) {
                aVar.g(19, this.rLO);
            }
            if (this.wQu != null) {
                aVar.fW(20, this.wQu.bke());
                this.wQu.a(aVar);
            }
            aVar.fU(21, this.wQv);
            if (this.qYw == null) {
                return 0;
            }
            aVar.fW(22, this.qYw.bke());
            this.qYw.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nGJ != null) {
                r0 = e.a.a.b.b.a.h(1, this.nGJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.wxG)) + e.a.a.a.fR(4, this.pbl);
            if (this.wQl != null) {
                r0 += e.a.a.b.b.a.h(5, this.wQl);
            }
            if (this.wQm != null) {
                r0 += e.a.a.a.fT(6, this.wQm.bke());
            }
            if (this.wQn != null) {
                r0 += e.a.a.a.fT(7, this.wQn.bke());
            }
            if (this.wQo != null) {
                r0 += e.a.a.a.fT(8, this.wQo.bke());
            }
            if (this.vmS != null) {
                r0 += e.a.a.b.b.a.h(9, this.vmS);
            }
            if (this.vmT != null) {
                r0 += e.a.a.b.b.a.h(10, this.vmT);
            }
            if (this.wQp != null) {
                r0 += e.a.a.b.b.a.h(11, this.wQp);
            }
            r0 = (r0 + e.a.a.a.fR(12, this.wQq)) + e.a.a.a.fR(13, this.wQr);
            if (this.wQs != null) {
                r0 += e.a.a.b.b.a.h(14, this.wQs);
            }
            if (this.qYu != null) {
                r0 += e.a.a.a.fT(15, this.qYu.bke());
            }
            r0 += e.a.a.a.fR(16, this.hbg);
            if (this.wQt != null) {
                r0 += e.a.a.a.fT(17, this.wQt.bke());
            }
            if (this.rtA != null) {
                r0 += e.a.a.b.b.a.h(18, this.rtA);
            }
            if (this.rLO != null) {
                r0 += e.a.a.b.b.a.h(19, this.rLO);
            }
            if (this.wQu != null) {
                r0 += e.a.a.a.fT(20, this.wQu.bke());
            }
            r0 += e.a.a.a.fR(21, this.wQv);
            if (this.qYw != null) {
                r0 += e.a.a.a.fT(22, this.qYw.bke());
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
            bnp com_tencent_mm_protocal_c_bnp = (bnp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_aoy;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bnp.nGJ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnp.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnp.wxG = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnp.pbl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bnp.wQl = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoy = new aoy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoy.a(aVar4, com_tencent_mm_protocal_c_aoy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnp.wQm = com_tencent_mm_protocal_c_aoy;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoy = new cu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoy.a(aVar4, com_tencent_mm_protocal_c_aoy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnp.wQn = com_tencent_mm_protocal_c_aoy;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoy = new pb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoy.a(aVar4, com_tencent_mm_protocal_c_aoy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnp.wQo = com_tencent_mm_protocal_c_aoy;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bnp.vmS = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bnp.vmT = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bnp.wQp = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bnp.wQq = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bnp.wQr = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bnp.wQs = aVar3.Avy.readString();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoy = new at();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoy.a(aVar4, com_tencent_mm_protocal_c_aoy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnp.qYu = com_tencent_mm_protocal_c_aoy;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bnp.hbg = aVar3.Avy.ry();
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoy = new bme();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoy.a(aVar4, com_tencent_mm_protocal_c_aoy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnp.wQt = com_tencent_mm_protocal_c_aoy;
                    }
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bnp.rtA = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bnp.rLO = aVar3.Avy.readString();
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoy = new bxv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoy.a(aVar4, com_tencent_mm_protocal_c_aoy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnp.wQu = com_tencent_mm_protocal_c_aoy;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bnp.wQv = aVar3.Avy.ry();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoy = new bzu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoy.a(aVar4, com_tencent_mm_protocal_c_aoy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnp.qYw = com_tencent_mm_protocal_c_aoy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
