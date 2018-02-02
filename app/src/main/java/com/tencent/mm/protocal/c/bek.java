package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bek extends a {
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
    public String whR;
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
                if (this.hvu != null) {
                    aVar.g(7, this.hvu);
                }
                if (this.hvv != null) {
                    aVar.g(8, this.hvv);
                }
                if (this.hvw != null) {
                    aVar.g(9, this.hvw);
                }
                aVar.fU(10, this.hvx);
                aVar.fU(11, this.wvf);
                if (this.wvg != null) {
                    aVar.g(12, this.wvg);
                }
                if (this.wvh != null) {
                    aVar.g(13, this.wvh);
                }
                if (this.hvy != null) {
                    aVar.g(14, this.hvy);
                }
                if (this.wvi != null) {
                    aVar.g(15, this.wvi);
                }
                aVar.fU(16, this.wvj);
                aVar.fU(17, this.hvA);
                aVar.fU(18, this.hvz);
                if (this.hvB != null) {
                    aVar.g(19, this.hvB);
                }
                if (this.wvl != null) {
                    aVar.fW(20, this.wvl.bke());
                    this.wvl.a(aVar);
                }
                if (this.hvC != null) {
                    aVar.g(21, this.hvC);
                }
                if (this.hvD != null) {
                    aVar.g(22, this.hvD);
                }
                if (this.wvm != null) {
                    aVar.fW(23, this.wvm.bke());
                    this.wvm.a(aVar);
                }
                if (this.vUU != null) {
                    aVar.g(24, this.vUU);
                }
                if (this.vUV != null) {
                    aVar.g(25, this.vUV);
                }
                if (this.whR == null) {
                    return 0;
                }
                aVar.g(26, this.whR);
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
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(7, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(8, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(9, this.hvw);
            }
            r0 = (r0 + e.a.a.a.fR(10, this.hvx)) + e.a.a.a.fR(11, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(12, this.wvg);
            }
            if (this.wvh != null) {
                r0 += e.a.a.b.b.a.h(13, this.wvh);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(14, this.hvy);
            }
            if (this.wvi != null) {
                r0 += e.a.a.b.b.a.h(15, this.wvi);
            }
            r0 = ((r0 + e.a.a.a.fR(16, this.wvj)) + e.a.a.a.fR(17, this.hvA)) + e.a.a.a.fR(18, this.hvz);
            if (this.hvB != null) {
                r0 += e.a.a.b.b.a.h(19, this.hvB);
            }
            if (this.wvl != null) {
                r0 += e.a.a.a.fT(20, this.wvl.bke());
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(21, this.hvC);
            }
            if (this.hvD != null) {
                r0 += e.a.a.b.b.a.h(22, this.hvD);
            }
            if (this.wvm != null) {
                r0 += e.a.a.a.fT(23, this.wvm.bke());
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(24, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(25, this.vUV);
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
            if (this.vYI == null) {
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
            bek com_tencent_mm_protocal_c_bek = (bek) objArr[1];
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
                        com_tencent_mm_protocal_c_bek.vYI = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_bek.wsB = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_bek.vYw = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_bek.vYx = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bek.hvt = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_bek.vHb = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bek.hvu = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bek.hvv = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bek.hvw = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bek.hvx = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bek.wvf = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bek.wvg = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bek.wvh = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bek.hvy = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bek.wvi = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bek.wvj = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bek.hvA = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bek.hvz = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bek.hvB = aVar3.Avy.readString();
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bek.wvl = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bek.hvC = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bek.hvD = aVar3.Avy.readString();
                    return 0;
                case 23:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new pq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bek.wvm = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bek.vUU = aVar3.Avy.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bek.vUV = aVar3.Avy.readString();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bek.whR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
