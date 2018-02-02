package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class vm extends a implements bir {
    public int vJU;
    public int vPq;
    public bdn vRA;
    public om vRD;

    public final int getRet() {
        return this.vJU;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRD == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.vRA == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                aVar.fU(1, this.vJU);
                if (this.vRD != null) {
                    aVar.fW(2, this.vRD.bke());
                    this.vRD.a(aVar);
                }
                if (this.vRA != null) {
                    aVar.fW(3, this.vRA.bke());
                    this.vRA.a(aVar);
                }
                aVar.fU(4, this.vPq);
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vJU) + 0;
            if (this.vRD != null) {
                r0 += e.a.a.a.fT(2, this.vRD.bke());
            }
            if (this.vRA != null) {
                r0 += e.a.a.a.fT(3, this.vRA.bke());
            }
            return r0 + e.a.a.a.fR(4, this.vPq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vRD == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.vRA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vm vmVar = (vm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a omVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    vmVar.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        omVar = new om();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = omVar.a(aVar4, omVar, a.a(aVar4))) {
                        }
                        vmVar.vRD = omVar;
                    }
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
                        vmVar.vRA = omVar;
                    }
                    return 0;
                case 4:
                    vmVar.vPq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
