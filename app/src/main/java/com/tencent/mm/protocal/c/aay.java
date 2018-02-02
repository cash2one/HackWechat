package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class aay extends a {
    public int vWL;
    public int vWM;
    public int vWN;
    public b vWP;
    public akc vWQ;
    public int wjW;
    public int wjX;
    public int wjY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vWL);
            aVar.fU(2, this.vWM);
            aVar.fU(3, this.vWN);
            if (this.vWP != null) {
                aVar.b(4, this.vWP);
            }
            aVar.fU(5, this.wjW);
            aVar.fU(6, this.wjX);
            aVar.fU(7, this.wjY);
            if (this.vWQ != null) {
                aVar.fW(8, this.vWQ.bke());
                this.vWQ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.vWL) + 0) + e.a.a.a.fR(2, this.vWM)) + e.a.a.a.fR(3, this.vWN);
            if (this.vWP != null) {
                r0 += e.a.a.a.a(4, this.vWP);
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.wjW)) + e.a.a.a.fR(6, this.wjX)) + e.a.a.a.fR(7, this.wjY);
            if (this.vWQ != null) {
                return r0 + e.a.a.a.fT(8, this.vWQ.bke());
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
            aay com_tencent_mm_protocal_c_aay = (aay) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aay.vWL = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aay.vWM = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aay.vWN = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aay.vWP = aVar3.cJD();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aay.wjW = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aay.wjX = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aay.wjY = aVar3.Avy.ry();
                    return 0;
                case 8:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_akc = new akc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_akc.a(aVar4, com_tencent_mm_protocal_c_akc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aay.vWQ = com_tencent_mm_protocal_c_akc;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
