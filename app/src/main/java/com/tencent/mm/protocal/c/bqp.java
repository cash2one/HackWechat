package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqp extends bcv {
    public int njA;
    public int vIB;
    public int vIC;
    public int vID;
    public bdn vXz;
    public bdo wRY;
    public bdo wRZ;
    public int wSa;
    public int wSb;
    public int wSc;
    public int wSd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRY == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.wRZ == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.wRY != null) {
                    aVar.fW(2, this.wRY.bke());
                    this.wRY.a(aVar);
                }
                if (this.wRZ != null) {
                    aVar.fW(3, this.wRZ.bke());
                    this.wRZ.a(aVar);
                }
                aVar.fU(4, this.vIB);
                aVar.fU(5, this.vIC);
                aVar.fU(6, this.vID);
                if (this.vXz != null) {
                    aVar.fW(7, this.vXz.bke());
                    this.vXz.a(aVar);
                }
                aVar.fU(8, this.njA);
                aVar.fU(9, this.wSa);
                aVar.fU(10, this.wSb);
                aVar.fU(11, this.wSc);
                aVar.fU(12, this.wSd);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wRY != null) {
                r0 += e.a.a.a.fT(2, this.wRY.bke());
            }
            if (this.wRZ != null) {
                r0 += e.a.a.a.fT(3, this.wRZ.bke());
            }
            r0 = ((r0 + e.a.a.a.fR(4, this.vIB)) + e.a.a.a.fR(5, this.vIC)) + e.a.a.a.fR(6, this.vID);
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(7, this.vXz.bke());
            }
            return ((((r0 + e.a.a.a.fR(8, this.njA)) + e.a.a.a.fR(9, this.wSa)) + e.a.a.a.fR(10, this.wSb)) + e.a.a.a.fR(11, this.wSc)) + e.a.a.a.fR(12, this.wSd);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wRY == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.wRZ == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.vXz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqp com_tencent_mm_protocal_c_bqp = (bqp) objArr[1];
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
                        com_tencent_mm_protocal_c_bqp.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqp.wRY = fdVar;
                    }
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
                        com_tencent_mm_protocal_c_bqp.wRZ = fdVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqp.vIB = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqp.vIC = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqp.vID = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqp.vXz = fdVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bqp.njA = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bqp.wSa = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bqp.wSb = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bqp.wSc = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bqp.wSd = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
