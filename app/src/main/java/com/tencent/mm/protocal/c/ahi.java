package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahi extends bdf {
    public String hbH;
    public boolean lPs;
    public LinkedList<wb> vGV = new LinkedList();
    public LinkedList<String> woE = new LinkedList();
    public String woF;
    public String woG;
    public boolean woI;
    public LinkedList<cbz> woL = new LinkedList();
    public LinkedList<cca> woM = new LinkedList();
    public String woN;
    public String woO;
    public String woP;
    public String woQ;
    public boolean woR;
    public int woS;
    public String woT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.woN == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.woO == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.hbH == null) {
                throw new b("Not all required fields were included: rankid");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.d(2, 8, this.woL);
                aVar.d(3, 8, this.woM);
                aVar.d(4, 1, this.woE);
                if (this.woN != null) {
                    aVar.g(5, this.woN);
                }
                if (this.woO != null) {
                    aVar.g(6, this.woO);
                }
                if (this.hbH != null) {
                    aVar.g(7, this.hbH);
                }
                if (this.woP != null) {
                    aVar.g(8, this.woP);
                }
                if (this.woF != null) {
                    aVar.g(9, this.woF);
                }
                aVar.al(10, this.lPs);
                if (this.woG != null) {
                    aVar.g(11, this.woG);
                }
                aVar.d(12, 8, this.vGV);
                aVar.al(13, this.woI);
                if (this.woQ != null) {
                    aVar.g(14, this.woQ);
                }
                aVar.al(15, this.woR);
                aVar.fU(16, this.woS);
                if (this.woT == null) {
                    return 0;
                }
                aVar.g(17, this.woT);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.c(2, 8, this.woL)) + e.a.a.a.c(3, 8, this.woM)) + e.a.a.a.c(4, 1, this.woE);
            if (this.woN != null) {
                r0 += e.a.a.b.b.a.h(5, this.woN);
            }
            if (this.woO != null) {
                r0 += e.a.a.b.b.a.h(6, this.woO);
            }
            if (this.hbH != null) {
                r0 += e.a.a.b.b.a.h(7, this.hbH);
            }
            if (this.woP != null) {
                r0 += e.a.a.b.b.a.h(8, this.woP);
            }
            if (this.woF != null) {
                r0 += e.a.a.b.b.a.h(9, this.woF);
            }
            r0 += e.a.a.b.b.a.dX(10) + 1;
            if (this.woG != null) {
                r0 += e.a.a.b.b.a.h(11, this.woG);
            }
            r0 = (r0 + e.a.a.a.c(12, 8, this.vGV)) + (e.a.a.b.b.a.dX(13) + 1);
            if (this.woQ != null) {
                r0 += e.a.a.b.b.a.h(14, this.woQ);
            }
            r0 = (r0 + (e.a.a.b.b.a.dX(15) + 1)) + e.a.a.a.fR(16, this.woS);
            if (this.woT != null) {
                r0 += e.a.a.b.b.a.h(17, this.woT);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.woL.clear();
            this.woM.clear();
            this.woE.clear();
            this.vGV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.woN == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.woO == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.hbH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahi com_tencent_mm_protocal_c_ahi = (ahi) objArr[1];
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
                        com_tencent_mm_protocal_c_ahi.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new cbz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahi.woL.add(feVar);
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new cca();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahi.woM.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahi.woE.add(aVar3.Avy.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahi.woN = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ahi.woO = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ahi.hbH = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ahi.woP = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ahi.woF = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ahi.lPs = aVar3.cJC();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ahi.woG = aVar3.Avy.readString();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new wb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahi.vGV.add(feVar);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ahi.woI = aVar3.cJC();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ahi.woQ = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ahi.woR = aVar3.cJC();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ahi.woS = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ahi.woT = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
