package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bq.a;
import com.tencent.mm.protocal.c.bjf;
import e.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public bjf qTH;
    public String raP;
    public int raQ;
    public String raR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.raP == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.qTH == null) {
                throw new b("Not all required fields were included: actionGroup");
            } else {
                if (this.raP != null) {
                    aVar.g(1, this.raP);
                }
                if (this.qTH != null) {
                    aVar.fW(2, this.qTH.bke());
                    this.qTH.a(aVar);
                }
                aVar.fU(3, this.raQ);
                if (this.raR == null) {
                    return 0;
                }
                aVar.g(4, this.raR);
                return 0;
            }
        } else if (i == 1) {
            if (this.raP != null) {
                r0 = e.a.a.b.b.a.h(1, this.raP) + 0;
            } else {
                r0 = 0;
            }
            if (this.qTH != null) {
                r0 += e.a.a.a.fT(2, this.qTH.bke());
            }
            r0 += e.a.a.a.fR(3, this.raQ);
            if (this.raR != null) {
                r0 += e.a.a.b.b.a.h(4, this.raR);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.raP == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.qTH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: actionGroup");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.raP = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bjf = new bjf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bjf.a(aVar4, com_tencent_mm_protocal_c_bjf, a.a(aVar4))) {
                        }
                        eVar.qTH = com_tencent_mm_protocal_c_bjf;
                    }
                    return 0;
                case 3:
                    eVar.raQ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    eVar.raR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
