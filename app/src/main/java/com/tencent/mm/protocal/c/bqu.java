package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqu extends bdf {
    public int pbl;
    public int vGW;
    public bdo vGX;
    public bdo vGY;
    public long vHe;
    public int vIB;
    public int vIC;
    public int vID;
    public String vQA;
    public String vQE;
    public bdo wSf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wSf == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(2, this.vGW);
                if (this.wSf != null) {
                    aVar.fW(3, this.wSf.bke());
                    this.wSf.a(aVar);
                }
                if (this.vGX != null) {
                    aVar.fW(4, this.vGX.bke());
                    this.vGX.a(aVar);
                }
                if (this.vGY != null) {
                    aVar.fW(5, this.vGY.bke());
                    this.vGY.a(aVar);
                }
                aVar.fU(6, this.vIB);
                aVar.fU(7, this.vIC);
                aVar.fU(8, this.vID);
                aVar.fU(9, this.pbl);
                aVar.S(10, this.vHe);
                if (this.vQA != null) {
                    aVar.g(11, this.vQA);
                }
                if (this.vQE == null) {
                    return 0;
                }
                aVar.g(12, this.vQE);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vGW);
            if (this.wSf != null) {
                r0 += e.a.a.a.fT(3, this.wSf.bke());
            }
            if (this.vGX != null) {
                r0 += e.a.a.a.fT(4, this.vGX.bke());
            }
            if (this.vGY != null) {
                r0 += e.a.a.a.fT(5, this.vGY.bke());
            }
            r0 = ((((r0 + e.a.a.a.fR(6, this.vIB)) + e.a.a.a.fR(7, this.vIC)) + e.a.a.a.fR(8, this.vID)) + e.a.a.a.fR(9, this.pbl)) + e.a.a.a.R(10, this.vHe);
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(11, this.vQA);
            }
            if (this.vQE != null) {
                r0 += e.a.a.b.b.a.h(12, this.vQE);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wSf == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ToUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqu com_tencent_mm_protocal_c_bqu = (bqu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqu.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqu.vGW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqu.wSf = feVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqu.vGX = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqu.vGY = feVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqu.vIB = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bqu.vIC = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bqu.vID = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bqu.pbl = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bqu.vHe = aVar3.Avy.rz();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bqu.vQA = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bqu.vQE = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
