package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ark extends a {
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
    public int vXS;
    public bdo vYI;
    public bdo vYw;
    public bdo vYx;
    public String wnL;
    public bdo wsB;
    public int wvf;
    public String wvg;
    public String wvh;
    public String wvi;
    public int wvj;
    public bla wvl;
    public pq wvm;
    public bdo wyH;
    public bdo wyI;
    public bdo wyJ;
    public int wyY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYI == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vYw == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.vYx == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.wyH == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.wyI == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.wyJ == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.vYI != null) {
                    aVar.fW(1, this.vYI.bke());
                    this.vYI.a(aVar);
                }
                if (this.wsB != null) {
                    aVar.fW(2, this.wsB.bke());
                    this.wsB.a(aVar);
                }
                if (this.vYw != null) {
                    aVar.fW(3, this.vYw.bke());
                    this.vYw.a(aVar);
                }
                if (this.vYx != null) {
                    aVar.fW(4, this.vYx.bke());
                    this.vYx.a(aVar);
                }
                aVar.fU(5, this.hvt);
                if (this.vHb != null) {
                    aVar.fW(6, this.vHb.bke());
                    this.vHb.a(aVar);
                }
                aVar.fU(7, this.wyY);
                if (this.wyH != null) {
                    aVar.fW(8, this.wyH.bke());
                    this.wyH.a(aVar);
                }
                if (this.wyI != null) {
                    aVar.fW(9, this.wyI.bke());
                    this.wyI.a(aVar);
                }
                if (this.wyJ != null) {
                    aVar.fW(10, this.wyJ.bke());
                    this.wyJ.a(aVar);
                }
                aVar.fU(11, this.vXS);
                if (this.hvu != null) {
                    aVar.g(12, this.hvu);
                }
                if (this.hvv != null) {
                    aVar.g(13, this.hvv);
                }
                if (this.hvw != null) {
                    aVar.g(14, this.hvw);
                }
                aVar.fU(15, this.hvx);
                aVar.fU(16, this.wvf);
                if (this.wvg != null) {
                    aVar.g(17, this.wvg);
                }
                if (this.wvh != null) {
                    aVar.g(18, this.wvh);
                }
                if (this.wnL != null) {
                    aVar.g(19, this.wnL);
                }
                if (this.wvi != null) {
                    aVar.g(20, this.wvi);
                }
                aVar.fU(21, this.wvj);
                aVar.fU(22, this.hvA);
                aVar.fU(23, this.hvz);
                if (this.hvB != null) {
                    aVar.g(24, this.hvB);
                }
                if (this.hvy != null) {
                    aVar.g(25, this.hvy);
                }
                if (this.wvl != null) {
                    aVar.fW(26, this.wvl.bke());
                    this.wvl.a(aVar);
                }
                if (this.hvC != null) {
                    aVar.g(27, this.hvC);
                }
                if (this.vUU != null) {
                    aVar.g(28, this.vUU);
                }
                if (this.vUV != null) {
                    aVar.g(29, this.vUV);
                }
                if (this.hvD != null) {
                    aVar.g(30, this.hvD);
                }
                if (this.wvm == null) {
                    return 0;
                }
                aVar.fW(31, this.wvm.bke());
                this.wvm.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vYI != null) {
                r0 = e.a.a.a.fT(1, this.vYI.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wsB != null) {
                r0 += e.a.a.a.fT(2, this.wsB.bke());
            }
            if (this.vYw != null) {
                r0 += e.a.a.a.fT(3, this.vYw.bke());
            }
            if (this.vYx != null) {
                r0 += e.a.a.a.fT(4, this.vYx.bke());
            }
            r0 += e.a.a.a.fR(5, this.hvt);
            if (this.vHb != null) {
                r0 += e.a.a.a.fT(6, this.vHb.bke());
            }
            r0 += e.a.a.a.fR(7, this.wyY);
            if (this.wyH != null) {
                r0 += e.a.a.a.fT(8, this.wyH.bke());
            }
            if (this.wyI != null) {
                r0 += e.a.a.a.fT(9, this.wyI.bke());
            }
            if (this.wyJ != null) {
                r0 += e.a.a.a.fT(10, this.wyJ.bke());
            }
            r0 += e.a.a.a.fR(11, this.vXS);
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(12, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(13, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(14, this.hvw);
            }
            r0 = (r0 + e.a.a.a.fR(15, this.hvx)) + e.a.a.a.fR(16, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(17, this.wvg);
            }
            if (this.wvh != null) {
                r0 += e.a.a.b.b.a.h(18, this.wvh);
            }
            if (this.wnL != null) {
                r0 += e.a.a.b.b.a.h(19, this.wnL);
            }
            if (this.wvi != null) {
                r0 += e.a.a.b.b.a.h(20, this.wvi);
            }
            r0 = ((r0 + e.a.a.a.fR(21, this.wvj)) + e.a.a.a.fR(22, this.hvA)) + e.a.a.a.fR(23, this.hvz);
            if (this.hvB != null) {
                r0 += e.a.a.b.b.a.h(24, this.hvB);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(25, this.hvy);
            }
            if (this.wvl != null) {
                r0 += e.a.a.a.fT(26, this.wvl.bke());
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(27, this.hvC);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(28, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(29, this.vUV);
            }
            if (this.hvD != null) {
                r0 += e.a.a.b.b.a.h(30, this.hvD);
            }
            if (this.wvm != null) {
                r0 += e.a.a.a.fT(31, this.wvm.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYI == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vYw == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.vYx == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.wyH == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.wyI == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.wyJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RemarkQuanPin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ark com_tencent_mm_protocal_c_ark = (ark) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.vYI = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.wsB = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.vYw = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.vYx = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ark.hvt = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.vHb = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ark.wyY = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.wyH = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.wyI = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.wyJ = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ark.vXS = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ark.hvu = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ark.hvv = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ark.hvw = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ark.hvx = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ark.wvf = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ark.wvg = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ark.wvh = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ark.wnL = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ark.wvi = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ark.wvj = aVar3.Avy.ry();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_ark.hvA = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_ark.hvz = aVar3.Avy.ry();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ark.hvB = aVar3.Avy.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ark.hvy = aVar3.Avy.readString();
                    return 0;
                case 26:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.wvl = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ark.hvC = aVar3.Avy.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_ark.vUU = aVar3.Avy.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_ark.vUV = aVar3.Avy.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_ark.hvD = aVar3.Avy.readString();
                    return 0;
                case 31:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new pq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.wvm = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
