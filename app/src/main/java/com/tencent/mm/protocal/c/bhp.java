package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bhp extends a {
    public String hvC;
    public String hvD;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public String ksU;
    public String kub;
    public int vHa;
    public String vUU;
    public String vUV;
    public int wLf;
    public bdn wLg;
    public int wLh;
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
            if (this.wLg == null) {
                throw new b("Not all required fields were included: ImgBuffer");
            }
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
            aVar.fU(9, this.wLf);
            if (this.wLg != null) {
                aVar.fW(10, this.wLg.bke());
                this.wLg.a(aVar);
            }
            aVar.fU(11, this.wLh);
            if (this.wvh != null) {
                aVar.g(12, this.wvh);
            }
            if (this.wvi != null) {
                aVar.g(13, this.wvi);
            }
            aVar.fU(14, this.wvj);
            aVar.fU(15, this.wvf);
            if (this.wvg != null) {
                aVar.g(16, this.wvg);
            }
            if (this.wnL != null) {
                aVar.g(17, this.wnL);
            }
            aVar.fU(21, this.wvk);
            if (this.wvl != null) {
                aVar.fW(22, this.wvl.bke());
                this.wvl.a(aVar);
            }
            if (this.hvC != null) {
                aVar.g(23, this.hvC);
            }
            if (this.vUU != null) {
                aVar.g(24, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(25, this.vUV);
            }
            if (this.hvD != null) {
                aVar.g(26, this.hvD);
            }
            if (this.wvm != null) {
                aVar.fW(27, this.wvm.bke());
                this.wvm.a(aVar);
            }
            if (this.whR == null) {
                return 0;
            }
            aVar.g(28, this.whR);
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
            r0 = ((r0 + e.a.a.a.fR(7, this.hvt)) + e.a.a.a.fR(8, this.vHa)) + e.a.a.a.fR(9, this.wLf);
            if (this.wLg != null) {
                r0 += e.a.a.a.fT(10, this.wLg.bke());
            }
            r0 += e.a.a.a.fR(11, this.wLh);
            if (this.wvh != null) {
                r0 += e.a.a.b.b.a.h(12, this.wvh);
            }
            if (this.wvi != null) {
                r0 += e.a.a.b.b.a.h(13, this.wvi);
            }
            r0 = (r0 + e.a.a.a.fR(14, this.wvj)) + e.a.a.a.fR(15, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(16, this.wvg);
            }
            if (this.wnL != null) {
                r0 += e.a.a.b.b.a.h(17, this.wnL);
            }
            r0 += e.a.a.a.fR(21, this.wvk);
            if (this.wvl != null) {
                r0 += e.a.a.a.fT(22, this.wvl.bke());
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(23, this.hvC);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(24, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(25, this.vUV);
            }
            if (this.hvD != null) {
                r0 += e.a.a.b.b.a.h(26, this.hvD);
            }
            if (this.wvm != null) {
                r0 += e.a.a.a.fT(27, this.wvm.bke());
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(28, this.whR);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wLg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhp com_tencent_mm_protocal_c_bhp = (bhp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bhp.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhp.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhp.hvu = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhp.hvv = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhp.hvw = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhp.wve = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhp.hvt = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhp.vHa = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhp.wLf = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhp.wLg = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bhp.wLh = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bhp.wvh = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bhp.wvi = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bhp.wvj = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bhp.wvf = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bhp.wvg = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bhp.wnL = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bhp.wvk = aVar3.Avy.ry();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhp.wvl = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bhp.hvC = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bhp.vUU = aVar3.Avy.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bhp.vUV = aVar3.Avy.readString();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bhp.hvD = aVar3.Avy.readString();
                    return 0;
                case 27:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new pq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhp.wvm = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bhp.whR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
