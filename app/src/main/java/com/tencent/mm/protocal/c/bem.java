package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bem extends bdf {
    public int hvA;
    public String hvB;
    public String hvC;
    public String hvD;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public int hvx;
    public String hvy;
    public int hvz;
    public bdn vHb;
    public String vUU;
    public String vUV;
    public bdo vYI;
    public bdo vYw;
    public bdo vYx;
    public bdn wJW;
    public String wJX;
    public int wJY;
    public String wJZ;
    public String whR;
    public int wkk;
    public LinkedList<bek> wkl = new LinkedList();
    public bdo wsB;
    public int wvf;
    public String wvg;
    public String wvh;
    public String wvi;
    public int wvj;
    public bla wvl;
    public pq wvm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vYI == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vYw == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.vYx == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.vYI != null) {
                    aVar.fW(2, this.vYI.bke());
                    this.vYI.a(aVar);
                }
                if (this.wsB != null) {
                    aVar.fW(3, this.wsB.bke());
                    this.wsB.a(aVar);
                }
                if (this.vYw != null) {
                    aVar.fW(4, this.vYw.bke());
                    this.vYw.a(aVar);
                }
                if (this.vYx != null) {
                    aVar.fW(5, this.vYx.bke());
                    this.vYx.a(aVar);
                }
                aVar.fU(6, this.hvt);
                if (this.vHb != null) {
                    aVar.fW(7, this.vHb.bke());
                    this.vHb.a(aVar);
                }
                if (this.hvu != null) {
                    aVar.g(8, this.hvu);
                }
                if (this.hvv != null) {
                    aVar.g(9, this.hvv);
                }
                if (this.hvw != null) {
                    aVar.g(10, this.hvw);
                }
                aVar.fU(11, this.hvx);
                aVar.fU(12, this.wvf);
                if (this.wvg != null) {
                    aVar.g(13, this.wvg);
                }
                if (this.wvh != null) {
                    aVar.g(14, this.wvh);
                }
                if (this.hvy != null) {
                    aVar.g(15, this.hvy);
                }
                if (this.wvi != null) {
                    aVar.g(16, this.wvi);
                }
                aVar.fU(17, this.wvj);
                aVar.fU(18, this.hvA);
                aVar.fU(19, this.hvz);
                if (this.hvB != null) {
                    aVar.g(20, this.hvB);
                }
                if (this.wvl != null) {
                    aVar.fW(21, this.wvl.bke());
                    this.wvl.a(aVar);
                }
                if (this.hvC != null) {
                    aVar.g(22, this.hvC);
                }
                if (this.hvD != null) {
                    aVar.g(23, this.hvD);
                }
                if (this.wvm != null) {
                    aVar.fW(24, this.wvm.bke());
                    this.wvm.a(aVar);
                }
                aVar.fU(25, this.wkk);
                aVar.d(26, 8, this.wkl);
                if (this.vUU != null) {
                    aVar.g(27, this.vUU);
                }
                if (this.vUV != null) {
                    aVar.g(28, this.vUV);
                }
                if (this.wJW != null) {
                    aVar.fW(29, this.wJW.bke());
                    this.wJW.a(aVar);
                }
                if (this.whR != null) {
                    aVar.g(30, this.whR);
                }
                if (this.wJX != null) {
                    aVar.g(31, this.wJX);
                }
                aVar.fU(32, this.wJY);
                if (this.wJZ == null) {
                    return 0;
                }
                aVar.g(33, this.wJZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vYI != null) {
                r0 += e.a.a.a.fT(2, this.vYI.bke());
            }
            if (this.wsB != null) {
                r0 += e.a.a.a.fT(3, this.wsB.bke());
            }
            if (this.vYw != null) {
                r0 += e.a.a.a.fT(4, this.vYw.bke());
            }
            if (this.vYx != null) {
                r0 += e.a.a.a.fT(5, this.vYx.bke());
            }
            r0 += e.a.a.a.fR(6, this.hvt);
            if (this.vHb != null) {
                r0 += e.a.a.a.fT(7, this.vHb.bke());
            }
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(8, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(9, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(10, this.hvw);
            }
            r0 = (r0 + e.a.a.a.fR(11, this.hvx)) + e.a.a.a.fR(12, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(13, this.wvg);
            }
            if (this.wvh != null) {
                r0 += e.a.a.b.b.a.h(14, this.wvh);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(15, this.hvy);
            }
            if (this.wvi != null) {
                r0 += e.a.a.b.b.a.h(16, this.wvi);
            }
            r0 = ((r0 + e.a.a.a.fR(17, this.wvj)) + e.a.a.a.fR(18, this.hvA)) + e.a.a.a.fR(19, this.hvz);
            if (this.hvB != null) {
                r0 += e.a.a.b.b.a.h(20, this.hvB);
            }
            if (this.wvl != null) {
                r0 += e.a.a.a.fT(21, this.wvl.bke());
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(22, this.hvC);
            }
            if (this.hvD != null) {
                r0 += e.a.a.b.b.a.h(23, this.hvD);
            }
            if (this.wvm != null) {
                r0 += e.a.a.a.fT(24, this.wvm.bke());
            }
            r0 = (r0 + e.a.a.a.fR(25, this.wkk)) + e.a.a.a.c(26, 8, this.wkl);
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(27, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(28, this.vUV);
            }
            if (this.wJW != null) {
                r0 += e.a.a.a.fT(29, this.wJW.bke());
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(30, this.whR);
            }
            if (this.wJX != null) {
                r0 += e.a.a.b.b.a.h(31, this.wJX);
            }
            r0 += e.a.a.a.fR(32, this.wJY);
            if (this.wJZ != null) {
                r0 += e.a.a.b.b.a.h(33, this.wJZ);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wkl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vYI == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vYw == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.vYx == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vHb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bem com_tencent_mm_protocal_c_bem = (bem) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.vYI = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.wsB = feVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.vYw = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.vYx = feVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bem.hvt = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.vHb = feVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bem.hvu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bem.hvv = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bem.hvw = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bem.hvx = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bem.wvf = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bem.wvg = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bem.wvh = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bem.hvy = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bem.wvi = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bem.wvj = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bem.hvA = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bem.hvz = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bem.hvB = aVar3.Avy.readString();
                    return 0;
                case 21:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bla();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.wvl = feVar;
                    }
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bem.hvC = aVar3.Avy.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bem.hvD = aVar3.Avy.readString();
                    return 0;
                case 24:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new pq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.wvm = feVar;
                    }
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bem.wkk = aVar3.Avy.ry();
                    return 0;
                case 26:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bek();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.wkl.add(feVar);
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bem.vUU = aVar3.Avy.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bem.vUV = aVar3.Avy.readString();
                    return 0;
                case 29:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bem.wJW = feVar;
                    }
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bem.whR = aVar3.Avy.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_bem.wJX = aVar3.Avy.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_bem.wJY = aVar3.Avy.ry();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_bem.wJZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
