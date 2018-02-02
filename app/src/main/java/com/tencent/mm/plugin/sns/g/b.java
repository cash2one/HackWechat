package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bq.a;
import com.tencent.mm.protocal.c.aqr;
import java.util.LinkedList;

public final class b extends a {
    public aqr fHC;
    public int hzW;
    public String raG;
    public int raH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fHC != null) {
                aVar.fW(1, this.fHC.bke());
                this.fHC.a(aVar);
            }
            if (this.raG != null) {
                aVar.g(2, this.raG);
            }
            aVar.fU(3, this.hzW);
            aVar.fU(4, this.raH);
            return 0;
        } else if (i == 1) {
            if (this.fHC != null) {
                r0 = e.a.a.a.fT(1, this.fHC.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.raG != null) {
                r0 += e.a.a.b.b.a.h(2, this.raG);
            }
            return (r0 + e.a.a.a.fR(3, this.hzW)) + e.a.a.a.fR(4, this.raH);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_aqr = new aqr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aqr.a(aVar4, com_tencent_mm_protocal_c_aqr, a.a(aVar4))) {
                        }
                        bVar.fHC = com_tencent_mm_protocal_c_aqr;
                    }
                    return 0;
                case 2:
                    bVar.raG = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bVar.hzW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    bVar.raH = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
