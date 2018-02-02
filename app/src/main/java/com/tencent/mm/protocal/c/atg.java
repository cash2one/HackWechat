package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class atg extends bdf {
    public String ksU;
    public int ktm;
    public int lOd;
    public String lOf;
    public String vDZ;
    public int vFA;
    public String vFB;
    public String vFs;
    public int vFv;
    public String vFy;
    public String vFz;
    public String vJh;
    public bin vJk;
    public int vJp;
    public aki vMq;
    public il vMr;
    public asx vMs;
    public jp vSD;
    public jp vSE;
    public jp vSF;
    public String wBf;
    public int wBg;
    public String wBh;
    public int wBi;
    public axi wBj;
    public int wBk;
    public String wBl;
    public String wBm;
    public bfl wBn;
    public String wnK;
    public bdn wnN;

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
            aVar.fU(2, this.lOd);
            if (this.vDZ != null) {
                aVar.g(3, this.vDZ);
            }
            if (this.vFy != null) {
                aVar.g(4, this.vFy);
            }
            if (this.vFz != null) {
                aVar.g(5, this.vFz);
            }
            if (this.wBf != null) {
                aVar.g(6, this.wBf);
            }
            if (this.vFs != null) {
                aVar.g(7, this.vFs);
            }
            aVar.fU(8, this.vFA);
            aVar.fU(9, this.wBg);
            if (this.wBh != null) {
                aVar.g(10, this.wBh);
            }
            if (this.vMr != null) {
                aVar.fW(14, this.vMr.bke());
                this.vMr.a(aVar);
            }
            if (this.vFB != null) {
                aVar.g(15, this.vFB);
            }
            if (this.ksU != null) {
                aVar.g(16, this.ksU);
            }
            aVar.fU(17, this.ktm);
            if (this.vMs != null) {
                aVar.fW(18, this.vMs.bke());
                this.vMs.a(aVar);
            }
            aVar.fU(19, this.wBi);
            aVar.fU(20, this.vFv);
            if (this.vJh != null) {
                aVar.g(21, this.vJh);
            }
            if (this.wBj != null) {
                aVar.fW(22, this.wBj.bke());
                this.wBj.a(aVar);
            }
            if (this.lOf != null) {
                aVar.g(23, this.lOf);
            }
            aVar.fU(24, this.wBk);
            if (this.vMq != null) {
                aVar.fW(25, this.vMq.bke());
                this.vMq.a(aVar);
            }
            if (this.wBl != null) {
                aVar.g(26, this.wBl);
            }
            if (this.vSD != null) {
                aVar.fW(27, this.vSD.bke());
                this.vSD.a(aVar);
            }
            if (this.wBm != null) {
                aVar.g(28, this.wBm);
            }
            if (this.wnK != null) {
                aVar.g(29, this.wnK);
            }
            if (this.wnN != null) {
                aVar.fW(30, this.wnN.bke());
                this.wnN.a(aVar);
            }
            if (this.vJk != null) {
                aVar.fW(31, this.vJk.bke());
                this.vJk.a(aVar);
            }
            if (this.vSE != null) {
                aVar.fW(32, this.vSE.bke());
                this.vSE.a(aVar);
            }
            if (this.vSF != null) {
                aVar.fW(33, this.vSF.bke());
                this.vSF.a(aVar);
            }
            if (this.wBn != null) {
                aVar.fW(34, this.wBn.bke());
                this.wBn.a(aVar);
            }
            aVar.fU(35, this.vJp);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.lOd);
            if (this.vDZ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vDZ);
            }
            if (this.vFy != null) {
                r0 += e.a.a.b.b.a.h(4, this.vFy);
            }
            if (this.vFz != null) {
                r0 += e.a.a.b.b.a.h(5, this.vFz);
            }
            if (this.wBf != null) {
                r0 += e.a.a.b.b.a.h(6, this.wBf);
            }
            if (this.vFs != null) {
                r0 += e.a.a.b.b.a.h(7, this.vFs);
            }
            r0 = (r0 + e.a.a.a.fR(8, this.vFA)) + e.a.a.a.fR(9, this.wBg);
            if (this.wBh != null) {
                r0 += e.a.a.b.b.a.h(10, this.wBh);
            }
            if (this.vMr != null) {
                r0 += e.a.a.a.fT(14, this.vMr.bke());
            }
            if (this.vFB != null) {
                r0 += e.a.a.b.b.a.h(15, this.vFB);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(16, this.ksU);
            }
            r0 += e.a.a.a.fR(17, this.ktm);
            if (this.vMs != null) {
                r0 += e.a.a.a.fT(18, this.vMs.bke());
            }
            r0 = (r0 + e.a.a.a.fR(19, this.wBi)) + e.a.a.a.fR(20, this.vFv);
            if (this.vJh != null) {
                r0 += e.a.a.b.b.a.h(21, this.vJh);
            }
            if (this.wBj != null) {
                r0 += e.a.a.a.fT(22, this.wBj.bke());
            }
            if (this.lOf != null) {
                r0 += e.a.a.b.b.a.h(23, this.lOf);
            }
            r0 += e.a.a.a.fR(24, this.wBk);
            if (this.vMq != null) {
                r0 += e.a.a.a.fT(25, this.vMq.bke());
            }
            if (this.wBl != null) {
                r0 += e.a.a.b.b.a.h(26, this.wBl);
            }
            if (this.vSD != null) {
                r0 += e.a.a.a.fT(27, this.vSD.bke());
            }
            if (this.wBm != null) {
                r0 += e.a.a.b.b.a.h(28, this.wBm);
            }
            if (this.wnK != null) {
                r0 += e.a.a.b.b.a.h(29, this.wnK);
            }
            if (this.wnN != null) {
                r0 += e.a.a.a.fT(30, this.wnN.bke());
            }
            if (this.vJk != null) {
                r0 += e.a.a.a.fT(31, this.vJk.bke());
            }
            if (this.vSE != null) {
                r0 += e.a.a.a.fT(32, this.vSE.bke());
            }
            if (this.vSF != null) {
                r0 += e.a.a.a.fT(33, this.vSF.bke());
            }
            if (this.wBn != null) {
                r0 += e.a.a.a.fT(34, this.wBn.bke());
            }
            return r0 + e.a.a.a.fR(35, this.vJp);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
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
            atg com_tencent_mm_protocal_c_atg = (atg) objArr[1];
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
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atg.lOd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_atg.vDZ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_atg.vFy = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_atg.vFz = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_atg.wBf = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_atg.vFs = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_atg.vFA = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_atg.wBg = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_atg.wBh = aVar3.Avy.readString();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new il();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.vMr = feVar;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_atg.vFB = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_atg.ksU = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_atg.ktm = aVar3.Avy.ry();
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new asx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.vMs = feVar;
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_atg.wBi = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_atg.vFv = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_atg.vJh = aVar3.Avy.readString();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new axi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.wBj = feVar;
                    }
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_atg.lOf = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_atg.wBk = aVar3.Avy.ry();
                    return 0;
                case 25:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new aki();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.vMq = feVar;
                    }
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_atg.wBl = aVar3.Avy.readString();
                    return 0;
                case 27:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.vSD = feVar;
                    }
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_atg.wBm = aVar3.Avy.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_atg.wnK = aVar3.Avy.readString();
                    return 0;
                case 30:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.wnN = feVar;
                    }
                    return 0;
                case 31:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bin();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.vJk = feVar;
                    }
                    return 0;
                case 32:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.vSE = feVar;
                    }
                    return 0;
                case 33:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.vSF = feVar;
                    }
                    return 0;
                case 34:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bfl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atg.wBn = feVar;
                    }
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_atg.vJp = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
