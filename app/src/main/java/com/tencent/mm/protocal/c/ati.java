package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ati extends a {
    public int rYW;
    public String vJA;
    public bdn vRA;
    public int vRz;
    public om wBu;
    public int wBv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wBu == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.vRA == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                if (this.wBu != null) {
                    aVar.fW(1, this.wBu.bke());
                    this.wBu.a(aVar);
                }
                aVar.fU(2, this.vRz);
                if (this.vRA != null) {
                    aVar.fW(3, this.vRA.bke());
                    this.vRA.a(aVar);
                }
                aVar.fU(4, this.rYW);
                if (this.vJA != null) {
                    aVar.g(5, this.vJA);
                }
                aVar.fU(6, this.wBv);
                return 0;
            }
        } else if (i == 1) {
            if (this.wBu != null) {
                r0 = e.a.a.a.fT(1, this.wBu.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vRz);
            if (this.vRA != null) {
                r0 += e.a.a.a.fT(3, this.vRA.bke());
            }
            r0 += e.a.a.a.fR(4, this.rYW);
            if (this.vJA != null) {
                r0 += e.a.a.b.b.a.h(5, this.vJA);
            }
            return r0 + e.a.a.a.fR(6, this.wBv);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wBu == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.vRA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ati com_tencent_mm_protocal_c_ati = (ati) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a omVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        omVar = new om();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = omVar.a(aVar4, omVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ati.wBu = omVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ati.vRz = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        omVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = omVar.a(aVar4, omVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ati.vRA = omVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ati.rYW = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ati.vJA = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ati.wBv = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
