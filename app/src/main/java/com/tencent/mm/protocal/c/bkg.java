package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bkg extends bcv {
    public String vGQ;
    public int wAO;
    public bos wEF;
    public bdn wMW;
    public int wNE;
    public int wNF;
    public int wNG;
    public bke wNH;
    public bdn wNI;
    public String wNJ;
    public kd wNK;
    public int wNL;
    public LinkedList<aqp> wNM = new LinkedList();
    public bjg wNN;
    public int wNf;
    public LinkedList<bdo> wNg = new LinkedList();
    public long wNj;
    public int wNk;
    public LinkedList<bdo> wNl = new LinkedList();
    public int wNm;
    public bkk wNo;
    public bdn wvs;
    public int wyb;
    public LinkedList<bjq> wyh = new LinkedList();
    public LinkedList<bdo> wym = new LinkedList();
    public bkf wyn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wMW == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wMW != null) {
                aVar.fW(2, this.wMW.bke());
                this.wMW.a(aVar);
            }
            aVar.fU(3, this.wNf);
            aVar.d(4, 8, this.wNg);
            aVar.fU(5, this.wNE);
            aVar.fU(6, this.wyb);
            if (this.vGQ != null) {
                aVar.g(7, this.vGQ);
            }
            aVar.fU(8, this.wNF);
            aVar.fU(9, this.wAO);
            aVar.d(10, 8, this.wyh);
            aVar.fU(11, this.wNG);
            aVar.S(12, this.wNj);
            aVar.fU(13, this.wNk);
            aVar.d(14, 8, this.wNl);
            if (this.wEF != null) {
                aVar.fW(15, this.wEF.bke());
                this.wEF.a(aVar);
            }
            aVar.fU(16, this.wNm);
            aVar.d(17, 8, this.wym);
            if (this.wNH != null) {
                aVar.fW(18, this.wNH.bke());
                this.wNH.a(aVar);
            }
            if (this.wyn != null) {
                aVar.fW(19, this.wyn.bke());
                this.wyn.a(aVar);
            }
            if (this.wNo != null) {
                aVar.fW(20, this.wNo.bke());
                this.wNo.a(aVar);
            }
            if (this.wNI != null) {
                aVar.fW(21, this.wNI.bke());
                this.wNI.a(aVar);
            }
            if (this.wNJ != null) {
                aVar.g(22, this.wNJ);
            }
            if (this.wNK != null) {
                aVar.fW(23, this.wNK.bke());
                this.wNK.a(aVar);
            }
            aVar.fU(24, this.wNL);
            aVar.d(25, 8, this.wNM);
            if (this.wNN != null) {
                aVar.fW(26, this.wNN.bke());
                this.wNN.a(aVar);
            }
            if (this.wvs == null) {
                return 0;
            }
            aVar.fW(27, this.wvs.bke());
            this.wvs.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wMW != null) {
                r0 += e.a.a.a.fT(2, this.wMW.bke());
            }
            r0 = (((r0 + e.a.a.a.fR(3, this.wNf)) + e.a.a.a.c(4, 8, this.wNg)) + e.a.a.a.fR(5, this.wNE)) + e.a.a.a.fR(6, this.wyb);
            if (this.vGQ != null) {
                r0 += e.a.a.b.b.a.h(7, this.vGQ);
            }
            r0 = ((((((r0 + e.a.a.a.fR(8, this.wNF)) + e.a.a.a.fR(9, this.wAO)) + e.a.a.a.c(10, 8, this.wyh)) + e.a.a.a.fR(11, this.wNG)) + e.a.a.a.R(12, this.wNj)) + e.a.a.a.fR(13, this.wNk)) + e.a.a.a.c(14, 8, this.wNl);
            if (this.wEF != null) {
                r0 += e.a.a.a.fT(15, this.wEF.bke());
            }
            r0 = (r0 + e.a.a.a.fR(16, this.wNm)) + e.a.a.a.c(17, 8, this.wym);
            if (this.wNH != null) {
                r0 += e.a.a.a.fT(18, this.wNH.bke());
            }
            if (this.wyn != null) {
                r0 += e.a.a.a.fT(19, this.wyn.bke());
            }
            if (this.wNo != null) {
                r0 += e.a.a.a.fT(20, this.wNo.bke());
            }
            if (this.wNI != null) {
                r0 += e.a.a.a.fT(21, this.wNI.bke());
            }
            if (this.wNJ != null) {
                r0 += e.a.a.b.b.a.h(22, this.wNJ);
            }
            if (this.wNK != null) {
                r0 += e.a.a.a.fT(23, this.wNK.bke());
            }
            r0 = (r0 + e.a.a.a.fR(24, this.wNL)) + e.a.a.a.c(25, 8, this.wNM);
            if (this.wNN != null) {
                r0 += e.a.a.a.fT(26, this.wNN.bke());
            }
            if (this.wvs != null) {
                r0 += e.a.a.a.fT(27, this.wvs.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wNg.clear();
            this.wyh.clear();
            this.wNl.clear();
            this.wym.clear();
            this.wNM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wMW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkg com_tencent_mm_protocal_c_bkg = (bkg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wMW = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkg.wNf = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNg.add(fdVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkg.wNE = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkg.wyb = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bkg.vGQ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bkg.wNF = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bkg.wAO = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bjq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wyh.add(fdVar);
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bkg.wNG = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bkg.wNj = aVar3.Avy.rz();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bkg.wNk = aVar3.Avy.ry();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNl.add(fdVar);
                    }
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bos();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wEF = fdVar;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bkg.wNm = aVar3.Avy.ry();
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wym.add(fdVar);
                    }
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bke();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNH = fdVar;
                    }
                    return 0;
                case 19:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bkf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wyn = fdVar;
                    }
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bkk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNo = fdVar;
                    }
                    return 0;
                case 21:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNI = fdVar;
                    }
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bkg.wNJ = aVar3.Avy.readString();
                    return 0;
                case 23:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new kd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNK = fdVar;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bkg.wNL = aVar3.Avy.ry();
                    return 0;
                case 25:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new aqp();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNM.add(fdVar);
                    }
                    return 0;
                case 26:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bjg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wNN = fdVar;
                    }
                    return 0;
                case 27:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkg.wvs = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
