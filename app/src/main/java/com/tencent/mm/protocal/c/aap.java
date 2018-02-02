package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class aap extends a {
    public lh wjA;
    public String wjB;
    public boolean wjC;
    public int wjD;
    public String wjx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wjA != null) {
                aVar.fW(1, this.wjA.bke());
                this.wjA.a(aVar);
            }
            if (this.wjx != null) {
                aVar.g(2, this.wjx);
            }
            if (this.wjB != null) {
                aVar.g(3, this.wjB);
            }
            aVar.al(4, this.wjC);
            aVar.fU(5, this.wjD);
            return 0;
        } else if (i == 1) {
            if (this.wjA != null) {
                r0 = e.a.a.a.fT(1, this.wjA.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wjx != null) {
                r0 += e.a.a.b.b.a.h(2, this.wjx);
            }
            if (this.wjB != null) {
                r0 += e.a.a.b.b.a.h(3, this.wjB);
            }
            return (r0 + (e.a.a.b.b.a.dX(4) + 1)) + e.a.a.a.fR(5, this.wjD);
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
            aap com_tencent_mm_protocal_c_aap = (aap) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a lhVar = new lh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = lhVar.a(aVar4, lhVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aap.wjA = lhVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aap.wjx = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aap.wjB = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aap.wjC = aVar3.cJC();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aap.wjD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
