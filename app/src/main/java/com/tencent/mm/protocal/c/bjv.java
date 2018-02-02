package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bjv extends a {
    public int pbl;
    public LinkedList<bjq> vHz = new LinkedList();
    public String vIy;
    public long vPO;
    public int wAO;
    public bdn wMW;
    public int wMX;
    public int wMY;
    public int wMZ;
    public int wMx;
    public LinkedList<bjk> wNa = new LinkedList();
    public int wNb;
    public int wNc;
    public LinkedList<bjk> wNd = new LinkedList();
    public int wNe;
    public int wNf;
    public LinkedList<bjk> wNg = new LinkedList();
    public int wNh;
    public String wNi;
    public long wNj;
    public int wNk;
    public LinkedList<bdo> wNl = new LinkedList();
    public int wNm;
    public bdn wNn;
    public bkk wNo;
    public axr wNp;
    public bjg wNq;
    public String wvW;
    public LinkedList<bdo> wym = new LinkedList();
    public int wzr;
    public int wzw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMW == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.S(1, this.vPO);
            if (this.vIy != null) {
                aVar.g(2, this.vIy);
            }
            if (this.wvW != null) {
                aVar.g(3, this.wvW);
            }
            aVar.fU(4, this.pbl);
            if (this.wMW != null) {
                aVar.fW(5, this.wMW.bke());
                this.wMW.a(aVar);
            }
            aVar.fU(6, this.wMX);
            aVar.fU(7, this.wMY);
            aVar.fU(8, this.wMZ);
            aVar.d(9, 8, this.wNa);
            aVar.fU(10, this.wNb);
            aVar.fU(11, this.wNc);
            aVar.d(12, 8, this.wNd);
            aVar.fU(13, this.wNe);
            aVar.fU(14, this.wNf);
            aVar.d(15, 8, this.wNg);
            aVar.fU(16, this.wzw);
            aVar.fU(17, this.wNh);
            aVar.fU(18, this.wAO);
            aVar.d(19, 8, this.vHz);
            aVar.fU(20, this.wMx);
            if (this.wNi != null) {
                aVar.g(21, this.wNi);
            }
            aVar.S(22, this.wNj);
            aVar.fU(23, this.wNk);
            aVar.d(24, 8, this.wNl);
            aVar.fU(25, this.wzr);
            aVar.fU(26, this.wNm);
            aVar.d(27, 8, this.wym);
            if (this.wNn != null) {
                aVar.fW(28, this.wNn.bke());
                this.wNn.a(aVar);
            }
            if (this.wNo != null) {
                aVar.fW(29, this.wNo.bke());
                this.wNo.a(aVar);
            }
            if (this.wNp != null) {
                aVar.fW(30, this.wNp.bke());
                this.wNp.a(aVar);
            }
            if (this.wNq != null) {
                aVar.fW(31, this.wNq.bke());
                this.wNq.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.vPO) + 0;
            if (this.vIy != null) {
                r0 += e.a.a.b.b.a.h(2, this.vIy);
            }
            if (this.wvW != null) {
                r0 += e.a.a.b.b.a.h(3, this.wvW);
            }
            r0 += e.a.a.a.fR(4, this.pbl);
            if (this.wMW != null) {
                r0 += e.a.a.a.fT(5, this.wMW.bke());
            }
            r0 = ((((((((((((((r0 + e.a.a.a.fR(6, this.wMX)) + e.a.a.a.fR(7, this.wMY)) + e.a.a.a.fR(8, this.wMZ)) + e.a.a.a.c(9, 8, this.wNa)) + e.a.a.a.fR(10, this.wNb)) + e.a.a.a.fR(11, this.wNc)) + e.a.a.a.c(12, 8, this.wNd)) + e.a.a.a.fR(13, this.wNe)) + e.a.a.a.fR(14, this.wNf)) + e.a.a.a.c(15, 8, this.wNg)) + e.a.a.a.fR(16, this.wzw)) + e.a.a.a.fR(17, this.wNh)) + e.a.a.a.fR(18, this.wAO)) + e.a.a.a.c(19, 8, this.vHz)) + e.a.a.a.fR(20, this.wMx);
            if (this.wNi != null) {
                r0 += e.a.a.b.b.a.h(21, this.wNi);
            }
            r0 = (((((r0 + e.a.a.a.R(22, this.wNj)) + e.a.a.a.fR(23, this.wNk)) + e.a.a.a.c(24, 8, this.wNl)) + e.a.a.a.fR(25, this.wzr)) + e.a.a.a.fR(26, this.wNm)) + e.a.a.a.c(27, 8, this.wym);
            if (this.wNn != null) {
                r0 += e.a.a.a.fT(28, this.wNn.bke());
            }
            if (this.wNo != null) {
                r0 += e.a.a.a.fT(29, this.wNo.bke());
            }
            if (this.wNp != null) {
                r0 += e.a.a.a.fT(30, this.wNp.bke());
            }
            if (this.wNq != null) {
                return r0 + e.a.a.a.fT(31, this.wNq.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wNa.clear();
            this.wNd.clear();
            this.wNg.clear();
            this.vHz.clear();
            this.wNl.clear();
            this.wym.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
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
            bjv com_tencent_mm_protocal_c_bjv = (bjv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bjv.vPO = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjv.vIy = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjv.wvW = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjv.pbl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wMW = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjv.wMX = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjv.wMY = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bjv.wMZ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bjk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNa.add(com_tencent_mm_protocal_c_bdn);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bjv.wNb = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bjv.wNc = aVar3.Avy.ry();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bjk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNd.add(com_tencent_mm_protocal_c_bdn);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bjv.wNe = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bjv.wNf = aVar3.Avy.ry();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bjk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNg.add(com_tencent_mm_protocal_c_bdn);
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bjv.wzw = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bjv.wNh = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bjv.wAO = aVar3.Avy.ry();
                    return 0;
                case 19:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bjq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.vHz.add(com_tencent_mm_protocal_c_bdn);
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bjv.wMx = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bjv.wNi = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bjv.wNj = aVar3.Avy.rz();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bjv.wNk = aVar3.Avy.ry();
                    return 0;
                case 24:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNl.add(com_tencent_mm_protocal_c_bdn);
                    }
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bjv.wzr = aVar3.Avy.ry();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bjv.wNm = aVar3.Avy.ry();
                    return 0;
                case 27:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wym.add(com_tencent_mm_protocal_c_bdn);
                    }
                    return 0;
                case 28:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNn = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 29:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bkk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNo = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 30:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new axr();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNp = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 31:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bjg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjv.wNq = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
