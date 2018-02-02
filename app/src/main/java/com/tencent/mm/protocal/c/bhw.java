package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bhw extends bcv {
    public int vHT;
    public int vLj;
    public float vQu;
    public int vWK;
    public bdn vXz;
    public int wLl;
    public float wLm;
    public float wLn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vXz != null) {
                aVar.fW(2, this.vXz.bke());
                this.vXz.a(aVar);
            }
            aVar.fU(3, this.wLl);
            aVar.fU(4, this.vLj);
            aVar.m(5, this.wLm);
            aVar.fU(6, this.vWK);
            aVar.fU(7, this.vHT);
            aVar.m(8, this.wLn);
            aVar.m(9, this.vQu);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(2, this.vXz.bke());
            }
            return ((((((r0 + e.a.a.a.fR(3, this.wLl)) + e.a.a.a.fR(4, this.vLj)) + (e.a.a.b.b.a.dX(5) + 4)) + e.a.a.a.fR(6, this.vWK)) + e.a.a.a.fR(7, this.vHT)) + (e.a.a.b.b.a.dX(8) + 4)) + (e.a.a.b.b.a.dX(9) + 4);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhw com_tencent_mm_protocal_c_bhw = (bhw) objArr[1];
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
                        com_tencent_mm_protocal_c_bhw.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhw.vXz = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhw.wLl = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhw.vLj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhw.wLm = aVar3.Avy.readFloat();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhw.vWK = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhw.vHT = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhw.wLn = aVar3.Avy.readFloat();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhw.vQu = aVar3.Avy.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
