package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brb extends bcv {
    public String nko;
    public String nkp;
    public String vHU;
    public int vHW;
    public String vHc;
    public String vQA;
    public int vQB;
    public int vQC;
    public int vQD;
    public int vZu;
    public int wKA;
    public String wSA;
    public String wSB;
    public int wSC;
    public String wSD;
    public String wSE;
    public String wSF;
    public String wSG;
    public String wSH;
    public String wSI;
    public String wSJ;
    public String wSK;
    public int wSl;
    public int wSm;
    public int wSn;
    public int wSt;
    public int wSu;
    public bdn wSv;
    public int wSw;
    public int wSx;
    public String wSy;
    public int wSz;
    public int wac;
    public String wrR;
    public String wrT;
    public int wxp;
    public int wxq;
    public bdn wxr;
    public int wxs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wxr == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.wSv == null) {
                throw new b("Not all required fields were included: VideoData");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.vHU != null) {
                    aVar.g(2, this.vHU);
                }
                if (this.nkp != null) {
                    aVar.g(3, this.nkp);
                }
                if (this.nko != null) {
                    aVar.g(4, this.nko);
                }
                aVar.fU(5, this.wxp);
                aVar.fU(6, this.wxq);
                if (this.wxr != null) {
                    aVar.fW(7, this.wxr.bke());
                    this.wxr.a(aVar);
                }
                aVar.fU(8, this.wSt);
                aVar.fU(9, this.wSu);
                if (this.wSv != null) {
                    aVar.fW(10, this.wSv.bke());
                    this.wSv.a(aVar);
                }
                aVar.fU(11, this.wSw);
                aVar.fU(12, this.vZu);
                aVar.fU(13, this.wxs);
                aVar.fU(14, this.wSx);
                if (this.vHc != null) {
                    aVar.g(15, this.vHc);
                }
                if (this.wSy != null) {
                    aVar.g(16, this.wSy);
                }
                if (this.vQA != null) {
                    aVar.g(17, this.vQA);
                }
                aVar.fU(18, this.vQB);
                if (this.wrR != null) {
                    aVar.g(19, this.wrR);
                }
                aVar.fU(20, this.wSl);
                aVar.fU(21, this.wSm);
                aVar.fU(22, this.wSn);
                if (this.wrT != null) {
                    aVar.g(23, this.wrT);
                }
                aVar.fU(24, this.wSz);
                aVar.fU(25, this.wac);
                if (this.wSA != null) {
                    aVar.g(26, this.wSA);
                }
                if (this.wSB != null) {
                    aVar.g(27, this.wSB);
                }
                aVar.fU(28, this.wSC);
                if (this.wSD != null) {
                    aVar.g(29, this.wSD);
                }
                if (this.wSE != null) {
                    aVar.g(30, this.wSE);
                }
                if (this.wSF != null) {
                    aVar.g(31, this.wSF);
                }
                if (this.wSG != null) {
                    aVar.g(32, this.wSG);
                }
                if (this.wSH != null) {
                    aVar.g(33, this.wSH);
                }
                if (this.wSI != null) {
                    aVar.g(34, this.wSI);
                }
                if (this.wSJ != null) {
                    aVar.g(35, this.wSJ);
                }
                aVar.fU(36, this.wKA);
                if (this.wSK != null) {
                    aVar.g(37, this.wSK);
                }
                aVar.fU(38, this.vQC);
                aVar.fU(39, this.vQD);
                aVar.fU(40, this.vHW);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHU);
            }
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(3, this.nkp);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(4, this.nko);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.wxp)) + e.a.a.a.fR(6, this.wxq);
            if (this.wxr != null) {
                r0 += e.a.a.a.fT(7, this.wxr.bke());
            }
            r0 = (r0 + e.a.a.a.fR(8, this.wSt)) + e.a.a.a.fR(9, this.wSu);
            if (this.wSv != null) {
                r0 += e.a.a.a.fT(10, this.wSv.bke());
            }
            r0 = (((r0 + e.a.a.a.fR(11, this.wSw)) + e.a.a.a.fR(12, this.vZu)) + e.a.a.a.fR(13, this.wxs)) + e.a.a.a.fR(14, this.wSx);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(15, this.vHc);
            }
            if (this.wSy != null) {
                r0 += e.a.a.b.b.a.h(16, this.wSy);
            }
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(17, this.vQA);
            }
            r0 += e.a.a.a.fR(18, this.vQB);
            if (this.wrR != null) {
                r0 += e.a.a.b.b.a.h(19, this.wrR);
            }
            r0 = ((r0 + e.a.a.a.fR(20, this.wSl)) + e.a.a.a.fR(21, this.wSm)) + e.a.a.a.fR(22, this.wSn);
            if (this.wrT != null) {
                r0 += e.a.a.b.b.a.h(23, this.wrT);
            }
            r0 = (r0 + e.a.a.a.fR(24, this.wSz)) + e.a.a.a.fR(25, this.wac);
            if (this.wSA != null) {
                r0 += e.a.a.b.b.a.h(26, this.wSA);
            }
            if (this.wSB != null) {
                r0 += e.a.a.b.b.a.h(27, this.wSB);
            }
            r0 += e.a.a.a.fR(28, this.wSC);
            if (this.wSD != null) {
                r0 += e.a.a.b.b.a.h(29, this.wSD);
            }
            if (this.wSE != null) {
                r0 += e.a.a.b.b.a.h(30, this.wSE);
            }
            if (this.wSF != null) {
                r0 += e.a.a.b.b.a.h(31, this.wSF);
            }
            if (this.wSG != null) {
                r0 += e.a.a.b.b.a.h(32, this.wSG);
            }
            if (this.wSH != null) {
                r0 += e.a.a.b.b.a.h(33, this.wSH);
            }
            if (this.wSI != null) {
                r0 += e.a.a.b.b.a.h(34, this.wSI);
            }
            if (this.wSJ != null) {
                r0 += e.a.a.b.b.a.h(35, this.wSJ);
            }
            r0 += e.a.a.a.fR(36, this.wKA);
            if (this.wSK != null) {
                r0 += e.a.a.b.b.a.h(37, this.wSK);
            }
            return ((r0 + e.a.a.a.fR(38, this.vQC)) + e.a.a.a.fR(39, this.vQD)) + e.a.a.a.fR(40, this.vHW);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wxr == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.wSv != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: VideoData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brb com_tencent_mm_protocal_c_brb = (brb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brb.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brb.vHU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_brb.nkp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_brb.nko = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_brb.wxp = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_brb.wxq = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brb.wxr = fdVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_brb.wSt = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_brb.wSu = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brb.wSv = fdVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_brb.wSw = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_brb.vZu = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_brb.wxs = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_brb.wSx = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_brb.vHc = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_brb.wSy = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_brb.vQA = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_brb.vQB = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_brb.wrR = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_brb.wSl = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_brb.wSm = aVar3.Avy.ry();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_brb.wSn = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_brb.wrT = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_brb.wSz = aVar3.Avy.ry();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_brb.wac = aVar3.Avy.ry();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_brb.wSA = aVar3.Avy.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_brb.wSB = aVar3.Avy.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_brb.wSC = aVar3.Avy.ry();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_brb.wSD = aVar3.Avy.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_brb.wSE = aVar3.Avy.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_brb.wSF = aVar3.Avy.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_brb.wSG = aVar3.Avy.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_brb.wSH = aVar3.Avy.readString();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_brb.wSI = aVar3.Avy.readString();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_brb.wSJ = aVar3.Avy.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_brb.wKA = aVar3.Avy.ry();
                    return 0;
                case 37:
                    com_tencent_mm_protocal_c_brb.wSK = aVar3.Avy.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_brb.vQC = aVar3.Avy.ry();
                    return 0;
                case 39:
                    com_tencent_mm_protocal_c_brb.vQD = aVar3.Avy.ry();
                    return 0;
                case 40:
                    com_tencent_mm_protocal_c_brb.vHW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
