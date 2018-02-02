package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bwb extends a {
    public bvx wXo;
    public bvo wXp;
    public String wXq;
    public String wXr;
    public String wXs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXo != null) {
                aVar.fW(1, this.wXo.bke());
                this.wXo.a(aVar);
            }
            if (this.wXp != null) {
                aVar.fW(2, this.wXp.bke());
                this.wXp.a(aVar);
            }
            if (this.wXq != null) {
                aVar.g(3, this.wXq);
            }
            if (this.wXr != null) {
                aVar.g(4, this.wXr);
            }
            if (this.wXs == null) {
                return 0;
            }
            aVar.g(5, this.wXs);
            return 0;
        } else if (i == 1) {
            if (this.wXo != null) {
                r0 = e.a.a.a.fT(1, this.wXo.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wXp != null) {
                r0 += e.a.a.a.fT(2, this.wXp.bke());
            }
            if (this.wXq != null) {
                r0 += e.a.a.b.b.a.h(3, this.wXq);
            }
            if (this.wXr != null) {
                r0 += e.a.a.b.b.a.h(4, this.wXr);
            }
            if (this.wXs != null) {
                r0 += e.a.a.b.b.a.h(5, this.wXs);
            }
            return r0;
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
            bwb com_tencent_mm_protocal_c_bwb = (bwb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bvx;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bvx = new bvx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bvx.a(aVar4, com_tencent_mm_protocal_c_bvx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bwb.wXo = com_tencent_mm_protocal_c_bvx;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bvx = new bvo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bvx.a(aVar4, com_tencent_mm_protocal_c_bvx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bwb.wXp = com_tencent_mm_protocal_c_bvx;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bwb.wXq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bwb.wXr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bwb.wXs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
