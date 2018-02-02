package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class asj extends a {
    public int hvA;
    public String hvB;
    public String hvC;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public int hvx;
    public String hvy;
    public int hvz;
    public int ktm;
    public int vFr;
    public int vFu;
    public bdo vYI;
    public ajc wAa;
    public int wAb;
    public String wAc;
    public long wcd;
    public String wce;
    public bdo wsB;
    public int wvf;
    public String wvg;
    public String wvh;
    public String wvi;
    public int wvj;
    public int wzK;
    public int wzP;
    public b wzQ;
    public int wzS = 2048;
    public bdo wzT;
    public bdo wzU;
    public int wzV;
    public int wzW;
    public int wzX;
    public int wzY;
    public int wzZ;
    public int wze;
    public rd wzy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYI == null) {
                throw new e.a.a.b("Not all required fields were included: UserName");
            } else if (this.wsB == null) {
                throw new e.a.a.b("Not all required fields were included: NickName");
            } else if (this.wzT == null) {
                throw new e.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.wzU == null) {
                throw new e.a.a.b("Not all required fields were included: BindMobile");
            } else {
                aVar.fU(1, this.wzS);
                if (this.vYI != null) {
                    aVar.fW(2, this.vYI.bke());
                    this.vYI.a(aVar);
                }
                if (this.wsB != null) {
                    aVar.fW(3, this.wsB.bke());
                    this.wsB.a(aVar);
                }
                aVar.fU(4, this.vFr);
                if (this.wzT != null) {
                    aVar.fW(5, this.wzT.bke());
                    this.wzT.a(aVar);
                }
                if (this.wzU != null) {
                    aVar.fW(6, this.wzU.bke());
                    this.wzU.a(aVar);
                }
                aVar.fU(7, this.ktm);
                aVar.fU(8, this.wzP);
                if (this.wzQ != null) {
                    aVar.b(9, this.wzQ);
                }
                aVar.fU(10, this.hvt);
                if (this.hvu != null) {
                    aVar.g(11, this.hvu);
                }
                if (this.hvv != null) {
                    aVar.g(12, this.hvv);
                }
                if (this.hvw != null) {
                    aVar.g(13, this.hvw);
                }
                aVar.fU(14, this.hvx);
                if (this.wzy != null) {
                    aVar.fW(15, this.wzy.bke());
                    this.wzy.a(aVar);
                }
                aVar.fU(16, this.vFu);
                aVar.fU(17, this.wvf);
                if (this.wvg != null) {
                    aVar.g(18, this.wvg);
                }
                aVar.fU(19, this.wzV);
                aVar.fU(20, this.wzW);
                aVar.fU(21, this.wze);
                aVar.fU(22, this.wzX);
                aVar.fU(23, this.wzY);
                if (this.wvh != null) {
                    aVar.g(24, this.wvh);
                }
                aVar.fU(25, this.wzZ);
                if (this.wAa != null) {
                    aVar.fW(26, this.wAa.bke());
                    this.wAa.a(aVar);
                }
                if (this.hvy != null) {
                    aVar.g(27, this.hvy);
                }
                if (this.wvi != null) {
                    aVar.g(28, this.wvi);
                }
                aVar.fU(29, this.wvj);
                aVar.fU(30, this.wAb);
                aVar.S(31, this.wcd);
                if (this.wce != null) {
                    aVar.g(32, this.wce);
                }
                aVar.fU(33, this.hvA);
                aVar.fU(34, this.hvz);
                if (this.hvB != null) {
                    aVar.g(35, this.hvB);
                }
                aVar.fU(36, this.wzK);
                if (this.wAc != null) {
                    aVar.g(37, this.wAc);
                }
                if (this.hvC != null) {
                    aVar.g(38, this.hvC);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wzS) + 0;
            if (this.vYI != null) {
                r0 += e.a.a.a.fT(2, this.vYI.bke());
            }
            if (this.wsB != null) {
                r0 += e.a.a.a.fT(3, this.wsB.bke());
            }
            r0 += e.a.a.a.fR(4, this.vFr);
            if (this.wzT != null) {
                r0 += e.a.a.a.fT(5, this.wzT.bke());
            }
            if (this.wzU != null) {
                r0 += e.a.a.a.fT(6, this.wzU.bke());
            }
            r0 = (r0 + e.a.a.a.fR(7, this.ktm)) + e.a.a.a.fR(8, this.wzP);
            if (this.wzQ != null) {
                r0 += e.a.a.a.a(9, this.wzQ);
            }
            r0 += e.a.a.a.fR(10, this.hvt);
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(11, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(12, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(13, this.hvw);
            }
            r0 += e.a.a.a.fR(14, this.hvx);
            if (this.wzy != null) {
                r0 += e.a.a.a.fT(15, this.wzy.bke());
            }
            r0 = (r0 + e.a.a.a.fR(16, this.vFu)) + e.a.a.a.fR(17, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(18, this.wvg);
            }
            r0 = ((((r0 + e.a.a.a.fR(19, this.wzV)) + e.a.a.a.fR(20, this.wzW)) + e.a.a.a.fR(21, this.wze)) + e.a.a.a.fR(22, this.wzX)) + e.a.a.a.fR(23, this.wzY);
            if (this.wvh != null) {
                r0 += e.a.a.b.b.a.h(24, this.wvh);
            }
            r0 += e.a.a.a.fR(25, this.wzZ);
            if (this.wAa != null) {
                r0 += e.a.a.a.fT(26, this.wAa.bke());
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(27, this.hvy);
            }
            if (this.wvi != null) {
                r0 += e.a.a.b.b.a.h(28, this.wvi);
            }
            r0 = ((r0 + e.a.a.a.fR(29, this.wvj)) + e.a.a.a.fR(30, this.wAb)) + e.a.a.a.R(31, this.wcd);
            if (this.wce != null) {
                r0 += e.a.a.b.b.a.h(32, this.wce);
            }
            r0 = (r0 + e.a.a.a.fR(33, this.hvA)) + e.a.a.a.fR(34, this.hvz);
            if (this.hvB != null) {
                r0 += e.a.a.b.b.a.h(35, this.hvB);
            }
            r0 += e.a.a.a.fR(36, this.wzK);
            if (this.wAc != null) {
                r0 += e.a.a.b.b.a.h(37, this.wAc);
            }
            if (this.hvC != null) {
                return r0 + e.a.a.b.b.a.h(38, this.hvC);
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
                throw new e.a.a.b("Not all required fields were included: UserName");
            } else if (this.wsB == null) {
                throw new e.a.a.b("Not all required fields were included: NickName");
            } else if (this.wzT == null) {
                throw new e.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.wzU != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: BindMobile");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asj com_tencent_mm_protocal_c_asj = (asj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_asj.wzS = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_asj.vYI = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_asj.wsB = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asj.vFr = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asj.wzT = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asj.wzU = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asj.ktm = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_asj.wzP = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_asj.wzQ = aVar3.cJD();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_asj.hvt = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_asj.hvu = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_asj.hvv = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_asj.hvw = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_asj.hvx = aVar3.Avy.ry();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new rd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asj.wzy = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_asj.vFu = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_asj.wvf = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_asj.wvg = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_asj.wzV = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_asj.wzW = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_asj.wze = aVar3.Avy.ry();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_asj.wzX = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_asj.wzY = aVar3.Avy.ry();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_asj.wvh = aVar3.Avy.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_asj.wzZ = aVar3.Avy.ry();
                    return 0;
                case 26:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new ajc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asj.wAa = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_asj.hvy = aVar3.Avy.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_asj.wvi = aVar3.Avy.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_asj.wvj = aVar3.Avy.ry();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_asj.wAb = aVar3.Avy.ry();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_asj.wcd = aVar3.Avy.rz();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_asj.wce = aVar3.Avy.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_asj.hvA = aVar3.Avy.ry();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_asj.hvz = aVar3.Avy.ry();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_asj.hvB = aVar3.Avy.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_asj.wzK = aVar3.Avy.ry();
                    return 0;
                case 37:
                    com_tencent_mm_protocal_c_asj.wAc = aVar3.Avy.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_asj.hvC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
