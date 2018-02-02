package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adr extends bcv {
    public int vGW;
    public bdo vGX;
    public bdo vGY;
    public long vHe;
    public int vIB;
    public int vIC;
    public int vID;
    public int wmj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                aVar.fU(2, this.vGW);
                if (this.vGX != null) {
                    aVar.fW(3, this.vGX.bke());
                    this.vGX.a(aVar);
                }
                if (this.vGY != null) {
                    aVar.fW(4, this.vGY.bke());
                    this.vGY.a(aVar);
                }
                aVar.fU(5, this.vIB);
                aVar.fU(6, this.vIC);
                aVar.fU(7, this.vID);
                aVar.fU(8, this.wmj);
                aVar.S(9, this.vHe);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vGW);
            if (this.vGX != null) {
                r0 += e.a.a.a.fT(3, this.vGX.bke());
            }
            if (this.vGY != null) {
                r0 += e.a.a.a.fT(4, this.vGY.bke());
            }
            return ((((r0 + e.a.a.a.fR(5, this.vIB)) + e.a.a.a.fR(6, this.vIC)) + e.a.a.a.fR(7, this.vID)) + e.a.a.a.fR(8, this.wmj)) + e.a.a.a.R(9, this.vHe);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vGX == null) {
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
            adr com_tencent_mm_protocal_c_adr = (adr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adr.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adr.vGW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adr.vGX = fdVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adr.vGY = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adr.vIB = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adr.vIC = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adr.vID = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adr.wmj = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_adr.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
