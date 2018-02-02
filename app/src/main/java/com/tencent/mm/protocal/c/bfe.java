package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bfe extends a {
    public String hvC;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public int hvx;
    public String hvy;
    public String vUU;
    public String vUV;
    public bdo vYI;
    public pr wKn;
    public bdo wsB;
    public int wvf;
    public String wvg;
    public String wvh;
    public String wvi;
    public int wvj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYI == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.vYI != null) {
                    aVar.fW(1, this.vYI.bke());
                    this.vYI.a(aVar);
                }
                if (this.wsB != null) {
                    aVar.fW(2, this.wsB.bke());
                    this.wsB.a(aVar);
                }
                aVar.fU(3, this.hvt);
                if (this.hvu != null) {
                    aVar.g(4, this.hvu);
                }
                if (this.hvv != null) {
                    aVar.g(5, this.hvv);
                }
                if (this.hvw != null) {
                    aVar.g(6, this.hvw);
                }
                aVar.fU(7, this.hvx);
                aVar.fU(8, this.wvf);
                if (this.wvg != null) {
                    aVar.g(9, this.wvg);
                }
                if (this.wvh != null) {
                    aVar.g(10, this.wvh);
                }
                if (this.hvy != null) {
                    aVar.g(11, this.hvy);
                }
                if (this.wvi != null) {
                    aVar.g(12, this.wvi);
                }
                aVar.fU(13, this.wvj);
                if (this.hvC != null) {
                    aVar.g(14, this.hvC);
                }
                if (this.wKn != null) {
                    aVar.fW(15, this.wKn.bke());
                    this.wKn.a(aVar);
                }
                if (this.vUU != null) {
                    aVar.g(16, this.vUU);
                }
                if (this.vUV == null) {
                    return 0;
                }
                aVar.g(17, this.vUV);
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
            r0 += e.a.a.a.fR(3, this.hvt);
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(4, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(5, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(6, this.hvw);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.hvx)) + e.a.a.a.fR(8, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(9, this.wvg);
            }
            if (this.wvh != null) {
                r0 += e.a.a.b.b.a.h(10, this.wvh);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(11, this.hvy);
            }
            if (this.wvi != null) {
                r0 += e.a.a.b.b.a.h(12, this.wvi);
            }
            r0 += e.a.a.a.fR(13, this.wvj);
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(14, this.hvC);
            }
            if (this.wKn != null) {
                r0 += e.a.a.a.fT(15, this.wKn.bke());
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(16, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(17, this.vUV);
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
            } else if (this.wsB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfe com_tencent_mm_protocal_c_bfe = (bfe) objArr[1];
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
                        com_tencent_mm_protocal_c_bfe.vYI = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_bfe.wsB = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfe.hvt = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfe.hvu = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfe.hvv = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfe.hvw = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfe.hvx = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfe.wvf = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfe.wvg = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bfe.wvh = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bfe.hvy = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bfe.wvi = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bfe.wvj = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bfe.hvC = aVar3.Avy.readString();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new pr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfe.wKn = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bfe.vUU = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bfe.vUV = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
