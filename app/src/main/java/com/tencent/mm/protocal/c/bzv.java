package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class bzv extends a {
    public String lOo;
    public int rYW;
    public bnb tjZ;
    public int vNW;
    public long vPp;
    public String vPs;
    public int wIL;
    public LinkedList<bro> wKb = new LinkedList();
    public int wYd;
    public int wYe = 2;
    public String wYh;
    public axj wZA;
    public int wZl;
    public LinkedList<or> wZm = new LinkedList();
    public String wZr;
    public String wZs;
    public int wZt;
    public LinkedList<String> wZu = new LinkedList();
    public LinkedList<atl> wZv = new LinkedList();
    public b wZw;
    public b wZx;
    public bjn wZy;
    public ps wZz;
    public String wgS;
    public aoh wwI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgS == null) {
                throw new e.a.a.b("Not all required fields were included: Keyword");
            }
            aVar.fU(1, this.wIL);
            if (this.wgS != null) {
                aVar.g(2, this.wgS);
            }
            aVar.fU(3, this.vNW);
            aVar.S(4, this.vPp);
            aVar.fU(5, this.wYd);
            if (this.wwI != null) {
                aVar.fW(6, this.wwI.bke());
                this.wwI.a(aVar);
            }
            aVar.d(7, 8, this.wKb);
            aVar.fU(8, this.rYW);
            if (this.vPs != null) {
                aVar.g(9, this.vPs);
            }
            aVar.fU(10, this.wZl);
            if (this.wZr != null) {
                aVar.g(11, this.wZr);
            }
            if (this.wZs != null) {
                aVar.g(12, this.wZs);
            }
            aVar.fU(13, this.wZt);
            aVar.d(14, 1, this.wZu);
            aVar.fU(15, this.wYe);
            if (this.tjZ != null) {
                aVar.fW(16, this.tjZ.bke());
                this.tjZ.a(aVar);
            }
            aVar.d(17, 8, this.wZm);
            aVar.d(18, 8, this.wZv);
            if (this.lOo != null) {
                aVar.g(19, this.lOo);
            }
            if (this.wZw != null) {
                aVar.b(20, this.wZw);
            }
            if (this.wYh != null) {
                aVar.g(21, this.wYh);
            }
            if (this.wZx != null) {
                aVar.b(22, this.wZx);
            }
            if (this.wZy != null) {
                aVar.fW(23, this.wZy.bke());
                this.wZy.a(aVar);
            }
            if (this.wZz != null) {
                aVar.fW(24, this.wZz.bke());
                this.wZz.a(aVar);
            }
            if (this.wZA != null) {
                aVar.fW(25, this.wZA.bke());
                this.wZA.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wIL) + 0;
            if (this.wgS != null) {
                r0 += e.a.a.b.b.a.h(2, this.wgS);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.vNW)) + e.a.a.a.R(4, this.vPp)) + e.a.a.a.fR(5, this.wYd);
            if (this.wwI != null) {
                r0 += e.a.a.a.fT(6, this.wwI.bke());
            }
            r0 = (r0 + e.a.a.a.c(7, 8, this.wKb)) + e.a.a.a.fR(8, this.rYW);
            if (this.vPs != null) {
                r0 += e.a.a.b.b.a.h(9, this.vPs);
            }
            r0 += e.a.a.a.fR(10, this.wZl);
            if (this.wZr != null) {
                r0 += e.a.a.b.b.a.h(11, this.wZr);
            }
            if (this.wZs != null) {
                r0 += e.a.a.b.b.a.h(12, this.wZs);
            }
            r0 = ((r0 + e.a.a.a.fR(13, this.wZt)) + e.a.a.a.c(14, 1, this.wZu)) + e.a.a.a.fR(15, this.wYe);
            if (this.tjZ != null) {
                r0 += e.a.a.a.fT(16, this.tjZ.bke());
            }
            r0 = (r0 + e.a.a.a.c(17, 8, this.wZm)) + e.a.a.a.c(18, 8, this.wZv);
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(19, this.lOo);
            }
            if (this.wZw != null) {
                r0 += e.a.a.a.a(20, this.wZw);
            }
            if (this.wYh != null) {
                r0 += e.a.a.b.b.a.h(21, this.wYh);
            }
            if (this.wZx != null) {
                r0 += e.a.a.a.a(22, this.wZx);
            }
            if (this.wZy != null) {
                r0 += e.a.a.a.fT(23, this.wZy.bke());
            }
            if (this.wZz != null) {
                r0 += e.a.a.a.fT(24, this.wZz.bke());
            }
            if (this.wZA != null) {
                return r0 + e.a.a.a.fT(25, this.wZA.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wKb.clear();
            this.wZu.clear();
            this.wZm.clear();
            this.wZv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wgS != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Keyword");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzv com_tencent_mm_protocal_c_bzv = (bzv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_aoh;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bzv.wIL = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzv.wgS = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzv.vNW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzv.vPp = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bzv.wYd = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new aoh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.wwI = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new bro();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.wKb.add(com_tencent_mm_protocal_c_aoh);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bzv.rYW = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bzv.vPs = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bzv.wZl = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bzv.wZr = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bzv.wZs = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bzv.wZt = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bzv.wZu.add(aVar3.Avy.readString());
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bzv.wYe = aVar3.Avy.ry();
                    return 0;
                case 16:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new bnb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.tjZ = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new or();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.wZm.add(com_tencent_mm_protocal_c_aoh);
                    }
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new atl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.wZv.add(com_tencent_mm_protocal_c_aoh);
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bzv.lOo = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bzv.wZw = aVar3.cJD();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bzv.wYh = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bzv.wZx = aVar3.cJD();
                    return 0;
                case 23:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new bjn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.wZy = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 24:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new ps();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.wZz = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 25:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aoh = new axj();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzv.wZA = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
