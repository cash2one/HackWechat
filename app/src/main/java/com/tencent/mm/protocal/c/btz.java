package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btz extends bdf {
    public long wUT;
    public int wVd;
    public int wVe;
    public int wVf;
    public int wVg;
    public b wVh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.S(2, this.wUT);
            aVar.S(3, this.wbi);
            aVar.fU(4, this.wVd);
            aVar.fU(5, this.wVe);
            aVar.fU(6, this.wVf);
            aVar.fU(7, this.wVg);
            if (this.wVh == null) {
                return 0;
            }
            aVar.b(8, this.wVh);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((((r0 + e.a.a.a.R(2, this.wUT)) + e.a.a.a.R(3, this.wbi)) + e.a.a.a.fR(4, this.wVd)) + e.a.a.a.fR(5, this.wVe)) + e.a.a.a.fR(6, this.wVf)) + e.a.a.a.fR(7, this.wVg);
            if (this.wVh != null) {
                r0 += e.a.a.a.a(8, this.wVh);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btz com_tencent_mm_protocal_c_btz = (btz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btz.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_btz.wUT = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_btz.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_btz.wVd = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_btz.wVe = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_btz.wVf = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_btz.wVg = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_btz.wVh = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
