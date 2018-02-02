package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public class aoe extends a {
    public String hvC;
    public String hvD;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public String hvy;
    public String ksU;
    public String kub;
    public int vHa;
    public String vUU;
    public String vUV;
    public String whR;
    public String wnL;
    public String wve;
    public int wvf;
    public String wvg;
    public String wvh;
    public String wvi;
    public int wvj;
    public int wvk;
    public bla wvl;
    public pq wvm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            if (this.hvu != null) {
                aVar.g(3, this.hvu);
            }
            if (this.hvv != null) {
                aVar.g(4, this.hvv);
            }
            if (this.hvw != null) {
                aVar.g(5, this.hvw);
            }
            if (this.wve != null) {
                aVar.g(6, this.wve);
            }
            aVar.fU(7, this.hvt);
            aVar.fU(8, this.vHa);
            aVar.fU(9, this.wvf);
            if (this.wvg != null) {
                aVar.g(10, this.wvg);
            }
            if (this.wnL != null) {
                aVar.g(11, this.wnL);
            }
            if (this.hvy != null) {
                aVar.g(12, this.hvy);
            }
            if (this.wvh != null) {
                aVar.g(13, this.wvh);
            }
            if (this.wvi != null) {
                aVar.g(14, this.wvi);
            }
            aVar.fU(15, this.wvj);
            aVar.fU(19, this.wvk);
            if (this.wvl != null) {
                aVar.fW(20, this.wvl.bke());
                this.wvl.a(aVar);
            }
            if (this.hvC != null) {
                aVar.g(21, this.hvC);
            }
            if (this.vUU != null) {
                aVar.g(22, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(23, this.vUV);
            }
            if (this.hvD != null) {
                aVar.g(24, this.hvD);
            }
            if (this.wvm != null) {
                aVar.fW(25, this.wvm.bke());
                this.wvm.a(aVar);
            }
            if (this.whR == null) {
                return 0;
            }
            aVar.g(26, this.whR);
            return 0;
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(3, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(4, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(5, this.hvw);
            }
            if (this.wve != null) {
                r0 += e.a.a.b.b.a.h(6, this.wve);
            }
            r0 = ((r0 + e.a.a.a.fR(7, this.hvt)) + e.a.a.a.fR(8, this.vHa)) + e.a.a.a.fR(9, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(10, this.wvg);
            }
            if (this.wnL != null) {
                r0 += e.a.a.b.b.a.h(11, this.wnL);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(12, this.hvy);
            }
            if (this.wvh != null) {
                r0 += e.a.a.b.b.a.h(13, this.wvh);
            }
            if (this.wvi != null) {
                r0 += e.a.a.b.b.a.h(14, this.wvi);
            }
            r0 = (r0 + e.a.a.a.fR(15, this.wvj)) + e.a.a.a.fR(19, this.wvk);
            if (this.wvl != null) {
                r0 += e.a.a.a.fT(20, this.wvl.bke());
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(21, this.hvC);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(22, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(23, this.vUV);
            }
            if (this.hvD != null) {
                r0 += e.a.a.b.b.a.h(24, this.hvD);
            }
            if (this.wvm != null) {
                r0 += e.a.a.a.fT(25, this.wvm.bke());
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(26, this.whR);
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
            aoe com_tencent_mm_protocal_c_aoe = (aoe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bla;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aoe.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoe.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoe.hvu = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoe.hvv = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoe.hvw = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoe.wve = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aoe.hvt = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aoe.vHa = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aoe.wvf = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aoe.wvg = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aoe.wnL = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aoe.hvy = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aoe.wvh = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aoe.wvi = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aoe.wvj = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aoe.wvk = aVar3.Avy.ry();
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bla = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bla.a(aVar4, com_tencent_mm_protocal_c_bla, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aoe.wvl = com_tencent_mm_protocal_c_bla;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aoe.hvC = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aoe.vUU = aVar3.Avy.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aoe.vUV = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aoe.hvD = aVar3.Avy.readString();
                    return 0;
                case 25:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bla = new pq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bla.a(aVar4, com_tencent_mm_protocal_c_bla, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aoe.wvm = com_tencent_mm_protocal_c_bla;
                    }
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_aoe.whR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
