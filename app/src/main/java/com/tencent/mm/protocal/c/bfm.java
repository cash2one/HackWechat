package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bfm extends a {
    public b vZC;
    public int wKq;
    public int wKr;
    public int wKs;
    public int wKt;
    public int wKu;
    public int wKv;
    public int wKw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZC == null) {
                throw new e.a.a.b("Not all required fields were included: data");
            }
            aVar.fU(1, this.wKq);
            aVar.fU(2, this.wKr);
            aVar.fU(3, this.wKs);
            aVar.fU(4, this.wKt);
            aVar.fU(5, this.wKu);
            aVar.fU(6, this.wKv);
            aVar.fU(7, this.wKw);
            if (this.vZC != null) {
                aVar.b(8, this.vZC);
            }
            return 0;
        } else if (i == 1) {
            int fR = ((((((e.a.a.a.fR(1, this.wKq) + 0) + e.a.a.a.fR(2, this.wKr)) + e.a.a.a.fR(3, this.wKs)) + e.a.a.a.fR(4, this.wKt)) + e.a.a.a.fR(5, this.wKu)) + e.a.a.a.fR(6, this.wKv)) + e.a.a.a.fR(7, this.wKw);
            if (this.vZC != null) {
                return fR + e.a.a.a.a(8, this.vZC);
            }
            return fR;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJE();
                }
            }
            if (bArr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfm com_tencent_mm_protocal_c_bfm = (bfm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bfm.wKq = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfm.wKr = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfm.wKs = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfm.wKt = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfm.wKu = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfm.wKv = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfm.wKw = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfm.vZC = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
