package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dr extends a {
    public String vEm;
    public String vIR;
    public sm vIS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIR == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.vIS == null) {
                throw new b("Not all required fields were included: Price");
            } else {
                if (this.vIR != null) {
                    aVar.g(1, this.vIR);
                }
                if (this.vIS != null) {
                    aVar.fW(2, this.vIS.bke());
                    this.vIS.a(aVar);
                }
                if (this.vEm == null) {
                    return 0;
                }
                aVar.g(3, this.vEm);
                return 0;
            }
        } else if (i == 1) {
            if (this.vIR != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIR) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIS != null) {
                r0 += e.a.a.a.fT(2, this.vIS.bke());
            }
            if (this.vEm != null) {
                r0 += e.a.a.b.b.a.h(3, this.vEm);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIR == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.vIS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Price");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dr drVar = (dr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    drVar.vIR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a smVar = new sm();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = smVar.a(aVar4, smVar, a.a(aVar4))) {
                        }
                        drVar.vIS = smVar;
                    }
                    return 0;
                case 3:
                    drVar.vEm = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
