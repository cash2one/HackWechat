package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btq extends bcv {
    public int vWK;
    public long wFp;
    public int wFq;
    public String wUU;
    public b wUV;
    public b wUW;
    public String wUX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wUU == null) {
                throw new e.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.wUW == null) {
                throw new e.a.a.b("Not all required fields were included: CapInfo");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                aVar.fU(2, this.wFq);
                if (this.wUU != null) {
                    aVar.g(3, this.wUU);
                }
                aVar.fU(4, this.vWK);
                if (this.wUV != null) {
                    aVar.b(5, this.wUV);
                }
                if (this.wUW != null) {
                    aVar.b(6, this.wUW);
                }
                aVar.S(7, this.wFp);
                if (this.wUX == null) {
                    return 0;
                }
                aVar.g(8, this.wUX);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wFq);
            if (this.wUU != null) {
                r0 += e.a.a.b.b.a.h(3, this.wUU);
            }
            r0 += e.a.a.a.fR(4, this.vWK);
            if (this.wUV != null) {
                r0 += e.a.a.a.a(5, this.wUV);
            }
            if (this.wUW != null) {
                r0 += e.a.a.a.a(6, this.wUW);
            }
            r0 += e.a.a.a.R(7, this.wFp);
            if (this.wUX != null) {
                r0 += e.a.a.b.b.a.h(8, this.wUX);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wUU == null) {
                throw new e.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.wUW != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btq com_tencent_mm_protocal_c_btq = (btq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btq.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_btq.wFq = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_btq.wUU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_btq.vWK = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_btq.wUV = aVar3.cJD();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_btq.wUW = aVar3.cJD();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_btq.wFp = aVar3.Avy.rz();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_btq.wUX = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
