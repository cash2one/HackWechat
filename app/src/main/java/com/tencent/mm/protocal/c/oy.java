package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class oy extends a {
    public int hvt;
    public String hvy;
    public String ksU;
    public String kub;
    public String nkB;
    public bdn vHb;
    public String vXK;
    public String vXL;
    public int vXM;
    public int vXN;
    public String vXO;
    public int vXP;
    public String vXQ;
    public String vXR;
    public int vXS;
    public int vXT;
    public LinkedList<bdm> vXU = new LinkedList();
    public String vXV;
    public int vXW;
    public int vXX;
    public int vXY;
    public int vXZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            }
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            if (this.vXK != null) {
                aVar.g(3, this.vXK);
            }
            if (this.vXL != null) {
                aVar.g(4, this.vXL);
            }
            aVar.fU(5, this.hvt);
            if (this.vHb != null) {
                aVar.fW(6, this.vHb.bke());
                this.vHb.a(aVar);
            }
            aVar.fU(7, this.vXM);
            aVar.fU(8, this.vXN);
            if (this.vXO != null) {
                aVar.g(9, this.vXO);
            }
            aVar.fU(10, this.vXP);
            if (this.vXQ != null) {
                aVar.g(11, this.vXQ);
            }
            if (this.vXR != null) {
                aVar.g(12, this.vXR);
            }
            aVar.fU(13, this.vXS);
            aVar.fU(14, this.vXT);
            aVar.d(15, 8, this.vXU);
            if (this.vXV != null) {
                aVar.g(16, this.vXV);
            }
            aVar.fU(17, this.vXW);
            aVar.fU(18, this.vXX);
            if (this.nkB != null) {
                aVar.g(19, this.nkB);
            }
            aVar.fU(20, this.vXY);
            aVar.fU(21, this.vXZ);
            if (this.hvy == null) {
                return 0;
            }
            aVar.g(22, this.hvy);
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
            if (this.vXK != null) {
                r0 += e.a.a.b.b.a.h(3, this.vXK);
            }
            if (this.vXL != null) {
                r0 += e.a.a.b.b.a.h(4, this.vXL);
            }
            r0 += e.a.a.a.fR(5, this.hvt);
            if (this.vHb != null) {
                r0 += e.a.a.a.fT(6, this.vHb.bke());
            }
            r0 = (r0 + e.a.a.a.fR(7, this.vXM)) + e.a.a.a.fR(8, this.vXN);
            if (this.vXO != null) {
                r0 += e.a.a.b.b.a.h(9, this.vXO);
            }
            r0 += e.a.a.a.fR(10, this.vXP);
            if (this.vXQ != null) {
                r0 += e.a.a.b.b.a.h(11, this.vXQ);
            }
            if (this.vXR != null) {
                r0 += e.a.a.b.b.a.h(12, this.vXR);
            }
            r0 = ((r0 + e.a.a.a.fR(13, this.vXS)) + e.a.a.a.fR(14, this.vXT)) + e.a.a.a.c(15, 8, this.vXU);
            if (this.vXV != null) {
                r0 += e.a.a.b.b.a.h(16, this.vXV);
            }
            r0 = (r0 + e.a.a.a.fR(17, this.vXW)) + e.a.a.a.fR(18, this.vXX);
            if (this.nkB != null) {
                r0 += e.a.a.b.b.a.h(19, this.nkB);
            }
            r0 = (r0 + e.a.a.a.fR(20, this.vXY)) + e.a.a.a.fR(21, this.vXZ);
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(22, this.hvy);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vXU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vHb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuf");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oy oyVar = (oy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    oyVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    oyVar.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    oyVar.vXK = aVar3.Avy.readString();
                    return 0;
                case 4:
                    oyVar.vXL = aVar3.Avy.readString();
                    return 0;
                case 5:
                    oyVar.hvt = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        oyVar.vHb = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 7:
                    oyVar.vXM = aVar3.Avy.ry();
                    return 0;
                case 8:
                    oyVar.vXN = aVar3.Avy.ry();
                    return 0;
                case 9:
                    oyVar.vXO = aVar3.Avy.readString();
                    return 0;
                case 10:
                    oyVar.vXP = aVar3.Avy.ry();
                    return 0;
                case 11:
                    oyVar.vXQ = aVar3.Avy.readString();
                    return 0;
                case 12:
                    oyVar.vXR = aVar3.Avy.readString();
                    return 0;
                case 13:
                    oyVar.vXS = aVar3.Avy.ry();
                    return 0;
                case 14:
                    oyVar.vXT = aVar3.Avy.ry();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdm();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        oyVar.vXU.add(com_tencent_mm_protocal_c_bdn);
                    }
                    return 0;
                case 16:
                    oyVar.vXV = aVar3.Avy.readString();
                    return 0;
                case 17:
                    oyVar.vXW = aVar3.Avy.ry();
                    return 0;
                case 18:
                    oyVar.vXX = aVar3.Avy.ry();
                    return 0;
                case 19:
                    oyVar.nkB = aVar3.Avy.readString();
                    return 0;
                case 20:
                    oyVar.vXY = aVar3.Avy.ry();
                    return 0;
                case 21:
                    oyVar.vXZ = aVar3.Avy.ry();
                    return 0;
                case 22:
                    oyVar.hvy = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
