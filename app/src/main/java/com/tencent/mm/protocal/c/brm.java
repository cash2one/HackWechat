package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class brm extends a {
    public String fWD;
    public String hvD;
    public int vFx;
    public aor vHl;
    public String vLO;
    public bdr vMv;
    public String vUU;
    public String vUV;
    public String wST;
    public String wSU;
    public int wSV;
    public int wSW;
    public int wSX;
    public String wSY;
    public int wSZ;
    public bdo wTa;
    public int wTb;
    public String wTc;
    public String wTd;
    public String wTe;
    public String wTf;
    public String wTg;
    public avl wTh;
    public String wTi;
    public int wTj;
    public long wTk;
    public String wTl;
    public int whI;
    public bla wvl;
    public String wzj;
    public String wzk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wvl == null) {
                throw new b("Not all required fields were included: SnsUserInfo");
            }
            if (this.wvl != null) {
                aVar.fW(1, this.wvl.bke());
                this.wvl.a(aVar);
            }
            if (this.hvD != null) {
                aVar.g(2, this.hvD);
            }
            if (this.wST != null) {
                aVar.g(3, this.wST);
            }
            if (this.wSU != null) {
                aVar.g(4, this.wSU);
            }
            aVar.fU(5, this.wSV);
            aVar.fU(6, this.wSW);
            aVar.fU(7, this.wSX);
            if (this.wSY != null) {
                aVar.g(8, this.wSY);
            }
            if (this.vUU != null) {
                aVar.g(9, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(10, this.vUV);
            }
            aVar.fU(11, this.wSZ);
            if (this.wTa != null) {
                aVar.fW(12, this.wTa.bke());
                this.wTa.a(aVar);
            }
            if (this.vMv != null) {
                aVar.fW(13, this.vMv.bke());
                this.vMv.a(aVar);
            }
            aVar.fU(14, this.vFx);
            aVar.fU(15, this.wTb);
            if (this.vLO != null) {
                aVar.g(16, this.vLO);
            }
            if (this.wzj != null) {
                aVar.g(17, this.wzj);
            }
            if (this.wzk != null) {
                aVar.g(18, this.wzk);
            }
            if (this.wTc != null) {
                aVar.g(19, this.wTc);
            }
            if (this.wTd != null) {
                aVar.g(20, this.wTd);
            }
            if (this.wTe != null) {
                aVar.g(21, this.wTe);
            }
            if (this.wTf != null) {
                aVar.g(22, this.wTf);
            }
            if (this.vHl != null) {
                aVar.fW(23, this.vHl.bke());
                this.vHl.a(aVar);
            }
            if (this.wTg != null) {
                aVar.g(24, this.wTg);
            }
            if (this.wTh != null) {
                aVar.fW(25, this.wTh.bke());
                this.wTh.a(aVar);
            }
            if (this.wTi != null) {
                aVar.g(26, this.wTi);
            }
            aVar.fU(27, this.wTj);
            if (this.fWD != null) {
                aVar.g(28, this.fWD);
            }
            aVar.fU(29, this.whI);
            aVar.S(30, this.wTk);
            if (this.wTl == null) {
                return 0;
            }
            aVar.g(31, this.wTl);
            return 0;
        } else if (i == 1) {
            if (this.wvl != null) {
                r0 = e.a.a.a.fT(1, this.wvl.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.hvD != null) {
                r0 += e.a.a.b.b.a.h(2, this.hvD);
            }
            if (this.wST != null) {
                r0 += e.a.a.b.b.a.h(3, this.wST);
            }
            if (this.wSU != null) {
                r0 += e.a.a.b.b.a.h(4, this.wSU);
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.wSV)) + e.a.a.a.fR(6, this.wSW)) + e.a.a.a.fR(7, this.wSX);
            if (this.wSY != null) {
                r0 += e.a.a.b.b.a.h(8, this.wSY);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(9, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(10, this.vUV);
            }
            r0 += e.a.a.a.fR(11, this.wSZ);
            if (this.wTa != null) {
                r0 += e.a.a.a.fT(12, this.wTa.bke());
            }
            if (this.vMv != null) {
                r0 += e.a.a.a.fT(13, this.vMv.bke());
            }
            r0 = (r0 + e.a.a.a.fR(14, this.vFx)) + e.a.a.a.fR(15, this.wTb);
            if (this.vLO != null) {
                r0 += e.a.a.b.b.a.h(16, this.vLO);
            }
            if (this.wzj != null) {
                r0 += e.a.a.b.b.a.h(17, this.wzj);
            }
            if (this.wzk != null) {
                r0 += e.a.a.b.b.a.h(18, this.wzk);
            }
            if (this.wTc != null) {
                r0 += e.a.a.b.b.a.h(19, this.wTc);
            }
            if (this.wTd != null) {
                r0 += e.a.a.b.b.a.h(20, this.wTd);
            }
            if (this.wTe != null) {
                r0 += e.a.a.b.b.a.h(21, this.wTe);
            }
            if (this.wTf != null) {
                r0 += e.a.a.b.b.a.h(22, this.wTf);
            }
            if (this.vHl != null) {
                r0 += e.a.a.a.fT(23, this.vHl.bke());
            }
            if (this.wTg != null) {
                r0 += e.a.a.b.b.a.h(24, this.wTg);
            }
            if (this.wTh != null) {
                r0 += e.a.a.a.fT(25, this.wTh.bke());
            }
            if (this.wTi != null) {
                r0 += e.a.a.b.b.a.h(26, this.wTi);
            }
            r0 += e.a.a.a.fR(27, this.wTj);
            if (this.fWD != null) {
                r0 += e.a.a.b.b.a.h(28, this.fWD);
            }
            r0 = (r0 + e.a.a.a.fR(29, this.whI)) + e.a.a.a.R(30, this.wTk);
            if (this.wTl != null) {
                r0 += e.a.a.b.b.a.h(31, this.wTl);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wvl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsUserInfo");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brm com_tencent_mm_protocal_c_brm = (brm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bla;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bla = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bla.a(aVar4, com_tencent_mm_protocal_c_bla, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brm.wvl = com_tencent_mm_protocal_c_bla;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brm.hvD = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_brm.wST = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_brm.wSU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_brm.wSV = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_brm.wSW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_brm.wSX = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_brm.wSY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_brm.vUU = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_brm.vUV = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_brm.wSZ = aVar3.Avy.ry();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bla = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bla.a(aVar4, com_tencent_mm_protocal_c_bla, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brm.wTa = com_tencent_mm_protocal_c_bla;
                    }
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bla = new bdr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bla.a(aVar4, com_tencent_mm_protocal_c_bla, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brm.vMv = com_tencent_mm_protocal_c_bla;
                    }
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_brm.vFx = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_brm.wTb = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_brm.vLO = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_brm.wzj = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_brm.wzk = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_brm.wTc = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_brm.wTd = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_brm.wTe = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_brm.wTf = aVar3.Avy.readString();
                    return 0;
                case 23:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bla = new aor();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bla.a(aVar4, com_tencent_mm_protocal_c_bla, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brm.vHl = com_tencent_mm_protocal_c_bla;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_brm.wTg = aVar3.Avy.readString();
                    return 0;
                case 25:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bla = new avl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bla.a(aVar4, com_tencent_mm_protocal_c_bla, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brm.wTh = com_tencent_mm_protocal_c_bla;
                    }
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_brm.wTi = aVar3.Avy.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_brm.wTj = aVar3.Avy.ry();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_brm.fWD = aVar3.Avy.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_brm.whI = aVar3.Avy.ry();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_brm.wTk = aVar3.Avy.rz();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_brm.wTl = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
