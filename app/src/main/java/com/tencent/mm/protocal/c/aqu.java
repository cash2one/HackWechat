package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class aqu extends a {
    public int afu;
    public String fFm;
    public String fqR;
    public int ftB;
    public int hkU;
    public String nfe;
    public String token;
    public String videoPath;
    public int wxG;
    public String wxZ;
    public int wyA;
    public String wyB;
    public String wyC;
    public String wyD;
    public aqc wyE;
    public int wyF;
    public int wya;
    public int wyb;
    public int wyj;
    public String wyk;
    public aqo wyx;
    public int wyy;
    public LinkedList<aqo> wyz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wya);
            aVar.fU(2, this.wyb);
            aVar.fU(3, this.wxG);
            if (this.wyx != null) {
                aVar.fW(4, this.wyx.bke());
                this.wyx.a(aVar);
            }
            aVar.fU(5, this.wyy);
            aVar.d(6, 8, this.wyz);
            aVar.fU(7, this.hkU);
            aVar.fU(8, this.wyA);
            if (this.nfe != null) {
                aVar.g(9, this.nfe);
            }
            if (this.wyB != null) {
                aVar.g(10, this.wyB);
            }
            if (this.token != null) {
                aVar.g(11, this.token);
            }
            if (this.wyk != null) {
                aVar.g(12, this.wyk);
            }
            aVar.fU(13, this.wyj);
            if (this.videoPath != null) {
                aVar.g(14, this.videoPath);
            }
            if (this.wyC != null) {
                aVar.g(15, this.wyC);
            }
            if (this.wyD != null) {
                aVar.g(16, this.wyD);
            }
            if (this.fqR != null) {
                aVar.g(17, this.fqR);
            }
            if (this.fFm != null) {
                aVar.g(18, this.fFm);
            }
            aVar.fU(19, this.afu);
            aVar.fU(20, this.ftB);
            if (this.wxZ != null) {
                aVar.g(21, this.wxZ);
            }
            if (this.wyE != null) {
                aVar.fW(22, this.wyE.bke());
                this.wyE.a(aVar);
            }
            aVar.fU(23, this.wyF);
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.wya) + 0) + e.a.a.a.fR(2, this.wyb)) + e.a.a.a.fR(3, this.wxG);
            if (this.wyx != null) {
                r0 += e.a.a.a.fT(4, this.wyx.bke());
            }
            r0 = (((r0 + e.a.a.a.fR(5, this.wyy)) + e.a.a.a.c(6, 8, this.wyz)) + e.a.a.a.fR(7, this.hkU)) + e.a.a.a.fR(8, this.wyA);
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(9, this.nfe);
            }
            if (this.wyB != null) {
                r0 += e.a.a.b.b.a.h(10, this.wyB);
            }
            if (this.token != null) {
                r0 += e.a.a.b.b.a.h(11, this.token);
            }
            if (this.wyk != null) {
                r0 += e.a.a.b.b.a.h(12, this.wyk);
            }
            r0 += e.a.a.a.fR(13, this.wyj);
            if (this.videoPath != null) {
                r0 += e.a.a.b.b.a.h(14, this.videoPath);
            }
            if (this.wyC != null) {
                r0 += e.a.a.b.b.a.h(15, this.wyC);
            }
            if (this.wyD != null) {
                r0 += e.a.a.b.b.a.h(16, this.wyD);
            }
            if (this.fqR != null) {
                r0 += e.a.a.b.b.a.h(17, this.fqR);
            }
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(18, this.fFm);
            }
            r0 = (r0 + e.a.a.a.fR(19, this.afu)) + e.a.a.a.fR(20, this.ftB);
            if (this.wxZ != null) {
                r0 += e.a.a.b.b.a.h(21, this.wxZ);
            }
            if (this.wyE != null) {
                r0 += e.a.a.a.fT(22, this.wyE.bke());
            }
            return r0 + e.a.a.a.fR(23, this.wyF);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wyz.clear();
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
            aqu com_tencent_mm_protocal_c_aqu = (aqu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_aqo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aqu.wya = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqu.wyb = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqu.wxG = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aqo = new aqo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqo.a(aVar4, com_tencent_mm_protocal_c_aqo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqu.wyx = com_tencent_mm_protocal_c_aqo;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqu.wyy = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aqo = new aqo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqo.a(aVar4, com_tencent_mm_protocal_c_aqo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqu.wyz.add(com_tencent_mm_protocal_c_aqo);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqu.hkU = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqu.wyA = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqu.nfe = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqu.wyB = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqu.token = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aqu.wyk = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aqu.wyj = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aqu.videoPath = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aqu.wyC = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aqu.wyD = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aqu.fqR = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aqu.fFm = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aqu.afu = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aqu.ftB = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aqu.wxZ = aVar3.Avy.readString();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aqo = new aqc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqo.a(aVar4, com_tencent_mm_protocal_c_aqo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqu.wyE = com_tencent_mm_protocal_c_aqo;
                    }
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aqu.wyF = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
