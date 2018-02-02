package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class aqs extends a {
    public String fGF;
    public int fLD;
    public String fqu;
    public int hkU;
    public String token;
    public String vGQ;
    public String vZK;
    public int wxG;
    public int wya;
    public int wyb;
    public LinkedList<aox> wyc = new LinkedList();
    public LinkedList<bld> wyd = new LinkedList();
    public int wye;
    public long wyf;
    public int wyg;
    public LinkedList<Long> wyh = new LinkedList();
    public int wyi;
    public int wyj;
    public String wyk;
    public int wyl;
    public LinkedList<bdo> wym = new LinkedList();
    public bkf wyn;
    public LinkedList<bkl> wyo = new LinkedList();
    public String wyp;
    public long wyq;
    public String wyr;
    public boolean wys;
    public bjg wyt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wya);
            aVar.fU(2, this.wyb);
            aVar.fU(3, this.wxG);
            if (this.vGQ != null) {
                aVar.g(4, this.vGQ);
            }
            aVar.d(5, 8, this.wyc);
            aVar.d(6, 8, this.wyd);
            aVar.fU(7, this.wye);
            aVar.fU(8, this.hkU);
            aVar.S(9, this.wyf);
            aVar.fU(10, this.wyg);
            aVar.d(11, 3, this.wyh);
            aVar.fU(12, this.wyi);
            aVar.fU(13, this.wyj);
            if (this.token != null) {
                aVar.g(14, this.token);
            }
            if (this.wyk != null) {
                aVar.g(15, this.wyk);
            }
            aVar.fU(16, this.wyl);
            aVar.d(17, 8, this.wym);
            if (this.wyn != null) {
                aVar.fW(18, this.wyn.bke());
                this.wyn.a(aVar);
            }
            if (this.fGF != null) {
                aVar.g(19, this.fGF);
            }
            aVar.d(20, 8, this.wyo);
            if (this.fqu != null) {
                aVar.g(21, this.fqu);
            }
            if (this.wyp != null) {
                aVar.g(22, this.wyp);
            }
            if (this.vZK != null) {
                aVar.g(23, this.vZK);
            }
            aVar.fU(24, this.fLD);
            aVar.S(25, this.wyq);
            if (this.wyr != null) {
                aVar.g(26, this.wyr);
            }
            aVar.al(27, this.wys);
            if (this.wyt != null) {
                aVar.fW(28, this.wyt.bke());
                this.wyt.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.wya) + 0) + e.a.a.a.fR(2, this.wyb)) + e.a.a.a.fR(3, this.wxG);
            if (this.vGQ != null) {
                r0 += e.a.a.b.b.a.h(4, this.vGQ);
            }
            r0 = ((((((((r0 + e.a.a.a.c(5, 8, this.wyc)) + e.a.a.a.c(6, 8, this.wyd)) + e.a.a.a.fR(7, this.wye)) + e.a.a.a.fR(8, this.hkU)) + e.a.a.a.R(9, this.wyf)) + e.a.a.a.fR(10, this.wyg)) + e.a.a.a.c(11, 3, this.wyh)) + e.a.a.a.fR(12, this.wyi)) + e.a.a.a.fR(13, this.wyj);
            if (this.token != null) {
                r0 += e.a.a.b.b.a.h(14, this.token);
            }
            if (this.wyk != null) {
                r0 += e.a.a.b.b.a.h(15, this.wyk);
            }
            r0 = (r0 + e.a.a.a.fR(16, this.wyl)) + e.a.a.a.c(17, 8, this.wym);
            if (this.wyn != null) {
                r0 += e.a.a.a.fT(18, this.wyn.bke());
            }
            if (this.fGF != null) {
                r0 += e.a.a.b.b.a.h(19, this.fGF);
            }
            r0 += e.a.a.a.c(20, 8, this.wyo);
            if (this.fqu != null) {
                r0 += e.a.a.b.b.a.h(21, this.fqu);
            }
            if (this.wyp != null) {
                r0 += e.a.a.b.b.a.h(22, this.wyp);
            }
            if (this.vZK != null) {
                r0 += e.a.a.b.b.a.h(23, this.vZK);
            }
            r0 = (r0 + e.a.a.a.fR(24, this.fLD)) + e.a.a.a.R(25, this.wyq);
            if (this.wyr != null) {
                r0 += e.a.a.b.b.a.h(26, this.wyr);
            }
            r0 += e.a.a.b.b.a.dX(27) + 1;
            if (this.wyt != null) {
                return r0 + e.a.a.a.fT(28, this.wyt.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wyc.clear();
            this.wyd.clear();
            this.wyh.clear();
            this.wym.clear();
            this.wyo.clear();
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
            aqs com_tencent_mm_protocal_c_aqs = (aqs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_aox;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aqs.wya = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqs.wyb = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqs.wxG = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqs.vGQ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aox = new aox();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aox.a(aVar4, com_tencent_mm_protocal_c_aox, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqs.wyc.add(com_tencent_mm_protocal_c_aox);
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aox = new bld();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aox.a(aVar4, com_tencent_mm_protocal_c_aox, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqs.wyd.add(com_tencent_mm_protocal_c_aox);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqs.wye = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqs.hkU = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqs.wyf = aVar3.Avy.rz();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqs.wyg = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqs.wyh.add(Long.valueOf(aVar3.Avy.rz()));
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aqs.wyi = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aqs.wyj = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aqs.token = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aqs.wyk = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aqs.wyl = aVar3.Avy.ry();
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aox = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aox.a(aVar4, com_tencent_mm_protocal_c_aox, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqs.wym.add(com_tencent_mm_protocal_c_aox);
                    }
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aox = new bkf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aox.a(aVar4, com_tencent_mm_protocal_c_aox, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqs.wyn = com_tencent_mm_protocal_c_aox;
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aqs.fGF = aVar3.Avy.readString();
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aox = new bkl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aox.a(aVar4, com_tencent_mm_protocal_c_aox, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqs.wyo.add(com_tencent_mm_protocal_c_aox);
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aqs.fqu = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aqs.wyp = aVar3.Avy.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aqs.vZK = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aqs.fLD = aVar3.Avy.ry();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_aqs.wyq = aVar3.Avy.rz();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_aqs.wyr = aVar3.Avy.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_aqs.wys = aVar3.cJC();
                    return 0;
                case 28:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aox = new bjg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aox.a(aVar4, com_tencent_mm_protocal_c_aox, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqs.wyt = com_tencent_mm_protocal_c_aox;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
