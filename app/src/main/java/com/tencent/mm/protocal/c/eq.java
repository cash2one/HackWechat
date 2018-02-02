package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class eq extends a implements bir {
    public String ID;
    public bdn vJC;
    public String vJT;
    public int vJU;
    public bdn vJV;
    public String vJW;
    public int vJX;
    public String vJY;
    public String vJZ;

    public final int getRet() {
        return this.vJU;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJV == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.vJC == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                aVar.fU(1, this.vJU);
                if (this.vJV != null) {
                    aVar.fW(2, this.vJV.bke());
                    this.vJV.a(aVar);
                }
                if (this.vJW != null) {
                    aVar.g(3, this.vJW);
                }
                if (this.vJC != null) {
                    aVar.fW(4, this.vJC.bke());
                    this.vJC.a(aVar);
                }
                if (this.vJY != null) {
                    aVar.g(5, this.vJY);
                }
                if (this.vJZ != null) {
                    aVar.g(6, this.vJZ);
                }
                aVar.fU(7, this.vJX);
                if (this.ID != null) {
                    aVar.g(8, this.ID);
                }
                if (this.vJT != null) {
                    aVar.g(9, this.vJT);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vJU) + 0;
            if (this.vJV != null) {
                r0 += e.a.a.a.fT(2, this.vJV.bke());
            }
            if (this.vJW != null) {
                r0 += e.a.a.b.b.a.h(3, this.vJW);
            }
            if (this.vJC != null) {
                r0 += e.a.a.a.fT(4, this.vJC.bke());
            }
            if (this.vJY != null) {
                r0 += e.a.a.b.b.a.h(5, this.vJY);
            }
            if (this.vJZ != null) {
                r0 += e.a.a.b.b.a.h(6, this.vJZ);
            }
            r0 += e.a.a.a.fR(7, this.vJX);
            if (this.ID != null) {
                r0 += e.a.a.b.b.a.h(8, this.ID);
            }
            if (this.vJT != null) {
                return r0 + e.a.a.b.b.a.h(9, this.vJT);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vJV == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.vJC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            eq eqVar = (eq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    eqVar.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        eqVar.vJV = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 3:
                    eqVar.vJW = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        eqVar.vJC = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 5:
                    eqVar.vJY = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eqVar.vJZ = aVar3.Avy.readString();
                    return 0;
                case 7:
                    eqVar.vJX = aVar3.Avy.ry();
                    return 0;
                case 8:
                    eqVar.ID = aVar3.Avy.readString();
                    return 0;
                case 9:
                    eqVar.vJT = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
