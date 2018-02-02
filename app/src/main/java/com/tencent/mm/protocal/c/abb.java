package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class abb extends bdf {
    public String ID;
    public int ktN;
    public long kti;
    public int rYW;
    public bdn vJC;
    public int vJO;
    public LinkedList<ov> vJP = new LinkedList();
    public String vJQ;
    public String vJR;
    public String vJS;
    public int vJX;
    public String vJY;
    public String vJZ;
    public String wkc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vJC == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.ID != null) {
                    aVar.g(2, this.ID);
                }
                if (this.vJC != null) {
                    aVar.fW(3, this.vJC.bke());
                    this.vJC.a(aVar);
                }
                if (this.vJY != null) {
                    aVar.g(4, this.vJY);
                }
                if (this.vJZ != null) {
                    aVar.g(5, this.vJZ);
                }
                aVar.fU(6, this.ktN);
                aVar.fU(7, this.vJO);
                aVar.d(8, 8, this.vJP);
                if (this.wkc != null) {
                    aVar.g(9, this.wkc);
                }
                if (this.vJQ != null) {
                    aVar.g(10, this.vJQ);
                }
                if (this.vJR != null) {
                    aVar.g(11, this.vJR);
                }
                aVar.fU(12, this.vJX);
                aVar.fU(13, this.rYW);
                aVar.S(14, this.kti);
                if (this.vJS == null) {
                    return 0;
                }
                aVar.g(15, this.vJS);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ID != null) {
                r0 += e.a.a.b.b.a.h(2, this.ID);
            }
            if (this.vJC != null) {
                r0 += e.a.a.a.fT(3, this.vJC.bke());
            }
            if (this.vJY != null) {
                r0 += e.a.a.b.b.a.h(4, this.vJY);
            }
            if (this.vJZ != null) {
                r0 += e.a.a.b.b.a.h(5, this.vJZ);
            }
            r0 = ((r0 + e.a.a.a.fR(6, this.ktN)) + e.a.a.a.fR(7, this.vJO)) + e.a.a.a.c(8, 8, this.vJP);
            if (this.wkc != null) {
                r0 += e.a.a.b.b.a.h(9, this.wkc);
            }
            if (this.vJQ != null) {
                r0 += e.a.a.b.b.a.h(10, this.vJQ);
            }
            if (this.vJR != null) {
                r0 += e.a.a.b.b.a.h(11, this.vJR);
            }
            r0 = ((r0 + e.a.a.a.fR(12, this.vJX)) + e.a.a.a.fR(13, this.rYW)) + e.a.a.a.R(14, this.kti);
            if (this.vJS != null) {
                r0 += e.a.a.b.b.a.h(15, this.vJS);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vJP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vJC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abb com_tencent_mm_protocal_c_abb = (abb) objArr[1];
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
                        com_tencent_mm_protocal_c_abb.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_abb.ID = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abb.vJC = feVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_abb.vJY = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_abb.vJZ = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_abb.ktN = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_abb.vJO = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ov();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abb.vJP.add(feVar);
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_abb.wkc = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_abb.vJQ = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_abb.vJR = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_abb.vJX = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_abb.rYW = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_abb.kti = aVar3.Avy.rz();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_abb.vJS = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
