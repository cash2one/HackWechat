package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class all extends a {
    public String ksU;
    public int lOd;
    public String vLN;
    public String vXO;
    public bdo wsB;
    public int wsC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            }
            aVar.fU(1, this.lOd);
            if (this.wsB != null) {
                aVar.fW(2, this.wsB.bke());
                this.wsB.a(aVar);
            }
            if (this.vLN != null) {
                aVar.g(3, this.vLN);
            }
            if (this.vXO != null) {
                aVar.g(4, this.vXO);
            }
            if (this.ksU != null) {
                aVar.g(5, this.ksU);
            }
            aVar.fU(6, this.wsC);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.lOd) + 0;
            if (this.wsB != null) {
                r0 += e.a.a.a.fT(2, this.wsB.bke());
            }
            if (this.vLN != null) {
                r0 += e.a.a.b.b.a.h(3, this.vLN);
            }
            if (this.vXO != null) {
                r0 += e.a.a.b.b.a.h(4, this.vXO);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksU);
            }
            return r0 + e.a.a.a.fR(6, this.wsC);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wsB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: NickName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            all com_tencent_mm_protocal_c_all = (all) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_all.lOd = aVar3.Avy.ry();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdo = new bdo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_all.wsB = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_all.vLN = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_all.vXO = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_all.ksU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_all.wsC = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
