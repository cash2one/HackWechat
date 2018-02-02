package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class buo extends a {
    public int nDT;
    public but wUm;
    public but wUn;
    public int wVC;
    public bth wVD;
    public bth wVE;
    public int wVF;
    public int wVG;
    public int wVH;
    public int wVI;
    public bdn wVJ;
    public int wVK;
    public bth wVL;
    public int wVM;
    public int wVN;
    public int wVO;
    public int wVP;
    public int wVQ;
    public int wVR;
    public bdn wVS;
    public bdn wVT;
    public int wVU;
    public bdn wVV;
    public int wVW;
    public int wVX;
    public int wVY;
    public amx wVZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wUm == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.wUn == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.wUm != null) {
                    aVar.fW(1, this.wUm.bke());
                    this.wUm.a(aVar);
                }
                if (this.wUn != null) {
                    aVar.fW(2, this.wUn.bke());
                    this.wUn.a(aVar);
                }
                aVar.fU(3, this.wVC);
                if (this.wVD != null) {
                    aVar.fW(4, this.wVD.bke());
                    this.wVD.a(aVar);
                }
                if (this.wVE != null) {
                    aVar.fW(5, this.wVE.bke());
                    this.wVE.a(aVar);
                }
                aVar.fU(6, this.wVF);
                aVar.fU(7, this.wVG);
                aVar.fU(8, this.wVH);
                aVar.fU(9, this.wVI);
                if (this.wVJ != null) {
                    aVar.fW(10, this.wVJ.bke());
                    this.wVJ.a(aVar);
                }
                aVar.fU(11, this.wVK);
                if (this.wVL != null) {
                    aVar.fW(12, this.wVL.bke());
                    this.wVL.a(aVar);
                }
                aVar.fU(13, this.wVM);
                aVar.fU(14, this.wVN);
                aVar.fU(15, this.wVO);
                aVar.fU(16, this.wVP);
                aVar.fU(17, this.wVQ);
                aVar.fU(18, this.nDT);
                aVar.fU(19, this.wVR);
                if (this.wVS != null) {
                    aVar.fW(20, this.wVS.bke());
                    this.wVS.a(aVar);
                }
                if (this.wVT != null) {
                    aVar.fW(21, this.wVT.bke());
                    this.wVT.a(aVar);
                }
                aVar.fU(22, this.wVU);
                if (this.wVV != null) {
                    aVar.fW(23, this.wVV.bke());
                    this.wVV.a(aVar);
                }
                aVar.fU(24, this.wVW);
                aVar.fU(25, this.wVX);
                aVar.fU(26, this.wVY);
                if (this.wVZ == null) {
                    return 0;
                }
                aVar.fW(27, this.wVZ.bke());
                this.wVZ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wUm != null) {
                r0 = e.a.a.a.fT(1, this.wUm.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wUn != null) {
                r0 += e.a.a.a.fT(2, this.wUn.bke());
            }
            r0 += e.a.a.a.fR(3, this.wVC);
            if (this.wVD != null) {
                r0 += e.a.a.a.fT(4, this.wVD.bke());
            }
            if (this.wVE != null) {
                r0 += e.a.a.a.fT(5, this.wVE.bke());
            }
            r0 = (((r0 + e.a.a.a.fR(6, this.wVF)) + e.a.a.a.fR(7, this.wVG)) + e.a.a.a.fR(8, this.wVH)) + e.a.a.a.fR(9, this.wVI);
            if (this.wVJ != null) {
                r0 += e.a.a.a.fT(10, this.wVJ.bke());
            }
            r0 += e.a.a.a.fR(11, this.wVK);
            if (this.wVL != null) {
                r0 += e.a.a.a.fT(12, this.wVL.bke());
            }
            r0 = ((((((r0 + e.a.a.a.fR(13, this.wVM)) + e.a.a.a.fR(14, this.wVN)) + e.a.a.a.fR(15, this.wVO)) + e.a.a.a.fR(16, this.wVP)) + e.a.a.a.fR(17, this.wVQ)) + e.a.a.a.fR(18, this.nDT)) + e.a.a.a.fR(19, this.wVR);
            if (this.wVS != null) {
                r0 += e.a.a.a.fT(20, this.wVS.bke());
            }
            if (this.wVT != null) {
                r0 += e.a.a.a.fT(21, this.wVT.bke());
            }
            r0 += e.a.a.a.fR(22, this.wVU);
            if (this.wVV != null) {
                r0 += e.a.a.a.fT(23, this.wVV.bke());
            }
            r0 = ((r0 + e.a.a.a.fR(24, this.wVW)) + e.a.a.a.fR(25, this.wVX)) + e.a.a.a.fR(26, this.wVY);
            if (this.wVZ != null) {
                r0 += e.a.a.a.fT(27, this.wVZ.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wUm == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.wUn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buo com_tencent_mm_protocal_c_buo = (buo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_but;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new but();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wUm = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new but();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wUn = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_buo.wVC = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new bth();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVD = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new bth();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVE = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_buo.wVF = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_buo.wVG = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_buo.wVH = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_buo.wVI = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVJ = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_buo.wVK = aVar3.Avy.ry();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new bth();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVL = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_buo.wVM = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_buo.wVN = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_buo.wVO = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_buo.wVP = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_buo.wVQ = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_buo.nDT = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_buo.wVR = aVar3.Avy.ry();
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVS = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 21:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVT = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_buo.wVU = aVar3.Avy.ry();
                    return 0;
                case 23:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVV = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_buo.wVW = aVar3.Avy.ry();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_buo.wVX = aVar3.Avy.ry();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_buo.wVY = aVar3.Avy.ry();
                    return 0;
                case 27:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_but = new amx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_but.a(aVar4, com_tencent_mm_protocal_c_but, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buo.wVZ = com_tencent_mm_protocal_c_but;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
